package pippin;

public class DivideByZeroException extends RuntimeException
{
	private static final long serialVersionUID = 2L;

	public DivideByZeroException()
	{
		super();
	}

	public DivideByZeroException(String msg)
	{
		super(msg);
	}
}
