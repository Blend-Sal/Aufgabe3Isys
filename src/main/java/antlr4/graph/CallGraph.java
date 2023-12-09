package antlr4.graph;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class CallGraph {
   public static class Graph {
        private Set<String> nodes_R = new OrderedHashSet<>();
        private Set<String> nodes_ER = new OrderedHashSet<>();
        private Set<String> nodes_default = new OrderedHashSet<>();

        private MultiMap<String, String> edges_R = new MultiMap<>();
        private MultiMap<String, String> edges_ER = new MultiMap<>();
        private MultiMap<String, String> edges_default = new MultiMap<>();



        public void edge(String source, String target) {
            edges_default.map(source, target);
        }

        public Set<String> getNodes_R() {
            return nodes_R;
        }

        public Set<String> getNodes_ER() {
            return nodes_ER;
        }

        public Set<String> getNodes_default() {
            return nodes_default;
        }

        public MultiMap<String, String> getEdges_R() {
            return edges_R;
        }

        public MultiMap<String, String> getEdges_ER() {
            return edges_ER;
        }

        public MultiMap<String, String> getEdges_default() {
            return edges_default;
        }

        public String toString() {
            return "edges: " + edges_default.toString() + ", functions: " + nodes_default;
        }

    }

    static class FunctionListener extends CymbolBaseListener {
        Graph graph = new Graph();
        String currentFunctionName = null;

        public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            currentFunctionName = ctx.ID().getText();
            graph.nodes_default.add(currentFunctionName);
        }

        public void exitCall(CymbolParser.CallContext ctx) {
            String functionName = ctx.ID().getText();
            if (currentFunctionName.equals(functionName)) {
                if (ctx.getParent() instanceof CymbolParser.ReturnContext) {
                    graph.edges_ER.map(currentFunctionName, functionName);
                    graph.nodes_ER.add(currentFunctionName);
                } else {
                    graph.edges_R.map(currentFunctionName, functionName);
                    graph.nodes_R.add(currentFunctionName);
                }
            } else {
                graph.edge(currentFunctionName, functionName);
                graph.nodes_default.add(currentFunctionName);
            }
        }
    }

    public static Graph run(String filename) throws IOException {
        CharStream input = fromFileName(filename);
        CymbolLexer lexer = new CymbolLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree parseTree = parser.file();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FunctionListener functionListener = new FunctionListener();
        parseTreeWalker.walk(functionListener, parseTree);

        Graph graph = functionListener.graph;
        GraphDisplay graphDisplay = new GraphDisplay(graph);

        ST stGraph = graphDisplay.toST();
        System.out.println(stGraph);

        return graph;
    }
}
