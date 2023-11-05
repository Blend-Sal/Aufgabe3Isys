package exprit;

import antlr4.exprit.expritLexer;
import antlr4.exprit.expritParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExpritTest {
    @ParameterizedTest
    @CsvSource("'(prog (stat (expr (term (fact 10) * (fact 2) / (fact 2)) + (term (fact 4))) \\n))'")
    public void expritTest(String str) {
        CharStream input = CharStreams.fromString("10 * 2 / 2 + 4 \n");
        expritLexer lexer = new expritLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        expritParser parser = new expritParser(tokens);
        ParseTree tree = parser.prog();
        String erg = tree.toStringTree(parser);
        Assertions.assertEquals(str, erg);
    }
}
