package assignment03;

import java.util.ArrayList;

public class Visualizer
{	
	public static void showElev(Elevator e)
	{
		for (int i = e.getNumFloors() - 1; i >= 0; i--)
		{
			Line line = e.getLines().get(i);
			String extraString = "";
			
			if (line != null && line.getLine().size() != 0)
			{
				ArrayList<Passenger> pass = line.getLine();
				extraString = "" + pass + "\t\t";
			}
			
			if (i == e.getCurrentFloor())
			{
				// Bold & Color from StackOverflow to help easier determine what floor elevator is on
				// https://stackoverflow.com/questions/1448858/how-to-color-system-out-println-output
				// https://stackoverflow.com/questions/8510398/make-the-input-text-bold-when-reading-from-the-console

				System.out.print("\033[0;1m" + (char)27 + "[31m" + e.getFloorName(i) + (char)27 + "[0m" + "\033[0;0m");
				System.out.println("\t\t" + e.getNumOccupants() + "\t\t" + extraString);
			}
			else
			{
				System.out.println(e.getFloorName(i) + "\t\t0" + "\t\t" + extraString);
			}

		}
	}
	
	public static void main(String[] args)
	{
		Elevator ele1 = new Elevator(15, 5, 10);
		Line line1 = new Line("G", ele1);
		Line line2 = new Line("2", ele1);
		Line line3 = new Line("3", ele1);
		Line line4 = new Line("4", ele1);
		Line line5 = new Line("5", ele1);
		Line line6 = new Line("6", ele1);
		Line line7 = new Line("7", ele1);
		Line line8 = new Line("8", ele1);
		Line line9 = new Line("9", ele1);
		Line line10 = new Line("10", ele1);
		Line line11 = new Line("B1", ele1);
		Line line12 = new Line("B2", ele1);
		Line line13 = new Line("B3", ele1);
		Line line14 = new Line("B4", ele1);
		Line line15 = new Line("B5", ele1);

		Passenger pass1 = new Passenger("7", ele1);
		Passenger pass2 = new Passenger("7", ele1);
		Passenger pass3 = new Passenger("7", ele1);
		Passenger pass4 = new Passenger("7", ele1);
		Passenger pass5 = new Passenger("7", ele1);
		Passenger pass6 = new Passenger("7", ele1);
		
		Passenger pass7 = new Passenger("3", ele1);
		Passenger pass8 = new Passenger("3", ele1);
		Passenger pass9 = new Passenger("3", ele1);
		
		Passenger pass10 = new Passenger("B3", ele1);
		Passenger pass11 = new Passenger("B3", ele1);
		Passenger pass12 = new Passenger("B3", ele1);
		
		Passenger pass13 = new Passenger("9", ele1);
		Passenger pass14 = new Passenger("10", ele1);
		Passenger pass15 = new Passenger("B3", ele1);
		Passenger pass16 = new Passenger("B4", ele1);
		Passenger pass17 = new Passenger("B1", ele1);
		Passenger pass18 = new Passenger("G", ele1);
		Passenger pass19 = new Passenger("5", ele1);
		Passenger pass20 = new Passenger("9", ele1);
		
		line1.getLine().add(pass1);
		line1.getLine().add(pass2);
		line1.getLine().add(pass3);
		line1.getLine().add(pass4);
		line1.getLine().add(pass5);
		line1.getLine().add(pass6);
		
		line2.getLine().add(pass7);
		line2.getLine().add(pass8);
		line2.getLine().add(pass9);
		
		line3.getLine().add(pass10);
		
		line4.getLine().add(pass11);
		line4.getLine().add(pass12);
		
		line5.getLine().add(pass13);
		
		line6.getLine().add(pass14);
		line7.getLine().add(pass15);
		
		line8.getLine().add(pass16);
		line8.getLine().add(pass17);
		
		line10.getLine().add(pass19);
		
		line11.getLine().add(pass20);

		line14.getLine().add(pass18);		
		
		showElev(ele1);
		line1.loadElevator();
		
		for (int i = 0; i < 22; i++)
		{
			System.out.println("+++++++++++++++++");
			showElev(ele1);
			ele1.move();
		}
	}
}