package assignment06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Graphic
{
	JFrame frame = new JFrame();
	JButton[][] buttons = new JButton[2][4];
	String[] names = {"Recolor", "Rotate", "Shuffle", "Sort"};
	BoxArea area = new BoxArea();

	public Graphic(String name)
	{
		frame.setSize(500, 500);
		frame.setTitle(name);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4, 2, 2));
		makeRow1ButtonsWithListeners();
		makeRow2ButtonsWithListeners();

		for (JButton[] row : buttons)
			for (JButton b : row)
				panel.add(b);

		frame.add(panel, BorderLayout.PAGE_END);
		frame.add(area);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new MyWindowListener());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setList(ArrayList<Box> list)
	{
		area.setList(list);
		frame.repaint();
	}

	public ArrayList<Box> getList()
	{
		return area.getList();
	}

	public JFrame getFrame()
	{
		return frame;
	}

	public void callRepaint()
	{
		frame.repaint();
	}

	private void exit()
	{
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}

	private class MyWindowListener extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent arg0)
		{
			exit();
		}
	}

	private void makeRow1ButtonsWithListeners()
	{
		for (int i = 0; i < buttons[0].length; i++)
		{
			buttons[0][i] = new JButton(names[i]);
		}

		buttons[0][0].addActionListener(new ColorListener(this));
		buttons[0][1].addActionListener(new RotateListener(this));
		buttons[0][2].addActionListener(new ShuffleListener());
		buttons[0][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Box> list = getList();
				Collections.sort(list, 
						Comparator.comparingDouble(b -> b.getBox().getWidth()*b.getBox().getHeight()));
				setList(list);
			}
		});
	}

	private void makeRow2ButtonsWithListeners()
	{
		for (int i = 0; i < buttons[1].length; i++)
		{
			buttons[1][i] = new JButton(names[i]);
		}
		
		buttons[1][0].addActionListener(e -> {
			Color newColor = JColorChooser.showDialog(frame, "Select New Color", Color.GREEN);
			for(Box b : area.getList()) {
				b.setColor(newColor);
			}
			frame.repaint();
		});
		
		buttons[1][1].addActionListener(e -> {
			for (int i = 0; i < area.getList().size(); i++)
			{
				Box thisBox = area.getList().get(i);
				Rectangle2D.Double r = thisBox.getBox();
				
				r.setRect(0, 0, r.getHeight(), r.getWidth());
			}
			
			frame.repaint();
		});
		
		buttons[1][2].addActionListener(e -> {
			ArrayList<Box> list = getList();
			Collections.shuffle(list);
			setList(list);
			
			frame.repaint();
		});

		buttons[1][3].addActionListener(e -> {
			ArrayList<Box> list = getList();
			Collections.sort(list, 
				Comparator.comparingDouble(b -> b.getBox().getWidth()*b.getBox().getHeight()));
			setList(list);
		});
	}
	
	private class ShuffleListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ArrayList<Box> list = getList();
			Collections.shuffle(list);
			setList(list);
		}
	}
}
