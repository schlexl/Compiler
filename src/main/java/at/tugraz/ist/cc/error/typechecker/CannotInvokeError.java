package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class CannotInvokeError extends JovaError {

    public CannotInvokeError(String err_msg, int line, int char_pos, String class_id, String method_id) {
        super(err_msg, line, char_pos);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
