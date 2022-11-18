package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaymentFrame extends CommonFrame {
	
	Image background = new ImageIcon(PaymentFrame.class.getResource("../image/payment.png")).getImage();
	Consumer c = new Consumer();
	
	public PaymentFrame() {
		JOptionPane.showMessageDialog(null, "결제 금액은 " + c.getPrice() + "원 입니다", "정보", JOptionPane.INFORMATION_MESSAGE);
		var mainPanel = new JPanel();
		mainPanel.setBounds(100,300,250,280);
		mainPanel.setLayout(new BorderLayout());
		 
		var tf = new JTextField(50);
		tf.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		tf.setText("0");
		tf.setEditable(false);
		mainPanel.add(tf, BorderLayout.NORTH);
		
		var centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2,3));
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
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
		
		add(mainPanel);
		
		var paymentBtn = new CommonButton(100, 600, 250, 80, "payment", "payBtn");
		paymentBtn.addActionListener(e -> {
			int money = Integer.parseInt(tf.getText());
			if ( money == c.getPrice() ) {
				new Charge().setVisible(true);
				this.dispose();
			}else if ( money > c.getPrice() ) {
				JOptionPane.showMessageDialog(null, "거스름돈 " + (money-c.getPrice()) + "원을 반환합니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
				new Charge().setVisible(true);
				this.dispose();
			}else {
				new FailFrame().setVisible(true);
				this.dispose();
			}
		});
		add(paymentBtn);
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
