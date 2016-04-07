package lab09;

public class Const implements Expr
{
	private final int CONSTANT;
	
	public Const(int i)
	{
		CONSTANT = i;
	}
	
	@Override
	public int eval()
	{
		return CONSTANT;
	}
}
