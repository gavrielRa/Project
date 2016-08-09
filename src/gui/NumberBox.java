package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class NumberBox {

	private JFrame frame;
	ArrayList<JButton> buttonOpenBox;     
	ArrayList<Integer> notVisited;
	HexagoneButton [] buttonHexArray;
	int[] locationArray;
	int start,end;
	int type;


	/**
	 * Create the application.
	 */
	public NumberBox(ArrayList<JButton> buttonOpenBox, ArrayList<Integer> notVisited, HexagoneButton[] buttonHexArray,
			int[] locationArray, int start, int end) {
		super();
		
		this.buttonOpenBox = buttonOpenBox;
		this.notVisited = notVisited;
		this.buttonHexArray = buttonHexArray;
		this.locationArray = locationArray;
		this.start = start;
		this.end = end;
	}
	
	public void openNumberBox(int location,int type){
		
		this.type=type;
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Number Box");
		frame.getContentPane().setLayout(new GridLayout(5,2));
		frame.setUndecorated(true);
		
		buttonOpenBox= new ArrayList<JButton>();     

		JButton del = new JButton("del");
		buttonOpenBox.add(del);

		frame.getContentPane().add(del);
		switchButton(del,location,frame);

		for (int j = 0; j < notVisited.size(); j++) {
			String val = notVisited.get(j)+""; 							
			buttonOpenBox.add(new JButton(val)); // val+1
			JButton cur = buttonOpenBox.get(j+1);//j+1 because del is in the first index of the buttonBox 
			frame.getContentPane().add(buttonOpenBox.get(j+1));

			switchButton(cur,location,frame);

		}

		frame.pack();
		frame.setVisible(true);

	}




	public void switchButton (JButton cur ,int location ,JFrame frame){
		cur.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) {

				String	curButtonBox = ((JButton) actionEvent.getSource()).getText(); //button of buttonBox 
				String hexValue =  buttonHexArray[location].getText();//the value in the hive index

				if (hexValue.equals("")){			//if the value in the hive index is nothing
					if(!cur.getText().equals("del")){
						buttonHexArray[location].setText(curButtonBox); 
						buttonHexArray[location].setFont(new Font("Serif", Font.BOLD, 18));

						notVisited.remove(new Integer(Integer.parseInt(curButtonBox)));
					}
				}
				else{		
					if(cur.getText().equals("del")){
						buttonHexArray[location].setText("");
					}
					else{
						buttonHexArray[location].setText(curButtonBox);
						notVisited.remove(new Integer(Integer.parseInt(curButtonBox)));
					}

					notVisited.add(Integer.parseInt(hexValue));
					notVisited.sort(null);
				}
				frame.dispose();
				if(type==1) turnHexOn();
				else turnHexOn2(buttonHexArray[location]);
			}
		});
	}
	public void turnHexOn(){
		
		for (int i = 0; i < buttonHexArray.length; i++) {

			buttonHexArray[i].setEnabled(true);
			buttonHexArray[i].setForeground(Color.BLACK);


		}
		//hints
		for (int i = 0; i < locationArray.length; i++) {
			buttonHexArray[locationArray[i]].setEnabled(false);
		}
		buttonHexArray[start].setFont(new Font("Serif", Font.BOLD, 18));
		buttonHexArray[start].setBackground(Color.orange);

		buttonHexArray[end].setFont(new Font("Serif", Font.BOLD, 18));
		buttonHexArray[end].setBackground(Color.orange);

	}
	
	public void turnHexOn2(JButton btn){
		
		for (int i = 0; i < buttonHexArray.length; i++) {
			buttonHexArray[i].setEnabled(true);
			buttonHexArray[i].setForeground(Color.BLACK);
		}

		buttonHexArray[Integer.parseInt(btn.getName())].setFont(new Font("Serif", Font.BOLD, 18));
		buttonHexArray[Integer.parseInt(btn.getName())].setFont(new Font("Serif", Font.BOLD, 18));

		
		if(btn.getText().equals("1") || btn.getText().equals("61"))buttonHexArray[Integer.parseInt(btn.getName())].setBackground(Color.orange);
		else buttonHexArray[Integer.parseInt(btn.getName())].setBackground(Color.white);
		
	}
	
	public JFrame getFrameOfNumberBox(){
		return frame;
	}
	public void closeFrameOfNumberBox(){
		if(frame==null) return;
		if(frame.isVisible()){
			frame.dispose();
		}

	}
	public boolean isEmpty (){	
		
		return (notVisited.size() == 1) ;

	}
	
	public int getl1 (){
		return notVisited.size();
	}

	public HexagoneButton[] getButtonHexArray(){
		return buttonHexArray;
	}
	
}
