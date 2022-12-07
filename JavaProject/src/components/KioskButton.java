package components;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskButton extends JButton {

	public KioskButton() {}
	
	public KioskButton(int x, int y, int width, int height, String title, String imgName) {
		setText(title);
		setFocusPainted(false);
		setBackground(Color.WHITE);
		setBorder(null);
		setRolloverIcon(new ImageIcon(KioskButton.class.getResource("../image/"+imgName+".png")));
		setIcon(new ImageIcon(KioskButton.class.getResource("../image/"+imgName+".png")));
		setBounds(x, y, width, height);
		setContentAreaFilled(false);
	}//constructor
	
	public KioskButton(String title, String imgName) {
		setText(title);
		setFocusPainted(false);
		setBackground(Color.WHITE);
		setBorder(null);
		setRolloverIcon(new ImageIcon(KioskButton.class.getResource("../image/"+imgName+".png")));
		setIcon(new ImageIcon(KioskButton.class.getResource("../image/"+imgName+".png")));
		setContentAreaFilled(false);
	}//constructor
	
	public KioskButton(int x, int y, int width, int height, String title, ImageIcon icon) {
		setText(title);
		setFocusPainted(false);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(icon);
		setRolloverIcon(icon);
		setBounds(x, y, width, height);
		setContentAreaFilled(false);
	}//constructor
}
