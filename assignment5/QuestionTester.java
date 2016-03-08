package assignment05;

import static org.junit.Assert.assertEquals;
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

		/*MultichoiceQuestion third = new MultichoiceQuestion("Which colleges are part of SUNY?");
		third.addChoice("Binghamton", true);
		third.addChoice("St. Bonaventure", false);
		third.addChoice("Stony Brook", true);
		third.addChoice("Elmira College", false);*/

		assertEquals(true, second.checkAnswer("Canada"));
	}
}
