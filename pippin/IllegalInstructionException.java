package pippin;

public class IllegalInstructionException extends RuntimeException
{
	private static final long serialVersionUID = 3L;

	public IllegalInstructionException()
	{
		super();
	}
	
	public IllegalInstructionException(String msg)
	{
		super(msg);
	}
}
