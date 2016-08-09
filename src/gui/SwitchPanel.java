package gui;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @authors 
 *                  gavriel rachmilov  id:310526900
 *           		vladislav hanochov id:308903871 
 *
 */
public class SwitchPanel {


	private runTheApp run_the_app;
	private Menu menu;

	private NewGame newgame;
	private Rules rules;
	private About about;
	private SelectedGame selectedGame;
	private GameByUser gameByUser;
	
	private JLabel imglabel;
	private ImageIcon pic,picM;
	
	/*constructor*/
	public SwitchPanel(runTheApp run_the_app, Menu menu){
		this.run_the_app=run_the_app;
		this.menu=menu;
		
		imglabel = new JLabel("");
		
		URL url = Menu.class.getResource(
				"/101.jpg");
		URL url2 = Menu.class.getResource(
				"/menuPic.png");
		pic = new ImageIcon(url);
		picM= new ImageIcon(url2);
		
		//this.pic = new ImageIcon(this.getClass().getResource("/101.jpg")).getImage();
		//this.picM = new ImageIcon(this.getClass().getResource("/menuPic.png")).getImage();
		
		//imglabel.setIcon(new ImageIcon(pic));
		//imglabel.setBounds(0, 0, 500, 700);
		//menu.add(imglabel);
		changeBackground(menu,picM);
	}
	
	public void changeBackground(JPanel panel,ImageIcon pic){
		panel.add(imglabel);
		imglabel.setIcon(pic);
		imglabel.setBounds(0, 0, 500, 700);
		
	}
	/**
	 * change panel from Menu to NewGame
	 */
	public void toNewGame(){
		run_the_app.remove(menu);
		newgame=new NewGame();
		run_the_app.add(newgame);
		
		//newgame.add(imglabel);

		changeBackground(newgame,pic);

		
		run_the_app.repaint();
		
		
	}
	/**
	 * change panel from Menu to Rules
	 */
	public void toRules(){
		run_the_app.remove(menu);
		rules=new Rules();
		run_the_app.add(rules);
		
		//rules.add(imglabel);
		changeBackground(rules,pic);

		
		run_the_app.repaint();
	}
	/**
	 * change panel from Menu to SelectedGame
	 */
	public void toSelectedGame(int size){
		run_the_app.remove(newgame);
		selectedGame=new SelectedGame(size);
		run_the_app.add(selectedGame);
		
		//selectedGame.add(imglabel);
		changeBackground(selectedGame,pic);

		
		run_the_app.repaint();
	}

	/**
	 * change panel from Menu to About
	 */
	public void toAbout(){
		run_the_app.remove(menu);
		about=new About();
		run_the_app.add(about);
		
		//about.add(imglabel);
		changeBackground(about,pic);

		
		run_the_app.repaint();
	}

	public void toGameByUser(){
		run_the_app.remove(newgame);
		gameByUser=new GameByUser();
		run_the_app.add(gameByUser);
		
		//gameByUser.add(imglabel);
		changeBackground(gameByUser,pic);

		
		run_the_app.repaint();

	}
	/**
	 * change panel from NewGame to Menu
	 */
	public void goBackFromNewGame(){
		run_the_app.remove(newgame);
		run_the_app.add(menu);
		
		//menu.add(imglabel);
		changeBackground(menu,picM);

		
		run_the_app.repaint();
	}
	/**
	 * change panel from Rules to Menu
	 */
	public void goBackFromRules(){
		run_the_app.remove(rules);
		run_the_app.add(menu);
		
		//menu.add(imglabel);
		changeBackground(menu,picM);

		run_the_app.repaint();
	}
	/**
	 * change panel from About to Menu
	 */
	public void goBackFromAbout(){
		run_the_app.remove(about);
		run_the_app.add(menu);
		
		//menu.add(imglabel);
		changeBackground(menu,picM);

		
		run_the_app.repaint();
	}
	/**
	 * change panel from SelectedGame to NewGame
	 */
	public void goBackFromSelectedGame(){
		run_the_app.remove(selectedGame);
		run_the_app.add(newgame);
		
		//newgame.add(imglabel);
		changeBackground(newgame,pic);

		
		run_the_app.repaint();
	}
	/**
	 * change panel from GameByUser to NewGame
	 */
	public void goBackFromGameByUser(){
		run_the_app.remove(gameByUser);
		run_the_app.add(newgame);
		
		newgame.add(imglabel);
		changeBackground(newgame,pic);

		
		run_the_app.repaint();
	}

}
