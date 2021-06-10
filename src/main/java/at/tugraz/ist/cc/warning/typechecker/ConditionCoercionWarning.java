package at.tugraz.ist.cc.warning.typechecker;

import at.tugraz.ist.cc.warning.JovaWarning;

/**
 * @author ccfuntime
 *
 */
public class ConditionCoercionWarning extends JovaWarning{

    private final String found_type;
    private final String res_type;

    public ConditionCoercionWarning(String msg, int line, int char_pos, String found_type, String res_type) {
        super(msg, line, char_pos);
        this.found_type = found_type;
        this.res_type = res_type;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
