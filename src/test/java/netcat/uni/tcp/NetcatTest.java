package netcat.uni.tcp;


import inout.Input;
import inout.Output;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static inout.ProcessReader.processReader;
import static inout.ProcessWriter.processWriter;
import static org.junit.jupiter.api.Assertions.*;

class NetcatTest {
    ProcessBuilder serverbuilder = new ProcessBuilder("java", "-jar", "builds/vspraktikum/wise22_23/Igor.Greszta/aufgaben-ab-0/src/main/resources/UniNetcat.jar", "-l", "5555");
    ProcessBuilder clientbuilder = new ProcessBuilder("java", "-jar", "builds/vspraktikum/wise22_23/Igor.Greszta/aufgaben-ab-0/src/main/resources/UniNetcat.jar", "localhost", "5555");
    @ParameterizedTest
    @ValueSource(strings = {"Nachrichten", "von", "Client", "zu", "Server"})
    void netcatTest(String str) throws Exception {

        Process server = serverbuilder.start();
        Process client = clientbuilder.start();

        Output clientWriter = processWriter(client);
        clientWriter.printLine(str);
        clientWriter.shutdownOutput();
        Input serverReader = processReader(server);

        assertEquals(str, serverReader.readLines().head());
        client.destroy();
        server.destroy();
    }
}