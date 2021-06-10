package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class UnknownTypeError extends JovaError {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UnknownTypeError(String err_msg, int line, int char_pos, String class_id) {
        super(err_msg, line, char_pos);
    }
}
