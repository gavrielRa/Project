package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import finalsol.searchSol;

public class BuildLevel extends JPanel{

	int index,k ,nn,sizeforbox,middle,scale,sc,row,col;
	int ans;
	int n=0;	
	int len=0;
	int[] keyArray,locationArray,ansPath;
	ArrayList<Integer> keyArrayList;
	ArrayList<Integer> notVisited;
	ArrayList<JButton> buttonOpenBox;
	JFrame frame;
	HexagoneButton [] buttonHexArray,validButtonArray;
	int start,end;
	searchSol sco; 
	NumberBox nb;


	public BuildLevel(int n,int [] keyArray, int [] locationArray){


		setBounds(0, 0, 500, 700);
		setLayout(null);
		index=0;
		nn=n;
		sizeforbox=n;
		this.n=n;
		this.row=90;
		this.col=160;
		this.frame=new JFrame();
		this.keyArray=keyArray;
		this.locationArray=locationArray;
		this.notVisited = new ArrayList<Integer>();
		this.keyArrayList = new ArrayList<Integer>();
		this.start = locationArray[0];
		this.end = locationArray[locationArray.length-1];




		for (int i = 0; i < keyArray.length; i++) {
			keyArrayList.add(i, keyArray[i]);
		}

		for (int i = 1; i <= sizeOfHex(sizeforbox); i++ ) 
			notVisited.add(i);  

		for (int i = keyArray.length - 1; i >= 0  ; i--) {
			if ((notVisited.contains(keyArray[i]))) notVisited.remove(keyArray[i]-1); 
		}        


		buildHive();
	}




	/**
	 * this method fill in the hints and
	 * set the buttons of the hive
	 */

	public  void one() {

		nb=new NumberBox(buttonOpenBox, notVisited, buttonHexArray, locationArray, start, end);


		//fill in the hints
		for (int i = 0; i < locationArray.length; i++) {				
			buttonHexArray[locationArray[i]].setText(Integer.toString(keyArray[i]));	
			buttonHexArray[locationArray[i]].setEnabled(false);
			buttonHexArray[locationArray[i]].setFont(new Font("Serif", Font.BOLD, 18));
		}



		//set the hive with buttons and action listener 
		for (int i = 0; i < buttonHexArray.length; i++) {

			buttonHexArray[i].name=i+"";
			buttonHexArray[i].setBackground(Color.white);
			buttonHexArray[i].addActionListener(new ActionListener() {
				String num;
				public void actionPerformed(ActionEvent actionEvent) {

					num= actionEvent.getSource().toString();
					turnHexOff();
					nb.openNumberBox(Integer.parseInt(num),1);
				}
			});
		}
		nb.turnHexOn();
	}

	public  void two() {

		nb=new NumberBox(buttonOpenBox, notVisited, buttonHexArray, locationArray, start, end);


		//fill in the hints
		//		for (int i = 0; i < locationArray.length; i++) {				
		//			buttonHexArray[locationArray[i]].setText(Integer.toString(keyArray[i]));	
		//			buttonHexArray[locationArray[i]].setEnabled(false);
		//			buttonHexArray[locationArray[i]].setFont(new Font("Serif", Font.BOLD, 18));
		//		}

		JButton btn=new JButton();

		//set the hive with buttons and action listener 
		for (int i = 0; i < buttonHexArray.length; i++) {

			btn=buttonHexArray[i];
			buttonHexArray[i].name=i+"";
			buttonHexArray[i].setBackground(Color.white);
			buttonHexArray[i].addActionListener(new ActionListener() {
				String num;
				public void actionPerformed(ActionEvent actionEvent) {

					num= actionEvent.getSource().toString();
					turnHexOff();
					nb.openNumberBox(Integer.parseInt(num),2);
				}
			});
		}
		nb.turnHexOn2(btn);
	}

	/**
	 * 
	 */
	public void solve(){

		//System.out.println(Arrays.toString(keyArray)+"  "+Arrays.toString(locationArray)+"   "+sizeforbox);
		//System.out.println(Arrays.toString(ansPath));
		this.sco = new searchSol(keyArray, locationArray, sizeforbox);
		this.ansPath = sco.getPath();
		sco.resetStaticFields();


		//fill in the hive with the answer 
		for (int i = 0; i < sizeOfHex(sizeforbox); i++) {
			buttonHexArray[ansPath[i]].setText(Integer.toString(i+1));
			buttonHexArray[ansPath[i]].setFont(new Font("Serif", Font.BOLD, 18));
		}
		turnHexOff();
	}

