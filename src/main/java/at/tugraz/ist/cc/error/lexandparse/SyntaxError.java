package at.tugraz.ist.cc.error.lexandparse;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class SyntaxError extends JovaError {

    public SyntaxError(String err_msg, int line, int char_pos) {
        super(err_msg, line, char_pos);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
