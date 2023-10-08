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
import tokenReader.lexer.ip.ip;
import tokenReader.lexer.times.times;

public class IpTest {

    private static Function<Token, Function<Supplier<ST>, ST>> f = token -> stSupplier -> {
        ST st = stSupplier.get();
        st.add("ip", token.getText());
        return st;
    };

    @Test
    public void ipTest() {

        STGroup templates = new STGroupFile("src/main/java/tokenReader/lexer/ip/ip.stg");

        Result<AntlrInput<Token>> rTokenReader = TokenReader.lexFile("src/main/java/tokenReader/lexer/ip/ip_ex.txt", ip::new);

        Result<ST> rst = rTokenReader.map(tr -> tr.stream()
                .filter(t -> t.getType() == ip.IP)
                .foldr(() -> templates.getInstanceOf("ipExample"), f));

        rst.forEach(st -> System.out.println(st.render()));
    }
}
