package G6;

import antlr4.G6.G6Lexer;
import antlr4.G6.G6Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class G6Test {

    @ParameterizedTest
    @CsvSource("'(prog (stat (expr (expr (term (term (term (fact 10)) * (fact 2)) / (fact 2))) + (term (fact 4))) \\n))'")
    public void g6Test(String str) {
        CharStream input = CharStreams.fromString("10 * 2 / 2 + 4 \n");
        G6Lexer lexer = new G6Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        G6Parser parser = new G6Parser(tokens);
        ParseTree tree = parser.prog();
        String erg = tree.toStringTree(parser);
        Assertions.assertEquals(str, erg);
    }

}
