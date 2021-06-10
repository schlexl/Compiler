package at.tugraz.ist.cc.error;

import at.tugraz.ist.cc.error.lexandparse.LexerError;
import at.tugraz.ist.cc.error.lexandparse.SyntaxError;
import at.tugraz.ist.cc.error.typechecker.MethodAccessError;
import at.tugraz.ist.cc.error.typechecker.BinaryTypeError;
import at.tugraz.ist.cc.error.typechecker.UnaryTypeError;
import at.tugraz.ist.cc.error.typechecker.CannotInvokeError;
import at.tugraz.ist.cc.error.typechecker.ClassDoubleDefTypeError;
import at.tugraz.ist.cc.error.typechecker.DoesNotHaveFieldError;
import at.tugraz.ist.cc.error.typechecker.IncompatibleCondTypeError;
import at.tugraz.ist.cc.error.typechecker.MethodDoubleDefTypeError;
import at.tugraz.ist.cc.error.typechecker.IncompatibleReturnTypeError;
import at.tugraz.ist.cc.error.typechecker.MainInstantiationError;
import at.tugraz.ist.cc.error.typechecker.MainMemberError;
import at.tugraz.ist.cc.error.typechecker.MemberAccessError;
import at.tugraz.ist.cc.error.typechecker.MemberDoubleDefTypeError;
import at.tugraz.ist.cc.error.typechecker.UndefMethodError;
import at.tugraz.ist.cc.error.typechecker.UndefIdError;
import at.tugraz.ist.cc.error.typechecker.UnknownTypeError;
import at.tugraz.ist.cc.error.typechecker.VarDoubleDefTypeError;
import at.tugraz.ist.cc.warning.JovaWarning;
import at.tugraz.ist.cc.warning.typechecker.BinaryCoercionWarning;
import at.tugraz.ist.cc.warning.typechecker.ConditionCoercionWarning;
import at.tugraz.ist.cc.warning.typechecker.ReturnCoercionWarning;
import at.tugraz.ist.cc.warning.typechecker.UnaryCoercionWarning;

/**
 * A factory class to generate {@link at.tugraz.ist.cc.error.JovaError} subclass
 * instances with the respective error messages defined in the assignment
 * description.
 * 
 * @author ccfuntime
 *
 */
public class JovaErrorFactory {
    private StringBuilder bob = null;

    private void appandStringArray(String[] a)
    {
        if (a.length != 0) {
            bob.append(a[0]);
            for (int i = 1; i < a.length; ++i)
                bob.append(" ").append(a[i]);
        }
    }

    public JovaError createLexerError(String msg, int line, int char_pos) {
        return new LexerError(msg, line, char_pos);
    }

