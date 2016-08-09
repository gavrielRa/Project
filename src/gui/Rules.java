package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

public class Rules extends JPanel{


	/**
	 * Create the application.
	 */
	public Rules() {
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
				runTheApp.game.goBackFromRules();
			}
		});
		
		btnBack.setIcon(new ImageIcon(picu));
		btnBack.setHorizontalTextPosition(AbstractButton.CENTER);
		btnBack.setVerticalTextPosition(AbstractButton.CENTER);
	/*	
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBackground(SystemColor.control);
		textArea.setBounds(85, 60, 292, 179);
		add(textArea);
		textArea.setText("The rules of the game are as follows: \r\nPlease complete the missing numbers\r\n between the vertex which contains the \r\nlowest number to the vertex which contains \r\nthe highest number, The sequential numbers \r\nshould be close together");
	*/
		
		JTextPane aboutTextLabel = new JTextPane();
		aboutTextLabel.setBounds(0, 13, 500, 594);
		add(aboutTextLabel);
		aboutTextLabel.setOpaque(false);
		aboutTextLabel.setFont(new Font("Serif", Font.BOLD, 25));
		aboutTextLabel.setForeground(Color.BLACK);


		aboutTextLabel.setText("\r\nThe rules of the game are as follows: \r\n\r\nComplete the missing numbers\r\nbetween the vertex which contains the \r\nlowest number to the vertex which contains \r\nthe highest number.\r\n\r\n\r\n1. The sequential numbers should be close together.\r\n\r\n2. The intention is that 1 must be close to 2,    2 must be close to 3 and to 1.\r\n\r\n3. 3 must be close to 4 and to 2, and so on.");

	}

}
