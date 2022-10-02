package echo.runnable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import echo.runnable.Input2Output;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input2OutputTest {

    @ParameterizedTest
    @CsvSource({"'Hallo1\nHallo2'",
            "'HalloHallo\njaja'"})
    public void test(String s) {
        assertEquals("bla", "bla");
    }


    @ParameterizedTest
    @CsvSource({
            "'HalloHallo\njaja'"})
    public void test2(Input2Output io) {
        assertEquals(io, io );
    }
}

