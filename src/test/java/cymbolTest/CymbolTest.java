package cymbolTest;
import antlr4.aufgabenSet6.CymbolCompiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.*;
import java.util.stream.Stream;

public class CymbolTest {
    private static final String PATH = "src/test/resources/cymbolCompiler/";
    @ParameterizedTest
    @MethodSource("testparams")
    void testCymbolCompiler(String file, String output) throws Exception {
        try (FileWriter fw = new FileWriter(PATH +"code.rcode")) {
            String[] args = {file};
            fw.write(new CymbolCompiler().process(args));
        }
        final Process p = new ProcessBuilder(
                "java", "-jar", "out/artifacts/cymbol_Interpreter/cymbol_Interpreter.jar", PATH +"code.rcode").start();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            StringBuilder consoleOutput = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
                consoleOutput.append(line).append("\n");
            Assertions.assertEquals(output, consoleOutput.toString());
        }
        p.destroy();
    }

    static Stream<Arguments> testparams() {
        return Stream.of(Arguments.of(PATH +"evenodd.cymbol.c", "1\n0\n0\n1\n"),
                Arguments.of(PATH +"fact.cymbol.c", "6\n"),
                Arguments.of(PATH +"fib.cymbol.c", "5\n"),
                Arguments.of(PATH +"for.cymbol.c", "8\n"),
                Arguments.of(PATH +"funcCall.cymbol.c", "30\n"),
                Arguments.of(PATH +"ifElse.cymbol.c", "1\n"),
                Arguments.of(PATH +"ifgt.cymbol.c", "1\n"),
                Arguments.of(PATH +"iflt.cymbol.c", "1\n"),
                Arguments.of(PATH +"ifTrueFalse.cymbol.c", "1\n"),
                Arguments.of(PATH +"max.cymbol.c", "5\n"),
                Arguments.of(PATH +"neq.cymbol.c", "1\n"),
                Arguments.of(PATH +"not.cymbol.c", "4\n"),
                Arguments.of(PATH +"patternS261.cymbol.c", "30\n"),
                Arguments.of(PATH +"printf.cymbol.c", "7\n"),
                Arguments.of(PATH +"rec.cymbol.c", "24\n5\n12\n61\n91\n"),
                Arguments.of(PATH +"sum.cymbol.c", "21\n21\n"),
                Arguments.of(PATH +"uebungA.cymbol.c", "-173\n"),
                Arguments.of(PATH +"uminus.cymbol.c", "-3\n"),
                Arguments.of(PATH +"while.cymbol.c", "8\n"),
                Arguments.of(PATH +"whileTwice.cymbol.c", "64\n"),
                Arguments.of(PATH +"for.clobal.c", "8\n"),
                Arguments.of(PATH +"forTwice.clobal.c", "64\n"),
                Arguments.of(PATH +"funcCall.clobal.c", "30\n"),
                Arguments.of(PATH +"ifElse.clobal.c", "1\n"),
                Arguments.of(PATH +"ifgt.clobal.c", "1\n"),
                Arguments.of(PATH +"iflt.clobal.c", "1\n"),
                Arguments.of(PATH +"ifTrueFalse.clobal.c", "1\n"),
                Arguments.of(PATH +"neq.clobal.c", "1\n"),
                Arguments.of(PATH +"not.clobal.c", "4\n"),
                Arguments.of(PATH +"printf.clobal.c", "26\n"),
                Arguments.of(PATH +"uebungA.clobal.c", "-173\n"),
                Arguments.of(PATH +"uebungB.clobal.c", "-175\n"),
                Arguments.of(PATH +"uebungC.clobal.c", "-48\n"),
                Arguments.of(PATH +"uebungD.clobal.c", "-48\n"),
                Arguments.of(PATH +"uminus.clobal.c", "-3\n"),
                Arguments.of(PATH +"while.clobal.c", "8\n")
        );
    }
}