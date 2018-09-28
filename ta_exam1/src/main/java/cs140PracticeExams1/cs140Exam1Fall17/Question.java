package cs140PracticeExams1.cs140Exam1Fall17;

public class Question
{
    private String question;

    public Question(String text)
    {
        question = text;
    }

    public void display()
    {
        System.out.println("Write your answer to the question below:");
        System.out.println(question);
    }
}

class TweetQuestion extends Question
{
    public TweetQuestion(String text)
    {
        super(text);
    }

    @Override
    public void display()
    {
        System.out.println("You must limit your answer to 140 characters.");
        super.display();
    }
}

class QuestionTest
{
    public static void main(String[] args)
    {
        Question q1 = new Question("What did you do on your last vacation?");
        Question q2 = new TweetQuestion("Which course are you enjoying most?");

        q1.display();
        System.out.println("-------------------");
        q2.display();
    }
}