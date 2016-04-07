package lab09;

public class Add implements Expr
{
	private int total;
	
	public Add(Expr num1, Expr num2)
	{
		total = num1.eval() + num2.eval();
	}
	
	@Override
	public int eval()
	{
		return total;
	}
}

	
