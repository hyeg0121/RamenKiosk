package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.CharBuffer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Consumer;
import kiosk.Ramen;

public class RamenFrame extends KioskFrame {

	private Image background = setImage("ChoiceRamen");
	
	//생성자
	public RamenFrame () {		
		KioskPanel panel = new KioskPanel(setImage("ChoiceRamen"));
		add(panel);
		
		String[] ramens = { "진라면","신라면","너구리","참깨라면","불닭볶음면","짜파게티" };

		for (int i = 0; i < ramens.length; i++) {
			
			var btn = new KioskButton(ramens[i], "ramen"+(i+1));

			if ( i % 2 == 0 ) {
				btn.setBounds(50, 115+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 115+170*(i/2), 160, 160);
			}

			btn.addActionListener(e -> {
				Consumer.setPrice(Ramen.getPrice(btn.getText()));
				Consumer.setSecond(Ramen.getSecond(btn.getText()));
				new OtherFrame(btn.getText()).setVisible(true);
				this.dispose();
			});

			panel.add(btn);

		}
	}

}
