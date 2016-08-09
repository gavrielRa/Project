package finalsol;
//
//import java.awt.Point;
//import java.util.ArrayList;
//
//
public class build {
//
//	myNode myNodeMat[][];
//	int intMat[][];
//	
//	public build(int n,int [][]mat) {
//		// TODO Auto-generated constructor stub
//		int col=mat[0].length,row=mat.length;
//		myNodeMat=new myNode[row][col];
//		
//		this.intMat=mat;
//		definePoints();
//		
//	}
//
//
//	public void definePoints (){
//		for (int i = 0; i < intMat.length; i++) {//we have space 1 in up and 1 in dawn
//			for (int j = 0; j < intMat[0].length; j++) {//we have space 2 in right and 2 in left
//				if(intMat[i][j]==1){
//					myNodeMat[i][j]=new myNode(i, j);;
//				}
//				else{
//					myNodeMat[i][j]=new myNode();
//				}
//			}
//		}
//	}
//	
//	public ArrayList<myNode> allNeighbors(myNode cur){
//		ArrayList<myNode> arr=new ArrayList<myNode>();
//		int i=cur.x;
//		int j=cur.y;
//		
//		//R
//		if(intMat[i][j+2]!=0) arr.add(new myNode(i, (j+2)));
//		//RD
//		if(intMat[i+1][j+1]!=0)  arr.add(new myNode((i+1), (j+1)));
//		//LD
//		if(intMat[i+1][j-1]!=0) arr.add(new myNode((i+1), (j-1)));
//		//L
//		if(intMat[i][j-2]!=0) arr.add(new myNode((i), (j-2)));
//		//LU
//		if(intMat[i-1][j-1]!=0) arr.add(new myNode((i-1), (j-1)));
//		//RU
//		if(intMat[i-1][j+1]!=0) arr.add(new myNode((i-1), (j+1)));
//
//		if(arr.isEmpty()) return null;
//		return arr;
//		
//	}
//	
//	
//	public void print(){
//		System.out.println("PointMat");
//		for (int i = 0; i < myNodeMat.length; i++) {
//			for (int j = 0; j < myNodeMat[0].length; j++) {
//				System.out.print(myNodeMat[i][j].toString());
//			}
//			System.out.println();
//		}
//	}
}
