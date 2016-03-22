/**
 * ManufactureTimeVisitor
 * The ManufactureTimeVisitor class implements Visitor and implements all three versions.
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */
package assignment07;

public class ManufactureTimeVisitor implements Visitor
{
	private double increase;

	/**
	 * Constructor that will set the increase value of the Visitor
	 * @param i -- how much to increase by (a percentage)
	 */
	public ManufactureTimeVisitor(double i)
	{
		increase = i;
	}
	
	/**
	 * Override the visit interface class for Products, does nothing
	 * @param p -- Must be of type of Product
	 */
	@Override
	public void visit(Product p)
	{
		// Do Nothing
	}

	/**
	 * Override the visit interface class for Subassemblys, does nothing
	 * @param p -- Must be of type of Subassembly
	 */
	@Override
	public void visit(Subassembly p)
	{
		// Do Nothing
	}

	/**
	 * Override the visit interface class for Pieces, sets the manufacture time 
	 * of the piece to the new time (New time = old time + old time * increase)
	 * @param p -- Must be of type Piece
	 */
	@Override
	public void visit(Piece p)
	{
		p.setManufactureTime(p.getManufactureTime() + p.getManufactureTime() * increase/100);
	}
}
