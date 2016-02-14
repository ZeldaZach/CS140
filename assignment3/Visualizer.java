package assignment03;

import java.util.Arrays;
import java.util.ArrayList;

public class Visualizer
{
	public static void showElev(Elevator e)
	{
		for (int i = e.getNumFloors() - 1; i >= 0; i--)
		{
			if (i == e.getCurrentFloor())
			{
				System.out.println(e.getFloorName(i) + "\t\t" + e.getNumOccupants());
			}
			else
			{
				System.out.println(e.getFloorName(i) + "\t\t0");
			}

		}
	}
	
	public static void main(String[] args)
	{
		Elevator ele1 = new Elevator(15, 5, 10);
		Line line1 = new Line("G", ele1);

		Passenger pass1 = new Passenger("10", ele1);
		Passenger pass2 = new Passenger("9", ele1);
		Passenger pass3 = new Passenger("8", ele1);
		Passenger pass4 = new Passenger("7", ele1);
		Passenger pass5 = new Passenger("6", ele1);
		Passenger pass6 = new Passenger("5", ele1);
		Passenger pass7 = new Passenger("4", ele1);
		Passenger pass8 = new Passenger("3", ele1);
		Passenger pass9 = new Passenger("2", ele1);
		Passenger pass10 = new Passenger("G", ele1);
		Passenger pass11 = new Passenger("B1", ele1);
		Passenger pass12 = new Passenger("B2", ele1);
		Passenger pass13 = new Passenger("B3", ele1);
		Passenger pass14 = new Passenger("B4", ele1);
		Passenger pass15 = new Passenger("B5", ele1);
		
		line1.addToLine(pass1);

		showElev(ele1);
		line1.loadElevator();
		
		for (int i = 0; i < 22; i++)
		{
			System.out.println("+++++");
			showElev(ele1);
			ele1.move();
		}
	}
}