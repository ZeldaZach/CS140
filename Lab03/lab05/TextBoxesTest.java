package lab05;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.awt.Rectangle;

public class TextBoxesTest {

	@Test
	public void testFullArray() {
		TextBoxes boxset1 = new TextBoxes(4);

		Rectangle rect1 = new Rectangle(10,20,40,40);
		Rectangle rect2 = new Rectangle(10,33,80,40);
		Rectangle rect3 = new Rectangle(10,20,3,40);
		Rectangle rect4 = new Rectangle(10,104,40,90);

		TextBox box1 = new TextBox("Hello", rect1);
		TextBox box2 = new TextBox("What's up", rect2);
		TextBox box3 = new TextBox("Welcome!", rect3);
		TextBox box4 = new TextBox("You've got mail", rect4);

		boxset1.addTextBox(box1);
		boxset1.addTextBox(box2);
		boxset1.addTextBox(box3);
		boxset1.addTextBox(box4);

		assertEquals(rect4, boxset1.longestTextRectangle());
	}

	@Test
	public void testNullArray() {
		TextBox[] boxArray = null;
		TextBoxes boxset1 = new TextBoxes(boxArray);	

		assertEquals(null, boxset1.longestTextRectangle());
	}

	@Test
	public void testEmptyArray()
	{
		TextBoxes boxset1 = new TextBoxes(2);

		assertEquals(null, boxset1.longestTextRectangle());
	}

	@Test
	public void testFullArea()
	{
		TextBoxes boxset1 = new TextBoxes(4);

		Rectangle rect1 = new Rectangle(10,20,40,40);
		Rectangle rect2 = new Rectangle(10,33,80,40);
		Rectangle rect3 = new Rectangle(10,20,3,40);
		Rectangle rect4 = new Rectangle(10,104,40,90);

		TextBox box1 = new TextBox("Hello", rect1);
		TextBox box2 = new TextBox("What's up", rect2);
		TextBox box3 = new TextBox("Welcome!", rect3);
		TextBox box4 = new TextBox("Dunk", rect4);

		boxset1.addTextBox(box1);
		boxset1.addTextBox(box2);
		boxset1.addTextBox(box3);
		boxset1.addTextBox(box4);

		assertEquals("Dunk", boxset1.largestAreaText());
	}
	
	@Test
	public void testNullArea()
	{
		TextBox[] boxArray = null;
		TextBoxes boxset1 = new TextBoxes(boxArray);	

		assertEquals(null, boxset1.largestAreaText());
	}
	
	@Test
	public void tesetEmptyArea()
	{
		TextBoxes boxset1 = new TextBoxes(2);

		assertEquals(null, boxset1.largestAreaText());
	}

}
