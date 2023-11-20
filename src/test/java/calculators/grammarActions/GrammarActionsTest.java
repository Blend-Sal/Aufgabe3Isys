package calculators.grammarActions;

import antlr4.kalkulator.grammarActions.tools.ExprLexer;
import antlr4.kalkulator.grammarActions.tools.ExprParser;
import antlr4.kalkulator.parseTreeVisitor.EvalVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrammarActionsTest {
    @ParameterizedTest
    @CsvSource(value = {"'5+2\n 2*2\n', '7\n4\n'", "'3+7\n1+2\n', '10\n3\n'", "'3-7*2\n', '-11\n'", "'2^2*2\n', '8\n'", "'3<5^2\n', '1\n'", "'2^8<10\n', '0\n'"}, delimiter = ',')
    public void test(String input, String output) {
        CharStream inputStream = CharStreams.fromString(input);
        ExprLexer lexer = new ExprLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        parser.prog();
        System.setOut(originalOut);

        assertEquals(output, outContent.toString().replaceAll("\r", ""));

    }
}

