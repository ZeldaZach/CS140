package lab04;

public class Refrigerator
{
    WaterJug[] water_in_fridge;
    int next_open_index = 0;

    public Refrigerator(int capacity)
    {
		if (capacity < 0) // Arrays can't have neg length
			capacity = 0;

        water_in_fridge = new WaterJug[capacity];
    }
	
	public void insertWaterJug(WaterJug wj)
	{
		if (wj != null && next_open_index != water_in_fridge.length)
		{
			water_in_fridge[next_open_index] = wj;
			next_open_index++;
		}
	}
	
	public int collect(int ml)
	{
		int total_taken_out = 0;
		for (int i = 0; i < water_in_fridge.length; i++)
		{
			if (water_in_fridge[i] != null)
			{
				if (ml > water_in_fridge[i].getMilliliters()) // Trying to take out more then jug has
				{
					total_taken_out += water_in_fridge[i].getMilliliters(); // Adding all water in jug to taken out
				}
				else if (ml < 0) // Putting in, wrong function?
				{
					break;
				}
				else
				{
					total_taken_out += ml;
				}

				water_in_fridge[i].pourOut(ml); // Will pour out either jug.getMili() OR ml based on jug value
			}
		}
		
		return total_taken_out;
	}
	
	public void restock(int ml)
	{
		for (int i = 0; i < water_in_fridge.length; i++)
		{
			if (water_in_fridge[i] != null)
			{
				// Trying to pour out, wrong function?
				if (ml < 0)
					ml = 0;

				water_in_fridge[i].fillUp(ml);
			}
		}
	}

}
