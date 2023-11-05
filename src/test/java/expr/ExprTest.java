package expr;

import antlr4.expr.ExprLexer;
import antlr4.expr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExprTest {
    @ParameterizedTest
    @CsvSource("'(prog (stat (expr (expr (expr 10) * (expr 2)) / (expr (expr 2) + (expr 4))) \\n))'")
    public void expritTest(String str) {
        CharStream input = CharStreams.fromString("10 * 2 / 2 + 4 \n");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();
        String erg = tree.toStringTree(parser);
        Assertions.assertEquals(str, erg);
    }
}
