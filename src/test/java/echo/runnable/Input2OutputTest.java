package echo.runnable;

import inout.ScriptReader;
import inout.ScriptWriter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static echo.runnable.Input2Output.input2output;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input2OutputTest {

    @ParameterizedTest
    @CsvSource({"'Hallo1\nHallo2'",
            "'HalloHallo\njaja'"})
    public void test(String s) {
        assertEquals("bla", "bla");
    }

   @ParameterizedTest
    @CsvSource({"0ne", "Tw0", "Thr33"})
    public void i2o_Test(String str) {
       ScriptReader sR = new ScriptReader(str);
       ScriptWriter sW = new ScriptWriter();
       Runnable i2O = input2output(sR, sW);
       i2O.run();
       assertEquals(sR.toList(), sW.toList());

   }
}

