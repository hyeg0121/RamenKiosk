package kiosk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Charge extends CommonFrame {
	Image background = new ImageIcon(Charge.class.getResource("../image/Charge.png")).getImage();
	
	public Charge() {
		var startcookBtn = new CommonButton(100, 530, 250, 80, "startcook", "StartCookBtn");
		startcookBtn.addActionListener(e -> {
			new TimerFrame().setVisible(true);
			this.dispose();
		});
		add(startcookBtn);
		
	}// 생성자
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
