package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OtherFrame extends CommonFrame {
	
	Image background = new ImageIcon(RamenFrame.class.getResource("../image/ChoiceOther.png")).getImage();
	JTextArea otherArea = new JTextArea();
	JTextArea payArea = new JTextArea();
	Consumer c = new Consumer();
	int cnt = 0;
	
	public OtherFrame(String name) {
		this.otherArea.setBounds(0, 450, 200, 150);
		otherArea.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		otherArea.setText(name+" 선택\n");
		this.add(this.otherArea);
		
		this.payArea.setBounds(225, 450, 200, 150);
		payArea.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		payArea.setText(c.getPrice()+"원\n");
		this.add(this.payArea);
		
		// 사리 버튼 추가 
		String[] others = {"치즈","계란","떡","소세지"};
		for ( int i =0; i < others.length; i++ ) {
			var btn = new CommonButton(others[i], "other"+(i+1));
			
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100 + 170*(i/2), 160, 160);
			}
			
			btn.addActionListener(e -> {
				
				if ( cnt == 3 ) {
					JOptionPane.showMessageDialog(null, "뽀글이 사용 안전을 위하여 \n 사리 추가를 제한합니다.","경고", JOptionPane.ERROR_MESSAGE );
					return;
				}
				var other = new Other(btn.getText());
				this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
				this.payArea.setText((this.payArea.getText()+other.getPrice() +"원\n"));
				c.setPrice(other.getPrice());
				System.out.println(c.getPrice());
				cnt++;
			});
			
			this.add(btn);
			
		}//버튼 생성
		
		//취소버튼
		var noChoiceBtn = new JButton();
		noChoiceBtn.setBounds(15, 650, 200, 80);
		noChoiceBtn.setBackground(Color.white);
		noChoiceBtn.setBorder(null);
		noChoiceBtn.setIcon(new ImageIcon(OtherFrame.class.getResource("../image/backBtn.png")));
		noChoiceBtn.addActionListener(e -> {
			int ans = JOptionPane.showConfirmDialog(null, "취소하시겠습니까?", "취소", JOptionPane.YES_NO_OPTION);
			if ( ans == JOptionPane.NO_OPTION) {
				return;
			}
			new RamenFrame().setVisible(true);
			c.clear();
			
			this.dispose();
		});
		this.add(noChoiceBtn);
		
		//선택완료버튼
		var yesChoiceBtn = new JButton();
		yesChoiceBtn.setBounds(225, 650, 200, 80);
		yesChoiceBtn.setBackground(Color.white);
		yesChoiceBtn.setBorder(null);
		yesChoiceBtn.setIcon(new ImageIcon(OtherFrame.class.getResource("../image/ChargeBtn.png")));
		yesChoiceBtn.addActionListener(e -> {
			int ans = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제", JOptionPane.YES_OPTION);
			if ( ans == JOptionPane.NO_OPTION) {
				return;
			}
			new ChoicePayWayFrame().setVisible(true);
			this.dispose();
			
		});
		this.add(yesChoiceBtn);
		
	}//생성자 메소드
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
