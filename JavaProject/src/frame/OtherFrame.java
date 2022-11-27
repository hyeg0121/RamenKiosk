package frame;

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

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Consumer;
import kiosk.Other;

public class OtherFrame extends KioskFrame {

	JTextArea otherArea = new JTextArea();
	JTextArea payArea = new JTextArea();

	public OtherFrame() {}
	
	public OtherFrame(String name) {
		KioskPanel panel = new KioskPanel(setImage("ChoiceOther"));
		add(panel);
		
		//선택창
		this.otherArea.setBounds(20, 460, 200, 150);
		otherArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		otherArea.setText(name+" 선택\n");
		otherArea.setEditable(false);
		panel.add(this.otherArea);

		this.payArea.setBounds(225, 460, 200, 150);
		payArea.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payArea.setText(Consumer.getPrice()+"원\n");
		payArea.setEditable(false);
		panel.add(this.payArea);

		// 사리 버튼 추가 
		String[] others = {"치즈","계란","떡","소세지"};
		for (int i =0; i < others.length; i++ ) {

			KioskButton btn = new KioskButton(others[i], "other"+(i+1));

			//버튼 배치
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 120+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 120 + 170*(i/2), 160, 160);
			}

			//버튼 기능
			btn.addActionListener(e -> {
				this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
				this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
				Consumer.addPrice(Other.getPrice(name));
				Other.setChoiceValue(btn.getText());
				Other.setQuantity(btn.getText());
			});

			panel.add(btn);

		}//버튼 생성

		//취소버튼
		JButton backBtn = new KioskButton(15,670,200,80,"라면선택","backBtn");
		backBtn.addActionListener(e -> {
			new RamenFrame().setVisible(true); //라면선택창 띄우기
			Consumer.clear(); //지불 가격과 시간 초기화
			for (int i = 0; i < Other.choiceList.length; i++) {
				Other.choiceList[i] = false;
			}//사리 선택 여부 초기화 
			this.dispose(); //종료
		});
		panel.add(backBtn);

		//선택완료버튼
		JButton choiceBtn = new KioskButton(225,670,200,80,"결제하기","ChargeBtn");
		choiceBtn.addActionListener(e -> {
			int ans = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제", JOptionPane.YES_OPTION);
			if ( ans == JOptionPane.NO_OPTION) {
				return;
			}
			new ChoicePayWayFrame().setVisible(true);
			this.dispose();

		});
		panel.add(choiceBtn);

	}//생성자 메소드


}
