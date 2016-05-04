package pippin;

public class ParityCheckException extends RuntimeException
{
	private static final long serialVersionUID = 4L;

	public ParityCheckException()
	{
		super();
	}

	public ParityCheckException(String msg)
	{
		super(msg);
	}
}
