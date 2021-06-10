package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author friendshaveaccesstothierprivatemembers
 *
 */
public class MemberAccessError extends JovaError {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MemberAccessError(String err_msg, int line, int char_pos, String mem_id, String class_id) {
        super(err_msg, line, char_pos);
    }

}
