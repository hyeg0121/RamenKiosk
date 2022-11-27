package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class SuccessChargFrame extends KioskFrame {
	
	public SuccessChargFrame() {
		KioskPanel panel = new KioskPanel(setImage("Charge"));
		add(panel);
		
		var startcookBtn = new KioskButton(100, 530, 250, 80, "startcook", "StartCookBtn");
		startcookBtn.addActionListener(e -> {
			new TimerFrame().setVisible(true);
			this.dispose();
		});
		panel.add(startcookBtn);
		
	}// 생성자

}
