package lab03;

public class Tester
{
	public static void main(String[] args)
	{
		String test1, test2, test3, test4, test5;
		test1 = "Hello how are you?";
		test2 = "  What's   up   sir?   YES!";
		test3 = "Welcome    to the jungl_e";
		test4 = "   When will we be done?";
		test5 = "Bye!! ";
		
		System.out.println("Original: \"" + test1 + "\"");
		System.out.println(Functions.splitOnSpaces(test1));
		System.out.println(Functions.strLengths(test1));
		
		System.out.println("Original: \"" + test2 + "\"");
		System.out.println(Functions.splitOnSpaces(test2));
		System.out.println(Functions.strLengths(test2));
		
		System.out.println("Original: \"" + test3 + "\"");
		System.out.println(Functions.splitOnSpaces(test3));
		System.out.println(Functions.strLengths(test3));
		
		System.out.println("Original: \"" + test4 + "\"");
		System.out.println(Functions.splitOnSpaces(test4));
		System.out.println(Functions.strLengths(test4));
		
		System.out.println("Original: \"" + test5 + "\"");
		System.out.println(Functions.splitOnSpaces(test5));
		System.out.println(Functions.strLengths(test5));
	}
}