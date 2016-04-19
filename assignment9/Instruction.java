package pippin;

public interface Instruction
{
	void execute(int arg, int flags);
	
	public static int numOnes(int i)
	{
		/*int count = 0;
		
		for (int v = 0; v < Integer.toUnsignedString(i, 2).length(); v++)
			if (Integer.toUnsignedString(i, 2).charAt(v) == '1')
				count++;

		return count;*/
		
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
	}
	
	public static void checkParity(int arg)
	{
		if (numOnes(arg) % 2 != 0)
			throw new ParityCheckException("This instruction is corrupted.");
	}
	
}
