package at.tugraz.ist.cc.error;

import at.tugraz.ist.cc.warning.typechecker.ReturnCoercionWarning;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton to handle all error and warnings occurring during the lexer, parser
 * and type checker phase of the compiler. Use this class's methods to collect
 * and print your errors for task 1 and 2.
 * <p>
 * This class uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to
 * generate {@link at.tugraz.ist.cc.error.JovaError}s with specified error
 * messages and stores them in a 2-dimensional {@link java.util.ArrayList}
 * {@link #errors}. {@code errors} has a size of 4, that is one list for every
 * error type (see {@link #LEX_ERR}, {@link #PARSE_ERR}, {@link #TYPE_ERR} ,
 * {@link ErrorHandler#TYPE_WARNING}).
 * <p>
 * Use the <code>add..(..)</code> methods to add errors which shall be printed
 * later on.
 * <p>
 * The methods {@link #printLexerErrors()}, {@link #printParserErrors()},
 * {@link #printTypeErrors()} and {@link #printTypeWarnings()} should be used to
 * print the summary of previously added errors/warnings for the respective
 * task.
 * <p>
 * Since there is only one instance of this class it is might be necessary to
 * use the method {@link #reset()} during testing.
 * <p>
 * If you encounter any bugs/typos etc. or have ideas on how to improve the
 * framework please contact us via mail cc@ist.tugraz.at
 * 
 * @author cc17
 */
public enum ErrorHandler {
    /**
     * The singleton instance
     */
    INSTANCE;

    /**
     * Constant used to internally represent the lexer error type
     */
    private static final int LEX_ERR = 0;

    /**
     * Constant used to internally represent the parser/syntax error type
     */
    private static final int PARSE_ERR = 1;

    /**
     * Constant used to internally represent the type error type
     */
    private static final int TYPE_ERR = 2;

    /**
     * Constant used to internally represent the type warning type
     */
    private static final int TYPE_WARNING = 3;

    /**
     * The {@link at.tugraz.ist.cc.error.JovaErrorFactory ErrorFactory} used to
     * create new {@link at.tugraz.ist.cc.error.JovaError} instances
     */
    private final JovaErrorFactory fact = new JovaErrorFactory();

    /**
     * 2-dimensional list to hold all the errors. It is initialized as
     * {@link java.util.ArrayList} with a size of 4 by using the
     * {@link #initErrorList(int)} method to hold all 4 different error types
     * (including type warning).
     * <p>
     * Why can't I hold all dem errors?
     * <p>
     * Every error list for an error type is accessed via a constant index (see
     * {@link #LEX_ERR}, {@link #PARSE_ERR}, {@link #TYPE_ERR},
     * {@link #TYPE_WARNING}).
     */
    private List<List<JovaError>> errors = initErrorList(4);

    /**
     * Initializes {@link #errors} to the given size. Since <code>errors</code>
     * is a 2-dimensional list, it adds 1 new {@link java.util.ArrayList} for
     * the outer and adds <code>size</code> new <code>ArrayList</code>s to it.
     * 
     * @param size
     *            the wanted size of the outer list, that is the number of
     *            different error types and warnings
     * @return the newly initialized 2-dimensional list
     */
    private static List<List<JovaError>> initErrorList(int size) {
        List<List<JovaError>> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(new ArrayList<>());
        return list;
    }

    /**
     * Resets {@link #errors} by reinitializing it to a size of 4. Uses the
     * {@link #initErrorList(int)} method. May be used when performing unit
     * tests.
     * <b>WARNING: BE CAREFUL WHEN CALLING THIS MEHTOD INSIDE YOUR COMPILER
     * IMPLEMENTATION, SINCE THE TEST SYSTEM USES THIS CLASS' COLLECTIONS
     * TO CHECK FOR THE REPORTED ERRORS.</b>
     */
    public void reset() {
        errors = initErrorList(4);
    }

    /**
     * Prints a summary of previously added lexer errors in a formated way to
     * stdout. Use this method for printing your lexer errors for task 1.
     * <p>
     * Wrapper-method which uses {@link #checkAndPrintErrors(int)} to print a
     * summary of all errors of the lexer error type.
     */
    public void printLexerErrors() {
        checkAndPrintErrors(LEX_ERR);
    }

    /**
     * Prints a summary of previously added parser errors in a formated way to
     * stdout. Use this method for printing your parser errors for task 1.
     * <p>
     * Wrapper-method which uses {@link #checkAndPrintErrors(int)} to print a
     * summary of all errors of the parser error type.
     */
    public void printParserErrors() {
        checkAndPrintErrors(PARSE_ERR);
    }

    /**
     * Prints a summary of previously added type errors in a formated way to
     * stdout. Use this method for printing your type errors for task 2.
     * <p>
     * Wrapper-method which uses {@link #checkAndPrintErrors(int)} to print a
     * summary of all errors of the type error type.
     */
    public void printTypeErrors() {
        checkAndPrintErrors(TYPE_ERR);
    }

    /**
     * Prints a summary of previously added type warnings in a formated way to
     * stdout. Use this method for printing your type warnings for task 2.
     * <p>
     * Wrapper-method which uses {@link #checkAndPrintErrors(int)} to print a
     * summary of all warnings of the type warning type.
     */
    public void printTypeWarnings() {
        checkAndPrintErrors(TYPE_WARNING);
    }

    /**
     * Returns all {@link at.tugraz.ist.cc.error.JovaError}s with the lexer
     * error type added to {@link #errors} .
     * 
     * @return an <code>JovaError</code> array containing all elements added to
     *         <code>errors</code> with the lexer error type.
     */
    public JovaError[] getLexerErrors() {
        return errors.get(LEX_ERR).toArray(new JovaError[errors.get(LEX_ERR).size()]);
    }

    /**
     * Returns all {@link at.tugraz.ist.cc.error.JovaError}s with the parser
     * error type added to {@link #errors} .
     * 
     * @return an <code>JovaError</code> array containing all elements added to
     *         <code>errors</code> with the parser error type.
     */
    public JovaError[] getParserErrors() {
        return errors.get(PARSE_ERR).toArray(new JovaError[errors.get(PARSE_ERR).size()]);
    }

    /**
     * Returns all {@link at.tugraz.ist.cc.error.JovaError}s with the type error
     * type added to {@link #errors} .
     * 
     * @return an <code>JovaError</code> array containing all elements added to
     *         <code>errors</code> with the type error type.
     */
    public JovaError[] getTypeErrors() {
        return errors.get(TYPE_ERR).toArray(new JovaError[errors.get(TYPE_ERR).size()]);
    }

    /**
     * Returns all {@link at.tugraz.ist.cc.error.JovaError}s with the type
     * warning type added to {@link #errors} .
     * 
     * @return an <code>JovaError</code> array containing all elements added to
     *         <code>errors</code> with the type warning type.
     */
    public JovaError[] getTypeWarnings() {
        return errors.get(TYPE_WARNING).toArray(new JovaError[errors.get(TYPE_WARNING).size()]);
    }

    /**
     * Prints all previously added lexer, parser, type errors and type warnings
     * in a formated way to stdout.
     * <p>
     * Wrapper-method which uses {@link #checkAndPrintErrors(int)} to print a
     * summary of all errors and warning.
     * <p>
     * Stops printing the summary if errors are present.
     *
     *
     */
    public void printErrorsAndWarnings() {
        if (checkAndPrintErrors(LEX_ERR) && checkAndPrintErrors(PARSE_ERR) && checkAndPrintErrors(TYPE_ERR))
            checkAndPrintErrors(TYPE_WARNING);
    }

    /**
     * Returns the total number of lexer errors added to the error list.
     * 
     * @return the size of the lexer error list.
     */
    public int getNumLexErrors() {
        return errors.get(LEX_ERR).size();
    }

    /**
     * Returns the total number of parser errors added to the error list.
     * 
     * @return the size of the parser error list.
     */
    public int getNumParseErrors() {
        return errors.get(PARSE_ERR).size();
    }

    /**
     * Returns the total number of type errors added to the error list.
     * 
     * @return the size of the type error list.
     */
    public int getNumTypeErrors() {
        return errors.get(TYPE_ERR).size();
    }

    /**
     * Checks if the error list for a given error/warning type is empty and
     * prints a summary of all errors of the given error/warning type in a
     * formatted way to stdout. For every different error type an introduction
     * line is printed before the summary respectively. If the list of this
     * error type is empty only the introduction line is printed.
     * 
     * @param error_type
     *            the wanted error type. (see {@link #LEX_ERR},
     *            {@link #PARSE_ERR} , {@link #TYPE_ERR}, {@link #TYPE_WARNING})
     * @return <code>true</code> if the error list of the given error type is
     *         empty; <code>false</code> otherwise.
     */
    private boolean checkAndPrintErrors(int error_type) {
        final String error_type_str;

        switch (error_type) {
        case LEX_ERR:
            error_type_str = "lexical errors: ";
            break;
        case PARSE_ERR:
            error_type_str = "syntax errors: ";
            break;
        case TYPE_ERR:
            error_type_str = "type errors: ";
            break;
        case TYPE_WARNING:
            error_type_str = "type warnings: ";
            break;
        default:
            error_type_str = "";
            return false;
        }

        System.out.print(System.lineSeparator() + "Number of " + error_type_str + errors.get(error_type).size());

        int num_err = 0;
        if (error_type != TYPE_ERR) {
            for (JovaError e : errors.get(error_type))
                System.out.print(System.lineSeparator() + "  #" + ++num_err + ": line " + e.getLine() + ":"
                        + e.getCharPos() + " " + e.getMessage());

        } else {
            for (JovaError e : errors.get(error_type))
                System.out.print(System.lineSeparator() + "  #" + ++num_err + ": " + e.getMessage() + " (line "
                        + e.getLine() + ")");
        }

        System.out.print(System.lineSeparator());

        return num_err == 0 ? true : false;

    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.lexandparse.LexerError}
     * instance and adds it to the list of lexical errors. Use this method to
     * add new lexer errors to {@link #errors}.
     * 
     * @param line
     *            the line number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param msg
     *            a string with the error message to be printed
     */
    public void addLexerError(int line, int char_pos, String msg) {
        errors.get(LEX_ERR).add(fact.createLexerError(msg, line, char_pos));
    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.lexandparse.SyntaxError}
     * instance and adds it to the list of syntax errors. Use this method to add
     * new syntax errors to {@link #errors}.
     * 
     * @param line
     *            the line number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param msg
     *            a string with the error message to be printed
     */
    public void addSyntaxError(int line, int char_pos, String msg) {
        errors.get(PARSE_ERR).add(fact.createSyntaxError(msg, line, char_pos));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.warning.typechecker.BinaryCoercionWarning}
     * instance and adds it to the list of type warnings. Use this method to add
     * new coercion warnings for binary operators to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Operator 'op': Found types: 'found_lhs', 'found_rhs'. Coerced
     * to: 'res_lhs', 'res_rhs'</code>"
     * 
     * @param line
     *            the line's number where the coercion occurred in the source
     *            file
     * @param char_pos
     *            the character position in the line where the coercion occurred
     *            in the source file
     * @param op
     *            a string containing the Jova source code representation of the
     *            operator for which the coercion should be performed
     * @param found_lhs
     *            a string containing the Jova source code representation of the
     *            type of the operator's left-hand side operand
     * @param found_rhs
     *            a string containing the Jova source code representation of the
     *            type of the operator's right-hand side operand
     * @param res_lhs
     *            a string containing the Jova source code representation of the
     *            type which is the result of the coercion for the operator's
     *            left-hand side operand
     * @param res_rhs
     *            a string containing the Jova source code representation of the
     *            type which is the result of the coercion for the operator's
     *            right-hand side operand
     */
    public void addBinaryTypeCoercionWarning(int line, int char_pos, String op, String found_lhs, String found_rhs,
            String res_lhs, String res_rhs) {
        errors.get(TYPE_WARNING)
                .add(fact.createBinaryCoercionWarning(line, char_pos, op, found_lhs, found_rhs, res_lhs, res_rhs));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.warning.typechecker.UnaryCoercionWarning}
     * instance and adds it to the list of type warnings. Use this method to add
     * new coercion warnings for unary operators to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Operator 'op': Found type: 'found_type'. Coerced to: 'result_type'</code>
     * "
     * 
     * @param line
     *            the line's number where the coercion occurred in the source
     *            file
     * @param char_pos
     *            the character position in the line where the coercion occurred
     *            in the source file
     * @param op
     *            a string containing the Jova source code representation of the
     *            operator for which the coercion should be performed
     * @param found_type
     *            a string containing the Jova source code representation of the
     *            type of the operator's operand
     * @param res_type
     *            a string containing the Jova source code representation of the
     *            type which is the result of the coercion for the operator's
     *            operand
     */
    public void addUnaryTypeCoercionWarning(int line, int char_pos, String op, String found_type, String res_type) {
        errors.get(TYPE_WARNING).add(fact.createUnaryCoercionWarning(line, char_pos, op, found_type, res_type));
    }

    /**
     * Creates a new
     * {@link ReturnCoercionWarning}
     * instance and adds it to the list of type warnings. Use this method to add
     * new coercion warnings for return to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Return: Found type: 'found_type'. Coerced to: 'res_type'</code>"
     * 
     * @param line
     *            the line's number where the coercion occurred in the source
     *            file
     * @param char_pos
     *            the character position in the line where the coercion occurred
     *            in the source file
     * @param found_type
     *            a string containing the Jova source code representation of the
     *            type of the operator's operand
     * @param res_type
     *            a string containing the Jova source code representation of the
     *            type which is the result of the coercion for the operator's
     *            operand
     */
    public void addReturnTypeCoercionWarning(int line, int char_pos, String found_type, String res_type) {
        errors.get(TYPE_WARNING).add(fact.createReturnTypeCoercionWarning(line, char_pos, found_type, res_type));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.warning.typechecker.ConditionCoercionWarning}
     * instance and adds it to the list of type warnings. Use this method to add
     * new coercion warnings for conditions to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Condition: Found type: 'found_type'. Coerced to: 'res_type'</code>"
     * 
     * @param line
     *            the line's number where the coercion occurred in the source
     *            file
     * @param char_pos
     *            the character position in the line where the coercion occurred
     *            in the source file
     * @param found_type
     *            a string containing the Jova source code representation of the
     *            type of the operator's operand
     * @param res_type
     *            a string containing the Jova source code representation of the
     *            type which is the result of the coercion for the operator's
     *            operand
     */
    public void addConditionTypeCoercionWarning(int line, int char_pos, String found_type, String res_type) {
        errors.get(TYPE_WARNING).add(fact.createConditionTypeCoercionWarning(line, char_pos, found_type, res_type));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (1) Use of undeclared identifiers.
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.UndefIdError}
     * instance and adds it to the list of type errors. Use this method to add
     * new undefined id errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Usage of undefined identifier 'id'</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param id
     *            a string containing the Jova source code representation of the
     *            identifier
     */
    public void addUndefIdError(int line, int char_pos, String id) {
        errors.get(TYPE_ERR).add(fact.createUndefIdError(line, char_pos, id));
    }

    // <class ID> does not have field ’<ID>’
    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.DoesNotHaveFieldError} instance
     * and adds it to the list of type errors. Use this method to add new does
     * not have field errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>'class_id' does not have field 'field_id'</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     * @param field_id
     *            a string containing the Jova source code representation of the
     *            field's identifier
     */
    public void addDoesNotHaveFieldError(int line, int char_pos, String class_id, String field_id) {
        errors.get(TYPE_ERR).add(fact.createDoesNotHaveFieldError(line, char_pos, class_id, field_id));
    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.UndefMethodError}
     * instance and adds it to the list of type errors. Use this method to add
     * new undefined method errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Call to undefined method 'method_id(param_types)'</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param method_id
     *            a string containing the Jova source code representation of the
     *            method's identifier
     * @param param_types
     *            a series of strings containing the Jova source code
     *            representation of the parameters' types
     */
    public void addUndefMethodError(int line, int char_pos, String method_id, String... param_types) {
        errors.get(TYPE_ERR).add(fact.createUndefMethodError(line, char_pos, method_id, param_types));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.CannotInvokeError} instance and
     * adds it to the list of type errors. Use this method to add new cannot
     * invoke errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Cannot invoke method 'method_id(arg_types)' on type 'class_id'</code>
     * "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     * @param method_id
     *            a string containing the Jova source code representation of the
     *            method's identifier
     * @param arg_types
     *            a series of strings containing the Jova source code
     *            representation of the arguments' types
     */
    public void addCannotInvokeError(int line, int char_pos, String class_id, String method_id, String... arg_types) {
        errors.get(TYPE_ERR).add(fact.createCannotInvokeError(line, char_pos, class_id, method_id, arg_types));

    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.UnknownTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new unknown type errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Usage of undefined type 'class_id'</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     */
    public void addUnknownTypeError(int line, int char_pos, String class_id) {
        errors.get(TYPE_ERR).add(fact.createUnknownTypeError(line, char_pos, class_id));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.VarDoubleDefTypeError} instance
     * and adds it to the list of type errors. Use this method to add new
     * variable double definition errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Double definition of variable 'var_type var_id' in method 'method_id(param_types)'</code>
     * "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param var_id
     *            a string containing the Jova source code representation of the
     *            variable's identifier
     * @param var_type
     *            a string containing the Jova source code representation of the
     *            variable's type
     * @param method_id
     *            a string containing the Jova source code representation of the
     *            method's identifier
     * @param param_types
     *            a series of strings containing the Jova source code
     *            representation of the parameters' types
     */
    public void addVarDoubleDefError(int line, int char_pos, String var_id, String var_type, String method_id,
            String... param_types) {
        errors.get(TYPE_ERR)
                .add(fact.createVarDoubleDefError(line, char_pos, var_id, var_type, method_id, param_types));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.MethodDoubleDefTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new method double definition errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Double definition of method 'method_id(param_types)' class 'class_id'</code>
     * "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param method_id
     *            a string containing the Jova source code representation of the
     *            method's identifier
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     * @param param_types
     *            a series of strings containing the Jova source code
     *            representation of the parameters' types
     */
    public void addMethodDoubleDefError(int line, int char_pos, String method_id, String class_id,
            String... param_types) {
        errors.get(TYPE_ERR).add(fact.createMethodDoubleDefError(line, char_pos, method_id, class_id, param_types));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.MemberDoubleDefTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new member double definition errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Double definition of member 'mem_type mem_id' in class 'class_id'</code>
     * "
     * 
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param mem_id
     *            a string containing the Jova source code representation of the
     *            member's identifier
     * @param mem_type
     *            a string containing the Jova source code representation of the
     *            member's type; that is the member which triggered the error,
     *            not the memeber already defined earlier
     * @param class_scope
     *            a string containing the Jova source code representation of the
     *            memeber's class
     */
    public void addMemberDoubleDefError(int line, int char_pos, String mem_id, String mem_type, String class_scope) {
        errors.get(TYPE_ERR).add(fact.createMemberDoubleDefError(line, char_pos, mem_id, mem_type, class_scope));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.ClassDoubleDefTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new class double definition errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Double definition of class 'class_id'</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     */
    public void addClassDoubleDefError(int line, int char_pos, String class_id) {
        errors.get(TYPE_ERR).add(fact.createClassDoubleDefError(line, char_pos, class_id));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (3) Member and method access errors.
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.MemberAccessError} instance and
     * adds it to the list of type errors. Use this method to add new member
     * access errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Field 'mem_id' from type 'class_id' not visible</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param mem_id
     *            a string containing the Jova source code representation of the
     *            member's identifier
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     */
    public void addMemberAccessError(int line, int char_pos, String mem_id, String class_id) {
        errors.get(TYPE_ERR).add(fact.createMemberAccessError(line, char_pos, mem_id, class_id));
    }

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.MethodAccessError} instance and
     * adds it to the list of type errors. Use this method to add new method
     * access errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Method 'method_id(param_types)' from type 'class_id' not visible</code>
     * "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param method_id
     *            a string containing the Jova source code representation of the
     *            method's identifier; the method's signature should result
     *            together with the given {@code param_types}
     * @param class_id
     *            a string containing the Jova source code representation of the
     *            class's identifier
     * @param param_types
     *            a series of strings containing the Jova source code
     *            representation of the parameters' types; the method's
     *            signature should be result together with the given
     *            {@code method_id}
     */
    public void addMethodAccessError(int line, int char_pos, String method_id, String class_id, String... param_types) {
        errors.get(TYPE_ERR).add(fact.createMethodAccessError(line, char_pos, method_id, class_id, param_types));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (4) Use of incorrect operand types.
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.BinaryTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new binary type errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Operator 'op' not defined for 'lhs_type', 'rhs_type'</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param lhs_type
     *            a string containing the Jova source code representation of the
     *            type of the operator's left-hand side operand
     * @param rhs_type
     *            a string containing the Jova source code representation of the
     *            type of the operator's right-hand side operand
     * @param op
     *            a string containing the Jova source code representation of the
     *            operator for which the error occurred
     */
    public void addBinaryTypeError(int line, int char_pos, String lhs_type, String rhs_type, String op) {
        errors.get(TYPE_ERR).add(fact.createBinaryTypeError(line, char_pos, lhs_type, rhs_type, op));
    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.UnaryTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new unary type errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Operator 'op' not defined for 'type'</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param type
     *            a string containing the Jova source code representation of the
     *            type of the operand
     * @param op
     *            a string containing the Jova source code representation of the
     *            operator for which the error occurred
     */
    public void addUnaryTypeError(int line, int char_pos, String type, String op) {
        errors.get(TYPE_ERR).add(fact.createUnaryTypeError(line, char_pos, type, op));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (5) Incompatible type for return:
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.IncompatibleReturnTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new incompatible return type errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Incompatible type 'type' for return</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param type
     *            a string containing the Jova source code representation of the
     *            type of the evaluated expression to be returned
     */
    public void addIncompatibleReturnTypeError(int line, int char_pos, String type) {
        errors.get(TYPE_ERR).add(fact.createIncompatibleReturnTypeError(line, char_pos, type));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (6) Incompatible type for condition:
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.IncompatibleCondTypeError}
     * instance and adds it to the list of type errors. Use this method to add
     * new incompatible condition type errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Incompatible type 'type' for condition</code> "
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     * @param type
     *            a string containing the Jova source code representation of the
     *            type of the evaluated expression used as condition
     */
    public void addIncompatibleCondTypeError(int line, int char_pos, String type) {
        errors.get(TYPE_ERR).add(fact.createIncompatibleCondTypeError(line, char_pos, type));
    }

    ///////////////////////////////////////////////////////////////////////////
    // (8) Illegal Main-class structure or access:
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new
     * {@link at.tugraz.ist.cc.error.typechecker.MainInstantiationError}
     * instance and adds it to the list of type errors. Use this method to add
     * new main instantiation errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Main cannot be used as a type</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     */
    public void addMainInstatiationError(int line, int char_pos) {
        errors.get(TYPE_ERR).add(fact.createInstantiationError(line, char_pos));
    }

    /**
     * Creates a new {@link at.tugraz.ist.cc.error.typechecker.MainMemberError}
     * instance and adds it to the list of type errors. Use this method to add
     * new main member errors to {@link #errors}.
     * <p>
     * Uses the {@link at.tugraz.ist.cc.error.JovaErrorFactory} to generate a
     * {@link at.tugraz.ist.cc.error.JovaError} with the message of the form: "
     * <code>Cannot add member to class Main</code>"
     * 
     * @param line
     *            the line's number where the error occurred in the source file
     * @param char_pos
     *            the character position in the line where the error occurred in
     *            the source file
     */
    public void addMainMemberError(int line, int char_pos) {
        errors.get(TYPE_ERR).add(fact.createMainMemberError(line, char_pos));
    }
}
