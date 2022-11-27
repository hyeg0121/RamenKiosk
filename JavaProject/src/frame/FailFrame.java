package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class FailFrame extends KioskFrame{
	
	Image background = new ImageIcon(FailFrame.class.getResource("../image/fail.png")).getImage();
	
	public FailFrame() {
		KioskPanel panel = new KioskPanel(getImage("fail"));
		add(panel);
		var restartBtn = new KioskButton(100, 490, 250, 80, "restart", "restart");
		restartBtn.addActionListener(e -> {
			new PaymentFrame().setVisible(true);
			this.dispose();
		});
		panel.add(restartBtn);
		
		var cancelBtn = new KioskButton(100, 585, 250, 80, "cancel", "cancel");
		cancelBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose();
		});
		panel.add(cancelBtn);
	}//constructor
	
}//class
