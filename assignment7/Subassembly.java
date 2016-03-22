/**
 * Subassembly
 * The Subassembly class extends the Product class, and implements everything necessary for
 * Iterator and Comparable. Has numerous overriding methods to get/set the cost, 
 * manufacture time, indent value, and visit.
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */
package assignment07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subassembly extends Product
{
	private ArrayList<Product> parts = new ArrayList<>();

	/** 
	 * Constructor that creates a Product with description d
	 * @param d the description to give
	 */
	public Subassembly(String d)
	{
		super(d);
	}

	/**
	 * Override the Product getCost(); Will get the cost of all the products
	 * @return total (The cost of all the pieces added together)
	 */
	@Override
	public double getCost()
	{
		double total = 0;

		for (Product p : parts)
			total += p.getCost();

		return total;
	}

	/** 
	 * Override the Product getManufactureTime(); Will get the max time of all the products
	 * @return max (The maximum time it takes to manufacture any of the objects in the ArrayList)
	 */
	@Override
	public double getManufactureTime()
	{
		double max = -1;
		if (parts.size() > 0)
			max = parts.get(0).getManufactureTime();

		for (int i = 1; i < parts.size(); i++)
			if (parts.get(i).getManufactureTime() > max)
				max = parts.get(i).getManufactureTime();

		return max;
	}

	/**
	 * Add a Product or Subclass of Product to the parts ArrayList
	 * @param p The product to add to the list
	 */
	public void add(Product p)
	{
		parts.add(p);
	}

	/**
	 * Sets the indent value to indent, then calls the addAllParts from
	 * the typeof p class in a recursive way
	 * @param indent Indent value
	 * @param list Recursion list of the Products already added
	 */
	@Override
	public void addAllParts(int indent, List<Product> list)
	{
		super.setIndent(indent);

		for (Product p : parts)
		{
			list.add(p);
			p.addAllParts(1+indent, list);
		}
	}

	/**
	 * This method will do nothing, but is included as it's necessary to compile
	 * @param v a Visitor or sub-class of Visitor which will determine the action to take, only if this is a Piece
	 */
	@Override
	public void accept(Visitor v)
	{
		v.visit(this);
	}

	/**
	 * Sort the parts ArrayList based on the compareTo function's return value
	 */
	public void sort()
	{
		Collections.sort(parts);
	}
}
