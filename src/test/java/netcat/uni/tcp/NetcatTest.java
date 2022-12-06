package netcat.uni.tcp;


import inout.Input;
import inout.Output;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static inout.ProcessReader.processReader;
import static inout.ProcessWriter.processWriter;
import static org.junit.jupiter.api.Assertions.*;

class NetcatTest {
    ProcessBuilder serverbuilder = new ProcessBuilder("java", "-jar", "C:\\IntelliJ_Projects\\VSys\\out\\artifacts\\praktikum_jar\\UniNetcat.jar", "-l", "5555");
    ProcessBuilder clientbuilder = new ProcessBuilder("java", "-jar", "C:\\IntelliJ_Projects\\VSys\\out\\artifacts\\praktikum_jar\\UniNetcat.jar", "localhost", "5555");
    @ParameterizedTest
    @ValueSource(strings = {"Nachrichten", "von", "Client", "zu", "Server"})
    void netcatTest(String str) throws Exception {

        Process server = serverbuilder.start();
        Process client = clientbuilder.start();

        Output clientWriter = processWriter(client);
        clientWriter.printLine(str + "\n");
        clientWriter.shutdownOutput();
        Input serverReader = processReader(server);

        assertEquals(str, serverReader.readLine().successValue().fst);
        client.destroy();
        server.destroy();
    }
}