package finalsol;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;



public class buildGame {

	HamiltonPath hamPath;
	private int n , numOfKeys , sizeOfHex;
	int mat[][];
	int keyArray[];
	int locationArray[];
	Matrix bm;

	public buildGame(int n,int numOfKeys){

		this.n=n;
		this.numOfKeys=numOfKeys;
		this.bm=new Matrix(n);
		this.sizeOfHex=bm.sizeOfHex(n);




		bm.countIndexUp();
		mat=bm.matToNeighbor();

		//generate the start index for the hamilton path.
		int start= (int)(Math.random()*sizeOfHex);

		//create a new hamilton path. 
		hamPath=new HamiltonPath();
		hamPath.HamiltonPath(mat, start);
		int path[]=hamPath.getOnePath();


		keyArray = new int[numOfKeys];		
		locationArray = new int[numOfKeys];


		keyArray[0]=1;
		keyArray[keyArray.length-1]=sizeOfHex;


		locationArray[0]=path[0];
		locationArray[locationArray.length-1]=path[sizeOfHex-1];


		ArrayList<Integer> arrRandomNum=new ArrayList<>();
		arrRandomNum.add(1);
		arrRandomNum.add(sizeOfHex);


		int i = 2;
		while(i < numOfKeys){
			int randomNum=(int)((Math.random()*((sizeOfHex-1)-1)+1)+1); //Generate locationNumbers
			if(!arrRandomNum.contains(randomNum)){
				arrRandomNum.add(randomNum);
				i++;
			}

		}

		Collections.sort(arrRandomNum);

		for (int j = 1; j < arrRandomNum.size()-1; j++) {
			keyArray[j]=arrRandomNum.get(j);//arrRandomNum[j];
			locationArray[j]=path[arrRandomNum.get(j)-1];
		}
	}

	/**
	 * print the matrix that represent the connection between the neighbors
	 */
	public void printNeighborMat(){
		System.out.println();
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
	}
	/**
	 * 
	 */
	public void printKeyAndLocationArray(){
		System.out.println("keyArray:      "+Arrays.toString(keyArray));
		System.out.println("locationArray: "+Arrays.toString(locationArray));
		System.out.println();
	}


	public int[] getKeyArray(){
		return keyArray;
	}

	public int[] getLocationArray(){
		return locationArray;
	}

	/*
	public static void main(String[] args) {
		long start = System.nanoTime();

		int n=5;
		int h=19;

		buildGame bg=new buildGame(n, h);
		bg.printKeyAndLocationArray();
		System.out.println(Arrays.toString(bg.hamPath.getOnePath()));		

		searchSol s=new searchSol(bg.getKeyArray(),bg.getLocationArray(), n);
		System.out.println(Arrays.toString(s.getPath()));
		long end = System.nanoTime();

		NumberFormat formatter = new DecimalFormat("#0.00000000000000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000000000.0) + " seconds");

	}
	*/
}
