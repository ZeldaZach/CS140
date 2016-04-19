package pippin;

public class IllegalInstructionException extends RuntimeException
{
	private static final long serialVersionUID = -1012466332035775760L;

	public IllegalInstructionException()
	{
		super();
	}
	
	public IllegalInstructionException(String msg)
	{
		super(msg);
	}
}