	public void solveUserGame(){
		//Hexnb.getButtonHexArray();
		int countSize=0,index=0;
		
		for (int i = 0; i < buttonHexArray.length; i++) {
			if(!buttonHexArray[i].getText().equals("")) countSize++;
			//if(Integer.parseInt(buttonHexArray[i].getText()) < min) min=Integer.parseInt(buttonHexArray[i].getText());
		}

		int [] tempKeyArray=new int[countSize];
		int [] tempLocationArray=new int[countSize];

		
		for (int i = 0; i < buttonHexArray.length; i++) {
				if(!buttonHexArray[i].getText().equals("")){
					tempKeyArray[index]=Integer.parseInt(buttonHexArray[i].getText());
					tempLocationArray[index]=Integer.parseInt(buttonHexArray[i].getName());
					index++;
				}
		}
		
		int temp;
		
		for (int i = 0; i < tempKeyArray.length; i++) {
			int min=i;
			for (int j = i+1; j < tempKeyArray.length; j++) {
				if(tempKeyArray[j]<tempKeyArray[min]) min=j;
			}
			if(tempKeyArray[min]<tempKeyArray[i]) {
				temp=tempKeyArray[min];
				tempKeyArray[min]=tempKeyArray[i];
				tempKeyArray[i]=temp;
				
				temp=tempLocationArray[min];
				tempLocationArray[min]=tempLocationArray[i];
				tempLocationArray[i]=temp;
			}
			
		}
		

		
		keyArray=tempKeyArray;
		locationArray=tempLocationArray;


		System.out.println("keyArray: "+Arrays.toString(keyArray));
		System.out.println("locationArray: "+Arrays.toString(locationArray));

		solve();
	}

	/**
	 * This method generate hints for the game.
	 */
	public void hint(){

		this.sco = new searchSol(keyArray, locationArray, sizeforbox);
		this.ansPath = sco.getPath();
		sco.resetStaticFields();
		
		boolean hintFlag = true;
		while (hintFlag){
			if (keyArrayList.size() ==  sizeOfHex(sizeforbox)) break;
			int rand = (int) (Math.random()*sizeOfHex(sizeforbox));
			if (!keyArrayList.contains(rand+1)){
				buttonHexArray[ansPath[rand]].setText(Integer.toString(rand+1));
				buttonHexArray[ansPath[rand]].setFont(new Font("Serif", Font.BOLD, 18));
				keyArrayList.add(rand+1);
				hintFlag = false;
			}
		}
		System.gc();
	}


	/**
	 *This method return the buttonHexArray
	 * @return arrays of HexagoneButton
	 */
	public HexagoneButton[] getButtonHexArray(){
		return buttonHexArray;
	}



	/**
	 * This method enabled the buttons of the hive.
	 */
	public void turnHexOff(){
		for (int i = 0; i < buttonHexArray.length; i++) {
			buttonHexArray[i].setEnabled(false);
			buttonHexArray[i].setForeground(Color.red);
		}
	}

	/**
	 * this function calculate the user solution
	 * @return array of Integer
	 */
	public int [] getUserSolution(){
		int [] userSol = new int [buttonHexArray.length];
		for (int i = 0; i < buttonHexArray.length; i++) {
			String s = buttonHexArray[i].getText();
			if(!s.equals("")){
				int num = Integer.parseInt(s); 
				int name = Integer.parseInt(buttonHexArray[i].getName());
				userSol[num-1]=name;
			}
		}
		return userSol;
	}


	/**
	 * This function build the hive
	 * and locate and organizes the buttons on the panel.
	 */
	public void buildHive(){

		if(n==2){
			scale =100;
			sc =100;
		}
		else if(n==3){
			scale= 140;
			sc= 180;
		}
		else if(n==4){
			scale= 180;
			sc= 260;
		}
		else if(n==5){
			scale= 220;
			sc= 340;
		}
		else{
			scale= 260;
			sc= 420;
		}


		final int x = 35;
		final int y = 41;
		final int z = 40;


		int temp = n;
		int temp2 = n ;
		int sizeOfHex = sizeOfHex(n);

		buttonHexArray = new HexagoneButton[sizeOfHex];
		validButtonArray = new HexagoneButton[sizeOfHex - (locationArray.length)];


		while(n-1>0){

			for (int i = 0; i < temp; i++) {
				buttonHexArray[index] = new HexagoneButton("");
				buttonHexArray[index].setBounds(col, row, x, y);
				add(buttonHexArray[index]);
				col += z;
				index++;			  		
			}
			col -=scale;
			row+=x;
			temp++;
			n--;
			scale+=z;

		}

		int middle = middleSize(nn);

		for (int i = 0; i < middle; i++) {
			buttonHexArray[index] = new HexagoneButton("");
			buttonHexArray[index].setBounds(col, row, x, y);
			add(buttonHexArray[index]);

			col += z;
			index++;	
		}

		col -=sc;
		row+=x;
		temp2 = middleSize(nn)-1;

		while(nn-1>0){

			for (int i = 0; i < temp2; i++) {
				buttonHexArray[index] = new HexagoneButton("");
				buttonHexArray[index].setBounds(col, row, x, y);
				add(buttonHexArray[index]);

				col += z;
				index++;			  		
			}
			col -=sc-z;
			row+=x;
			temp2--;
			nn--;
			sc+=-z;
		}
	}




	/**
	 * This method calculate the size of the hive by her rib 
	 * @param m integer
	 * @return integer
	 */
	public static int sizeOfHex(int n){
		int numOfRows=2*n-1;
		int ans = 0 ;

		for (int i = 0; i < numOfRows/2 ; i++) 
			ans=ans + n + i;				
		return ans*2 + numOfRows;
	}
	/**
	 * 
	 * @param n - integer
	 * @return integer
	 */
	public int len(int n){
		int size = sizeOfHex(n);
		return (size/2)-(n-1);
	}

	/**
	 * 
	 * @param n - integer
	 * @return integer
	 */
	public int middleSize(int n){
		int size = sizeOfHex(n);
		int len = len(n);
		int ans =  size - (2*len);
		return ans;
	}

}
