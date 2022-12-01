package frame;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class FailFrame extends KioskFrame{
	
	public FailFrame() {
		//패널생성
		KioskPanel panel = new KioskPanel(getImage("fail"));
		add(panel);
		
		//재시도
		KioskButton restartBtn = new KioskButton(100, 490, 250, 80, "restart", "restart");
		restartBtn.addActionListener(e -> {
			new PaymentFrame().setVisible(true);
			this.dispose();
		});
		panel.add(restartBtn);
		
		//취소
		KioskButton cancelBtn = new KioskButton(100, 585, 250, 80, "cancel", "cancel");
		cancelBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose();
		});
		panel.add(cancelBtn);
		
	}//constructor
	
}//class
