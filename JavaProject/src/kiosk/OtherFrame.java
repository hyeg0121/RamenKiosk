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
	int cnt=0;
	
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
			//버튼 배치
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100 + 170*(i/2), 160, 160);
			}
			
			//if ( cnt == 3 ) {
			//	JOptionPane.showMessageDialog(null, "뽀글이 사용 안전을 위하여 \n 사리 추가를 제한합니다.","경고", JOptionPane.ERROR_MESSAGE );
			//	return;
			//}
			
			if ( i == 0 ) {
				btn.addActionListener(e -> {
					this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
					this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
					c.addPrice(Other.getPrice(btn.getText()));
					Other.cheeseChoice = true;
				});
			}else if ( i == 1 ) {
				btn.addActionListener(e -> {
					this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
					this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
					c.addPrice(Other.getPrice(btn.getText()));
					Other.eggChoice = true;
				});
			}else if ( i == 2 ) {
				btn.addActionListener(e -> {
					this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
					this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
					c.addPrice(Other.getPrice(btn.getText()));
					Other.tteokChoice = true;
				});
			}else {
				btn.addActionListener(e -> {
					this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
					this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
					c.addPrice(Other.getPrice(btn.getText()));
					Other.sausegesChoice = true;
				});
			}
			
			this.add(btn);
			
		}//버튼 생성
		
		//취소버튼
		JButton backBtn = new CommonButton(15,650,200,80,"라면선택","backBtn");
		this.add(backBtn);
		//액션리스너 
		backBtn.addActionListener(e -> {
			new RamenFrame().setVisible(true); //라면선택창 띄우기
			
			c.clear(); //지불 가격과 시간 초기화
			
			for (int i = 0; i < Other.choices.length; i++) {
				Other.choices[i] = false;
			}//사리 선택 여부 초기화 
			
			this.dispose(); //종료
		});
		
		//선택완료버튼
		JButton choiceBtn = new CommonButton(225,650,200,80,"결제하기","ChargeBtn");
		choiceBtn.addActionListener(e -> {
			int ans = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제", JOptionPane.YES_OPTION);
			if ( ans == JOptionPane.NO_OPTION) {
				return;
			}
			new ChoicePayWayFrame().setVisible(true);
			this.dispose();
			
		});
		this.add(choiceBtn);
		
	}//생성자 메소드
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	

}
