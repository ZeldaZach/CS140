package lab06;

import java.util.ArrayList;

public class ComposedHand
{
	private ArrayList<Card> cards = new ArrayList<>();
	private ComputationMethod method;
	
	public ComposedHand(ComputationMethod m)
	{
		if (m != null)
			method = m;
	}

	public void addCard(Card c)
	{
		if (c != null)
			cards.add(c);
	}

	public void clear()
	{
		cards = new ArrayList<>();
	}

	public String toString()
	{
		return cards.toString();
	}

	public int value()
	{
		return method.compute(cards);
	}
}
