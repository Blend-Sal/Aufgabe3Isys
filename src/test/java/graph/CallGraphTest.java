package graph;

import antlr4.graph.CallGraph;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

public class CallGraphTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/graph/CallGraphTest.csv")
    public void graphTest() throws IOException {
        String str = CallGraph.run("src/main/resources/graph/rec.cymbol");

        System.out.println(str);

    }
}
