package lab06;

public class BlackjackHand extends CardHand
{
	@Override
	public int value()
	{
		int sum = 0;
		
		for (Card c_notAce : cards)
		{
			if (c_notAce.getValue() != 11)
			{
				sum += c_notAce.getValue();
			}
		}
		
		for (Card c_isAce : cards)
		{
			if (c_isAce.getValue() == 11)
			{
				if (sum + 11 > 21)
					sum++;
				else
					sum += 11;
			}
		}
		
		return sum;
	}
}
