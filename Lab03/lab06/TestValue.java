package lab06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestValue
{
	@Test
	public void test1()
	{
		Card card1 = new Card(Card.Suit.Hearts, 2);
		Card card2 = new Card(Card.Suit.Spades, 4);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		
		assertEquals(6, bjh.value());
	}
	
	@Test
	public void test2()
	{
		Card card1 = new Card(Card.Suit.Hearts, 11);
		Card card2 = new Card(Card.Suit.Spades, 10);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		
		assertEquals(21, bjh.value());
	}
	
	@Test
	public void test3()
	{
		Card card1 = new Card(Card.Suit.Hearts, 11);
		Card card2 = new Card(Card.Suit.Spades, 11);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		
		assertEquals(12, bjh.value());
	}
	
	@Test
	public void test4()
	{
		Card card1 = new Card(Card.Suit.Hearts, 11);
		Card card2 = new Card(Card.Suit.Spades, 11);
		Card card3 = new Card(Card.Suit.Diamonds, 11);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		bjh.addCard(card3);
		
		assertEquals(13, bjh.value());
	}
	
	@Test
	public void test5()
	{
		Card card1 = new Card(Card.Suit.Hearts, 10);
		Card card2 = new Card(Card.Suit.Spades, 10);
		Card card3 = new Card(Card.Suit.Diamonds, 2);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		bjh.addCard(card3);
		
		assertEquals(22, bjh.value());
	}
	
	@Test
	public void test6()
	{
		Card card1 = new Card(Card.Suit.Hearts, 10);
		Card card2 = new Card(Card.Suit.Spades, 10);
		Card card3 = new Card(Card.Suit.Diamonds, 11);
		
		BlackjackHand bjh = new BlackjackHand();
		bjh.addCard(card1);
		bjh.addCard(card2);
		bjh.addCard(card3);
		
		assertEquals(21, bjh.value());
	}
}
