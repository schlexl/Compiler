package at.tugraz.ist.cc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.junit.Test;


public class TypeCheckerPublicTest {

    private final String path_coercion = "src/test/resources/public/input/typechecking/coercion_warning/";
    private final String path_fail = "src/test/resources/public/input/typechecking/fail/";
    private final String path_pass = "src/test/resources/public/input/typechecking/pass/";
    
    TypeChecker typeChecker = new TypeChecker();
    boolean debug = true;

    @Test
    public void testPass01() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass01.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass02() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass02.jova", debug);
        assertEquals(0, result);
    }
        @Test
    public void testPass03() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass03.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass04() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass04.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass05Custom() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass05.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass05() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_coercion + "warning01.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass06() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_coercion + "warning02.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass07() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_coercion + "warning03.jova", debug);
        assertEquals(0, result);
    }
    
    @Test
    public void testPass08() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_coercion + "warning04.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass09() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass06.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testPass10() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_pass + "pass07.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testFail01() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "access/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail02() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "access/fail02.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail03() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail04() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail02.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail05() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail03.jova", debug);
        assertTrue(result > 0);
    }

    
    @Test
    public void testFail06() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail04.jova", debug);
        assertTrue(result > 0);
    }
    
    
    @Test
    public void testFail07() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail05.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testFail08() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incompatible_condition/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail09() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incompatible_return/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail10() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail11() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail02.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testFail12() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "main_structure/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail13() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "main_structure/fail02.jova", debug);
        assertTrue(result > 0);
    }
   
    @Test
    public void testFail14() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "undeclared_id/fail01.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail15() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "undeclared_id/fail02.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail16() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "undeclared_id/fail03.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testFail17() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "undeclared_id/fail04.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail18() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "undeclared_id/fail05.jova", debug);
        assertTrue(result > 0);
    }

        @Test
    public void testFail19() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail06.jova", debug);
        assertTrue(result > 0);
    }

    
    @Test
    public void testFail20() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail07.jova", debug);
        assertTrue(result > 0);
    }
    
    
    @Test
    public void testFail21() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "double_decl/fail08.jova", debug);
        assertTrue(result > 0);
    }

        @Test
    public void testFail22() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incompatible_condition/fail02.jova", debug);
        assertTrue(result > 0);
    }

        @Test
    public void testFail23() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail03.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail24() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail04.jova", debug);
        assertTrue(result > 0);
    }
            @Test
    public void testFail25() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail05.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail26() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail06.jova", debug);
        assertTrue(result > 0);
    }
            @Test
    public void testFail27() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail07.jova", debug);
        assertTrue(result > 0);
    }
    
    @Test
    public void testFail28() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "incorrect_operand/fail08.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testFail29() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail01.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testFail30() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail02.jova", debug);
        assertEquals(result, 1);
    }

    @Test
    public void testFail31() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail03.jova", debug);
        assertEquals(1, result);
    }

    @Test
    public void testFail32() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail04.jova", debug);
        assertEquals(result, 1);
    }

    @Test
    public void testFail33() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail05.jova", debug);
        assertEquals(result, 1);
    }

    @Test
    public void testFail34() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail06.jova", debug);
        assertEquals(1, result);
    }

    @Test
    public void testFail35() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail07.jova", debug);
        assertEquals(result, 1);
    }

    /** print TC*/
    //invalid Type in print()
    @Test
    public void testFail36() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail08.jova", debug);
        assertEquals(result, 1);
    }

    // double declaration of method print(int)  print(String)  print(bool) allows print(int, String)
    @Test
    public void testFail37() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail09.jova", debug);
        assertEquals(result, 3);
    }

    /** Main TC*/
    //public String main() {
    @Test
    public void testFail38() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail10.jova", debug);
        assertEquals(2, result);
    }

    //no Main Class
    @Test
    public void testFail39() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail11.jova", debug);
        assertEquals(result, 0);
    }

    //no main Method
    @Test
    public void testFail40() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail12.jova", debug);
        assertEquals(result, 0);
    }

    //public String main() in Main Class
    @Test
    public void testFail41() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail13.jova", debug);
        assertEquals(2, result);
    }

    //private int main() in Main Class
    @Test
    public void testFail42() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail14.jova", debug);
        assertEquals(result, 1);
    }


    /** Class_head TC*/
    // double Decl Class
    @Test
    public void testFail43() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail15.jova", debug);
        assertEquals(result, 1);
    }

    /** Class_body/method_decl TC*/
    // distinct method_decl
    @Test
    public void testFail44() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail16.jova", debug);
        assertEquals(result, 1);
    }
    // distinct method_decl pass. return types not in cosideration
    @Test
    public void testFail45() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail20.jova", debug);
        assertEquals(1, result);
    }

    //  method body// declaration in method head and assign_stmt in body + some Addition Operations
    @Test
    public void testFail46() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail17.jova", debug);
        assertEquals(result, 0);
    }

    //  method body// methods have own scope
    @Test
    public void testFail47() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail18.jova", debug);
        assertEquals(result, 0);
    }

    //  method body// method return
    @Test
    public void testFail48() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail19.jova", debug);
        assertEquals(5, result);
    }

    /** Class_body/member_decl TC*/
    // no member in main
    @Test
    public void testFail49() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail21.jova", debug);
        assertEquals(result, 1);
    }

    // every class own member scope
    @Test
    public void testFail50() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail22.jova", debug);
        assertEquals(result, 0);
    }

    /** Class_body/ctor TC*/
    // every class own member scope
    @Test
    public void testFail51() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail23.jova", debug);
        assertEquals(result, 0);
    }







    /** TC mentioned on assignment sheet*/

    /**Main */
    //Main can not have constructors, members or methods.
    @Test
    public void testFail52() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail24.jova", debug);
        assertEquals(result, 4);
    }

    /**Scopes*/
    //error to declare a variable, a method, a constructor, or a class more than once in
    //any given scope

    //Class: the members’ identifiers cannot be reused inside any method of this class
    @Test
    public void testFail53() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail25.jova", debug);
        assertEquals(result, 1);
    }

    //Method
    //Every method has own scope. Variable with same name in different scopes. Not bool func(){String x;int x;...} or bool func(int x){String x;...} or
    // bool func(String x,int x)
    @Test
    public void testFail54() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail26.jova", debug);
        assertEquals(result, 2);
    }

    /// Constructor
    //Every method has own scope. Variable with same name in different scopes. Not bool func(){String x;int x;...} or bool func(int x){String x;...} or
    // bool func(String x,int x)
    @Test
    public void testFail55() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail27.jova", debug);
        assertEquals(result, 1);
    }

    //Furthermore, you should enable 2 ways to allocate objects:
    //default constructor call without a parameter list (e.g. foo = new MyClass;)
    //The custom constructor call with a parameter list (e.g. foo = new MyClass();
    //or foo = new MyClass(a,42,"bar");)
    @Test
    public void testFail56() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail28.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail57() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail29.jova", debug);
        assertEquals(result, 2);
    }

    @Test
    public void testFail58() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail30.jova", debug);
        assertEquals(result, 4);
    }

    // if,while, for, do-while dont have their own scope
    @Test
    public void testFail59() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail31.jova", debug);
        assertEquals(result, 2);
    }

    /**Declarations*/
    //Class
    //Multiple declarations of the same class name are not allowed.
    @Test
    public void testFail60() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail32.jova", debug);
        assertEquals(result, 1);
    }

    //bool func(String x, int y), bool func(bool x, int y) is allowed
    @Test
    public void testFail61() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail33.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail62() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail34.jova", debug);
        assertEquals(result, 0);
    }


    //Whereas multiple declarations in the same class using the exact same combination of
    //these factors should be reported as an error
    @Test
    public void testFail63() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail35.jova", debug);
        assertEquals(result, 1);
    }

    @Test
    public void testFail64() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail36.jova", debug);
        assertEquals(result, 1);
    }

    //Implicit function declarations
    @Test
    public void testFail65() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail37.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail66() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail38.jova", debug);
        assertEquals(result, 1);
    }

    /**Access Modifier*/
    @Test
    public void testFail67() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail39.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail68() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail40.jova", debug);
        assertEquals(result, 2);
    }

    /**Type Checking*/
    //Type checking involves the task of determining the validity of each combination of operator and
    //operands occurring in the source program.

    //Operators and conditions
    // all expected Type
    @Test
    public void testFail69() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail41.jova", debug);
        assertEquals(result, 0);
    }
    // accepted type
    @Test
    public void testFail70() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail42.jova", debug);
        assertEquals(result, 0);
    }

    // Rejected Type
    @Test
    public void testFail71() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail43.jova", debug);
        assertEquals(result, 66);
    }

    @Test
    public void testFail72() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail44.jova", debug);
        assertEquals(result, 0);
    }

    //return worng type
    @Test
    public void testFail73() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail45.jova", debug);
        assertEquals(result, 1);
    }

    //while
    @Test
    public void testFail74() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail46.jova", debug);
        assertEquals(result, 1);
    }

    //coerced
    @Test
    public void testFail75() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail47.jova", debug);
        assertEquals(result, 0);
    }

    //ternop
    @Test
    public void testFail76() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail48.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail77() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail49.jova", debug);
        assertEquals(result, 0);
    }

    @Test
    public void testFail78() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail50.jova", debug);
        assertEquals(result, 1);
    }

    @Test
    public void testFail79() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail51.jova", debug);
        assertEquals(result, 2);
    }

    //assign Test
    @Test
    public void testFail80() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail52.jova", debug);
        assertEquals(result, 9);
    }

    @Test
    public void testFail81() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail53.jova", debug);
        assertEquals(result, 3);
    }

    @Test
    public void testOperatorRelGtTest() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/operator_rel_gt.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testOperatorUnSign() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/operator_un_sign.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testCtor() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/ctor_tests.jova", debug);
        assertEquals(10, result);
    }

    @Test
    public void testUnknownReturnType() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/method_return.jova", debug);
        assertEquals(2, result);
    }


    @Test
    public void testFail82() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail54.jova", debug);
        assertEquals(10, result);
    }
    /*@Test
    public void testUndefined() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail55.jova", debug);
        assertEquals(25, result);
    }*/
    @Test
    public void testFail83() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/my_fail56.jova", debug);
        assertEquals(5, result);
    }

    @Test
    public void testDoubleDecl() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/double_decl.jova", debug);
        assertEquals(8, result);
    }

    @Test
    public void testMemberAccess() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/member_access.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testDoubleDec() {
        ErrorHandler.INSTANCE.reset();
        int result = typeChecker.checkTypes(path_fail+ "my_test_cases/double_dec.jova", debug);
        assertEquals(0, result);
    }
}


