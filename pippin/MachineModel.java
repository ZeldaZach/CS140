package pippin;

import java.util.Observable;

public class MachineModel extends Observable
{
	public final Instruction[] INSTRUCTIONS = new Instruction[0x10];
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private boolean withGUI = false;
	private Code code = new Code();
	private boolean running = false;

	public void halt()
	{
		if (!withGUI)
			System.exit(0);
		else
			running = false;
	}

	public void setCode(int op, int arg)
	{
		code.setCode(op, arg);
	}

	public void setAccum(int i)
	{
		cpu.accum = i;
	}

	public void setRunning(boolean r)
	{
		running = r;
	}

	public void setData(int i, int j)
	{
		memory.setData(i, j);		
	}

	public Instruction get(int i)
	{
		return INSTRUCTIONS[i];
	}

	int[] getData()
	{
		return memory.getData();
	}

	public int getData(int i)
	{
		return memory.getData(i);
	}

	public Code getCode()
	{
		return code;
	}

	public int getPC()
	{
		return cpu.pc;
	}

	public void setPC(int pc)
	{
		cpu.pc = pc;
	}

	public int getAccum()
	{
		return cpu.accum;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void clear()
	{
		memory.clear();
		code.clear();
		cpu.accum = 0;
		cpu.pc = 0;
	}

	public int getChangedIndex()
	{
		return memory.getChangedIndex();
	}

	public MachineModel()
	{
		this(false);
	}

	public void step()
	{
		try
		{
			int opPart = code.getOpPart(cpu.pc);
			int arg = code.getArg(cpu.pc);

			Instruction.checkParity(opPart);
			INSTRUCTIONS[opPart/8].execute(arg, opPart%8);
		}
		catch (Exception e)
		{
			halt();
			throw e;
		}
	}

	public MachineModel(boolean gui)
	{
		withGUI = gui;

		//INSTRUCTION_MAP entry for "NOP"
		INSTRUCTIONS[0] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been verified

			if (flags != 0)
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;			
		};

		// INSTRUCTION entry for LOD (Load accumulator)
		INSTRUCTIONS[0x1] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0) // Direct Addressing
				cpu.accum = memory.getData(arg);
			else if (flags == 2) // Immediate Addressing 
				cpu.accum = arg;
			else if (flags == 4) // Indirect Addressing
				cpu.accum = memory.getData(memory.getData(arg));
			else // Illegal flag
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;
		};

		// INSTRUCTION FOR STO (Store accumulator in mem)
		INSTRUCTIONS[0x2] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0) // Direct Addressing
				memory.setData(arg, cpu.accum);
			else if (flags == 4) // Indirect Addressing
				memory.setData(memory.getData(arg), cpu.accum);
			else // Illegal flag
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;
		};

		// INSTRUCTION FOR JUMP (Jump pc to a new location in code)
		INSTRUCTIONS[0x3] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0) // Direct Addressing
				cpu.pc += arg;
			else if (flags == 2) // Immediate Addressing
				cpu.pc = arg;
			else if (flags == 4) // Indirect Addressing
				cpu.pc += memory.getData(arg);
			else // flags will = 6
				cpu.pc = memory.getData(arg);
		};

		// INSTRUCTION FOR JMPZ (jump to a new location, conditionally)
		INSTRUCTIONS[0x4] = (arg, flags) -> {
			flags = flags & 0x6;

			if (cpu.accum == 0)
				INSTRUCTIONS[3].execute(arg, flags);
			else
				cpu.pc++;
		};

		//INSTRUCTION entry for ADD (add)
		INSTRUCTIONS[0x5] = (arg, flags) -> {
			flags = flags & 0x6; // remove parity bit that will have been verified

			if (flags == 0) // direct addressing
				cpu.accum += memory.getData(arg);
			else if (flags == 2) // immediate addressing
				cpu.accum += arg;
			else if (flags == 4) // indirect addressing
				cpu.accum += memory.getData(memory.getData(arg));				
			else // here the illegal case is "11"
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;			
		};

		// INSTRUCTION FOR SUB (subtract from accum)
		INSTRUCTIONS[0x6] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0)  // direct addressing
				cpu.accum -= memory.getData(arg);
			else if (flags == 2) // immediate addressing
				cpu.accum -= arg;
			else if (flags == 4)  // indirect addressing
				cpu.accum -= memory.getData(memory.getData(arg));
			else  // here the illegal case is "11"
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;	
		};

		// INSTRUCTION FOR MUL (multiply accum)
		INSTRUCTIONS[0x7] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0)  // direct addressing
				cpu.accum *= memory.getData(arg);
			else if (flags == 2) // immediate addressing
				cpu.accum *= arg;
			else if (flags == 4)  // indirect addressing
				cpu.accum *= memory.getData(memory.getData(arg));
			else  // here the illegal case is "11"
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;	
		};

		// INSTRUCTION FOR DIV (division accum)
		INSTRUCTIONS[0x8] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0)  // direct addressing
			{
				if (memory.getData(arg) == 0)
					throw new DivideByZeroException();

				cpu.accum /= memory.getData(arg);
			}
			else if (flags == 2) // immediate addressing
			{ 
				if (arg == 0)
					throw new DivideByZeroException();

				cpu.accum /= arg;
			}
			else if (flags == 4)  // indirect addressing
			{
				if (memory.getData(memory.getData(arg)) == 0)
					throw new DivideByZeroException();

				cpu.accum /= memory.getData(memory.getData(arg));				
			}
			else  // here the illegal case is "11"
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;	
		};

		// INSTRUCTION FOR AND (and two values together)
		INSTRUCTIONS[0x9] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags == 0) // Direct Addressing
			{
				if (cpu.accum != 0 && memory.getData(arg) != 0)
					cpu.accum = 1;
				else
					cpu.accum = 0;
			}
			else if (flags == 2) // Immediate Addressing
			{
				if (cpu.accum != 0 && arg != 0)
					cpu.accum = 1;
				else
					cpu.accum = 0;
			}
			else // Illegal Flags
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			cpu.pc++;
		};

		// INSTRUCTION FOR NOT (not two values together)
		INSTRUCTIONS[0xA] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags != 0)
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			if (cpu.accum == 0)
				cpu.accum = 1;
			else
				cpu.accum = 0;

			cpu.pc++;	
		};

		// INSTRUCTION FOR CMPL (compare less than 0)
		INSTRUCTIONS[0xB] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags != 0)
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			if (memory.getData(arg) < 0)
				cpu.accum = 1;
			else
				cpu.accum = 0;

			cpu.pc++;
		};

		// INSTRUCTION FOR CMPZ (compare to zero)
		INSTRUCTIONS[0xC] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags != 0)
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			if (memory.getData(arg) == 0)
				cpu.accum = 1;
			else
				cpu.accum = 0;

			cpu.pc++;
		};

		// INSTRUCTION FOR FOR
		INSTRUCTIONS[0xD] = (arg, flags) -> {
			flags = flags & 0x6;

			int oldPC = cpu.pc, total_instruction, total_iterations;

			if (flags == 0) // Direct Addressing
			{
				total_instruction = memory.getData(arg) / 0x1000;
				total_iterations = memory.getData(arg) % 0x1000;
			}
			else if (flags == 2) // Immediate Addressing
			{
				total_instruction = arg / 0x1000;
				total_iterations = arg % 0x1000;
			}
			else // Illegal Flags
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			// The actual iterations
			for (int i = 0; i < total_iterations; i++)
			{
				cpu.pc = oldPC + 1;
				for (int j = 0; j < total_instruction; j++)
					this.step();
			}

			cpu.pc = oldPC + total_instruction;


		};

		// INSTRUCTION FOR HALT (halt execution)
		INSTRUCTIONS[0xF] = (arg, flags) -> {
			flags = flags & 0x6;

			if (flags != 0)
			{
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}

			halt();
		};
	}

	private class CPU
	{
		private int accum, pc; // accumulator, program counter
	}
}