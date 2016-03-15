package assignment06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

public class ColorListener implements ActionListener
{
	private Graphic graphic;
	
	public ColorListener(Graphic g)
	{
		graphic = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Color newColor = JColorChooser.showDialog(graphic.getFrame(), "Select New Color",  Color.GREEN);
		
		for (int i = 0; i < graphic.getList().size(); i++)
		{
			Box thisBox = graphic.getList().get(i);
			thisBox.setColor(newColor);
		}
		
		graphic.callRepaint();
	}
}