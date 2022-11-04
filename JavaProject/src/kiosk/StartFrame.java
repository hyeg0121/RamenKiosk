package kiosk;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends CommonFrame {
	Image background = new ImageIcon(StartFrame.class.getResource("../image/StartFrame.png")).getImage();
	
	public StartFrame() {
		ImageIcon startBtnImg = new ImageIcon(StartFrame.class.getResource("../image/StartBtn.png"));
		
		var startBtn = new JButton();
		startBtn.setBackground(Color.white);
		startBtn.setBorder(null);
		startBtn.setIcon(startBtnImg);
		startBtn.setBounds(94, 400, 250, 85);
		this.add(startBtn);
		startBtn.addActionListener(e -> {
			
			var pnl = new RamenFrame();
			pnl.setVisible(true);
			this.dispose();
		});
		
		var managerBtn = new JButton();
		managerBtn.setBackground(Color.white);
		managerBtn.setBorder(null);
		managerBtn.setIcon(new ImageIcon(StartFrame.class.getResource("../image/ManagerBtn.png")));
		managerBtn.setBounds(175, 665, 100, 35);
		managerBtn.addActionListener(e -> {
			new ManagerFrame().setVisible(true);
			this.dispose();
		});
		this.add(managerBtn);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
