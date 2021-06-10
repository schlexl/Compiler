package at.tugraz.ist.cc;

import org.junit.Test;

import java.io.*;

public class CodeOptimizationPrivateTest {
    private final String path_bytecode = "src/test/resources/public/input/bytecode/";
    private final String path_ref      = "src/test/resources/public/ref/bytecode";

    CodeOpt code_optimizer = new CodeOpt();

    @Test
    public void testSimpleCalc() {
        int result = code_optimizer.optimizeCode(path_bytecode + "simpleCalc.jova", false, path_bytecode + "out_opt/simpleCalc/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/simpleCalc/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/simpleCalc/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/simpleCalc/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/simpleCalc/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/simpleCalc/" + "simpleCalc"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void dead_code_Opt() {
        int result = code_optimizer.optimizeCode(path_bytecode + "dead_code.jova", false, path_bytecode + "out_opt/dead_code/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/dead_code/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/dead_code/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/dead_code/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/dead_code/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/dead_code/" + "dead_code"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void div0() {
        int result = code_optimizer.optimizeCode(path_bytecode + "div0.jova", false, path_bytecode + "out_opt/div0/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/div0/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/div0/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/div0/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/div0/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/div0/" + "div0"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void codeOpt_Prints() {
        int result = code_optimizer.optimizeCode(path_bytecode + "codeOpt_Prints.jova", false, path_bytecode + "out_opt/codeOpt_Prints/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/codeOpt_Prints/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/codeOpt_Prints/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/codeOpt_Prints/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/codeOpt_Prints/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/codeOpt_Prints/" + "codeOpt_Prints"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void nonOptimzingParameters() {
        int result = code_optimizer.optimizeCode(path_bytecode + "nonOptParam.jova", false, path_bytecode + "out_opt/nonOptParam/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/nonOptParam/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/nonOptParam/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/nonOptParam/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/nonOptParam/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/nonOptParam/" + "nonOptParam"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void Opt_calc2() {
        int result = code_optimizer.optimizeCode(path_bytecode + "Opt_calc2.jova", false, path_bytecode + "out_opt/Opt_calc2/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/Opt_calc2/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/Opt_calc2/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/Opt_calc2/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/Opt_calc2/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/Opt_calc2/" + "Opt_calc2"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void Const_prop() {
        int result = code_optimizer.optimizeCode(path_bytecode + "Constant_progagation.jova", false, path_bytecode + "out_opt/Constant_propagation/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/Constant_propagation/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/Constant_propagation/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/Constant_propagation/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/Constant_propagation/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/Constant_propagation/" + "Constant_propagation"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }




    @Test
    public void IloadandIstore() {
        int result = code_optimizer.optimizeCode(path_bytecode + "IloadandIstore.jova", false, path_bytecode + "out_opt/IloadandIstore/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/IloadandIstore/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/IloadandIstore/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/IloadandIstore/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/IloadandIstore/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/IloadandIstore/" + "IloadandIstore"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void noOPT() {
        int result = code_optimizer.optimizeCode(path_bytecode + "noOPT.jova", false, path_bytecode + "out_opt/noOPT/");

        if (result == -1)
            return;

        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out_opt/noOPT/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out_opt/noOPT/" + " Main";
        try {
            ExecJ_File(command);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out_opt/noOPT/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out_opt/noOPT/" + class_file));
            }

            commandClassPath(commandexecClassFile, path_bytecode + "out_opt/noOPT/" + "noOPT"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }



    private void ExecJ_File(String command) throws Exception
    {
        System.out.println("Use command: " + command);
        String line;
        Process process = Runtime.getRuntime().exec(command);
        Reader r = new InputStreamReader(process.getInputStream());
        BufferedReader in = new BufferedReader(r);

        while((line = in.readLine()) != null) System.out.println(line);
        in.close();
    }
    private void commandClassPath(String command, String filename) throws Exception
    {
        FileWriter fw = new FileWriter(filename);
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            fw.write(s+"\n");
        }

        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
            fw.write(s+"\n");
        }
        fw.close();
        stdInput.close();
        stdError.close();
    }

}
