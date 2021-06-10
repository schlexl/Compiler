package at.tugraz.ist.cc;
import org.antlr.v4.runtime.tree.ParseTree;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.util.Map;

/**
 * @author wehopeu
 *
 */
public class TypeChecker {

    public TypeCheckerVisitor visitor = new TypeCheckerVisitor();
    private ParseTree         parse_tree;

    public Map<String, TypeCheckerVisitor.ClassMembers> getSymbolTable() {
        return visitor.symbol_table;
    }

    public ParseTree getParseTree() { return parse_tree; }

    public int checkTypes(String file_path, boolean debug) {
        if (debug)
            System.out.println("File: " + file_path);

        try {
            return typeCheck(file_path, debug); // try ok
        }
        catch (IOException e) {                 // catch ok
            e.printStackTrace();
        }
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    private int typeCheck(String file_path, boolean debug) throws IOException {
        JovaLexer jovaLexer          = new JovaLexer(CharStreams.fromFileName(file_path));
        CommonTokenStream jovaTokens = new CommonTokenStream(jovaLexer);
        JovaParser jovaParser        = new JovaParser(jovaTokens);

        parse_tree = jovaParser.program();
        visitor.visit(parse_tree);

        ErrorHandler.INSTANCE.printErrorsAndWarnings();

        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }
}
