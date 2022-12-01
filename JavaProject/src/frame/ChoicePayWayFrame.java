package frame;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

public class ChoicePayWayFrame extends KioskFrame {

	public ChoicePayWayFrame() {
		
		//패널생성
		KioskPanel panel = new KioskPanel(getImage("ChoicePayWayFrame"));
		add(panel);
		
		//버튼 생성
		String buttons[] = { "카드", "현금", "삼성페이/페이코" };
		for (int i = 0; i < buttons.length; i++) {
			KioskButton btn = new KioskButton(100, 280+i*100, 260, 85, buttons[i], "payBtn"+(i+1));
			
			btn.addActionListener(e -> {
				if ( btn.getText().equals("현금")) {
					new PaymentFrame().setVisible(true);
					this.dispose();
					return;
				}
				new SuccessChargFrame().setVisible(true);
				this.dispose();
			});
			panel.add(btn);
		}
	}//constructor

}//class
