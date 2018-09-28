package cs140PracticeExams1.cs140Exam1Spring18;

import java.util.ArrayList;
import java.util.List;

public class SnobbyInternet extends Internet
{
    private double threshold;

    public SnobbyInternet(List<Website> WebSite, double _threshold)
    {
        super(WebSite);
        threshold = _threshold;
    }

    public void Trim()
    {
        List<Website> sitesToRemove = new ArrayList<>();

        for (Website website : super.getSites())
        {
            if (website.getPop() < threshold)
            {
                sitesToRemove.add(website);
            }
        }

        for (Website siteToRemove : sitesToRemove)
        {
            super.remSite(siteToRemove);
        }
    }
}

// NOT REQUIRED ON EXAM
class TestSnobbyInternet
{
    public static void main(String[] args)
    {
        // Create website objects
        Website w1 = new Website("binghamton.edu", 2.0);
        Website w2 = new Website("syracuse.edu", 1.0);
        Website w3 = new Website("stonybrook.edu", 0.1);
        Website w4 = new Website("albany.edu", 0.001);

        // Build an array list
        ArrayList<Website> websites = new ArrayList<>();
        websites.add(w1);
        websites.add(w2);
        websites.add(w3);
        websites.add(w4);


        SnobbyInternet internet = new SnobbyInternet(websites, 3.0);

        // Print out contents of internet
        for (Website w : internet.getSites())
        {
            System.out.println(w);
        }

        // Print out stats of internet
        System.out.println("Ranking: 0 1 2 3 4 5 6 7 8 9 10");
        System.out.print("Values :");
        int[] internetProfiles = internet.profile();

        for (int internetProfile1 : internetProfiles)
        {
            System.out.format("%2d", internetProfile1);
        }
        System.out.println("\n");

        // Update some popularities
        internet.incPop("binghamton.edu", 3.0);
        internet.incPop("syracuse.edu", 2.6);

        // Print out updated contents of internet
        for (Website w : internet.getSites())
        {
            System.out.println(w);
        }

        // Print out updated stats of internet
        System.out.println("Ranking: 0 1 2 3 4 5 6 7 8 9 10");
        System.out.print("Values :");
        internetProfiles = internet.profile();

        for (int internetProfile : internetProfiles)
        {
            System.out.format("%2d", internetProfile);
        }
        System.out.println("\n");

        // Now, lets trim off bad values :)
        internet.Trim();

        // Print out updated contents of internet
        for (Website w : internet.getSites())
        {
            System.out.println(w);
        }

        // Print out updated stats of internet
        System.out.println("Ranking: 0 1 2 3 4 5 6 7 8 9 10");
        System.out.print("Values :");
        internetProfiles = internet.profile();

        for (int internetProfile : internetProfiles)
        {
            System.out.format("%2d", internetProfile);
        }
        System.out.println();
    }
}
