package finalsol;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class main {

	public static void main(String[] args) {




		/*
		int n=4;
		int h=10;

		System.out.println("n= "+n);
		int[] keyArray;
		int[] locationArray;
		for (int j = 0; j < 1; j++) {



			buildGame bg=new buildGame(n, h);
			keyArray=bg.getKeyArray();
			locationArray=bg.getLocationArray();


			long start = System.nanoTime();

			searchSol s=new searchSol(keyArray, locationArray, n);
			s.co=0;
			s.gateAnswer=false;
			long end = System.nanoTime();

			NumberFormat formatter = new DecimalFormat("#0.0000000000");
			System.out.print("Execution time is " + formatter.format((end - start) / 1000000000.0) + " seconds");

			System.out.println();


			}
		 */		



		//					int n=6;
		//		int[] keyArray=		{1,7,9,13,16,20,22,24,28,30,32,35,37,39,43,44,45,54,55,56,60,62,66,67,73,76,78,83,88,91};
		//		int[] locationArray={28,37,36,11,3,8 ,17,26,46,56,75,73,55,44,23,15,14,31,32,42,51,70,79,71,81,82, 83,67,49,57};*/
		//long start = System.nanoTime();



		long start = System.nanoTime();

		int n=3;
		//int[] keyArray=		{1, 2, 3, 4, 5, 7, 9, 10, 12, 14, 15, 16, 17 ,19};
		//int[] locationArray={13, 8, 3,0, 1, 5, 9, 10, 11, 14 ,18, 17, 16, 7};
		
		int[] keyArray=		{1,2,3,4,5,6,8,9,10,13,14,17,18,19};
		int[] locationArray={0,1,2,5,4,3,8,9,10,15,14,16,17,18};

		
		searchSol s=new searchSol(keyArray, locationArray, n);
		System.out.println(Arrays.toString(s.getPath()));
		
		long end = System.nanoTime();

		NumberFormat formatter = new DecimalFormat("#0.00000000000000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000000000.0) + " seconds");





	}

}
