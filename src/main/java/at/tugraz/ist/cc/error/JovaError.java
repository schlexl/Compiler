package at.tugraz.ist.cc.error;

/**
 * Abstract class used to internally represent a compile error.
 * 
 * @author ccfuntime
 */
public abstract class JovaError extends Throwable {
	private static final long serialVersionUID = -8070518169660227619L;
	protected final int line;
	protected final int char_pos;

	protected JovaError(String err_msg, int line, int char_pos) {
		super(err_msg);
		this.line = line;
		this.char_pos = char_pos;
	}
	
	public int getLine()
	{
		return line;
	}
	
	public int getCharPos()
	{
		return char_pos + 1;
	}
}

