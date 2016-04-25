package pippin;

public class Memory
{
	public static final int DATA_SIZE = 512;
	private int[] data = new int[DATA_SIZE];
	
	int[] getData()
	{
		return data;
	}
	
	public int getData(int index)
	{
		return data[index];
	}
	
	public void setData(int index, int value)
	{
		data[index] = value;
	}
	
	public void clear()
	{
		for (int i = 0; i < DATA_SIZE; i++)
			data[i] = 0;
	}
}
