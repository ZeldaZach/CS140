package pippin;

public class Test
{
	public static void main(String[] args)
	{
		Instruction.checkParity(30);
		Instruction.checkParity(300000);
		Instruction.checkParity(20000000);
		Instruction.checkParity(100004); // Should throw exception
	}
}
