package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public class DoesNotHaveFieldError extends JovaError {

    public DoesNotHaveFieldError(String err_msg, int line, int char_pos, String class_id, String field_id) {
        super(err_msg, line, char_pos);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
