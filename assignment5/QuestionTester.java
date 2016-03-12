package assignment05;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuestionTester
{
	@Test
	public void test1()
	{

		ChoiceQuestion second = new ChoiceQuestion("In which country was the inventor of Java born?");
		second.addChoice("Australia", false);
		second.addChoice("Canada", true);
		second.addChoice("Denmark", false);
		second.addChoice("United States", false);


		assertTrue(second.checkAnswer("2"));
		assertFalse(second.checkAnswer("3"));
	}

	@Test
	public void test2()
	{
		MultichoiceQuestion third = new MultichoiceQuestion("Which colleges are part of SUNY?");
		third.addChoice("Binhamton", true);
		third.addChoice("St. Bonaventure", false);
		third.addChoice("Stony Brook", true);
		third.addChoice("Elmira College", false);

		assertTrue(third.checkAnswer("1 3"));
		assertTrue(third.checkAnswer("3 1"));

		assertFalse(third.checkAnswer("1 1"));
		assertFalse(third.checkAnswer("3 3"));
		assertFalse(third.checkAnswer("2 3"));
		assertFalse(third.checkAnswer("1 2 3"));
		assertFalse(third.checkAnswer("1"));
	}
}
