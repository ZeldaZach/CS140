package lab06;

public class Driver
{
	public static void main(String[] args)
	{
		Card card1 = new Card(Card.Suit.Hearts, 2);
		Card card2 = new Card(Card.Suit.Spades, 4);
		Card card3 = new Card(Card.Suit.Diamonds, 11);
		Card card4 = new Card(Card.Suit.Hearts, 10);
		Card card5 = new Card(Card.Suit.Clubs, 10);
		
		
		BlackjackMethod bjm = new BlackjackMethod();
		ComposedHand ch = new ComposedHand(bjm);
		
		ch.addCard(card1);
		ch.addCard(card2);
		ch.addCard(card3);
		ch.addCard(card4);
		ch.addCard(card5);
		
		System.out.println(ch);
	}
}
