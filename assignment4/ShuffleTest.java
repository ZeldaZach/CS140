package assignment04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ShuffleTest
{
	public static void main(String[] args)
	{
		try (Scanner kbd = new Scanner(System.in); 
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)))) {
			int count = 15;
			System.out.println("How many elements should the test have? (default is 15)");
			String str = kbd.nextLine();
			Scanner scan = new Scanner(str);
			if(scan.hasNextInt()) {
				count = scan.nextInt();
			} 
			scan.close();
			output.println("Number of elements = " + count);
			
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++)
			{
				list.add(i);
			}
			
			int[][] counters = new int[count][count];
			for (int i = 0; i < 100; i++)// i < 100
			{
				Collections.shuffle(list);
				//System.out.println(list);
				
				for (int j = 0; j < list.size(); j++)
					counters[list.get(j)][j]++;
			}
			
			double total = 0;
			double sDev = 0;
			double mean = 0;
			
			for (int i = 0; i < counters.length; i++)
			{
				for (int j = 0; j < counters[i].length; j++)
				{
					int rowVal = counters[i][j];
					
					System.out.print(rowVal + " ");
					total += rowVal;
				}
				System.out.println();
			}
	
			mean = total / (count * count);
			
			System.out.println("Total: " + total);
			System.out.println("Mean: " + mean);

			
			double total_submation = 0;
			for (int row = 0; row < counters.length; row++)
				for (int col = 0; col < counters[row].length; col++)
					total_submation += Math.pow(counters[row][col] - mean, 2);
			
			double divident = Math.pow(count,2);
			if (divident != 1) // Prevent divide by 0 error if only 1 row/col
				divident -= 1;
			
			sDev = Math.sqrt(total_submation / divident);
			
			System.out.println("SDev: " + sDev);
		}
		catch (IOException e)
		{
			System.out.println("IO exception");
		}
	}
}