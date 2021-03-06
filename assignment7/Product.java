/**
 * Product
 * The Product class implements Iterable and Comparable to allow us to iterate over a list
 * and compare things in the list to sort them. Has numerous methods to allow us to
 * get/set the cost, manufacture time, indent value, and manipulating the list
 * 
 * @author zach halpern
 * @version 1.0
 * @since 2016-03-22
 */

package assignment07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Product implements Iterable<Product>, Comparable<Product>
{
	private String description;
	private int indent;

	/**
	 * Create a Product with a description
	 * @param d the description you want to give the Product
	 */
	public Product(String d)
	{
		description = d;
	}

	/**
	 * Abstract method that will be implemented by sub classes to get the cost of the Product
	 * @return cost (A double which repesents the cost of the Product)
	 */
	public abstract double getCost();
	
	/**
	 * Abstract method that will be implemented by sub classes to get the manufactureTime of the Product
	 * @return manufactureTime (A double which represents the manufacturing time of the Product)
	 */
	public abstract double getManufactureTime();
	
	/**
	 * Abstract method that will be implemented by sub classes to create the pretty print list of the Product
	 * @param indent How far you want to indent the object
	 * @param list The list of the products
	 */
	public abstract void addAllParts(int indent, List<Product> list);
	
	/**
	 * An abstract method that must be implemented by subclasses
	 * @param v A Visitor or sub class of Visitor
	 */
	public abstract void accept(Visitor v);

	/**
	 * A method that has to be overridden to allow us to set the cost of the sub Product
	 * @throws UnsupportedOperationException This method needs to be overridden in sub classes
	 * @param cost To be used in sub class implementations, not this one
	 */
	public void setCost(double cost)
	{
		throw new UnsupportedOperationException("Method setCost cannot be called on this object");
	}

	/**
	 * A method that has to be overridden to allow us to set the manufacture time of the sub Product
	 * @throws UnsupportedOperationException This method needs to be overridden in the sub classes
	 * @param time What you want the new manufacture time to be, unused in this method
	 */
	public void setManufactureTime(double time)
	{
		throw new UnsupportedOperationException("Method setManufactureTime cannot be called on this object");
	}

	/**
	 * Get the indent value of the Product
	 * @return indent (An integer representing the indent value of the PRoduct)
	 */
	public int getIndent()
	{
		return indent;
	}

	/**
	 * Set the indent value of the Product
	 * @param i the indent value you want to set it to
	 */
	public void setIndent(int i)
	{
		indent = i;
	}

	/**
	 * Implementing Iterator interface to iterate elements in a structure
	 * @return list (the list after it has been iterated on)
	 */
	public Iterator<Product> iterator()
	{
		ArrayList<Product> list = new ArrayList<>();
		list.add(this);

		addAllParts(0, list);
		return list.iterator();
	}

	/**
	 * Overriding the Object toString class to allow us to print out a pretty list
	 * @return String (Lists proper amount of dashes (depth in the tree) for indents followed by the object name in the tree)
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < indent; i++)
			sb.append("--");

		sb.append(description);

		return sb.toString();
	}

	/**
	 * Implementing the comparator interface, putting Pieces before Subassemblys
	 * @param other A product or sub-class of it that we are comparing to re-arrange the list
	 * @return integer (an integer that tells us the placement of the object in the list)
	 */
	public int compareTo(Product other)
	{
		if (this instanceof Piece && other instanceof Subassembly)
			return -1;
		else if (this instanceof Subassembly && other instanceof Piece)
			return 1;
		else
			return 0;
	}
}
