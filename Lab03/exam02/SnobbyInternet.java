package exam02;

import java.util.ArrayList;

public class SnobbyInternet extends Internet
{
	private double threshold;

	public SnobbyInternet(double t)
	{
		threshold = t;
	}

	public void zealousTrim()
	{
		ArrayList<Website> tmp = getWebsites();
		Website[] w = new Website[tmp.size()];

		for (int i = 0; i < w.length; i++)
			w[i] = tmp.get(i);

		for (int i = 0; i < tmp.size(); i++)
			if (tmp.get(i).getPopularity() < threshold)
				w[i] = null;

		tmp = new ArrayList<>();
		for (int i = 0; i < w.length; i++)
			if (w[i] != null)
				tmp.add(w[i]);

		websites = tmp;
	}

	public void permissiveTrim(ArrayList<String> urls)
	{
		ArrayList<Website> tmp = getWebsites();
		Website[] w = new Website[tmp.size()];

		for (int i = 0; i < w.length; i++)
			w[i] = tmp.get(i);

		for (int i = 0; i < tmp.size(); i++)
			if (tmp.get(i).getPopularity() < threshold)
			{
				boolean stop = false;
				for (int j = 0; j < urls.size(); j++)
					if (tmp.get(i).getUrl().equals(urls.get(j)))
						stop = true;

				if (!stop)
					w[i] = null;
			}

		tmp = new ArrayList<>();
		for (int i = 0; i < w.length; i++)
			if (w[i] != null)
				tmp.add(w[i]);
		
		websites = tmp;
	}

	public int toTrim()
	{
		ArrayList<Website> tmp = getWebsites();
		int count = 0;

		for (int i = 0; i < tmp.size(); i++)
			if (tmp.get(i).getPopularity() < threshold)
				count++;

		return count;
	}
}
