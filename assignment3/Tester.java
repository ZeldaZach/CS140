package assignment03;

public class Tester
{
	public static void main(String[] args)
	{
		Elevator ele = new Elevator(15, 5, 10);
		
		String floorName_base = ele.getFloorName(2); 
		String floorName_ground = ele.getFloorName(5);
		String floorName_upper = ele.getFloorName(13);

		int floorIndex_base = ele.getFloorIndex(floorName_base);
		int floorIndex_ground = ele.getFloorIndex(floorName_ground);
		int floorIndex_upper = ele.getFloorIndex(floorName_upper);
		
		System.out.println("Expected Value for getFloorName(2): 'B3'");
		System.out.println("Returned Value for getFloorName(2): " + floorName_base + "\n");
		
		System.out.println("Expected Value for getFloorName(5): 'G'");
		System.out.println("Returned Value for getFloorName(5): " + floorName_ground + "\n");
		
		System.out.println("Expected Value for getFloorName(13): '9'");
		System.out.println("Returned Value for getFloorName(13): " + floorName_upper + "\n");
		
		System.out.println("Expected Value for getFloorIndex(floorName_base): '2'");
		System.out.println("Returned Value for getFloorIndex(floorName_base): " + floorIndex_base + "\n");
		
		System.out.println("Expected Value for getFloorIndex(floorName_ground): '5'");
		System.out.println("Returned Value for getFloorIndex(floorName_ground): " + floorIndex_ground + "\n");
		
		System.out.println("Expected Value for getFloorIndex(floorName_upper): '13'");
		System.out.println("Returned Value for getFloorIndex(floorName_upper): " + floorIndex_upper + "\n");
	}
}