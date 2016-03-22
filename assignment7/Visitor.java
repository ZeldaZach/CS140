/**
 * Visitor
 * The Visitor interface sets up three overloaded methods, visit,
 * which will do something in the implemented sub classes
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */
package assignment07;

public interface Visitor
{	
	/**
	 * Set up visit for param Product that must be implemented
	 * @param p Must be of type Product
	 */
	public void visit(Product p);
	
	/**
	 * Set up visit for param Subassembly that must be implemented
	 * @param p Must be of type Subassembly
	 */
	public void visit(Subassembly p);
	
	/**
	 * Set up visit for param Piece that must be implemented
	 * @param p Must be of type Piece
	 */
	public void visit(Piece p);
}
