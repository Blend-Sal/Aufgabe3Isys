package netcat.bidi.tcp;

import inout.InputOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static inout.ProcessReaderWriter.processReaderWriter;
import static org.junit.jupiter.api.Assertions.*;

class NetcatTest {
    ProcessBuilder serverbuilder = new ProcessBuilder("java", "-jar", "builds/vspraktikum/wise22_23/Igor.Greszta/aufgaben-ab-0/out/artifacts/BidiNetcat_jar/BidiNetcat.jar", "-l", "5555");
    ProcessBuilder clientbuilder = new ProcessBuilder("java", "-jar", "builds/vspraktikum/wise22_23/Igor.Greszta/aufgaben-ab-0/out/artifacts/BidiNetcat_jar/BidiNetcat.jar", "localhost", "5555");
    @ParameterizedTest
    @CsvSource({
            "ClientzuServerNachricht, ServerzuClientNachricht",
            "Hallo, Hi",
            "Bye, Ciao"
    })
    void netcatTest(String str1,String str2) throws Exception {

        Process client = clientbuilder.start();
        Process server = serverbuilder.start();

        InputOutput serverReaderWriter = processReaderWriter(server);
        InputOutput clientReaderWriter = processReaderWriter(client);

        clientReaderWriter.printLine(str1 + "\n");

        Thread.sleep(100);

        serverReaderWriter.printLine(str2 + "\n");

        assertEquals(serverReaderWriter.readLines().head(), str1);
        assertEquals(clientReaderWriter.readLines().head(), str2);

        client.destroy();
        server.destroy();
    }
}