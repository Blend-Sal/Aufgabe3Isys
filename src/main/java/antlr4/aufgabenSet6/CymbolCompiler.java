package antlr4.aufgabenSet6;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class CymbolCompiler {
    public static Symbol.Type getType(int tokenType) {
        switch (tokenType) {
            case CymbolParser.K_VOID:
                return Symbol.Type.tVOID;
            case CymbolParser.K_INT:
                return Symbol.Type.tINT;
            case CymbolParser.K_FLOAT:
                return Symbol.Type.tFLOAT;
        }
        return Symbol.Type.tINVALID;
    }

    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(), msg);
    }

    public String process(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }
        CymbolLexer lexer = new CymbolLexer(CharStreams.fromStream(is));
        CymbolParser parser = new CymbolParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);
        ParseTree tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk(def, tree);
        RefPhase ref = new RefPhase(def.globals, def.scopes);
        walker.walk(ref, tree);

        String out = ref.getTemplateTree().get(tree).render();
        System.out.println(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new CymbolCompiler().process(args);
    }
}