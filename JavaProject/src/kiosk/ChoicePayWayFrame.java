package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChoicePayWayFrame extends CommonFrame {
	
	Image background = new ImageIcon(ChoicePayWayFrame.class.getResource("../image/ChoicePayWayFrame.png")).getImage();

	public ChoicePayWayFrame() {
		JLabel titleLabel = new JLabel("결제 방법 선택");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBackground(new Color(255, 255, 255));
		titleLabel.setBounds(71, 69, 300, 100);
		this.add(titleLabel);
		
		String buttons[] = { "카드", "현금", "삼성페이/페이코" };
		
		for (int i = 0; i < buttons.length; i++) {
			var btn = new CommonButton(100, 260+i*100, 260, 85, buttons[i], "payBtn"+(i+1));
			
			btn.addActionListener(e -> {
				if ( btn.getText().equals("현금")) {
					var frame = new PaymentFrame();
					frame.setVisible(true);
					this.dispose();
					return;
				}
				new Charge().setVisible(true);
				this.dispose();
			});
			this.add(btn);
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
