package echo.actor;

import actor.Writer;
import inout.ScriptReader;
import inout.ScriptWriter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input2OutputTest {


    @ParameterizedTest
    @ValueSource(strings = { "Hello ", "World", "!!!" })
    public void echoActorTest(String s) throws InterruptedException {
        ScriptReader reader = new ScriptReader(s);
        ScriptWriter writer = new ScriptWriter();
        Writer.writer("writer", reader, writer).start();
        Thread.sleep(200);
        assertEquals(reader.toList(), writer.toList());
    }

}
