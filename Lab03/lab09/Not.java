package lab09;

public class Not implements Expr
{
	private int retVal;

	public Not(Expr e1)
	{
		if (e1.eval() == 0)
			retVal = 1;
		else
			retVal = 0;
	}
	
	@Override
	public int eval()
	{
		return retVal;
	}

}
