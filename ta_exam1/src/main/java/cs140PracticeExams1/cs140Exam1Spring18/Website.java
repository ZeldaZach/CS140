package cs140PracticeExams1.cs140Exam1Spring18;

public class Website
{
    private String url;
    private double pop; // popularity

    public Website(String _url, double _pop)
    {
        // ASSUMED URL != null, POP > 0
        url = _url;
        pop = _pop;
    }

    public double getPop()
    {
        return pop;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString()
    {
        return url + "(" + pop + ")";
    }

    public void incrPop(double factor) throws IllegalArgumentException
    {
        if (factor < 0)
        {
            throw new IllegalArgumentException("positive only");
        }

        pop *= factor;

        if (pop > 10)
        {
            pop = 10;
        }
    }
}

class Tester
{
    public static void main(String[] args)
    {
        Website website = new Website("binghamton.edu", 1.5);
        website.incrPop(2.0);

        System.out.println("Expecting: 3.0");
        System.out.println("Got      : " + website.getPop());

        System.out.println("toString : " + website);
    }
}


