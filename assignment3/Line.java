package assignment03;

import java.util.ArrayList;
import java.util.Arrays;

public class Line
{
	private String floor;
	private ArrayList<Passenger> line = new ArrayList<>();
	private Elevator elevator;
	
	public Line(String flr, Elevator elev)
	{
		floor = flr;
		elevator = elev;
		
		elev.addLine(flr, this);
	}
	
	public void addToLine(Passenger... p)
	{
		for (int i = 0; i < p.length; i++)
			line.add(p[i]);
	}
	
	public ArrayList<Passenger> getLine()
	{
		return line;
	}
	
	public void loadElevator()
	{
		Passenger[] temp = new Passenger[line.size()];
		
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = line.get(i);
		}
		
		int thisFloor = elevator.getFloorIndex(floor);
					
		if (elevator.getCurrentDirection() == Direction.UP)
		{
			for (Passenger p: temp)
			{
				if (elevator.getFloorIndex(p.getDestinationFloor()) > thisFloor)
				{
					if (elevator.addOccupants(p))
					{
						line.remove(p);
					}
				}
				else
				{
					if (elevator.addOccupants(p))
					{
						line.remove(p);
					}
				}
			}
		}
		else
		{
			for (Passenger p: temp)
			{
				if (elevator.getFloorIndex(p.getDestinationFloor()) < thisFloor)
				{
					if (elevator.addOccupants(p))
					{
						line.remove(p);
					}
				}
				else
				{
					if (elevator.addOccupants(p))
					{
						line.remove(p);
					}
				}
			}
		}
	}
}