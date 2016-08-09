package finalsol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class searchSol {

	int n,sizeOfHex; 
	int keyArray[];
	int locationArray[];
	DataPoint formatArray[];

	DataPoint start,end;
	Matrix bm;
	ArrayList<DataPoint> remainedLocationArray;
	ArrayList<DataPoint> locationArrayPoint;
	ArrayList<DataPoint> visited;
	int[] path;

	//HashMap<myNode, ArrayList<myNode>> graph;

	static int co=0;
	static boolean gateAnswer=false; 
	//static LinkedList<String> allLists;

	public searchSol(int keyArray[],int locationArray[],int n){

		//allLists=new LinkedList<String>();
		
		bm=new Matrix(n);					//build mat;
		bm.buildMatPoint();
		this.keyArray=keyArray; 			//keys {1 to sizeOfHex}
		this.locationArray=locationArray;   //indexes {0 to (sizeOfhex-1)} 

		this.n=n;							//rib size
		this.sizeOfHex=bm.sizeOfHex;		//number of hexagons

		locationArrayPoint=locationArrayPoint(locationArray);//like locationArray but with points 
		visited=new ArrayList<DataPoint>();//holds the visited nodes


		//initialize node end-the closest hint
		end=locationArrayPoint.get(1);
		end.index=locationArray[1];
		end.H=0;
		end.G=keyArray[1];
		end.F=end.G+end.H;

		//initialize node start
		start=locationArrayPoint.get(0);
		start.index=locationArray[0];
		start.H=bm.heuristic(start, end);
		start.G=keyArray[0];
		start.F=start.G+start.H;



		visited.add(start); 

		remainedLocationArray();
		formatArray();

		run(visited,start,end,lengthOfpath(0));

	}
	/**
	 * this is the main method to find the path.
	 * 
	 * @param visited - ArrayList<myNode>
	 * @param start - myNode
	 * @param end - myNode
	 * @param lengthOfpath - integer
	 */
	public void run(ArrayList<DataPoint> visited,DataPoint start,DataPoint end,int lengthOfpath){


		DataPoint cur=visited.get(visited.size()-1); //cur is the last node in the visited list.
		
		ArrayList<DataPoint> nodes=bm.allNeighbors(cur);

		for(DataPoint node: nodes){  //run on all neighbors to check if we finish to the current end
			//allLists.add(getPathsToString(visited)+" node*: " + node);
			co++;
			if(visited.contains(node)) continue; //if the node already in the visited list so move to the next node

			if (node.equals(end) && visited.size() == lengthOfpath) {

				if(visited.size()==(sizeOfHex-1) ){//if we came to the end
					visited.add(node);
					//printPath(visited);
					point2index();
					visited.remove(visited.size()-1);
					gateAnswer=true;
					//writeToFile();
					//System.out.println("number of steps " +co);

					return;
				}

				else if(locationArray[locationArray.length-2]!=start.index ){//change the START and the END
					start=end;
					for (int i = 0; i < locationArray.length; i++) {
						if(locationArray[i]==start.index ){
							end=locationArrayPoint.get(i+1);
							end.index=locationArray[i+1];
							end.G=keyArray[i+1];
							end.H=0;
							end.F=end.G+end.H;

							lengthOfpath=lengthOfpath+lengthOfpath(i);
							remainedLocationArray.remove(start);
							break;
						}
					}
					start.H=bm.heuristic(start, end);
					start.F=start.G+start.H;
					break;
				}
			}

		}




		for (DataPoint node : nodes) {// run on all neighbors 
			
			//allLists.add(getPathsToString(visited)+" node: " + node);

			co++;
			if (visited.contains(node) || node.equals(end)) {
				continue;
			}
			int a=checkIfNotSaveLocation(node);//if this location is not a hint location
			if (a!=-1){//if the node is define by locationArray
				continue;
			}

			node.H=bm.heuristic(node, end);
			node.G=cur.G+1;
			node.F=node.G+node.H;
			visited.add(node);

			if(checkFormat(visited)){
				if(node.F<=end.F)
					run(visited,start,end,lengthOfpath);
			}

			visited.remove(visited.size()-1);

			if(gateAnswer){ 
				break; //stop this recursion 
			}
		}
	}
	/**
	 * this method build a array that holds the point of each index
	 * that in the locationArray
	 * 
	 * @param locationArray - integer array
	 * @return	- ArrayList<myNode>
	 */
	public ArrayList<DataPoint> locationArrayPoint(int locationArray[]){

		ArrayList<DataPoint> ans=new ArrayList<DataPoint>();


		for (int k = 0; k < locationArray.length; k++) {
			int index=locationArray[k];
			int count=-1;
			boolean flag=false;

			for (int i = 0; i < bm.mat.length; i++) {
				for (int j = 0; j < bm.mat[0].length; j++) {

					if(bm.mat[i][j]!=0) {
						count++;
					}
					if(count==index) {
						ans.add(new DataPoint(i, j));
						count=0;
						flag=true;
						break;
					}
				}
				if(flag) break;
			}
		}
		return ans;
	}
	/**
	 * method that calculate the length of the path
	 * between 2 close hints
	 * 
	 * @param i - integer
	 * @return - integer
	 */
	public int lengthOfpath(int i){
		assert((keyArray.length-1) <i);
		return keyArray[i+1]-keyArray[i];
	}
	/**
	 * method that prints the final path.
	 * 
	 * @param visited - ArrayList<myNode>
	 */
	private void printPath(ArrayList<DataPoint> visited ) {
		System.out.println(co++ + " visited " + visited);
	}
	/**
	 * method that verify that some node will not locate on a hint index
	 *   
	 * @param Node - myNode 
	 * @return - integer
	 */
	public int checkIfNotSaveLocation(DataPoint Node){
		if(remainedLocationArray.contains(Node)){
			return remainedLocationArray.indexOf(Node);
		}
		return -1;
	}
	/**
	 * method that build a list that containing the left indexes of the hints
	 * that represent in the locationArray
	 */
	public void remainedLocationArray(){
		remainedLocationArray=new ArrayList<DataPoint>();
		for (int i = 2; i < locationArray.length; i++) {
			remainedLocationArray.add(locationArrayPoint.get(i));
		}
	}

	/**
	 * method that check if the current path is
	 * passing through the right hinds in the right direction
	 * if yes-true
	 * else false
	 * 
	 * @param visited - ArrayList<myNode>
	 * @return - boolean
	 */
	public boolean checkFormat (ArrayList<DataPoint> visited ){

		for (int i = 0; i < visited.size(); i++) {
			DataPoint index =visited.get(i);
			//System.out.println(formatArray[i]);
			if(formatArray[i]!=null){
				if(!index.equals(formatArray[i])) return false;
			}			
		}
		return true;
	}
	/**
	 * method that build a pattern of the final path
	 * the length is the size of the hex
	 * and the hints will be ordered over the list
	 * 
	 */
	public void formatArray(){


		formatArray=new DataPoint[sizeOfHex];
		int step=0;
		formatArray[step]=locationArrayPoint.get(0);
		for (int i = 1; i < locationArray.length; i++) {

			step=step+keyArray[i]-keyArray[i-1];
			formatArray[step]=locationArrayPoint.get(i);
		}
		//		for (int i = 1; i < sizeOfHex; i++) 
		//			if(formatArray[i].equals(new myNode())) formatArray[i]=new myNode(-1,-1);

	}


	/**
	 * method that write to file the paths 
	 */
//	public void writeToFile(){
//		try {
//			FileWriter fileW = null;
//
//			String str=new String();
//			int i=0;
//
//			File myFile= new File("n3.txt");
//			fileW = new FileWriter(myFile);
//			System.out.println(allLists.size());
//			int size=allLists.size();
//			while(i<size){
//				str=allLists.get(i);
//				fileW.write(str+"\n");
//				i++;
//				//System.out.println("row: "+i);
//			}
//			fileW.close();
//
//			System.out.println("Finish write to the file");
//		} catch (IOException e) {e.printStackTrace();}
//
//
//	}
	private String getPathsToString(ArrayList<DataPoint> visited2 ) {
		return (co++ + " visited " + visited2);
	}

	/**
	 * Method that convert the path representation from Point to integer 
	 */
	private void point2index(){
		path=new int[sizeOfHex];
		for (int i = 0; i < visited.size(); i++){
			path[i]=bm.mat[visited.get(i).x][visited.get(i).y]-1;
		}
		//System.out.println("Path: "+Arrays.toString(path));

	}
	
	public  int[]  getPath(){
		return path;
		
	}
	public int getSteps(){
		return co;
	}
	
	
	public void resetStaticFields(){
		co=0;
		gateAnswer=false;
	}
}
