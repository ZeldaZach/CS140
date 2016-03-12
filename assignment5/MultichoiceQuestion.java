package assignment05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MultichoiceQuestion extends Question
{
	ArrayList<String> choices = new ArrayList<>();
	ArrayList<Integer> correctChoices = new ArrayList<>();

	public MultichoiceQuestion(String questionText)
	{
		super(questionText);
	}

	public void addChoice(String choice, boolean correct)
	{
		if (choice != null)
			choices.add(choice);
		
		if (correct)
		{
			correctChoices.add(choices.size());
		}
	}

	@Override
	public void display()
	{
		// Display the question text
		super.display();
		// Display the answer choices
		for (int i = 0; i < choices.size(); i++)
		{
			int choiceNumber = i + 1;
			System.out.println(choiceNumber + ": " + choices.get(i));     
		}

		System.out.println("Your answers (if more than one, separate answers by spaces): ");
	}

	@Override
	public boolean checkAnswer(String response)
	{
		int counterCorrect = 0;
		int counterIncorrect = 0;
		Set<Integer> answers = new HashSet<>();

		try (Scanner scan = new Scanner(response))
		{
			while (scan.hasNextInt())
			{
				int ans = scan.nextInt();
				answers.add(ans);
			}
		}

		for (Integer i : answers)
		{
			if (correctChoices.contains(i))
			{
				counterCorrect++;
			}
			else
			{
				counterIncorrect++;
			}
		}

		if (counterCorrect == correctChoices.size() && counterIncorrect == 0)
		{
			return true;
		}

		System.out.println("Correct: " + counterCorrect + ", Incorrect: " + counterIncorrect);
		return false;
	}
}
