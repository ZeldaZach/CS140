package assignment04;

public class Town implements Comparable<Town>
{
	private String name;
	private String country;
	private Coordinate coordinates;
	
	public Town(String name, String country, Meridional northSouth, Zonal eastWest,
		int mDegrees, int mMinutes, int mSeconds, int zDegrees, int zMinutes, int zSeconds)
	{
		this.name = name;
		this.country = country;
		this.coordinates = new Coordinate(northSouth, eastWest, mDegrees, mMinutes,
			mSeconds, zDegrees, zMinutes, zSeconds);
	}
	
	public int compareTo(Town o)
	{
		return coordinates.compareTo(o.coordinates);
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Town && coordinates.equals(((Town)obj).coordinates))
			return true;
		
		return false;
	}
	
	public String toString()
	{
		return name + ", " + country;
	}
}