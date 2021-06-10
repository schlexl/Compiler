package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author doublethegundoublethefun
 *
 */
public class MethodDoubleDefTypeError extends JovaError {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MethodDoubleDefTypeError(String err_msg, int line, int char_pos, String method_id, String class_id) {
        super(err_msg, line, char_pos);
    }
}
