package frame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

import kiosk.Consumer;

public class StartFrame extends KioskFrame {

	public StartFrame() {

		Consumer.clear();  
		
		JPanel panel = new KioskPanel(setImage("StartFrame"));
		add(panel);
		
		//CommonButton으로 바꾸기
		var startBtn = new KioskButton(94, 400, 245, 85, "시작하기", "startBtn");
		panel.add(startBtn);
		startBtn.addActionListener(e -> {

			new RamenFrame().setVisible(true);
			Consumer.clear();
			this.dispose();
		});

		var managerBtn = new KioskButton(175, 665, 95, 35, "관리자페이지", "ManagerBtn");
		managerBtn.addActionListener(e -> {
			new ManagerFrame().setVisible(true);
			this.dispose();
		});
		panel.add(managerBtn);

	}
	
//	public void paint(Graphics g) {
//		paintComponents(g);
//	}
	
}
