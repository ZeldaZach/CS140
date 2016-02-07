package assignment02;

import java.util.Arrays;

public class Tester
{
	public static void main(String[] args)
	{
		/** Static Utilities Tests */
		/* countNulls Test */
		System.out.println("** countNulls Test **");
		System.out.println("Expected value 0");
		System.out.println("Returned value " + Utilities02.countNulls(null) + "\n");

		Object[] test = {};
		System.out.println("Expected value 0");
		System.out.println("Returned value " + Utilities02.countNulls(test) + "\n");

		/* countSpaces Test */
		System.out.println("** countSpaces Test **");
		System.out.println("Expected value -1");
		System.out.println("Returned value " + Utilities02.countSpaces(null) + "\n");

		System.out.println("Expected value 0");
		System.out.println("Returned value " + Utilities02.countSpaces("") + "\n");

		System.out.println("Expected value 0");
		System.out.println("Returned value " + Utilities02.countSpaces("MeowGrowth") + "\n");

		System.out.println("Expected value 3");
		System.out.println("Returned value " + Utilities02.countSpaces("The Fat Lazy Dog") + "\n");

		/* first Test */
		System.out.println("** first Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.first(null) + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.first("") + "\n");

		System.out.println("Expected value \"Ribbit\"");
		System.out.println("Returned value " + Utilities02.first("Ribbit house of fog") + "\n");

		System.out.println("Expected value \"YES\"");
		System.out.println("Returned value " + Utilities02.first(" YES ") + "\n");

		System.out.println("Expected value \"NO\"");
		System.out.println("Returned value " + Utilities02.first("NO ") + "\n");

		System.out.println("Expected value \"How's\"");
		System.out.println("Returned value " + Utilities02.first(" How's the wife? ") + "\n");

		System.out.println("Expected value \"FooD\"");
		System.out.println("Returned value " + Utilities02.first("FooD ") + "\n");

		/* rest Test */
		System.out.println("** rest Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.rest(null) + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.rest("") + "\n");

		System.out.println("Expected value \"house of fog\"");
		System.out.println("Returned value " + Utilities02.rest("Ribbit house of fog") + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.rest(" YES ") + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.rest("NO ") + "\n");

		System.out.println("Expected value \"the wife?\"");
		System.out.println("Returned value " + Utilities02.rest(" How's the wife? ") + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.rest("FooD ") + "\n");

		/* withoutExtraSpaces Test */
		System.out.println("** withoutExtraSpaces Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces(null) + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("") + "\n");

		System.out.println("Expected value \"Ribbit house of fog\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("Ribbit house of fog") + "\n");

		System.out.println("Expected value \"Ribbit house of fog\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("Ribbit     house of   fog") + "\n");

		System.out.println("Expected value \"YES\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces(" YES ") + "\n");

		System.out.println("Expected value \"YES\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces(" YES     ") + "\n");

		System.out.println("Expected value \"NO\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("NO ") + "\n");

		System.out.println("Expected value \"How's the wife?\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces(" How's the wife? ") + "\n");

		System.out.println("Expected value \"How's the wife?\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("      How's the  wife? ") + "\n");

		System.out.println("Expected value \"FooD\"");
		System.out.println("Returned value " + Utilities02.withoutExtraSpaces("FooD ") + "\n");

		/* splitOnSpaces Test */
		System.out.println("** splitOnSpaces Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.splitOnSpaces(null) + "\n");

		System.out.println("Expected value []");
		System.out.println("Returned value " + Arrays.toString(Utilities02.splitOnSpaces("")) + "\n");

		System.out.println("Expected value [The big brown fox jumped over the lazy dog]");
		System.out.println("Returned value " + Arrays.toString(Utilities02.splitOnSpaces("The big brown fox jumped over the lazy dog")) + "\n");

	   	/* splitOnSpaces1 Test */
		System.out.println("** splitOnSpaces1 Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.splitOnSpaces1(null) + "\n");

		System.out.println("Expected value []");
		System.out.println("Returned value " + Arrays.toString(Utilities02.splitOnSpaces1("")) + "\n");

		System.out.println("Expected value [The big brown fox jumped over the lazy dog]");
		System.out.println("Returned value " + Arrays.toString(Utilities02.splitOnSpaces1("The big brown fox jumped over the lazy dog")) + "\n");
	
	   	/* strLengths Test */
		System.out.println("** strLengths Test **");
		System.out.println("Expected value null");
		System.out.println("Returned value " + Utilities02.strLengths(null) + "\n");
	
		System.out.println("Expected value [0]");
		System.out.println("Returned value " + Arrays.toString(Utilities02.strLengths("")) + "\n");

		System.out.println("Expected value [3, 3, 5, 3, 6, 4, 3, 4, 3]");
		System.out.println("Returned value " + Arrays.toString(Utilities02.strLengths("The big brown fox jumped over the lazy dog")) + "\n");
		
		/** Instance Methods Tests */

		/* Initialize All Instances */
		InstanceMethodVersion testNull = new InstanceMethodVersion(null);
		InstanceMethodVersion testEmpty = new InstanceMethodVersion("");
		final InstanceMethodVersion testSpaces = new InstanceMethodVersion("  Welcome to the   house! ");
		InstanceMethodVersion testWordy = new InstanceMethodVersion("How many cows in a liter of cheese doodles?");
		
		/* testNull Instance Tests */
		System.out.println("** testNull Instance Test **");
		System.out.println("Expected value -1");
		System.out.println("Returned value " + testNull.countSpaces() + "\n");

		System.out.println("Expected value null");
		System.out.println("Returned value " + testNull.withoutExtraSpaces() + "\n");
		
		System.out.println("Expected value null");
		System.out.println("Returned value " + testNull.first() + "\n");
		
		System.out.println("Expected value null");
		System.out.println("Returned value " + testNull.rest() + "\n");
		
		System.out.println("Expected value null");
		System.out.println("Returned value " + Arrays.toString(testNull.splitOnSpaces()) + "\n");
		
		System.out.println("Expected value null");
		System.out.println("Returned value " + Arrays.toString(testNull.strLengths()) + "\n");
		
		/* testEmpty Instance Tests */
		System.out.println("** testEmpty Instance Test **");
		System.out.println("Expected value 0");
		System.out.println("Returned value " + testEmpty.countSpaces() + "\n");

		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + testEmpty.withoutExtraSpaces() + "\n");
		
		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + testEmpty.first() + "\n");
		
		System.out.println("Expected value \"\"");
		System.out.println("Returned value " + testEmpty.rest() + "\n");
		
		System.out.println("Expected value []");
		System.out.println("Returned value " + Arrays.toString(testEmpty.splitOnSpaces()) + "\n");
		
		System.out.println("Expected value []");
		System.out.println("Returned value " + Arrays.toString(testEmpty.strLengths()) + "\n");
		
		/* testSpaces Instance Tests */
		System.out.println("** testSpaces Instance Test **");
		System.out.println("Expected value 8");
		System.out.println("Returned value " + testSpaces.countSpaces() + "\n");

		System.out.println("Expected value \"Welcome to the house!\"");
		System.out.println("Returned value " + testSpaces.withoutExtraSpaces() + "\n");
		
		System.out.println("Expected value \"Welcome\"");
		System.out.println("Returned value " + testSpaces.first() + "\n");
		
		System.out.println("Expected value \"to the    house!\"");
		System.out.println("Returned value " + testSpaces.rest() + "\n");
		
		System.out.println("Expected value [Welcome, to, the, house!]");
		System.out.println("Returned value " + Arrays.toString(testSpaces.splitOnSpaces()) + "\n");
		
		System.out.println("Expected value [7, 2, 3, 6]");
		System.out.println("Returned value " + Arrays.toString(testSpaces.strLengths()) + "\n");
		
		/* testWordy Instance Tests */
		System.out.println("** testWordy Instance Test **");
		System.out.println("Expected value 8");
		System.out.println("Returned value " + testWordy.countSpaces() + "\n");

		System.out.println("Expected value \"How many cows in a liter of cheese doodles?\"");
		System.out.println("Returned value " + testWordy.withoutExtraSpaces() + "\n");
		
		System.out.println("Expected value \"How\"");
		System.out.println("Returned value " + testWordy.first() + "\n");
		
		System.out.println("Expected value \"many cows in a liter of cheese doodles?\"");
		System.out.println("Returned value " + testWordy.rest() + "\n");
		
		System.out.println("Expected value [How, many, cows, in, a, liter, of, cheese, doodles?]");
		System.out.println("Returned value " + Arrays.toString(testWordy.splitOnSpaces()) + "\n");
		
		System.out.println("Expected value [3, 4, 4, 2, 1, 5, 2, 5, 8]");
		System.out.println("Returned value " + Arrays.toString(testWordy.strLengths()) + "\n");
	}
}