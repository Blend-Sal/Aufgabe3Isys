package echo.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import actor.Actor;
import actor.AskStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stream.Stream;

public class EchoActorTest {


    @ParameterizedTest
    @ValueSource(strings = { "Moin", "Hello", "bye" })
    public void echoActorTest (String in) throws InterruptedException {
        Stream<String> askStr = AskStream.ask(new EchoActor("1", Actor.Type.SERIAL),in,100);
        assertEquals(in, askStr.head());
    }

}
