package pippin;

public class Memory
{
	public static final int DATA_SIZE = 512;
	private int[] data = new int[DATA_SIZE];
	private int changedIndex = -1;

	int[] getData()
	{
		return data;
	}

	public int getData(int index)
	{
		if (index < 0 || index > DATA_SIZE)
			throw new CodeAccessException("Attempt to get data outside its bounds");

		return data[index];
	}

	public int getChangedIndex()
	{
		return changedIndex;
	}

	public void setData(int index, int value)
	{
		if (index < 0 || index > DATA_SIZE)
			throw new CodeAccessException("Attempt to set data outside its bounds");

		data[index] = value;
		changedIndex = index;
	}

	public void clear()
	{
		for (int i = 0; i < DATA_SIZE; i++)
			data[i] = 0;

		changedIndex = -1;
	}
}
