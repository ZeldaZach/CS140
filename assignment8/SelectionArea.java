package assignment08;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SelectionArea extends JPanel {
	private static final long serialVersionUID = -9008844112301511166L;
	private ArrayList<Point2D.Double> points = new ArrayList<>();
	private Path2D.Double path = new Path2D.Double(); 
	Line2D.Double temp;
	private final int CLOSE = 7;
	private int baseOfMoveMouseX;
	private int baseOfMoveMouseY;
	private boolean drawingMode = false;

	public SelectionArea(SelectionDemo controller) {
		addMouseListener(MouseListenerFactory.mouseClickedHandler(e -> {
			if(!drawingMode) {
				path = new Path2D.Double();
				drawingMode = true;
				baseOfMoveMouseX = e.getX();
				baseOfMoveMouseY = e.getY();
				points.clear();
				points.add(new Point2D.Double(baseOfMoveMouseX, 
						baseOfMoveMouseY));
				path.moveTo(baseOfMoveMouseX, baseOfMoveMouseY);
				controller.updateLabelText(null);
			} else {
				int x = e.getX();
				int y = e.getY();
				if(Math.abs(x - baseOfMoveMouseX) > CLOSE ||
						Math.abs(y - baseOfMoveMouseY) > CLOSE) {
					points.add(new Point2D.Double(x,y));
					path.lineTo(x,y);
				} else {
					drawingMode = false;
					path.closePath();
					controller.updateLabelText(points);
				}
			}
			repaint();
		}));

		addMouseMotionListener(MouseListenerFactory.mouseMovedHandler(e -> {
			if(drawingMode) {
				if(points.size() > 0) {
					temp = new Line2D.Double(
							points.get(points.size()-1), 
							new Point2D.Double(e.getX(),e.getY()));
					repaint();
				}
			}
		}));

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //paints the background and image
		//Cast the Graphics context to Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		Color color = Color.BLUE;
		g2.setColor(color);
		g2.draw(path);
		if(drawingMode && temp != null) {
			g2.draw(temp);
			color = Color.RED;
			g2.setColor(color);
			g2.fill(new Ellipse2D.Double(baseOfMoveMouseX - CLOSE,
					baseOfMoveMouseY - CLOSE,
					2*CLOSE, 2*CLOSE));
		}		
	}
}

