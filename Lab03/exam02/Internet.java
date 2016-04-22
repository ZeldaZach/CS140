package exam02;

import java.util.ArrayList;

public class Internet
{
	protected ArrayList<Website> websites;

	public Internet()
	{
		websites = new ArrayList<>();
	}

	public void addSite(Website w)
	{
		// Arg is never null
		websites.add(w);
	}

	public ArrayList<Website> getWebsites()
	{
		return websites;
	}

	@Override
	public String toString()
	{
		return websites.toString();
	}
	
	public boolean incPopularity(String url, double pop)
	{
		// URL will never be null
		for (int i = 0; i < websites.size(); i++)
		{
			if (websites.get(i).getUrl().equals(url))
			{
				websites.get(i).incPopularity(pop);
				return true;
			}
		}
		
		return false;
	}
	
	public int size()
	{
		return websites.size();
	}
	
	public int[] asDiscrete()
	{
		int[] tmp = new int[11];
		
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < size(); j++)
				if (websites.get(j).getPopularity() >= i && websites.get(j).getPopularity() < i+1)
					tmp[i]++;

		return tmp;
	}
}
