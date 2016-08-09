package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel{




	/**
	 * Create the application.
	 */
	public Menu() {
		super();

		//	setBounds(650, 200, 600, 600);
		setLayout(null);
		Image picu = new ImageIcon(this.getClass().getResource("/btnEmpty.png")).getImage();


		


		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(111, 132, 172, 66);
		add(btnNewGame);
		btnNewGame.setFont(new Font("Times New Roman", Font.BOLD, 19));

		btnNewGame.setIcon(new ImageIcon(picu));
		btnNewGame.setHorizontalTextPosition(AbstractButton.CENTER);
		btnNewGame.setVerticalTextPosition(AbstractButton.CENTER);
		//btnNewGame.setBorderPainted(false);


		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runTheApp.game.toNewGame();
			}
		});




		JButton btnRules = new JButton("Rules");
		btnRules.setBounds(34, 288, 174, 67);
		add(btnRules);
		btnRules.setFont(new Font("Times New Roman", Font.BOLD, 19));

		//picu = new ImageIcon(this.getClass().getResource("/btnRules.png")).getImage();
		btnRules.setIcon(new ImageIcon(picu));
		btnRules.setHorizontalTextPosition(AbstractButton.CENTER);
		btnRules.setVerticalTextPosition(AbstractButton.CENTER);

		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runTheApp.game.toRules();

			}
		});


		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(111, 456, 174, 67);
		add(btnAbout);
		btnAbout.setFont(new Font("Times New Roman", Font.BOLD, 19));

		//picu = new ImageIcon(this.getClass().getResource("/btnAbout.png")).getImage();
		btnAbout.setIcon(new ImageIcon(picu));
		btnAbout.setHorizontalTextPosition(AbstractButton.CENTER);
		btnAbout.setVerticalTextPosition(AbstractButton.CENTER);


		
		JLabel lblHidato = new JLabel("Hidato");
		lblHidato.setHorizontalAlignment(SwingConstants.CENTER);
		lblHidato.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblHidato.setBounds(12, 13, 476, 94);
		add(lblHidato);
		lblHidato.setForeground(Color.BLACK);
		
		
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				runTheApp.game.toAbout();
			}
		});





	}
}
