package assignment08;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
/**
 * Driver class that creates a JFrame to hold the
 * component that shows a drawing of two paths,
 * connecting the points provided by the main method.
 *
 * @author CS 140
 *
 */
public class GraphSortResults {

	/**
	 * Main method draws a JFrame and places the
	 * component with graphs of the time taken by the
	 * sorts
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) {
		Sorter sorter1 = new InsertionSorter();
		Sorter sorter2 = new MergeSorter();
		//Sorter sorter3 = new MergeListSorter();
		Sorter sorter4 = new NaiveQuickSort();
		Sorter sorter5 = new ABubbleSortUtility();

		JFrame frame = new JFrame();

		Random r = new Random();
		final int FACTOR = 5000;
		double[] x = {0,1,2,3,4,5,6,7,8,9};
		double[] y1 = new double[x.length];
		double[] y2 = new double[x.length];
		double[] y3 = new double[x.length];
		double[] y4 = new double[x.length];
		double[] y5 = new double[x.length];
		ArrayList<Double> sample;
		ArrayList<Double> copy2;
		ArrayList<Double> copy3;
		ArrayList<Double> copy4;
		ArrayList<Double> copy5;
		for (int i = 1; i < x.length; i++) {
			sample = new ArrayList<Double>();
			for(int j = 0; j < FACTOR*i; j++) {
				sample.add(r.nextDouble());
			}
			copy2 = (ArrayList<Double>)sample.clone();
			copy3 = (ArrayList<Double>)sample.clone();
			copy4 = (ArrayList<Double>)sample.clone();
			copy5 = (ArrayList<Double>)sample.clone();

			y1[i] = sorter1.timedSort(sample);
			System.out.println(y1[i]);

			y2[i] = sorter2.timedSort(copy2);
			System.out.println(y2[i]);

			//y3[i] = sorter3.timedSort(copy3);
			//System.out.println(y3[i]);

			y4[i] = sorter4.timedSort(copy4);
			System.out.println(y4[i]);

			y5[i] = sorter5.timedSort(copy5);
			System.out.println(y5[i]);
			System.out.println("----------------");
		}
		for(int i = 1; i < x.length; i++) {
			x[i] = 20 + 500*x[i]/x[x.length-1];
		}
		double max = y1[y1.length-1];
		max = Math.max(max, y2[y2.length-1]);
		max = Math.max(max, y3[y3.length-1]);
		max = Math.max(max, y4[y4.length-1]);
		max = Math.max(max, y5[y5.length-1]);
		for(int i = 0; i < y1.length; i++) {
			y1[i] = 550 - 550*y1[i]/max;
			y2[i] = 550 - 550*y2[i]/max;
			y3[i] = 550 - 550*y3[i]/max;
			y4[i] = 550 - 550*y4[i]/max;
			y5[i] = 550 - 550*y5[i]/max;
		}
		frame.setSize(540, 600);
		frame.setTitle("Times");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Graph component = new Graph(x,y1,x,y2,x,y3,x,y4,x,y5);

		frame.add(component);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}