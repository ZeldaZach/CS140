/**
 * Piece
 * The Piece class extends the Product class, and implements everything necessary for
 * Iterator and Comparable. Has numerous overriding methods to get/set the cost, 
 * manufacture time, indent value, and visit.
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */

package assignment07;

import java.util.List;

public class Piece extends Product
{
	double cost, manufactureTime;

	/**
	 * Creates a Piece object with a name, cost, and how long it takes to manufacture
	 * @param description Description of the Piece
	 * @param cst How much the piece costs to manufacture
	 * @param mTime How much time it takes to manufacture the piece
	 */
	public Piece(String description, double cst, double mTime)
	{
		super(description);
		cost = cst;
		manufactureTime = mTime;
	}

	/**
	 * Get the cost of the Piece Product
	 * @return cost (A double which is the cost of the Piece)
	 */
	@Override
	public double getCost()
	{
		return cost;
	}

	/**
	 * Get how long it takes to manufacture the Piece Product
	 * @return manufactureTime (A double which is the manufacture time of the Piece)
	 */
	@Override
	public double getManufactureTime()
	{
		return manufactureTime;
	}

	/**
	 * Set the cost of the Piece Product
	 * @param cost How much you want the piece to cost
	 */
	@Override
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	/**
	 * Set the manufacturing time of the Piece Product
	 * @param time How much time you want the manufacture time to be for the piece
	 */
	@Override
	public void setManufactureTime(double time)
	{
		this.manufactureTime = time;
	}

	/**
	 * Sets the indent value of the printed list to indent
	 * @param indent used to set the indent value in the super class
	 * @param list not used in this function
	 */
	@Override
	public void addAllParts(int indent, List<Product> list)
	{
		super.setIndent(indent);	
	}
	
	/**
	 * Calls Visitor sub-class visit(Piece) which will either update the cost or manufacture time
	 * @param v a Visitor or sub-class of Visitor which will determine the action to take
	 */
	@Override
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
