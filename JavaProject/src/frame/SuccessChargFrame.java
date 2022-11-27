package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class SuccessChargFrame extends KioskFrame implements Runnable{
	
	private JLabel label = new JLabel();
	
	public SuccessChargFrame() {
		//패널 생성
		KioskPanel panel = new KioskPanel(getImage("Charge"));
		add(panel);
		
		var startcookBtn = new KioskButton(100, 530, 250, 80, "startcook", "StartCookBtn");
		startcookBtn.addActionListener(e -> {
			new TimerFrame().setVisible(true);
			this.dispose();
		});
		panel.add(startcookBtn);
		
		//시간 표시 
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0,400,450,80);
		panel.add(label);
		
		Thread t = new Thread(this);
		t.start();
	}//constructor

	@Override
	public void run() {
		int sec = 5;
		while(true) {
			try {
				Thread.sleep(1000);
				label.setText(sec--+"초 후 자동으로 시작합니다.");
				
				if( sec == 0) {
					new TimerFrame().setVisible(true);
					this.dispose();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//run
}//class
