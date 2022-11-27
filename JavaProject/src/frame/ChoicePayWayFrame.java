package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class ChoicePayWayFrame extends KioskFrame {

	public ChoicePayWayFrame() {
		KioskPanel panel = new KioskPanel(setImage("ChoicePayWayFrame"));
		add(panel);
		
		String buttons[] = { "카드", "현금", "삼성페이/페이코" };
		
		for (int i = 0; i < buttons.length; i++) {
			var btn = new KioskButton(100, 280+i*100, 260, 85, buttons[i], "payBtn"+(i+1));
			
			btn.addActionListener(e -> {
				if ( btn.getText().equals("현금")) {
					var frame = new PaymentFrame();
					frame.setVisible(true);
					this.dispose();
					return;
				}
				new SuccessChargFrame().setVisible(true);
				this.dispose();
			});
			panel.add(btn);
		}
	}
	

}
