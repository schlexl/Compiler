package at.tugraz.ist.cc;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.antlr.v4.runtime.*;

import java.io.IOException;

/**
 * @author wehopeu
 *
 */
public class LexicalAndSyntaxAnalyzer {

    private static class LexerErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            ErrorHandler.INSTANCE.addLexerError(line, charPositionInLine, msg);
        }
    }

    private static class ParserErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            ErrorHandler.INSTANCE.addSyntaxError(line, charPositionInLine, msg);
        }
    }

    public int lexer(String file_path, boolean debug) {
        try
        {
            ErrorHandler.INSTANCE.reset();

            JovaLexer jova_lexer = new JovaLexer(CharStreams.fromFileName(file_path));
            jova_lexer.removeErrorListeners();
            jova_lexer.addErrorListener(new LexerErrorListener());

            JovaParser jova_parser = new JovaParser(new CommonTokenStream(jova_lexer));
            jova_parser.removeErrorListeners();
            jova_parser.program();

            ErrorHandler.INSTANCE.printLexerErrors();

            return ErrorHandler.INSTANCE.getNumLexErrors();
        }
        catch (IOException e)
        {
            return -1;
        }
    }

    public int parser(String file_path, boolean debug) {
        try
        {
            ErrorHandler.INSTANCE.reset();

            JovaLexer jova_lexer = new JovaLexer(CharStreams.fromFileName(file_path));
            jova_lexer.removeErrorListeners();
            jova_lexer.addErrorListener(new LexerErrorListener());

            ErrorHandler.INSTANCE.printLexerErrors();

            if (ErrorHandler.INSTANCE.getNumLexErrors() != 0)
                return ErrorHandler.INSTANCE.getNumLexErrors();

            JovaParser jova_parser = new JovaParser(new CommonTokenStream(jova_lexer));
            jova_parser.removeErrorListeners();
            jova_parser.addErrorListener(new ParserErrorListener());

            jova_parser.program();

            ErrorHandler.INSTANCE.printParserErrors();
            return ErrorHandler.INSTANCE.getNumParseErrors();
        }
        catch (IOException e)
        {
            return -1;
        }
    }

}
