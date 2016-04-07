package lab09;

public class Mul implements Expr
{
	private int total;
	
	public Mul(Expr e1, Expr e2)
	{
		total = e1.eval() * e2.eval();
	}
	
	@Override
	public int eval()
	{
		return total;
	}

}
