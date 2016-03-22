/**
 * CostIncreaseVisitor
 * The CostIncreaseVisitor class implements Visitor and implements all three versions.
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */
package assignment07;

public class CostIncreaseVisitor implements Visitor
{
	private double increase;
	
	/**
	 * Constructor that will set the increase value of the Visitor
	 * @param i -- how much to increase by (a percentage)
	 */
	public CostIncreaseVisitor(double i)
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
	 * Override the visit interface class for Pieces, sets the cost of the piece to the new cost
	 * (New cost = old cost + old cost * increase)
	 * @param p -- Must be of type Piece
	 */
	@Override
	public void visit(Piece p)
	{
		p.setCost(p.getCost() + p.getCost() * increase/100);
	}
	
}
