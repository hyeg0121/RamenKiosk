package components;

import java.awt.Color;
import java.awt.Font;

import javax.net.ssl.CertPathTrustManagerParameters;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import frame.Main;

public class KioskButton extends JButton {
	
	public KioskButton() {}
	
	public KioskButton (int x, int y, String title) {
		setText(title);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		setForeground(Color.white);
		setBounds(x, y, 225, 75);
		setBackground(new Color(5, 0, 153));
	}
	
	public KioskButton(int x, int y, int width, int height, String title, String imgName) {
		setText(title);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(new ImageIcon(Main.class.getResource("../image/"+imgName+".png")));
		setBounds(x, y, width, height);
	}
	
	public KioskButton(String title, String imgName) {
		setText(title);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(new ImageIcon(Main.class.getResource("../image/"+imgName+".png")));
	}
	
	public KioskButton(int x, int y, int width, int height, String title, ImageIcon icon) {
		setText(title);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(icon);
		setBounds(x, y, width, height);
	}
}
