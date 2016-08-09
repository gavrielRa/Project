package gui;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NewGame extends JPanel{

	//generatorGames(level);
	SelectedGame sg;
	String level;


	// temporary

	/**
	 * Create the application.
	 */
	public NewGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(0, 0, 500, 700);
		setLayout(null);

		Image picu = new ImageIcon(this.getClass().getResource("/btnLevel2.png")).getImage();

		JButton btnBack = new JButton("Previous");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnBack.setBounds(30, 620, 440, 50);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				runTheApp.game.goBackFromNewGame();
			}
		});
		btnBack.setIcon(new ImageIcon(picu));
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);


		//create buttons for levels 
		JButton[] array=new JButton[4];
		int x=30;
		for (int i = 0; i < 4; i++) {
			array[i]=new JButton((i+2)+"");
			array[i].setFont(new Font("Times New Roman", Font.BOLD, 19));
			add(array[i]);
			//array[i].setBounds(x, 123, 76, 78);
			//x=x+120;

			array[i].setIcon(new ImageIcon(picu));
			array[i].setHorizontalTextPosition(AbstractButton.CENTER);
			array[i].setVerticalTextPosition(AbstractButton.CENTER);

			array[i].addActionListener(new ActionListener() {
				String btnId;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					btnId= ((JButton) e.getSource()).getText();
					runTheApp.game.toSelectedGame(Integer.parseInt(btnId));
				}
			});
		}

		array[0].setBounds(30, 80, 440, 50);
		array[1].setBounds(30, 140, 440, 50);
		array[2].setBounds(30, 200, 440, 50);
		array[3].setBounds(30, 260, 440, 50);

		picu = new ImageIcon(this.getClass().getResource("/btnCreat.png")).getImage();

		JButton btnGameByUser = new JButton("Build");
		btnGameByUser.setBounds(30, 400, 440, 150);
		add(btnGameByUser);
		btnGameByUser.setFont(new Font("Times New Roman", Font.BOLD, 19));

		btnGameByUser.setIcon(new ImageIcon(picu));
		btnGameByUser.setHorizontalTextPosition(AbstractButton.CENTER);
		btnGameByUser.setVerticalTextPosition(AbstractButton.CENTER);

		btnGameByUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				runTheApp.game.toGameByUser();
			}
		});

		JLabel lblLevel = new JLabel("Choose your level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBounds(54, 13, 376, 44);
		add(lblLevel);
		
		JLabel lblUserGame = new JLabel("Build your own game");
		lblUserGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserGame.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblUserGame.setBounds(54, 320, 376, 67);
		add(lblUserGame);

	}
}
