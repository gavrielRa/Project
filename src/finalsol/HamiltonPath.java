package finalsol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class HamiltonPath {


	int len;
	int path[];
	int count;
	LinkedList<int []> allPaths;
	boolean getPath;

	public HamiltonPath(){
		this.count=0;
		this.getPath=false;
		allPaths=new LinkedList<int []>();
	}
	/**This function find the all hamilton paths that in the graph.
	 * 
	 * @param mat-matrix
	 */
//	public void findAllHamiltonPath(int mat[][]){
//		this.len = mat.length;
//		this.path = new int[len];
//		for(int i = 0;i<len;i++){ //Go through column(of matrix)
//			path[0]=i+1;
//			findHamiltonpath(mat,i,0);
//		}
//	}
	/**This function find the all hamilton paths with a given start index that in the graph
	 * 
	 * @param mat-matrix
	 * @param start-i=real number
	 */
	public void HamiltonPath(int mat[][], int start){ 
		len = mat.length;
		path = new int[len];
		for (int i = 0; i < path.length; i++) {
			path[i]=-1;
		}

		path[0]=start;
		findHamiltonpath(mat,(start),0);
	}

	/**this function find recursively the path in matrix mat
	 * 
	 * @param M - original matrix/graph
	 * @param x - current index
	 * @param y - current row index
	 * @param l - current 
	 */
	private void findHamiltonpath(int mat[][],int j,int index){

		ArrayList<Integer> neighbors=new ArrayList<>();
		
		for(int i=0 ; i<len ; i++ ){
			if(mat[i][j]!=0) neighbors.add(i); 
		}
		
	//	Collections.shuffle(neighbors);
		
		for(int i:neighbors){        //run on row i
		//	System.out.println("s");

			if(mat[i][j]!=0){      			//check if 2 vertices are connected
				if(detect(path,i))			//if detect a point that already in the path => duplicate 
					continue;

				index++;            			//Increase path length due to 1 new point is connected 
				path[index]=i/*+1*/;    			//correspond to the array that start at 0, graph that start at point 1
				if(index==len-1){				//check if success connect all point
					//display(path);

					//					int[] temp=new int[path.length];	//Deep copy path
					//					for (int k = 0; k < temp.length; k++) {
					//						temp[k]=path[k];
					//					}
					//					allPaths.addLast(temp);
					index--;
					getPath=true;
					return;
					//continue;
				}

				//	mat[i][j]=mat[j][i]=0;  		 //remove the path that has been get and
				findHamiltonpath(mat,i,index);	 //recursively start to find new path at new end point
				index--;                		 // reduce path length due to the failure to find new path         
				//	mat[i][j] = mat[j][i]=1; 		 //and tranform back to the inital form of adjacent matrix(graph)

			}
			if(getPath) return;
		}
		path[index/*+1*/]=-1;    //disconnect two point correspond the failure to find the..   
	}                     //possible hamilton path at new point(ignore newest point try another one)         

	/**print the hamilton path
	 * 
	 * @param path-array
	 */
	public void display(int path[]){
		count++;   
		//System.out.print(count+" : ");
		for(int i:path){
			System.out.print(i+" ");
		}
		System.out.println();   
	}

	/**check if the path already contains the vertex.
	 * 
	 * @param path-array
	 * @param vertex
	 * @return true if yes otherwise false
	 */
	private boolean detect(int path[],int vertex){ //Detect duplicate point in Halmilton path 
		for(int i:path){//fix that not run on the all array
			if(i==vertex) return true;
		}

		return false;
	}
	public int[] getOnePath(){
		//int index = (int)(Math.random()*allPaths.size());
		//System.out.println("path at index: "+index+" is: "+Arrays.toString(allPaths.get(index)));
		return path;
	}

	public void printAllPaths(){
		for(int i = 0; i < allPaths.size();i++) 
			System.out.println(Arrays.toString(allPaths.get(i)));
	}


	public static void main(String[] args){


	}
}