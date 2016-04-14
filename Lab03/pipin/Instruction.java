package pippin;

public interface Instruction
{
	void execute(int arg, int flags);
	
	public static int numOnes(int arg)
	{
		int count = 0;
		
		for (int i = 0; i < Integer.toUnsignedString(arg, 2).length(); i++)
			if (Integer.toUnsignedString(arg, 2).charAt(i) == '1')
				count++;

		return count;
	}
	
	public static void checkParity(int arg)
	{
		if (numOnes(arg) % 2 != 0)
			throw new ParityCheckException("This instruction is corrupted.");
	}
	
}
