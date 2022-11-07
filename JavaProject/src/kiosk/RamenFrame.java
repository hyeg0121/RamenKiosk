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
	Consumer c = new Consumer();
	boolean ramenChecking = false;
	
	//생성자
	public RamenFrame () {
//		//카테고리 버튼
//		String categorys[] = "전체,best,국물,볶음".split(",");
//		
//		for ( int i = 0; i < categorys.length; i++ ) {
//			var btn = new JButton(categorys[i]);
//			btn.setBackground(Color.WHITE);
//			btn.setBorder(null);
//			btn.setIcon(new ImageIcon(RamenFrame.class.getResource("../image/category"+(i+1)+".png")));
//			btn.setRolloverSelectedIcon(new ImageIcon(RamenFrame.class.getResource("../image/ramen"+(i+1)+".png")));
//			btn.setBounds(10+i*110, 40, 100, 50);
//			
//			
//			add(btn);
//		}
		
		
		// 라면 버튼 ppt(버튼을 반복문으로 배치)
		String[] ramens = { "진라면","신라면","너구리","참깨라면","불닭볶음면","짜파게티" };
		for ( int i = 0; i < ramens.length; i++ ) {
			var btn = new CommonButton(ramens[i], "ramen"+(i+1));
			
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100+170*(i/2), 160, 160);
			}
			
			btn.addActionListener(e -> {
				var r = new Ramen(btn.getText());
				c.setPrice(r.getPrice());
				c.setSecond(r.getSecond());
				
				new OtherFrame(btn.getText()).setVisible(true);
				System.out.println(c.getPrice());
				this.dispose();
			});
			
			this.add(btn);
			
		}
	
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
	
}
