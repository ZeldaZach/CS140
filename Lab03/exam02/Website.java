package exam02;

public class Website
{
	private String url;
	private double popularity;
	
	public Website(String u, double p)
	{
		url = u;
		popularity = p;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public double getPopularity()
	{
		return popularity;
	}
	
	@Override
	public String toString()
	{
		return url + ": " + popularity;
	}
	
	public void incPopularity(double pop)
	{
		if (pop < 0)
			throw new IllegalArgumentException("cannot decrease popularity");
		
		popularity += pop;
		
		if (popularity > 10)
			popularity = 10;
	}
}
