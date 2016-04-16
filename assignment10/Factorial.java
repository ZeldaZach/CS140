package pippin;

public class Factorial
{
	public static void main(String[] args)
	{
		MachineModel test = new MachineModel();

		test.setData(0, 8);
		test.setRunning(true);

		int op = 0;
		int arg = 0;

		op = 1*8 + 1; // LOD w/ Direct Addressing & parity
		arg = 0;
		test.setCode(op, arg);

		op = 2*8 + 1; // STO w/ Direct Addressing & parity
		arg = 1;
		test.setCode(op, arg);

		op = 1*8 + 1; // LOD w/ Direct Addressing & parity
		arg = 0;
		test.setCode(op, arg);

		op = 6*8 + 1 + 2; // SUB w/ Immediate Addressing & flags 2 & parity
		arg = 1;
		test.setCode(op, arg);

		op = 2*8 + 1; // STO w/ Direct Addressing & parity
		arg = 0;
		test.setCode(op, arg);

		op = 4*8; // JMPZ w/ flags 0
		arg = 0;
		test.setCode(op, arg);

		op = 6*8 + 1 + 2; // SUB w/ Immediate Addressing & flags 2 & parity
		arg = 1;
		test.setCode(op, arg);

		op = 4*8 + 1; // JMPZ w/ flags 0 & parity
		arg = 4;
		test.setCode(op, arg);

		op = 1*8 + 1; // LOD w/ Direct Addressing & parity
		arg = 0;
		test.setCode(op, arg);

		op = 7*8 + 1; // MUL w/ Direct Addressing & parity
		arg = 1;
		test.setCode(op, arg);

		op = 3*8 + 1 + 2; // JUMP w/ flags 2 & parity
		arg = 1;
		test.setCode(op, arg);

		op = 16*8; // HALT
		arg = 0;
		test.setCode(op, arg);

		test.setRunning(true);
		int result = 0;

		while (test.isRunning())
		{
			if (result != test.getData(1))
			{
				result = test.getData(1);
				System.out.println("0 => " + test.getData(0) +
						"; 1 => " + result);
			}

			test.step();
		}
	}
}
