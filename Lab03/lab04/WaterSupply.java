package lab04;

import java.util.ArrayList;

public class WaterSupply
{
	ArrayList<WaterJug> jugList = new ArrayList<>();
	
	public void addJugs(WaterJug[] jugs)
	{
		for (int i = 0; i < jugs.length; i++)
			if (jugs[i] != null)
				jugList.add(jugs[i]);
	}
	
	public void deposit(int amount)
	{
		if (amount < 0)
			amount = 0;
		
		WaterJug tmp = new WaterJug();
		tmp.fillUp(amount);
		jugList.add(tmp);
	}
	
	public int numJugsAbove(int threshold)
	{
		int total = 0;
		
		if (threshold < 0) // Threshold has to be at least zero
			threshold = 0;

		for (WaterJug jug : jugList)
			if (jug.getMilliliters() >= threshold)
				total++;
		
		return total;
	}
}