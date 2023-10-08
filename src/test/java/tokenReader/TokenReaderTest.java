package tokenReader;

import antlr4.antlrInput.AntlrInput;
import fpinjava.Function;
import fpinjava.Result;
import fpinjava.Supplier;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import tokenReader.lexer.times;


public class TokenReaderTest {

    private static Function<Token, Function<Supplier<ST>, ST>> f = token -> stSupplier -> {
        ST st = stSupplier.get();
        st.add("clock", token.getText());
        return st;
    };


    @Test
    public void timesTest() {

        STGroup templates = new STGroupFile("src/main/java/tokenReader/lexer/times.stg");

        Result<AntlrInput<Token>> rTokenReader = TokenReader.lexFile("src/main/java/tokenReader/lexer/times_ex.txt", times::new);

        Result<ST> rst = rTokenReader.map(tr -> tr.stream()
                .filter(t -> t.getType() == times.TIME)
                .foldr(() -> templates.getInstanceOf("clockExample"), f));

        rst.forEach(st -> System.out.println(st.render()));
    }

}