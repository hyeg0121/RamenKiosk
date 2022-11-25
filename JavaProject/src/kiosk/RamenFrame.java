package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.CharBuffer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RamenFrame extends CommonFrame {
	//멤버 변수
	Image background = new ImageIcon(RamenFrame.class.getResource("../image/ChoiceRamen.png")).getImage();
	Ramen ramen = new Ramen();

	//생성자
	public RamenFrame () {		

		String[] ramens = { "진라면","신라면","너구리","참깨라면","불닭볶음면","짜파게티" };

		for (int i = 0; i < ramens.length; i++) {
			
			var btn = new CommonButton(ramens[i], "ramen"+(i+1));

			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100+170*(i/2), 160, 160);
			}

			btn.addActionListener(e -> {
				Consumer.setPrice(ramen.getPrice(btn.getText()));
				Consumer.setSecond(ramen.getSecond(btn.getText()));
				new OtherFrame(btn.getText()).setVisible(true);
				this.dispose();
			});

			this.add(btn);

		}
	}
	
	//배경 이미지 메서드
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}


}
