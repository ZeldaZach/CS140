package lab04;

public class SupplyTester
{
	public static void main(String[] args)
	{
		/* Initialize and fill jugs */
		WaterJug jug1 = new WaterJug();
		WaterJug jug2 = new WaterJug();
		WaterJug jug3 = new WaterJug();
		
		jug1.fillUp(3000);
		jug2.fillUp(5000);
		jug3.fillUp(1000);
		
		WaterJug[] jugArray = {jug1, jug2, jug3};
		
		/* Start a WaterSupply and lets test */
		WaterSupply supply = new WaterSupply();
		
		supply.addJugs(jugArray);
		
		supply.deposit(1600);
		supply.deposit(6000);
		
		int total = 0; // Tmp var for testing purposes
		
		total = supply.numJugsAbove(2000);
		System.out.println("Total should be 3; Actual is: " + total);
		
		total = supply.numJugsAbove(5000);
		System.out.println("Total should be 2; Actual is: " + total);
	}
}