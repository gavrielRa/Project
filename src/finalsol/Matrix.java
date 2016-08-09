package finalsol;

import java.util.*;
public class Matrix {

	int mat[][];
	int sizeOfHex,n;
	DataPoint myNodeMat[][];
	Hashtable<Integer,DataPoint> convertor = new Hashtable<Integer,DataPoint>();
	/**
	 * constructor
	 * @param n - integer
	 */
	public Matrix(int n){
		this.n=n;
		this.sizeOfHex=sizeOfHex(n);

		hexToMat();//represent hex by mat
		addBorder();//add border to mat
		//buildMatPoint();
	}

	public void buildMatPoint(){
		myNodeMat=new DataPoint[mat.length][mat[0].length];

		//countIndexUp();
		definePoints();//create a new mat that have point coordinates
	}
	/**Receive the size of the rib and return the 
	 * number of hexagonal.
	 * 
	 * @param n - integer
	 * @return real number
	 */
	public int sizeOfHex(int n){
		if(n<=1) return 0; //assert

		int numOfRows=2*n-1;
		int ans = 0 ;

		for (int i = 0; i < numOfRows/2 ; i++) 
			ans=ans + n + i;
		//System.out.println("n: "+n);
		//System.out.println("sizeOfHex : "  + (ans*2 + numOfRows)+"\n"); 
		return ans*2 + numOfRows;
	}

	/**represent the hive by matrix
	 * 
	 * @param n - integer
	 * @return - 2 din array
	 */
	public void hexToMat(){

		mat=new int[2*n-1][4*n-3];
		int col=n-1;
		int j=col;
		for (int i = 0; i < n-1; i++) {
			for(j=col;j<mat[0].length-col;j=j+2){
				mat[i][j]=1;
				mat[mat.length-1-i][j]=1;
			}
			col--;
			//j=col;
		}
		for (int i = 0; i < mat[0].length; i=i+2) {
			mat[mat.length/2][i]=1;
		}
	//	System.out.println("hexToMat");
	//	print(mat);
	}
	/**create bigger matrix that the edges are zeros.
	 * 
	 * @param mat - 2 din array
	 * @return - 2 din array
	 */
	public void addBorder(){
		int index=0;
		int ans[][]=new int[mat.length+2][mat[0].length+4];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]!=0) ans[i+1][j+2]=mat[i][j]+index++;
			}
		}
	//	System.out.println("addBorder");
	//	print(ans);
		mat=ans;
	}
	/**Increase the value of the indexes by one.
	 * 
	 * @param mat - 2 din array
	 */
	public void countIndexUp(){
		int val=1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==1) mat[i][j]=val++;
			}
		}
		//System.out.println("countIndexUp");
		//print(mat);
	}
	/**create new matrix that represent the neighbors of each vertex
	 * 
	 * @param mat - 2 din array
	 * @param n - integer
	 * @return - 2 din array
	 */
		public int[][] matToNeighbor(){
	
			int hex[][]=new int[sizeOfHex][sizeOfHex];
			for (int i = 1; i < mat.length-1; i++) {
				for (int j = 2; j < mat[0].length-2; j++) {
					if(mat[i][j]!=0){
	
						if(mat[i-1][j-1]!=0) hex[mat[i][j]-1][mat[i-1][j-1]-1]=1;
						if(mat[i-1][j+1]!=0) hex[mat[i][j]-1][mat[i-1][j+1]-1]=1;
						if(mat[i][j+2]!=0) hex[mat[i][j]-1][mat[i][j+2]-1]=1;
						if(mat[i+1][j+1]!=0) hex[mat[i][j]-1][mat[i+1][j+1]-1]=1;
						if(mat[i+1][j-1]!=0) hex[mat[i][j]-1][mat[i+1][j-1]-1]=1;
						if(mat[i][j-2]!=0) hex[mat[i][j]-1][mat[i][j-2]-1]=1;
	
					}
				}
			}
		//	System.out.println("matToNeighbor");
		//	print(hex);
			return hex;
		}
	/**
	 * create a new mat that the nodes are Points
	 * i.e-Instead of integer is not object: myNode
	 */
	public void definePoints (){
		for (int i = 0; i < mat.length; i++) {//we have space 1 in up and 1 in dawn
			for (int j = 0; j < mat[0].length; j++) {//we have space 2 in right and 2 in left
				if(mat[i][j]!=0){
					myNodeMat[i][j]=new DataPoint(i, j);;
				}
				else{
					myNodeMat[i][j]=new DataPoint();
				}
			}
		}
	}
	/**
	 * method that find all legal neighbors of node cur
	 * @param cur-current node
	 * @return - all neighbors
	 */
	public ArrayList<DataPoint> allNeighbors(DataPoint cur){
		ArrayList<DataPoint> arr=new ArrayList<DataPoint>();
		int i=cur.x;
		int j=cur.y;

		//LU
		if(mat[i-1][j-1]!=0) arr.add(new DataPoint((i-1), (j-1)));
		//RU
		if(mat[i-1][j+1]!=0) arr.add(new DataPoint((i-1), (j+1)));
		//L
		if(mat[i][j-2]!=0) arr.add(new DataPoint((i), (j-2)));
		//R
		if(mat[i][j+2]!=0) arr.add(new DataPoint(i, (j+2)));
		//LD
		if(mat[i+1][j-1]!=0) arr.add(new DataPoint((i+1), (j-1)));
		//RD
		if(mat[i+1][j+1]!=0)  arr.add(new DataPoint((i+1), (j+1)));

		if(arr.isEmpty()) return null;
		return arr;

	}

	

	
	/**
	 * method that build a graph that represent 
	 * key is nod ,value is all legal neighbors
	 * @return-graph
	 */
	//	public HashMap<myNode,ArrayList<myNode>> graph(){
	//		HashMap<myNode,ArrayList<myNode>> graph=new HashMap<myNode,ArrayList<myNode>>();
	//		for (int i = 1; i < mat.length-1; i++) {//we have space 1 in up and 1 in dawn
	//			for (int j = 2; j < mat[0].length-2; j++) {//we have space 2 in right and 2 in left
	//				if(mat[i][j]==1){
	//					graph.put(new myNode(i,j), allNeighbors(new myNode(i,j)));
	//				}
	//			}
	//		}
	//		return graph;
	//	}
	/**
	 * method that calculate the distance from cur to end
	 * 
	 * @param cur-node
	 * @param end-node
	 * @return integer
	 */
	public int heuristic(DataPoint cur, DataPoint end){

		int x=Math.abs(cur.x-end.x);
		int y=Math.abs(cur.y-end.y);

		if(y==0) return x;
		else return (x+y)/2; 
	}



	/**print matrix
	 * 
	 * @param mat - 2 din array
	 */
	public void print(int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			System.out.print("{");
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+", ");
			}
			System.out.println("}");
		}
	}
	/**print a hive 
	 * 
	 * @param mat - 2 din array
	 */
	public void paint(int mat[][]){
		char c='A';
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==0) System.out.print(" ");
				else System.out.print(c++);
			}
			System.out.println();
		}
	}
	public int[][] getAddBorderMat(){
		return mat;
	}
	/**print the mat that with points.
	 * 
	 */
	public void printPointMat(){
		System.out.println("PointMat");
		for (int i = 0; i < myNodeMat.length; i++) {
			for (int j = 0; j < myNodeMat[0].length; j++) {
				System.out.print(myNodeMat[i][j].toString());
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Matrix bg = new Matrix(2);
		bg.matToNeighbor();
	}

	
}

