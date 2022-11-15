package kiosk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ManagerFrame extends CommonFrame {
	
	Image background = new ImageIcon(StartFrame.class.getResource("../image/ManagerFrame.png")).getImage();
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}

