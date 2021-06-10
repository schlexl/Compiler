package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class IncompatibleCondTypeError extends JovaError {

    public IncompatibleCondTypeError(String err_msg, int line, int char_pos, String type) {
        super(err_msg, line, char_pos);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
