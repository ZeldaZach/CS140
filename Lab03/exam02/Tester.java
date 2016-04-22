package exam02;

import java.util.Arrays;
import java.util.ArrayList;

public class Tester {

    public static void print(Object act, Object exp) {
        System.out.println(act.toString() + " ?= " + exp.toString());
    }

    public static void print(int [] act, int [] exp) {
        print(Arrays.toString(act), Arrays.toString(exp));
    }

    public static void main(String[] args) {
        System.out.println("***** Testing Website *****");
        {
            Website website = new Website("google.com", 1.3);
            print(website.getUrl(), "google.com");
            print(website.getPopularity(), 1.3);
            website.incPopularity(5);
            print(website.getPopularity(), 6.3);
            website.incPopularity(4);
            print(website.getPopularity(), 10.0);
        }
        System.out.println("***** Testing Internet *****");
        {
            Internet internet = new Internet();

            print(internet.getWebsites(), "[]");

            internet.addSite(new Website("google.com", 1.3));
            internet.addSite(new Website("no.com", 1.4));
            internet.addSite(new Website("example.org", 1.6));
            internet.addSite(new Website("blah.com", 6.2));
            internet.addSite(new Website("sp.com", 5));
            internet.addSite(new Website("yes.yes", 3.7));

            internet.incPopularity("yes.yes", 1.1);

            print(internet.asDiscrete(), new int[]{0, 3, 0, 0, 1, 1, 1, 0, 0, 0, 0});

            print(internet.size(), 6);
        }
        System.out.println("***** Testing SnobbyInternet *****");
        {
            SnobbyInternet internet = new SnobbyInternet(5);

            print(internet.getWebsites(), "[]");

            internet.addSite(new Website("google.com", 1.3));
            internet.addSite(new Website("no.com", 1.4));
            internet.addSite(new Website("example.org", 1.6));
            internet.addSite(new Website("blah.com", 6.2));
            internet.addSite(new Website("sp.com", 5));
            internet.addSite(new Website("yes.yes", 3.7));

            internet.incPopularity("yes.yes", 1.1);

            print(internet.toTrim(), 4);

            ArrayList<String> tok = new ArrayList<>();
            tok.add("yes.yes");
            tok.add("no.com");
            internet.permissiveTrim(tok);

            print(internet.toTrim(), 2);
            print(internet.size(), 4);

            internet.zealousTrim();
            print(internet.toTrim(), 0);
            print(internet.size(), 2);
        }
    }
}