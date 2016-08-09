package gui;


import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;


public class About extends JPanel{

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(0, 0, 500, 700);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		
		Image picu = new ImageIcon(this.getClass().getResource("/btnLevel2.png")).getImage();

		JButton btnBack = new JButton("Previous");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnBack.setBounds(30, 620, 440, 50);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runTheApp.game.goBackFromAbout();
			}
		});
		
		btnBack.setIcon(new ImageIcon(picu));
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
		
		
		JTextPane aboutTextLabel = new JTextPane();
		aboutTextLabel.setBounds(0, 13, 500, 594);
		add(aboutTextLabel);
		aboutTextLabel.setOpaque(false);
		aboutTextLabel.setText("   This is java application for the Hidato game. \r\n\r\n   This is a final project that was created by:\r\n\r\n\t        Gavriel Rachamilov\r\n\t      \t        And\r\n\t        Vladislav Hanochov\r\n\r\n\t         Supervised by: \r\n\t          Dr Dan Ophir\r\n\r\n        Department of computer science and\r\n     Mathematics in University of Ariel ,Israel\r\n\r\n\t      \t  version 1.3");
		aboutTextLabel.setFont(new Font("Serif", Font.BOLD, 25));
		aboutTextLabel.setForeground(Color.BLACK);

	}


}
