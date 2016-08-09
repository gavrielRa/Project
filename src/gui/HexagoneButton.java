package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HexagoneButton extends JButton {

	Dimension dim;
	String name;

	public HexagoneButton(String name) {
		super(name);

		this.name =name;
		setBorder(null);
		Dimension size = new Dimension(35,41);;

		setPreferredSize(size);

		setContentAreaFilled(false);
	}

	/**
	 * return the name
	 */
	public String getName(){
		return name;
	}
	// Paint the round background and label.
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) 
			g.setColor(Color.lightGray);
		else 
			g.setColor(getBackground());

		int [ ] xx = {17, 0, 0, 17, 34, 34};
		int [ ] yy = {0, 10, 30, 40, 30, 10};

		g.fillPolygon(xx, yy, 6);

		super.paintComponent(g);
	}

	// Paint the border of the button using a simple stroke.
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());

		int [ ] xx = {17, 0, 0, 17, 34, 34};
		int [ ] yy = {0, 10, 30, 40, 30, 10};

		g.drawPolygon(xx, yy, 6);
	}

	// Hit detection.
	Shape shape;
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {

			int [ ] xx = {17, 0, 0, 17, 34, 34};
			int [ ] yy = {0, 10, 30, 40, 30, 10};

			shape = new Polygon(xx, yy, 6);
		}
		return shape.contains(x, y);
	}
	@Override
	public String toString(){
		return name;
	}

}