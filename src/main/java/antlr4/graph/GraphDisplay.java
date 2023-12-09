package antlr4.graph;

import org.antlr.v4.runtime.misc.MultiMap;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphDisplay {

    private CallGraph.Graph graph;
    private MultiMap<String, String> colors;

    public GraphDisplay(CallGraph.Graph graph) {
        this.graph = graph;

    }

    public ST toST() {
        STGroup stGroup = new STGroupFile("./src/main/resources/graph/callGraph.stg");
        ST st = stGroup.getInstanceOf("callGraph");
        st.add("edgePairs_Default", graph.getEdges_default().getPairs());
        st.add("edgePairs_R", graph.getEdges_R().getPairs());
        st.add("edgePairs_ER", graph.getEdges_ER().getPairs());
        st.add("nodes_ER", graph.getNodes_ER());
        st.add("nodes_R", graph.getNodes_R());
        st.add("nodes_Default", graph.getNodes_default());
        return st;
    }

}
