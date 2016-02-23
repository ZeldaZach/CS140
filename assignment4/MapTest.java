package assignment04;

import java.util.Collections;

public class MapTest
{
	public static void main(String[] args)
	{
		TownList towns = new TownList();
		towns.add(new Town("Lima", "Peru", Meridional.SOUTH, Zonal.WEST, 12, 2, 36, 77, 1, 30));
		towns.add(new Town("Williamsport, PA", "USA", Meridional.NORTH, Zonal.WEST, 41, 14, 40, 77, 1, 30));
		towns.add(new Town("London", "UK", Meridional.NORTH, Zonal.WEST, 51, 30, 26, 0, 7, 39));
		towns.add(new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST, 39, 28, 0, 0, 23, 0));
		towns.add(new Town("Mumbai", "India", Meridional.NORTH, Zonal.EAST, 18, 58, 30, 72, 49, 33));
		towns.add(new Town("Beijing", "China", Meridional.NORTH, Zonal.EAST, 39, 55, 0, 116, 23, 0));
		towns.add(new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST, 39, 28, 0, 0, 23, 0));
		towns.add(new Town("Christchurch", "New Zealand", Meridional.SOUTH, Zonal.EAST, 43, 31, 48, 172, 37, 13));
		
		// Additional towns
		towns.add(new Town("New York City, NY", "USA", Meridional.NORTH, Zonal.WEST, 40, 42, 51, 74, 0, 21));
		towns.add(new Town("New Orleans, LI", "USA", Meridional.NORTH, Zonal.WEST, 29, 58, 0, 90, 3, 0));
		towns.add(new Town("Jackson, MS", "USA", Meridional.NORTH, Zonal.WEST, 32, 18, 0, 90, 11, 0));
		towns.add(new Town("St. Louis, MI", "USA", Meridional.NORTH, Zonal.WEST, 38, 38, 0, 90, 11, 0));
		towns.add(new Town("Windhoek", "Namibia", Meridional.SOUTH, Zonal.EAST, 22, 34, 0, 17, 05, 0));
		towns.add(new Town("Cape Town", "South Africa", Meridional.SOUTH, Zonal.EAST, 33, 56, 0, 18, 25, 0));
		towns.add(new Town("Novi Sad", "Serbia", Meridional.NORTH, Zonal.EAST, 45, 15, 0, 19, 51, 0));
		towns.add(new Town("Skopje", "Macedonia", Meridional.NORTH, Zonal.EAST, 42, 0, 0, 21, 26, 0));
		towns.add(new Town("Tornio", "Finland", Meridional.NORTH, Zonal.EAST, 65, 51, 0, 24, 9, 0));
		towns.add(new Town("Honiara", "Solomon Islands", Meridional.SOUTH, Zonal.EAST, 9, 28, 0, 159, 49, 0));
		
		Collections.sort(towns);
		System.out.println(towns);
	}
}