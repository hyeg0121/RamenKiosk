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
	//멤버변수
	JTextArea otherArea = new JTextArea();
	JTextArea payArea = new JTextArea();

	//생성자
	public OtherFrame() {}
	public OtherFrame(String name) {
		KioskPanel panel = new KioskPanel(getImage("ChoiceOther"));
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

			if ( i % 2 == 0 ) {
				btn.setBounds(50, 120+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 120 + 170*(i/2), 160, 160);
			}

			btn.addActionListener(e -> {
				//재고 검사
				if ( Other.getQuantity(btn.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "죄송합니다. "+btn.getText() +"사리의 재고가 부족합니다.", "재고부족", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					return;
				}
				//중복선택 검사
				if ( Other.getChoiceValue(btn.getText()) ) {
					JOptionPane.showMessageDialog(null, "뽀글이 사용 안전을 위해 사리는 중복 추가 할 수 없습니다.", "중복추가불가", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					return;
				}
				this.otherArea.setText(this.otherArea.getText()+ btn.getText()+" 선택\n");
				this.payArea.setText((this.payArea.getText()+Other.getPrice(btn.getText()) +"원\n"));
				Consumer.addPrice(Other.getPrice(name));
				Other.changeChoiceValue(btn.getText());
			});

			panel.add(btn);

		}//버튼 생성

		//취소버튼
		KioskButton backBtn = new KioskButton(15,670,200,80,"라면선택","backBtn");
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
		KioskButton choiceBtn = new KioskButton(225,670,200,80,"결제하기","ChargeBtn");
		choiceBtn.addActionListener(e -> {
			int ans = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getImage("basic").getScaledInstance(60, 60, 4)));
			if ( ans == JOptionPane.NO_OPTION) {
				return;
			}
			new ChoicePayWayFrame().setVisible(true);
			this.dispose();
		});
		panel.add(choiceBtn);

	}//constructor

}//class
