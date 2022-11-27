package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Consumer;

public class PaymentFrame extends KioskFrame {

	public PaymentFrame() {
		//패널생성
		KioskPanel panel = new KioskPanel(getImage("payment"));
		add(panel);
		
		//결제금액 팝업
		JOptionPane.showMessageDialog(null, "결제 금액은 " + Consumer.getPrice() + "원 입니다", "정보", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("info").getScaledInstance(60, 60, 4)));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(100,300,250,280);
		mainPanel.setLayout(new BorderLayout());
		
		JTextField tf = new JTextField(50);
		tf.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		tf.setText("0");
		tf.setEditable(false);
		mainPanel.add(tf, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,3));
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		//금액 입력 버튼
		int buttons[] = { 100, 500, 1000, 5000, 10000, 50000 };
		for ( int i = 0; i < buttons.length; i++ ) {
			var btn = new JButton(String.valueOf(buttons[i]));
			btn.setBackground(Color.gray);
			btn.setBorder(null);
			btn.setForeground(Color.white);
			
			btn.addActionListener(e -> {
				tf.setText(String.valueOf(Integer.parseInt(tf.getText())+Integer.parseInt(btn.getText())));
			});
			centerPanel.add(btn);
		}
		
		panel.add(mainPanel);
		
		KioskButton paymentBtn = new KioskButton(100, 600, 250, 80, "payment", "payBtn");
		paymentBtn.addActionListener(e -> {
			int money = Integer.parseInt(tf.getText());
			if ( money == Consumer.getPrice() ) {
				new SuccessChargFrame().setVisible(true);
				this.dispose();
			}else if ( money > Consumer.getPrice() ) {
				JOptionPane.showMessageDialog(null, "거스름돈 " + (money-Consumer.getPrice()) + "원을 반환합니다.", "정보", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("info").getScaledInstance(60, 60, 4)));
				new SuccessChargFrame().setVisible(true);
				this.dispose();
			}else {
				new FailFrame().setVisible(true);
				this.dispose();
			}
		});
		panel.add(paymentBtn);
	}
	
}
