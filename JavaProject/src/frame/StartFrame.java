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
		//소비자의 가격과 시간 초기화
		Consumer.clear();  

		//패널생성
		JPanel panel = new KioskPanel(getImage("StartFrame"));
		add(panel);

		//시작하기
		var startBtn = new KioskButton(94, 400, 245, 85, "시작하기", "startBtn");
		startBtn.addActionListener(e -> {

			new RamenFrame().setVisible(true);
			Consumer.clear();
			this.dispose();
		});
		panel.add(startBtn);

		//관리자페이지
		var managerBtn = new KioskButton(175, 665, 95, 35, "관리자페이지", "ManagerBtn");
		managerBtn.addActionListener(e -> {
			new ManagerFrame().setVisible(true);
			this.dispose();
		});
		panel.add(managerBtn);

	}//constructor

}//class
