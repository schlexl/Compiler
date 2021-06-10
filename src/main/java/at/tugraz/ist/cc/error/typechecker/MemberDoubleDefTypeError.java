package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author doublethegundoublethefun
 *
 */
public class MemberDoubleDefTypeError extends JovaError {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MemberDoubleDefTypeError(String err_msg, int line, int char_pos, String mem_id, String mem_type) {
        super(err_msg, line, char_pos);
    }
}
