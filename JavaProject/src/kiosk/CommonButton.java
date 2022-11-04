package kiosk;

import java.awt.Color;
import java.awt.Font;

import javax.net.ssl.CertPathTrustManagerParameters;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class CommonButton extends JButton {
	
	public CommonButton() {}
	
	public CommonButton (int x, int y, String title) {
		setText(title);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		setForeground(Color.white);
		setBounds(x, y, 225, 75);
		setBackground(new Color(5, 0, 153));
	}
	
	public CommonButton(int x, int y, int width, int height, String title, String img) {
		setText(title);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(new ImageIcon(Main.class.getResource("../image/"+img+".png")));
		setBounds(x, y, width, height);
	}
	
	public CommonButton(String title, String img) {
		setText(title);
		setBackground(Color.WHITE);
		setBorder(null);
		setIcon(new ImageIcon(Main.class.getResource("../image/"+img+".png")));
	}
	
}
