package frame;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Consumer;
import kiosk.Ramen;

public class RamenFrame extends KioskFrame {

	public RamenFrame () {	
		//패널 생성
		KioskPanel panel = new KioskPanel(getImage("ChoiceRamen"));
		add(panel);

		//라면 선택 버튼 6개 생성
		String[] ramens = { "진라면","신라면","너구리","참깨라면","불닭볶음면","짜파게티" };
		for (int i = 0; i < ramens.length; i++) {

			KioskButton btn = new KioskButton(ramens[i], "ramen"+(i+1));

			if ( i % 2 == 0 ) {
				btn.setBounds(50, 115+170*(i/2), 140, 160);
			}else {
				btn.setBounds(240, 115+170*(i/2), 140, 160);
			}

			btn.addActionListener(e -> {
				Consumer.setPrice(Ramen.getPrice(btn.getText()));
				Consumer.setSecond(Ramen.getSecond(btn.getText()));
				new OtherFrame(btn.getText()).setVisible(true);
				this.dispose();
			});

			panel.add(btn);

		}//for

	}//constructor

}//class
