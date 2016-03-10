package lab06;

public class Card
{
	public static enum Suit { Hearts, Diamonds, Clubs, Spades };

	Suit suit;
	int value;

	public Card(Suit s, int v)
	{
		if (v < 2 || v > 11)
		{
			throw new IllegalArgumentException("Invalid value");
		}
		else
		{
			suit = s;
			value = v;
		}
	}
	
	public static void main(String[] args)
	{
		Card card1 = new Card(Suit.Hearts, 3);
		Card card2 = new Card(Suit.Hearts, 2);
		Card card3 = new Card(Suit.Diamonds, 8);
		Card card4 = new Card(Suit.Spades, 10);
		Card card5 = new Card(Suit.Clubs, 11);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
	}

	@Override
	public boolean equals(Object other)
	{
		if (other instanceof Card)
			if (((Card) other).getSuit() == this.getSuit())
				if (((Card) other).getValue() == this.getValue())
					return true;

		return false;
	}

	@Override
	public String toString()
	{
		String retVal = "";
		
		if (value == 11)
			retVal = "Ace";
		else
			retVal = "" + value;
		
		retVal += " of " + suit;

		return retVal;
	}
	
	@Override
	public int hashCode()
	{
		return 31*suit.hashCode() + value;
	}

	public Suit getSuit()
	{
		return suit;
	}

	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

}
