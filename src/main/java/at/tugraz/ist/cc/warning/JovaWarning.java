package at.tugraz.ist.cc.warning;

import at.tugraz.ist.cc.error.JovaError;

/**
 * @author ccfuntime
 *
 */
public abstract class JovaWarning extends JovaError {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected JovaWarning(String msg, int line, int char_pos) {
        super(msg, line, char_pos);

    }

}
