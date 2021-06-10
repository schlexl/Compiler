package at.tugraz.ist.cc;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Assert;


import static org.junit.Assert.*;

public class CodeGenerationPrivateTest {
    private final String path_bytecode = "src/test/resources/public/input/bytecode/";
    private final String path_ref      = "src/test/resources/public/ref/bytecode";

    CodeGenerator code_generator = new CodeGenerator();

    /*@Test
    public void testPass01() {
        ErrorHandler.INSTANCE.reset();
        int result = code_optimizer.createCode(path_bytecode + "pass01.jova", path_bytecode + "out/pass01/");
        assertEquals(0, result);
    }*/
    @Test
    public void testPass01_test() throws IOException {
        int result = code_generator.createCode(path_bytecode + "pass01.jova", path_bytecode + "out/pass01/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass01/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass01/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/pass01/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/pass01/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass01/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/pass01/" + "pass01" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testPass02() {
        int result = code_generator.createCode(path_bytecode + "pass02.jova", path_bytecode + "out/pass02/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass02/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass02/" + " Main";
        try {
            File currentfile =new File("src/test/resources/public/input/bytecode/out/pass02/Main.class");
            currentfile.delete();
            ExecJ_File(command);
            File file = new File("Main.class");
            file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass02/Main.class"));
            commandClassPath(commandexecClassFile, path_bytecode + "out/pass02/"+"pass02"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void testPass03() {
        int result = code_generator.createCode(path_bytecode + "pass03.jova", path_bytecode + "out/pass03/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass03/Main.j";
        String command2 = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass03/JonSnow.j";
        String command3 = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass03/Knowledge.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass03/" + " Main";
        try {
            ExecJ_File(command);
            ExecJ_File(command2);
            ExecJ_File(command3);
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/pass03/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass03/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/pass03/"+"pass03"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testPass04() {
        int result = code_generator.createCode(path_bytecode + "pass04.jova", path_bytecode + "out/pass04/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass04/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass04/" + " Main";
        try {
            File currentfile =new File("src/test/resources/public/input/bytecode/out/pass04/Main.class");
            currentfile.delete();
            ExecJ_File(command);
            File file = new File("Main.class");
            file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass04/Main.class"));
            commandClassPath(commandexecClassFile, path_bytecode + "out/pass04/"+"pass04"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testPass05() {
        int result = code_generator.createCode(path_bytecode + "pass05.jova", path_bytecode + "out/pass05/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass05/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass05/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/pass05/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/pass05/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass05/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/pass05/" + "pass05" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testPass06() {
        int result = code_generator.createCode(path_bytecode + "pass06.jova", path_bytecode + "out/pass06/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass06/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass06/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/pass06/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/pass06/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass06/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/pass06/" + "pass06" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void testPass07() {
        int result = code_generator.createCode(path_bytecode + "pass07.jova", path_bytecode + "out/pass07/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/pass07/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/pass07/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/pass07/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/pass07/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/pass07/" + class_file));
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void testSimplePrint() {
        int result = code_generator.createCode(path_bytecode + "simplePrint.jova", path_bytecode + "out/simplePrint/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/simplePrint/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simplePrint/" + " Main";
        try {
            ExecJ_File(command);
            ///\TODO TEST
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simplePrint/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simplePrint/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simplePrint/"+"simplePrint"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void testEmptyMain() {
        int result = code_generator.createCode(path_bytecode + "emptyMain.jova", path_bytecode + "out/emptyMain/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/emptyMain/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/emptyMain/" + " Main";
        try {
            ExecJ_File(command);
            ///\TODO TEST
            File dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                File currentfile =new File("src/test/resources/public/input/bytecode/out/emptyMain/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/emptyMain/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/emptyMain/"+"emptyMain"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void testSimpleCalc() {
        int result = code_generator.createCode(path_bytecode + "simpleCalc.jova", path_bytecode + "out/simpleCalc/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/simpleCalc/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleCalc/" + " Main";
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
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleCalc/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleCalc/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleCalc/"+"simpleCalc"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void simpleIF() {
        int result = code_generator.createCode(path_bytecode + "simpleIF.jova", path_bytecode + "out/simpleIF/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/simpleIF/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleIF/" + " Main";
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
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleIF/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleIF/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleIF/"+"simpleIF"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void simpleWhile() {
        int result = code_generator.createCode(path_bytecode + "simpleWhile.jova", path_bytecode + "out/simpleWhile/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/simpleWhile/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleWhile/" + " Main";
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
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleWhile/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleWhile/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleWhile/"+"simpleWhile"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void RelationOp() {
        int result = code_generator.createCode(path_bytecode + "RelationOp.jova", path_bytecode + "out/relationOp/");
        String jar_path = "jasmin_Task3TUT.jar";
        String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/relationOp/Main.j";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/relationOp/" + " Main";
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
                File currentfile =new File("src/test/resources/public/input/bytecode/out/relationOp/"+ class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/relationOp/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/relationOp/"+"relationOp"+".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
   /* @Test
    public void testPass07() {
        ErrorHandler.INSTANCE.reset();
        int result = code_optimizer.createCode(path_bytecode + "pass07.jova", path_bytecode + "out/pass07/");
        assertEquals(0, result);

        try {
            byte[] expected_tower = Files.readAllBytes(Paths.get(path_ref + "/pass07/Tower.j"));
            byte[] computed_tower = Files.readAllBytes(Paths.get(path_bytecode + "out/pass07/Tower.j"));
            assertArrayEquals(expected_tower, computed_tower);

            byte[] expected_printer = Files.readAllBytes(Paths.get(path_ref + "/pass07/Printer.j"));
            byte[] computed_printer = Files.readAllBytes(Paths.get(path_bytecode + "out/pass07/Printer.j"));
            assertArrayEquals(expected_printer, computed_printer);
        }
        catch (IOException ignored) {
        }
    }*/
   @Test
   public void dead_code_CodeGen() {
       int result = code_generator.createCode(path_bytecode + "dead_code.jova", path_bytecode + "out/dead_code/");
       String jar_path = "jasmin_Task3TUT.jar";
       String command = "java -jar "+ jar_path+ " " + "src/test/resources/public/input/bytecode/out/dead_code/Main.j";
       String commandexecClassFile = "java -cp " + path_bytecode + "out/dead_code/" + " Main";
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
               File currentfile =new File("src/test/resources/public/input/bytecode/out/dead_code/"+ class_file);
               currentfile.delete();
               File file = new File(String.valueOf(class_file));
               file.renameTo(new File("src/test/resources/public/input/bytecode/out/dead_code/" + class_file));
           }

           ////

           commandClassPath(commandexecClassFile, path_bytecode + "out/dead_code/"+"dead_code"+".out");
       }
       catch (Exception ex) {
           System.out.println(ex);
       }
   }

    @Test
    public void simpleMemberAccess() {
        int    result               = code_generator.createCode(path_bytecode + "simpleMemberAccess.jova", path_bytecode + "out/simpleMemberAccess/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/simpleMemberAccess/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleMemberAccess/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/simpleMemberAccess/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleMemberAccess/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleMemberAccess/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleMemberAccess/" + "simpleMemberAccess" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void customCtor() {
        int result = code_generator.createCode(path_bytecode + "customCtor.jova", path_bytecode + "out/customCtor/");

        if (result != 0)
            return;

        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/customCtor/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/customCtor/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/customCtor/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/customCtor/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/customCtor/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/customCtor/" + "customCtor" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void nestedMemberAccess() {
        int    result               = code_generator.createCode(path_bytecode + "nestedMemberAccess.jova", path_bytecode + "out/nestedMemberAccess/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/nestedMemberAccess/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/nestedMemberAccess/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/nestedMemberAccess/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/nestedMemberAccess/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/nestedMemberAccess/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/nestedMemberAccess/" + "nestedMemberAccess" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void simpleTernary() {
        int    result               = code_generator.createCode(path_bytecode + "simpleTernary.jova", path_bytecode + "out/simpleTernary/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/simpleTernary/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleTernary/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/simpleTernary/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleTernary/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleTernary/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleTernary/" + "simpleTernary" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void simpleRelation() {
        int    result               = code_generator.createCode(path_bytecode + "simpleRelation.jova", path_bytecode + "out/simpleRelation/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/simpleRelation/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/simpleRelation/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/simpleRelation/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/simpleRelation/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/simpleRelation/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/simpleRelation/" + "simpleRelation" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void NestedTernary() {
        int    result               = code_generator.createCode(path_bytecode + "nestedTernary.jova", path_bytecode + "out/nestedTernary/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/nestedTernary/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/nestedTernary/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/nestedTernary/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/nestedTernary/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/nestedTernary/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/nestedTernary/" + "nestedTernary" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void advancedIF() {
        int    result               = code_generator.createCode(path_bytecode + "advancedIF.jova", path_bytecode + "out/advancedIF/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/advancedIF/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/advancedIF/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/advancedIF/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/advancedIF/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/advancedIF/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/advancedIF/" + "advancedIF" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void IF_stackheight() {
        int    result               = code_generator.createCode(path_bytecode + "IF_stackheight.jova", path_bytecode + "out/IF_stackheight/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/IF_stackheight/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/IF_stackheight/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/IF_stackheight/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/IF_stackheight/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/IF_stackheight/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/IF_stackheight/" + "IF_stackheight" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void UnsignTest() {
        int    result               = code_generator.createCode(path_bytecode + "unSign.jova", path_bytecode + "out/UnsignTest/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/UnsignTest/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/UnsignTest/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/UnsignTest/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/UnsignTest/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/UnsignTest/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/UnsignTest/" + "UnsignTest" + ".out");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void logicOperators() {
        int    result               = code_generator.createCode(path_bytecode + "logicOperators.jova", path_bytecode + "out/logicOperators/");
        String jar_path             = "jasmin_Task3TUT.jar";
        String command              = "java -jar " + jar_path + " " + "src/test/resources/public/input/bytecode/out/logicOperators/";
        String commandexecClassFile = "java -cp " + path_bytecode + "out/logicOperators/" + " Main";
        try {
            File dir = new File("src/test/resources/public/input/bytecode/out/logicOperators/");
            File[] jasmin_files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".j");
                }
            });

            for (File file : jasmin_files) {
                String test = command + file.getName();
                ExecJ_File(test);
            }

            dir = new File(".");
            File [] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".class");
                }
            });

            for (File class_file : files) {
                System.out.println(class_file);
                File currentfile =new File("src/test/resources/public/input/bytecode/out/logicOperators/" + class_file);
                currentfile.delete();
                File file = new File(String.valueOf(class_file));
                file.renameTo(new File("src/test/resources/public/input/bytecode/out/logicOperators/" + class_file));
            }

            ////

            commandClassPath(commandexecClassFile, path_bytecode + "out/logicOperators/" + "logicOperators" + ".out");
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
