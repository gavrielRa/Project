package old;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Search {

	private int sizeOfHex;
	private int []keyArray;
	private int []locationArray;
	private int []formatArray;
	private int count=0;
	static boolean gateAnswer; 
	static LinkedList<String> allLists;
	static int Co=0;
	LinkedList<String> locationArrayLinlList;
	int lastLocationIndex;

	public Search(Graph graph,int keyArray[],int locationArray[],int sizeOfHex) {
		allLists=new LinkedList<String>();
		gateAnswer=false;
		this.sizeOfHex=sizeOfHex;
		keyArray(keyArray);
		locationArray(locationArray);
		formatArray();
		lastLocationIndex=locationArray[0];
		String START=locationArray[0]+"";
		String END=locationArray[1]+"";
		int lengthOfpath=lengthOfpath(0);

		LinkedList<String> visited = new LinkedList<String>();
		visited.add(START);

		locationArrayLinlList=new LinkedList<String>();
		for (int i = 2; i < locationArray.length; i++) {
			locationArrayLinlList.add(locationArray[i]+"");
		}

		depthFirst(graph, visited,lengthOfpath,START,END);

	}



	public void depthFirst(Graph graph, LinkedList<String> visited,int lengthOfpath,String START,String END) {

		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());//all neighbors 
		// examine adjacent nodes

		for (String node : nodes) {
			//if the path contains this node, then skip to the next node and check again
			allLists.add(getPathsToString(visited)+" node: " + node);
			//System.out.println(Co);
			if (visited.contains(node)) { //if the node is already in the path
				continue;
			}
			

			if (node.equals(END) && visited.size() == lengthOfpath) {
				//if we came to the end
				if(visited.size()==(sizeOfHex-1) ){
					visited.add(node);
					getPaths(visited);
					visited.removeLast();
					gateAnswer=true;
					//writeToFile();
					return;
				}
				//change the START and the END
				else if(locationArray[locationArray.length-2]!=Integer.parseInt(START) ){
					START=END;
					for (int i = 0; i < locationArray.length; i++) {
						if(locationArray[i]==Integer.parseInt(START) ){
							END=""+locationArray[i+1];
							lengthOfpath=lengthOfpath+lengthOfpath(i);
							locationArrayLinlList.remove(START);
							break;
						}
					}
					break;
				}
			}

		}

		for (String node : nodes) {
			//allLists.add(getPathsToString(visited)+"sec start for");

			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			int a=checkIfNotSaveLocation(node);
			if (a!=-1){//if the node is define by locationArray

				continue;
			}
			visited.addLast(node);

			if(checkFormat(visited)){
				//	System.out.println("count : " + count++);
				depthFirst(graph, visited,lengthOfpath,START,END);
			}
			
			visited.removeLast();
			//allLists.add(getPathsToString(visited)+"sec end for");

			if(gateAnswer){
				//System.out.println("gateAnswer: "+gateAnswer);
				break;
			}
		}
	}

	private void getPaths(LinkedList<String> visited ) {
		System.out.println(Co + " visited " + visited);
	}
	private String getPathsToString(LinkedList<String> visited ) {
		return (Co++ + " visited " + visited);
	}
	public int[] keyArray(int[] arr){
		keyArray=new int[arr.length];
		keyArray=arr;
		return keyArray;
	}
	public int[] locationArray(int[] arr){
		locationArray=new int[arr.length];
		locationArray=arr;
		return locationArray;
	}

	public int lengthOfpath(int i){
		assert((keyArray.length-1) <i);
		return keyArray[i+1]-keyArray[i];
	}


	private void printPath(LinkedList<String> visited) {
		for (String node : visited) {
			//if(visited.size() == lengthOfpath){
			System.out.print(node);
			System.out.print("->");
			//	}
		}
		System.out.println();
	}

	public void formatArray(){


		formatArray=new int[sizeOfHex];
		int step=0;
		formatArray[step]=locationArray[0];
		for (int i = 1; i < locationArray.length; i++) {

			step=step+keyArray[i]-keyArray[i-1];
			formatArray[step]=locationArray[i];
		}
		for (int i = 1; i < sizeOfHex; i++) {

			if(formatArray[i]==0) formatArray[i]=-1;
		}
	}

	public int checkIfNotSaveLocation( String Node){
		if(locationArrayLinlList.contains(Node)){
			return locationArrayLinlList.indexOf(Node);
		}
		return -1;
	}

	public boolean checkFormat (LinkedList<String> visited ){

		for (int i = 0; i < visited.size(); i++) {
			int index = Integer.parseInt(visited.get(i));
			if(formatArray[i] != -1){
				if(index != formatArray[i]) return false;
			}			
		}
		return true;
	}
	/*	public boolean unique (LinkedList<String> visited){
		int size  =visited.size();
		String cur = visited.poll();
		for(int i = 0 ; i<size;i++){
			if(visited.contains(cur)) return false;
			cur = visited.poll();
		}
		return true;
	}*/

	public void writeToFile(){
		try {
			FileWriter fileW = null;

			String str=new String();
			int i=0;

			File myFile= new File("n3.txt");
			fileW = new FileWriter(myFile);
			System.out.println(allLists.size());
			int size=allLists.size();
			while(i<size){
				str=allLists.get(i);
				fileW.write(str+"\n");
				i++;
				//System.out.println("row: "+i);
			}
			fileW.close();

			System.out.println("Finish write to the file");
		} catch (IOException e) {e.printStackTrace();}

		
	}
	
	

}