package at.tugraz.ist.cc.warning.typechecker;

import at.tugraz.ist.cc.warning.JovaWarning;

/**
 * @author ccfuntime
 *
 */
public class UnaryCoercionWarning extends JovaWarning {

    private final String op;
    private final String found_type;
    private final String res_type;

    public UnaryCoercionWarning(String msg, int line, int char_pos, String op, String found_type, String res_type) {
        super(msg, line, char_pos);
        this.op = op;
        this.found_type = found_type;
        this.res_type = res_type;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
