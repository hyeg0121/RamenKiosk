package components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import components.KioskPanel;
import components.KioskButton;

public class KioskFrame extends JFrame {

	public final int FRAMEWIDTH = 450;
	public final int FRAMEHEIGHT = 800;
	
	public KioskFrame() {
		setSize(FRAMEWIDTH, FRAMEHEIGHT);
		setLayout(null);
		setTitle("뽀글뽀글 키오스크"	);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(KioskFrame.class.getResource("../image/frameIcon.png")).getImage());
		setResizable(false);
	}
	
	public Image getImage(String imgName) {
		return new ImageIcon(KioskFrame.class.getResource("../image/"+imgName+".png")).getImage();	
	}
	
}
