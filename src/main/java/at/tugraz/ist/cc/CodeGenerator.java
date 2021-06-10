package at.tugraz.ist.cc;


import at.tugraz.ist.cc.error.ErrorHandler;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author wehopeu
 *
 */
public class CodeGenerator {

    public int createCode(String file_path, String out_path) {
        TypeChecker type_checker = new TypeChecker();

        type_checker.checkTypes(file_path, false);

        if (ErrorHandler.INSTANCE.getNumLexErrors() > 0)
            return ErrorHandler.INSTANCE.getNumLexErrors();
        else if (ErrorHandler.INSTANCE.getNumParseErrors() > 0)
            return ErrorHandler.INSTANCE.getNumParseErrors();
        else if (ErrorHandler.INSTANCE.getNumTypeErrors() > 0)
            return ErrorHandler.INSTANCE.getNumTypeErrors();

        File output_dir = new File(out_path);
        if (!output_dir.exists() && !output_dir.mkdirs()) {
            return 1;
        }


        ParseTree            parse_tree = type_checker.getParseTree();
        CodeGeneratorVisitor visitor    = new CodeGeneratorVisitor(type_checker.visitor);

        visitor.visit(parse_tree);

        Map<String, List<JasminBaseInstruction>> jasmin_instructions = visitor.getJasminInstructions();

        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            try {
                String file_name  = entry.getKey() + ".j";
                String output_file_path;
                if (!out_path.endsWith("/"))
                    output_file_path = out_path + "/" + file_name;
                else
                    output_file_path = out_path + file_name;

                OutputStream out_stream = new FileOutputStream(new File(output_file_path));
                for (JasminBaseInstruction jasmin_instruction : entry.getValue()) {
                    String instruction_string = jasmin_instruction.convertToString();
                    out_stream.write(instruction_string.getBytes(), 0, instruction_string.length());
                }

                out_stream.close();
            }
            catch (IOException e) {
                return -1;
            }
        }

        return 0;
    }
}
