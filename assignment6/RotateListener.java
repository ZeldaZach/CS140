package assignment06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class RotateListener implements ActionListener
{
	Graphic graphic = null;
	
	public RotateListener(Graphic g)
	{
		graphic = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (int i = 0; i < graphic.getList().size(); i++)
		{
			Box thisBox = graphic.getList().get(i);
			Rectangle2D r = thisBox.getBox();
			
			r.setRect(0, 0, r.getHeight(), r.getWidth());
		}
		
		graphic.callRepaint();
	}
}
