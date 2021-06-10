package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class UndefIdError extends JovaError {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UndefIdError(String err_msg, int line, int char_pos, String id) {
        super(err_msg, line, char_pos);
    }

}
