package assignment08;

public class Question3
{
	public static double squareRootGuess(double x, double g)
	{
		if (x < 0)
			throw new IllegalArgumentException("Non-negative inputs are expected");

		if (x == 0)
			return 0;

		if (Math.abs(x - g*g) < 1E-9)
			return g;

		return squareRootGuess(x, (g + x/g)/2);
	}

	public static double squareRoot(double x)
	{
		return squareRootGuess(x, 10);
	}
}
