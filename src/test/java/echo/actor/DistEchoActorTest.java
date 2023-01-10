package echo.actor;

import actor.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static actor.ActorSystem.publish2multiple;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistEchoActorTest {
   /* @ParameterizedTest
    @CsvSource({"'Hello.'"})
    public void echoActorTest(String s) throws Exception {
        Thread echo = new Thread(publish2multiple(new EchoActor("id", Actor.Type.SERIAL), 1111));
        Thread.sleep(100);
        echo.start();
        Writer w = ActorSystem.actorSelection("localhost",1111).call();
        Thread.sleep(100);
        assertEquals(AskStream.ask(w, s, 100).head(), s);
        Thread.sleep(50);
    }*/
   @ParameterizedTest
   @CsvSource({"Test1", "Test2", "Test3"})
   public void DistEchoActorTest(String s) throws Exception {
       ProcessBuilder serverBuilder = new ProcessBuilder("java", "-jar" , "out/artifacts/echoServer/echoServer.jar", "localhost", "1111");
       Process echoServer = serverBuilder.start();
       Thread.sleep(100);
       Writer clientWriter = ActorSystem.actorSelection("localhost",1111).call();
       Thread.sleep(100);
       assertEquals(AskStream.ask(clientWriter, s, 100).head(), s);
       Thread.sleep(100);
       echoServer.destroy();
   }
}


