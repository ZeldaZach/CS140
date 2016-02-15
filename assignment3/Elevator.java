package assignment03;

import java.util.ArrayList;

public class Elevator
{
	private int currentFloor;
	private ArrayList<Passenger> occupants = new ArrayList<>();
	private ArrayList<Line> lines = new ArrayList<>();
	private int groundFloor;
	private Direction currentDir = Direction.UP;
	private int capacity;
	private int numFloors;
	
	public Elevator(int nf, int gf, int cap)
	{
		capacity = cap;
		numFloors = nf;
		groundFloor = gf;
		currentFloor = groundFloor;
		
		for (int i = 0; i < numFloors; i++)
		{
			lines.add(null);
		}
	}
	
	public int getNumFloors()
	{
		return numFloors;
	}
	
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	public Direction getCurrentDirection()
	{
		return currentDir;
	}
	
	public ArrayList<Line> getLines()
	{
		return lines;
	}
	
	public int getNumOccupants()
	{
		return occupants.size();
	}
	
	public String getFloorName(int index)
	{
		if (index < 0 || index >= numFloors)
		{
			throw new IllegalArgumentException("Illegal floor number");
		}
		
		String returnVal;
		if (index == groundFloor)
		{
			returnVal = "G";
		}
		else if (index < groundFloor)
		{
			returnVal = "B" + (groundFloor - index);
		}
		else // index > groundFloor
		{
			returnVal = "" + (index - groundFloor + 1);
		}
		
		return returnVal;
	}
	
	/**
	* This will return to the user, in numbers, what their floor number
	* actually is. The lowest basement is 0 and you work your way up
	* @param String with floor number (is a number, but in string format)
	* @return human readable version of what floor the elevator is on
	*/
	public int getFloorIndex(String floor)
	{
		if (floor.equals("G"))
		{
			return groundFloor;
		}
		else if (floor.startsWith("B"))
		{
			return groundFloor - Integer.parseInt(floor.substring(1));
		}
		else
		{
			return groundFloor + Integer.parseInt(floor) - 1;
		}
	}
	
	public boolean addOccupants(Passenger p)
	{
		if (occupants.size() < capacity)
		{
			occupants.add(p);
			return true;
		}
		
		return false;
	}
	
	public void addLine(String flr, Line ln)
	{
		int floor = getFloorIndex(flr);
		lines.set(floor, ln);
	}
	
	/**
	* Move the elevator up or down one floor when called upon
	* Will check for which way the elevator is going
	* Then will see if it should still go up (did it reach the top?) /
	* Still go down (did it reach the bottom?)
	* Then it offloads all passengers who want to get off at currentFloor
	* Finally, if thisLine is not null, it will attempt to load passengers
	* Who want to go in the same direction the elevator is going
	*/
	public void move()
	{
		if (currentDir == Direction.UP)
		{
			if (currentFloor < numFloors - 1)
			{
				currentFloor++;
			}
			else if (currentFloor == numFloors - 1)
			{
				currentDir = Direction.DOWN;
				currentFloor--;
			}
		}
		else
		{
			if (currentFloor > 0)
			{
				currentFloor--;
			}
			else if (currentFloor == 0)
			{
				currentDir = Direction.UP;
				currentFloor++;
			}
		}
		
		Passenger[] temp = new Passenger[occupants.size()];
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = occupants.get(i);
		}
		
		for (Passenger p : temp)
		{
			if (p.getDestinationFloor().equals(getFloorName(getCurrentFloor())))
			{
				occupants.remove(p);
			}
		}
		
		Line thisLine = lines.get(getCurrentFloor()); // The line waiting outside the elevator at floor X
		if (thisLine != null)
			thisLine.loadElevator();
	}
}