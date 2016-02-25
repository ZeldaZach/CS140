package assignment04;

import java.util.ArrayList;
import java.util.Arrays;

public class TownListTester
{
	public static void main(String[] args)
	{
		TownList list = new TownList();
	
		Town town1 = new Town("Lima", "Peru", Meridional.SOUTH, Zonal.WEST, 12, 2, 36, 77, 1, 30);
		Town town2 = new Town("Williamsport, PA", "USA", Meridional.NORTH, Zonal.WEST, 41, 14, 40, 77, 1, 30);
		Town town3 = new Town("London", "UK", Meridional.NORTH, Zonal.WEST, 51, 30, 26, 0, 7, 39);
		Town town4 = new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST, 39, 28, 0, 0, 23, 0);
		Town town5 = new Town("Mumbai", "India", Meridional.NORTH, Zonal.EAST, 18, 58, 30, 72, 49, 33);
		Town town6 = new Town("Beijing", "China", Meridional.NORTH, Zonal.EAST, 39, 55, 0, 116, 23, 0);
		Town town7 = new Town("Valencia", "Spain", Meridional.NORTH, Zonal.WEST, 39, 28, 0, 0, 23, 0);
		Town town8 = new Town("Christchurch", "New Zealand", Meridional.SOUTH, Zonal.EAST, 43, 31, 48, 172, 37, 13);
		
		Town town9 = new Town("New York City, NY", "USA", Meridional.NORTH, Zonal.WEST, 40, 42, 51, 74, 0, 21);
		Town town10 = new Town("New Orleans, LI", "USA", Meridional.NORTH, Zonal.WEST, 29, 58, 0, 90, 3, 0);
		Town town11 = new Town("Jackson, MS", "USA", Meridional.NORTH, Zonal.WEST, 32, 18, 0, 90, 11, 0);
		Town town12 = new Town("St. Louis, MI", "USA", Meridional.NORTH, Zonal.WEST, 38, 38, 0, 90, 11, 0);
		
		ArrayList<Town> alist = new ArrayList<>(Arrays.asList(town6, town7, town8));
		ArrayList<Town> alist2 = new ArrayList<>(Arrays.asList(town9, town10, town11));
		ArrayList<Town> alist3 = new ArrayList<>(Arrays.asList(town9, town12));
	
		System.out.println(list.add(town1));
		System.out.println(list.add(town2));
		System.out.println(list.add(town3));
		System.out.println(list.add(town1)); // Repeat value
 		System.out.println(list.add(null)); // Null value
		
		System.out.println("Expected: [Lima, Peru; Williamsport, PA, USA; London, UK]");
		System.out.println("List using add(Town): " + list + "\n");
		
		list.add(2, town4);
		list.add(8, town5); // Index out of bounds value (So add to end of list instead)
		list.add(2, null); // Null value
		list.add(3, town5); // Repeat value
		
		System.out.println("Expected: [Lima, Peru; Williamsport, PA, USA; Valencia, Spain; London, UK; Mumbai, India]");
		System.out.println("List using add(index, Town): " + list + "\n");
		
		list.addAll(null);

		list.addAll(alist);
		System.out.println("Expected: [Lima, Peru; Williamsport, PA, USA; Valencia, Spain; London, UK; Mumbai, India; Beijing, China; Valencia, Spain; Christchurch, New Zealand]");
		System.out.println("List using addAll(ArrayList): " + list + "\n");

		list.addAll(4, null);
		
		list.addAll(1, alist2);
		System.out.println("Expected: [Lima, Peru; New York City, NY, USA; New Orleans, LI, USA; Jackson, MS, USA; Williamsport, PA, USA; Valencia, Spain; London, UK; Mumbai, India; Beijing, China; Valencia, Spain; Christchurch, New Zealand]");
		System.out.println("List using addAll(index, ArrayList2): " + list + "\n");
		
		list.addAll(2, alist3);
		System.out.println("Expected: [Lima, Peru; New York City, NY, USA; St. Louis, MI; New Orleans, LI, USA; Jackson, MS, USA; Williamsport, PA, USA; Valencia, Spain; London, UK; Mumbai, India; Beijing, China; Valencia, Spain; Christchurch, New Zealand]");
		System.out.println("List using addAll(index, ArrayList3): " + list + "\n");
	}
}