package netcat.bidi.tcp;

import inout.InputOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static inout.ProcessReaderWriter.processReaderWriter;
import static org.junit.jupiter.api.Assertions.*;

class NetcatTest {
    ProcessBuilder serverbuilder = new ProcessBuilder("java", "-jar", "C:\\IntelliJ_Projects\\VSys\\out\\artifacts\\BidiNetcat_jar\\BidiNetcat.java", "-l", "5555");
    ProcessBuilder clientbuilder = new ProcessBuilder("java", "-jar", "C:\\IntelliJ_Projects\\VSys\\out\\artifacts\\BidiNetcat_jar\\BidiNetcat.java", "localhost", "5555");
    @ParameterizedTest
    @CsvSource({
            "ClientzuServerNachricht, ServerzuClientNachricht",
            "Hallo, Hi",
            "Bye, Ciao"
    })
    void netcatTest(String str1,String str2) throws Exception {

        Process server = serverbuilder.start();
        Process client = clientbuilder.start();

        InputOutput serverReaderWriter = processReaderWriter(server);
        InputOutput clientReaderWriter = processReaderWriter(client);

        clientReaderWriter.printLine(str1 + "\n");
        //clientReaderWriter.shutdownOutput();
        Thread.sleep(100);

        serverReaderWriter.printLine(str2 + "\n");
        //serverReaderWriter.shutdownOutput();


        assertEquals(str1, serverReaderWriter.readLine().successValue().fst);
        assertEquals(str2, clientReaderWriter.readLine().successValue().fst);
        client.destroy();
        server.destroy();
    }
}