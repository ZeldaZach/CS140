/**
 * Sorter
 * The Sorter class implements Visitor and implements all three versions
 * of the visit method.
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */
package assignment07;

public class Sorter implements Visitor
{
	/**
	 * Sets up the visit method for param Product, Will do nothing
	 * @param p -- Must be of type Product
	 */
	@Override
	public void visit(Product p)
	{
		// Do Nothing		
	}

	/**
	 * Sets up the visit method for param Piece, Will do nothing
	 * @param p -- Must be of type Piece
	 */
	@Override
	public void visit(Piece p)
	{
		// Do Nothing
	}

	/**
	 * Sets up the visit method for param Subassembly, will sort using compareTo
	 * @param p -- Must be of type Subassembly
	 */
	@Override
	public void visit(Subassembly p)
	{
		p.sort();
	}
}
