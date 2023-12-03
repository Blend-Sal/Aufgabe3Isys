package antlr4.graph; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class CallGraph {
    /**
     * A graph model of the output. Tracks call from one function to
     * another by mapping function to list of called functions. E.g.,
     * f -> [g, h]
     * Can dump DOT two ways (StringBuilder and ST). Sample output:
     * digraph G {
     * ... setup ...
     * f -> g;
     * g -> f;
     * g -> h;
     * h -> h;
     * }
     */
    static class Graph {
        // I'm using org.antlr.v4.runtime.misc: OrderedHashSet, MultiMap
        Set<String> nodes = new OrderedHashSet<String>(); // list of functions
        MultiMap<String, String> edges =                  // caller->callee
                new MultiMap<String, String>();

        MultiMap<String, String> colors = new MultiMap<>();

        public void edge(String source, String target) {
            edges.map(source, target);
        }

        public String toString() {
            return "edges: " + edges.toString() + ", functions: " + nodes;
        }

        public String toDOT() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            buf.append("  ranksep=.25;\n");
            buf.append("  edge [arrowsize=.5]\n");
            buf.append("  node [shape=circle, fontname=\"ArialNarrow\",\n");
            buf.append("        fontsize=12, fixedsize=true, height=.45];\n");
            buf.append("  ");
            for (String node : nodes) { // print all nodes first
                buf.append(node);
                buf.append("; ");
            }
            buf.append("\n");
            for (String src : edges.keySet()) {
                for (String trg : edges.get(src)) {
                    buf.append("  ");
                    buf.append(src);
                    buf.append(" -> ");
                    buf.append(trg);
                    buf.append(";\n");
                }
            }
            buf.append("}\n");
            return buf.toString();
        }

        /**
         * Fill StringTemplate:
         * digraph G {
         * rankdir=LR;
         * <edgePairs:{edge| <edge.a> -> <edge.b>;}; separator="\n">
         * <childless:{f | <f>;}; separator="\n">
         * }
         * <p>
         * Just as an example. Much cleaner than buf.append method
         */
        public ST toST() {
            STGroup stGroup = new STGroupFile("./src/main/resources/graph/callGraph.stg");
            ST st = stGroup.getInstanceOf("callGraph");

            List<String> stNodes = new LinkedList<>();
            MultiMap<String, String> stEdges = new MultiMap<>();
            for (String node : nodes) {
                StringBuilder stringBuilder = new StringBuilder(node);
                if (colors.containsKey(node)) {
                    if (colors.get(node).stream().allMatch(c -> c.contains("cyan"))) {
                        stringBuilder.append(" [color = cyan]");
                    } else {
                        stringBuilder.append(" [color = orange]");
                    }
                } else {
                    stringBuilder.append(" [color = black]");
                }
                stNodes.add(stringBuilder.toString());
            }

            for (String str1 : edges.keySet()) {
                for (String str2 : edges.get(str1)) {
                    if (str1.equals(str2) && colors.containsKey(str1)) {
                        String color = colors.get(str1).remove(0);
                        str2 += " " + color;
                    }
                    stEdges.map(str1, str2);
                }
            }

            st.add("edges", stNodes);
            st.add("nodes", stEdges);

           /* try {
                Files.write(Paths.get("output.dot"), st.render().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; */
            return st;

        }

        public void insertColor(String node, String color) {
            colors.computeIfAbsent(node, k -> new LinkedList<>());
            colors.get(node).add("[color = " + color + "]");
        }

    }

    static class FunctionListener extends CymbolBaseListener {
        Graph graph = new Graph();
        String currentFunctionName = null;

        public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            currentFunctionName = ctx.ID().getText();
            graph.nodes.add(currentFunctionName);
        }

        public void exitCall(CymbolParser.CallContext ctx) {
            if (currentFunctionName != null) {
                String funcName = ctx.ID().getText();
                graph.edge(currentFunctionName, funcName);
                if (currentFunctionName.equals(funcName)) {
                    if (ctx.getParent() instanceof  CymbolParser.ReturnContext) {
                        graph.insertColor(currentFunctionName, "cyan");
                    } else {
                        graph.insertColor(currentFunctionName, "orange");
                    }
                }
            }

        }
    }

    public static String run(String filename) throws IOException {
        CharStream input = fromFileName(filename);
        CymbolLexer lexer = new CymbolLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree parseTree = parser.file();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FunctionListener functionListener = new FunctionListener();
        parseTreeWalker.walk(functionListener, parseTree);
        return functionListener.graph.toST().render();
    }
}
