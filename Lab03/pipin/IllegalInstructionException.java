package pippin;

public class IllegalInstructionException extends RuntimeException
{
	public IllegalInstructionException()
	{
		super();
	}
	
	public IllegalInstructionException(String msg)
	{
		super(msg);
	}
}
