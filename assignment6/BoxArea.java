package assignment06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class BoxArea extends JComponent
{
	private static final long serialVersionUID = -2356054430147906086L;
	private ArrayList<Box> list = new ArrayList<>();
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));

		int x_offset = 10;
		int y_offset = 10;
	
		for (int i = 0; i < list.size(); i++)
		{
			Box thisBox = list.get(i);

			g2.setColor(thisBox.getColor());
			Rectangle2D.Double r = thisBox.getBox();

			r.setRect(x_offset, y_offset, r.getWidth(), r.getHeight());

			g2.fill(r);
			g2.setColor(Color.BLACK);
			g2.draw(r);

			x_offset += r.getWidth() + 5;
			y_offset += r.getHeight() + 5;
		}
	}

	public ArrayList<Box> getList()
	{
		return list;
	}

	public void setList(ArrayList<Box> list)
	{
		this.list = list;
	}
}
