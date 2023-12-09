package graph;

import antlr4.graph.CallGraph;
import antlr4.graph.GraphDisplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CallGraphTest {
    @ParameterizedTest
    @CsvSource("'src/test/resources/graph/CallGraphTest.txt'")
        public void graphTest(String testFile) throws IOException {
        CallGraph.Graph graph = CallGraph.run("src/main/resources/graph/rec.cymbol");
        GraphDisplay graphDisplay = new GraphDisplay(graph);
        String filteredDisplay = graphDisplay.toST().render().replaceAll("\\s", "");
        String filteredFile = Files.readString(Path.of(testFile)).replaceAll("\\s", "");
        Assertions.assertEquals(filteredFile, filteredDisplay);
    }
}