    public JovaError createSyntaxError(String msg, int line, int char_pos) {

        return new SyntaxError(msg, line, char_pos);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (1) Use of undeclared identifiers.
    ///////////////////////////////////////////////////////////////////////////

    // Usage of undefined identifier ’<ID>’
    public JovaError createUndefIdError(int line, int char_pos, String id) {
        bob = new StringBuilder();
        bob.append("Usage of undefined identifier '").append(id).append("'");

        return new UndefIdError(bob.toString(), line, char_pos, id);
    }

    // '<class ID>' does not have field ’<ID>’
    public JovaError createDoesNotHaveFieldError(int line, int char_pos, String class_id, String field_id) {
        bob = new StringBuilder();
        bob.append("'").append(class_id).append("' does not have field '").append(field_id).append("'");
        return new DoesNotHaveFieldError(bob.toString(), line, char_pos, class_id, field_id);

    }

    // Call to undefined method ’<method signature>’
    public JovaError createUndefMethodError(int line, int char_pos, String method_id, String... param_types) {
        bob = new StringBuilder();
        bob.append("Call to undefined method '").append(method_id).append("(");
        appandStringArray(param_types);
        bob.append(")'");
        return new UndefMethodError(bob.toString(), line, char_pos, method_id, param_types);
    }

    // Cannot invoke method ’<method signature>’ on type ’<class ID>’
    public JovaError createCannotInvokeError(int line, int char_pos, String class_id, String method_id,
            String... arg_types) {
        bob = new StringBuilder();
        bob.append("Cannot invoke method '").append(method_id).append("(");
        appandStringArray(arg_types);
        bob.append(")' on type '").append(class_id).append("'");
        return new CannotInvokeError(bob.toString(), line, char_pos, class_id, method_id);

    }

    // Usage of undefined type ’<class ID>’
    public JovaError createUnknownTypeError(int line, int char_pos, String class_id) {
        bob = new StringBuilder();
        bob.append("Usage of undefined type '").append(class_id).append("'");
        return new UnknownTypeError(bob.toString(), line, char_pos, class_id);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (2) Double declarations of variables, methods, members and classes.
    ///////////////////////////////////////////////////////////////////////////

    // Double definition of variable ’<type> <ID>’ in method ’<method
    // signature>’
    public JovaError createVarDoubleDefError(int line, int char_pos, String var_id, String var_type, String fct_id,
            String... param_types) {
        bob = new StringBuilder();
        bob.append("Double definition of variable '").append(var_type).append(" ").append(var_id)
                .append("' in method '").append(fct_id).append("(");
        appandStringArray(param_types);
        bob.append(")'");

        return new VarDoubleDefTypeError(bob.toString(), line, char_pos, var_id, var_type, fct_id);
    }

    // Double definition of method ’<method signature>’ in class ’<class ID>’
    public JovaError createMethodDoubleDefError(int line, int char_pos, String method_id, String class_id,
            String... param_types) {
        bob = new StringBuilder();
        bob.append("Double definition of method '").append(method_id).append("(");
        appandStringArray(param_types);
        bob.append(")' in class '").append(class_id).append("'");

        return new MethodDoubleDefTypeError(bob.toString(), line, char_pos, method_id,class_id);
    }

    // Double definition of member ’<type> <ID>’ in class ’<class ID>’
    public JovaError createMemberDoubleDefError(int line, int char_pos, String mem_id, String mem_type,
            String class_scope) {
        bob = new StringBuilder();
        bob.append("Double definition of member '").append(mem_type).append(" ").append(mem_id).append("' in class '")
                .append(class_scope).append("'");
        return new MemberDoubleDefTypeError(bob.toString(), line, char_pos, mem_id, mem_type);
    }

    // Double definition of class ’<class ID>’
    public JovaError createClassDoubleDefError(int line, int char_pos, String class_id) {
        bob = new StringBuilder();
        bob.append("Double definition of class '").append(class_id).append("'");
        return new ClassDoubleDefTypeError(bob.toString(), line, char_pos, class_id);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (3) Member and method access errors.
    ///////////////////////////////////////////////////////////////////////////

    // Field ’<ID>’ from type ’<class ID>’ not visible
    public JovaError createMemberAccessError(int line, int char_pos, String mem_id, String class_id) {
        bob = new StringBuilder();
        bob.append("Field '").append(mem_id).append("' from type '").append(class_id).append("' not visible");

        return new MemberAccessError(bob.toString(), line, char_pos, mem_id, class_id);
    }

    // Method ’<method signature>’ from type ’<class ID>’ not visible
    public JovaError createMethodAccessError(int line, int char_pos, String method_id, String class_id,
            String... param_types) {
        bob = new StringBuilder();
        bob.append("Method '").append(method_id).append("(");
        appandStringArray(param_types);
        bob.append(")' from type '").append(class_id).append("' not visible");
        return new MethodAccessError(bob.toString(), line, char_pos, method_id, class_id, param_types);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (4) Use of incorrect operand types.
    ///////////////////////////////////////////////////////////////////////////

    // Operator '<OP>' not defined for type(s) '<lhs-type>', '<rhs-type>'
    public JovaError createBinaryTypeError(int line, int char_pos, String lhs_type, String rhs_type, String op) {
        bob = new StringBuilder();
        bob.append("Operator '").append(op).append("' not defined for type(s) '").append(lhs_type).append("', '")
                .append(rhs_type).append("'");
        return new BinaryTypeError(bob.toString(), line, char_pos, lhs_type, rhs_type, op);
    }

    // Operator '<OP>' not defined for type '<type>'
    public JovaError createUnaryTypeError(int line, int char_pos, String type, String op) {
        bob = new StringBuilder();
        bob.append("Operator '").append(op).append("' not defined for type '").append(type).append("'");

        return new UnaryTypeError(bob.toString(), line, char_pos, type, op);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (5) Incompatible type for return:
    ///////////////////////////////////////////////////////////////////////////

    // Incompatible type ’<type>’ for return
    public JovaError createIncompatibleReturnTypeError(int line, int char_pos, String type) {
        bob = new StringBuilder();
        bob.append("Incompatible type '").append(type).append("' for return");

        return new IncompatibleReturnTypeError(bob.toString(), line, char_pos, type);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (6) Incompatible type for condition:
    ///////////////////////////////////////////////////////////////////////////

    // Incompatible type ’<type>’ for condition
    public JovaError createIncompatibleCondTypeError(int line, int char_pos, String type) {
        bob = new StringBuilder();
        bob.append("Incompatible type '").append(type).append("' for condition");

        return new IncompatibleCondTypeError(bob.toString(), line, char_pos, type);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (7) Illegal Main-class structure or access:
    ///////////////////////////////////////////////////////////////////////////

    // Main cannot be used as a type
    public JovaError createInstantiationError(int line, int char_pos) {
        bob = new StringBuilder();
        bob.append("Main cannot be used as a type");
        return new MainInstantiationError(bob.toString(), line, char_pos);
    }

    // Cannot add member to class Main
    public JovaError createMainMemberError(int line, int char_pos) {
        bob = new StringBuilder();
        bob.append("Cannot add member to class Main");
        return new MainMemberError(bob.toString(), line, char_pos);
    }

    ///////////////////////////////////////////////////////////////////////////
    // (8) Coercion Warnings:
    ///////////////////////////////////////////////////////////////////////////

    // Operator '<OP>': Found types: '<lhs-type>', '<rhs-type>'. Coerced to:
    // '<result-lhs-type>', '<result-rhs-type>'
    public JovaWarning createBinaryCoercionWarning(int line, int char_pos, String op, String found_lhs,
            String found_rhs, String res_lhs, String res_rhs) {
        return new BinaryCoercionWarning("Operator '" + op + "': Found types: '" + found_lhs + "', '" + found_rhs
                + "'. Coerced to: '" + res_lhs + "', '" + res_rhs + "'", line, char_pos, op, found_lhs, found_rhs, res_lhs,res_rhs);
    }

    // Operator '<OP>': Found type: '<type>'. Coerced to: '<result-type>'
    public JovaWarning createUnaryCoercionWarning(int line, int char_pos, String op, String found_type,
            String res_type) {
        return new UnaryCoercionWarning(
                "Operator '" + op + "': Found type: '" + found_type + "'. Coerced to: '" + res_type + "'", line,
                char_pos, op, found_type, res_type);
    }

    // Return: Found type: '<type>'. Coerced to: '<result-type>'
    public JovaWarning createReturnTypeCoercionWarning(int line, int char_pos, String found_type, String res_type) {
        return new ReturnCoercionWarning("Return: Found type: '" + found_type + "'. Coerced to: '" + res_type + "'",
                line, char_pos, found_type, res_type);
    }

    // Condition: Found type: '<type>'. Coerced to: '<result-type>'
    public JovaWarning createConditionTypeCoercionWarning(int line, int char_pos, String found_type, String res_type) {
        return new ConditionCoercionWarning("Condition: Found type: '" + found_type + "'. Coerced to: '" + res_type + "'",
                line, char_pos, found_type,res_type);
    }
}
