package tokenReader;

import antlr4.antlrInput.AntlrInput;
import fpinjava.Function;
import fpinjava.Result;
import inout.Input;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import tuple.Tuple;

import java.io.IOException;

public class TokenReader implements AntlrInput<Token> {
    private Lexer lexer;
    private TokenReader(Lexer lexer){
        this.lexer = lexer;
    }
    public static TokenReader tokenReader(Lexer lexer){
        return new TokenReader(lexer);
    }
    public static Result<AntlrInput<Token>>lexFile(String filename, Function<CharStream,Lexer> lexer){
        return Result.of(() -> tokenReader(lexer.apply(CharStreams.fromFileName(filename))));
    }

    public Result<Tuple<Token, AntlrInput<Token>>>read() {
        Token t = lexer.nextToken();
        return t.getType() == Token.EOF
                ? Result.
                empty()
                : Result.
                success(new Tuple<>(t,this));
    }

    @Override
    public Result<Tuple<String, Input>> readLine() {
        return null;
    }

    @Override
    public void shutdownInput() throws IOException {

    }

}