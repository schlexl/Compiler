package at.tugraz.ist.cc.error.typechecker;

import at.tugraz.ist.cc.error.JovaError;

/**
 * youtu.be/Uye1u1bfubc
 * 
 * @author beamanandwatchtheyoutubelinkabove
 */
public class MainInstantiationError extends JovaError {

    public MainInstantiationError(String err_msg, int line, int char_pos) {
        super(err_msg, line, char_pos);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
