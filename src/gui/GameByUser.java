package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameByUser extends JPanel{


	BuildLevel bl;	
	
	
	
	/**
	 * Create the application.
	 */
	public GameByUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(0, 0, 500, 700);
		setLayout(null);

		int[] keyArray={0};
		int[] locationArray={0};

		bl=new BuildLevel(5,keyArray,locationArray);
		bl.two();

		Image picu = new ImageIcon(this.getClass().getResource("/btnLevel2.png")).getImage();

		JButton btnBack = new JButton("Previous");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnBack.setBounds(30, 620, 440, 50);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				runTheApp.game.goBackFromGameByUser();
			}
		});
		btnBack.setIcon(new ImageIcon(picu));
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
		
		
		JButton btnSolve = new JButton("solve");
		btnSolve.setBounds(30, 536, 438, 50);
		add(btnSolve);
		btnSolve.setFont(new Font("Times New Roman", Font.BOLD, 19));

		btnSolve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bl.solveUserGame();
			}
		});
		btnSolve.setIcon(new ImageIcon(picu));
		btnSolve.setHorizontalTextPosition(AbstractButton.CENTER);
		btnSolve.setVerticalTextPosition(AbstractButton.CENTER);
		



		for (int i = 0; i < bl.getButtonHexArray().length; i++) {
			add(bl.getButtonHexArray()[i]);
		}

	}
}
