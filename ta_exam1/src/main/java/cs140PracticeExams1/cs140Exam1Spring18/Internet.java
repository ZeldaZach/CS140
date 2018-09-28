package cs140PracticeExams1.cs140Exam1Spring18;

import java.util.List;
import java.util.ArrayList;

public class Internet
{
    private List<Website> sites;

    public Internet(List<Website> WebSite)
    {
        // ASSUME WebSite != null, unique URLs
        sites = WebSite;
    }

    public void addSite(Website website)
    {
        // ASSUME website != null, unique URL
        sites.add(website);
    }

    public List<Website> getSites()
    {
        return sites;
    }

    public boolean incPop(String urlstr, double fact)
    {
        // ASSUME urlstr != null
        for (Website site : sites)
        {
            if (site.getUrl().equals(urlstr))
            {
                site.incrPop(fact);
                return true;
            }
        }

        return false;
    }

    public int[] profile()
    {
        int[] popularities = new int[11];

        for (Website site : sites)
        {
            int sitePopularity = (int)site.getPop();
            popularities[sitePopularity]++;
        }

        return popularities;
    }

    protected void remSite(Website w)
    {
        sites.remove(w);
    }
}

// NOT REQUIRED ON EXAM
class TestInternet
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


        Internet internet = new Internet(websites);

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
        System.out.println();
    }
}