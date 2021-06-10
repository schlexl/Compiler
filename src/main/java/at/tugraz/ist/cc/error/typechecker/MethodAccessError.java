package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author friendshaveaccesstothierprivatemembers
 *
 */
public class MethodAccessError extends JovaError {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MethodAccessError(String err_msg, int line, int char_pos, String method_id, String class_id, String[] param_types) {
        super(err_msg, line, char_pos);
    }

}
