package pippin;

public class ParityCheckException extends RuntimeException
{
	private static final long serialVersionUID = 8760334189057724583L;

	public ParityCheckException()
	{
		super();
	}
	
	public ParityCheckException(String msg)
	{
		super(msg);
	}
}
