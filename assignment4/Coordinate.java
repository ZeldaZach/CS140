package assignment04;

public class Coordinate implements Comparable<Coordinate>
{
	private Meridional northSouth;
	private Zonal eastWest;
	private int mDegrees; // m for Meridional
	private int mMinutes;
	private int mSeconds; 
	private int zDegrees; // z for Zonal
	private int zMinutes;
	private int zSeconds;

	public Coordinate(Meridional ns, Zonal ew, int mdeg, int mmin, int msec, int zdeg,
		int zmin, int zsec)
	{
		northSouth = ns;
		eastWest =  ew;
		mDegrees = mdeg;
		mMinutes = mmin;
		mSeconds = msec;
		zDegrees = zdeg;
		zMinutes = zmin;
		zSeconds = zsec;
	}
	
	private int howMuchWest()
	{
		int total = 0;
		total += zDegrees * 60 * 60;
		total += zMinutes * 60;
		total += zSeconds;
		
		if (eastWest == Zonal.EAST)
			total = -total;
		
		return total;
	}
	
	private int howMuchSouth()
	{
		int total = 0;
		total += mDegrees * 60 * 60;
		total += mMinutes * 60;
		total += mSeconds;

		if (northSouth == Meridional.NORTH)
			total = -total;
		
		return total;
	}
	
	public int compareTo(Coordinate arg0)
	{
		int diff = howMuchWest() - arg0.howMuchWest();

		if (diff == 0)
			diff = howMuchSouth() - arg0.howMuchSouth();

		return diff;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Coordinate && compareTo((Coordinate)obj) == 0)
			return true;
		
		return false;
	}
}
