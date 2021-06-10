package at.tugraz.ist.cc;


/**
 * @author cc17
 *
 */
public class Main {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("USAGE:");
            System.out.println("param1 (task): lexer|parser|typechecker|bytecode");
            System.out.println("param2: path to the input file (*.jova)");
            System.out.println("param3 (debug): true|false");
            System.out.println("param4: path to output folder (for bytecode)");
            System.exit(-1);
        }

        if (args[0].equals("lexer")) {
            LexicalAndSyntaxAnalyzer lexAndSyntax = new LexicalAndSyntaxAnalyzer();
            lexAndSyntax.lexer(args[1], Boolean.parseBoolean(args[2]));
        } else if (args[0].equals("parser")) {
            LexicalAndSyntaxAnalyzer lexAndSyntax = new LexicalAndSyntaxAnalyzer();
            lexAndSyntax.parser(args[1], Boolean.parseBoolean(args[2]));
        } else if (args[0].equals("typechecker")) {
            TypeChecker typeChecker = new TypeChecker();
            typeChecker.checkTypes(args[1], Boolean.parseBoolean(args[2]));
        } else if (args[0].equals("bytecode")) {
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.createCode(args[1], args[3]);
        } else if (args[0].equals("codeopt")) {
            CodeOpt co = new CodeOpt();
            co.optimizeCode(args[1], Boolean.parseBoolean(args[2]), args[3]);
        } else {
            System.out.println("Unknown task name: " + args[0]);
        }
    }

}
