package echo.actor;

import inout.InputOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static inout.ProcessReaderWriter.processReaderWriter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistEchoActorTest {

    @ParameterizedTest
    @CsvSource({"Test1", "Test2", "Test3"})
    public void DistEchoActorTest(String s) throws Exception {
        //ProcessBuilder serverBuilder = new ProcessBuilder("java", "-jar", "out/artifacts/echoServer/echoServer.jar", "localhost", "1111");
        //ProcessBuilder clientBuilder = new ProcessBuilder("java", "-jar", "out/artifacts/echoClient/echoClient.jar", "localhost", "1111");
        ProcessBuilder serverBuilder = new ProcessBuilder("java", "-cp", "target/classes", "echo.actor.EchoServer", "localhost", "1111");
        ProcessBuilder clientBuilder = new ProcessBuilder("java", "-cp", "target/classes", "echo.actor.EchoClient", "localhost", "1111");


        Process echoServer = serverBuilder.start();
        Process echoClient = clientBuilder.start();
        //Thread.sleep(2000);
        InputOutput processReaderWriter = processReaderWriter(echoClient);
        //Thread.sleep(2000);

        processReaderWriter.printLine(s);
       // Thread.sleep(2000);
        processReaderWriter.printLine("\u0004");
        Thread.sleep(1000);


        assertEquals(s, processReaderWriter.readLines().head());

       // Thread.sleep(1000);
        echoServer.destroy();
        echoClient.destroy();

    }
}




