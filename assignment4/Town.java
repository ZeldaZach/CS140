package assignment04;

public class Town implements Comparable<Town>
{
	private String name;
	private String country;
	private Coordinate coordinate;
	
	public Town(String name, String country, Meridional northSouth, Zonal eastWest, int mDegrees, int mMinutes, int mSeconds, int zDegrees, int zMinutes, int zSeconds)
	{
		this.name = name;
		this.country = country;
		this.coordinate = new Coordinate(northSouth, eastWest, mDegrees, mMinutes, mSeconds, zDegrees, zMinutes, zSeconds);
	}
	
	public int compareTo(Town o)
	{
		return coordinate.compareTo(o.coordinate);
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Town && coordinate.equals(((Town)obj).coordinate))
			return true;
		
		return false;
	}
	
	public String toString()
	{
		return name + ", " + country;
	}
}