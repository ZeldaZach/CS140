package lab04;

public class RefrigeratorTester
{
	public static void main(String[] args)
	{
		Refrigerator fridge = new Refrigerator(3);
		int total_collected;
		
		WaterJug jug1 = new WaterJug();
		WaterJug jug2 = new WaterJug();
		WaterJug jug3 = new WaterJug();
		
		fridge.insertWaterJug(jug1);
		fridge.insertWaterJug(jug2);
		fridge.insertWaterJug(jug3);
		
		fridge.restock(5000);
		total_collected = fridge.collect(6000); // Jugs all at 0
		System.out.println("Total Collected should be 15000; Actual is: " + total_collected);
		
		fridge.restock(5000);
		total_collected = fridge.collect(-1000); // Jugs all at 5000
		System.out.println("Total Collected should be 0; Actual is: " + total_collected);
		
		total_collected = fridge.collect(3000); // Jugs all at 2000
		System.out.println("Total Collected should be 9000; Actual is: " + total_collected);
	}
}
