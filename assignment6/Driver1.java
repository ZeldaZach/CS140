package assignment06;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver1
{
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				Box box1 = new Box();
				Box box2 = new Box();
				Box box3 = new Box();
				Box box4 = new Box();
				Box box5 = new Box();

				box1.setBox(new Rectangle2D.Double(0, 0, 20, 30));
				box2.setBox(new Rectangle2D.Double(0, 0, 40, 30));
				box3.setBox(new Rectangle2D.Double(0, 0, 60, 30));
				box4.setBox(new Rectangle2D.Double(0, 0, 80, 30));
				box5.setBox(new Rectangle2D.Double(0, 0, 100, 30));

				ArrayList<Box> list = new ArrayList<>(Arrays.asList(box1, box2, box3, box4, box5));
				
				Graphic g = new Graphic("Lander");
				g.setList(list);
			}
		});
	}
}