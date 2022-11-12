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
	
	public ManagerFrame() {
		String[] others = "치즈,계란,떡,소세지".split(",");
		for ( int i =0; i < others.length; i++ ) {
			var btn = new JButton(others[i]);
			btn.setBackground(Color.white);
			btn.setBorder(null);
			
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100 + 170*(i/2), 160, 160);
			}
			
			btn.addActionListener(e -> {
				
			});
			btn.setIcon(new ImageIcon(OtherFrame.class.getResource("../image/other"+(i+1)+".png")));
			btn.setRolloverIcon(new ImageIcon(OtherFrame.class.getResource("../image/other"+(i+1)+".png")));
			this.add(btn);
		}//버튼 생성
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}

