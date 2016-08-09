package gui;
/**
 * 
 * @authors 
 *                  gavriel rachmilov  id:310526900
 *           		vladislav hanochov id:308903871 
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class runTheApp extends JFrame{

	private JPanel contentPane;
	public static SwitchPanel game;									// static main class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					runTheApp window = new runTheApp();
					window.setVisible(true);
					Menu menu=new Menu();  		       			// create new menu panel
					game=new SwitchPanel(window, menu);    			// create new main class
					window.getContentPane().add(menu);			// add menu panel to frame




				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public runTheApp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setBounds(200, 0, 500, 730);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		validate();

	}

}
