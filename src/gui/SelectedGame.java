package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import finalsol.Matrix;
import finalsol.buildGame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class SelectedGame extends JPanel{

	private int selectedLevel;
	private buildGame bg;// = new buildGame(n, numOfKeys);
	private BuildLevel bl;
	int hintsSize;
	int[] keyArray;
	int[] locationArray;
	final int framesize1=30;
	final int framesize2=120;
	//	static JButton buttonCeck;
	public SelectedGame(int selectedLevel) {

		this.selectedLevel = selectedLevel;
		hintsSize = numOfHints(selectedLevel);
		bg = new buildGame(selectedLevel, hintsSize);
		keyArray = bg.getKeyArray();
		locationArray = bg.getLocationArray();

		init();

	}


	public void init(){
		setBounds(0, 0, 500, 700);
		setLayout(null);

		bl = new BuildLevel(selectedLevel,keyArray,locationArray);
		bl.one();

		Image picu = new ImageIcon(this.getClass().getResource("/btnLevel2.png")).getImage();

		JLabel lblChechStatus = new JLabel();
		lblChechStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblChechStatus.setBounds(30, 13, 438, 38);
		add(lblChechStatus);
		lblChechStatus.setFont(new Font("Times New Roman", Font.BOLD, 30));

		
		JButton btnSolve = new JButton("solve");
		btnSolve.setBounds(30, 536, 438, 50);
		add(btnSolve);
		btnSolve.setFont(new Font("Times New Roman", Font.BOLD, 19));

		btnSolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bl.solve();
				btnSolve.setEnabled(false);
				bl.nb.closeFrameOfNumberBox();
			}
		});
		
		btnSolve.setIcon(new ImageIcon(picu));
		btnSolve.setHorizontalTextPosition(AbstractButton.CENTER);
		btnSolve.setVerticalTextPosition(AbstractButton.CENTER);
		


		JButton btnBack = new JButton("Previous");
		btnBack.setBounds(30, 620, 440, 50);
		add(btnBack);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runTheApp.game.goBackFromSelectedGame();
				bl.nb.closeFrameOfNumberBox();



			}
		});
		
		btnBack.setIcon(new ImageIcon(picu));
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
		
		
		JButton btnHint = new JButton("Hint");
		btnHint.setBounds(32, 436, 172, 66);
		add(btnHint);
		btnHint.setFont(new Font("Times New Roman", Font.BOLD, 19));

		btnHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bl.hint();
			}
		});
		picu = new ImageIcon(this.getClass().getResource("/btnEmpty.png")).getImage();
		
		btnHint.setIcon(new ImageIcon(picu));
		btnHint.setHorizontalTextPosition(AbstractButton.CENTER);
		btnHint.setVerticalTextPosition(AbstractButton.CENTER);
		
		
		JButton	btnCeck = new JButton("Check");
		btnCeck.setBounds(298, 436, 172, 66);
		add(btnCeck);
		btnCeck.setFont(new Font("Times New Roman", Font.BOLD, 19));

		//buttonCeck.setEnabled(false);
		btnCeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean res  = checkUserSolution();
				if (res){
					lblChechStatus.setText("Congratulations");
				}
				else lblChechStatus.setText("Try again");
			}
		});
		
		btnCeck.setIcon(new ImageIcon(picu));
		btnCeck.setHorizontalTextPosition(AbstractButton.CENTER);
		btnCeck.setVerticalTextPosition(AbstractButton.CENTER);
		
	
		
		for (int i = 0; i < bl.getButtonHexArray().length; i++) {
			add(bl.getButtonHexArray()[i]);
		}


	}
	/**
	 * check if the solution array is correct 
	 * using neighbors matrix
	 * @return boolean
	 */
	public boolean checkUserSolution(){
		Matrix bm = new Matrix(bl.sizeforbox);
		int [][] mat = bm.matToNeighbor();

		int [] ansSol = bl.getUserSolution();
		for (int i = 0; i < ansSol.length-1; i++) {
			if (mat[ansSol[i]][ansSol[i+1]] != 1) return false;
		}
		return true;
	}
	/**
	 * this method calculates how much hints to give to the game
	 * @param hexSize - integer
	 * @return integer 
	 */
	public int numOfHints (int hexSize){
		if(hexSize == 2) return 3;
		else if(hexSize == 3) return 6;
		else if(hexSize == 4) return 11;
		else if(hexSize == 5) return 18;
		else return -1;
	}


	


}
