package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class ManagerFrame extends CommonFrame {
	
	Image background = new ImageIcon(StartFrame.class.getResource("../image/ManagerFrame.png")).getImage();
	
	public ManagerFrame() {
		this.setBackground(Color.white);
		
		var btnList = "치즈,계란,떡,소세지".split(",");

		for ( int i = 0; i < btnList.length; i++ ) {
			var min = new JButton("-");
			var plus = new JButton("+");
			var name = new JTextField();
			
			name.setFont(new Font("맑은고딕", Font.BOLD, 20));
			name.setHorizontalAlignment(0);
			name.setText(String.valueOf(Other.quantityList[i]));
			
			if( i % 2 == 0) {
				min.setBounds(40, 200+180*(i/2), 50, 50);
				name.setBounds(90, 200+180*(i/2), 70, 50);
				plus.setBounds(160, 200+180*(i/2), 50, 50);
			}else {
				min.setBounds(250, 200+180*(i/2), 50, 50);
				name.setBounds(300, 200+180*(i/2), 70, 50);
				plus.setBounds(370, 200+180*(i/2), 50, 50);
			}
			
			if ( i == 0 ) {
				min.addActionListener(e-> {
					Other.quantityList[0]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[0]++;
				});
			}else if ( i == 1 ) {
				min.addActionListener(e-> {
					Other.quantityList[1]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[0]++;
				});
			}else if ( i == 2 ) {
				min.addActionListener(e-> {
					Other.quantityList[2]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[0]++;
				});
			}else {
				min.addActionListener(e-> {
					Other.quantityList[3]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[0]++;
				});
			}
			
			add(min); add(plus); add(name);
		}
		
		System.out.println(Other.getCheeseQuantity());
		System.out.println(Other.getEggQuantity());
		System.out.println(Other.getTteokQuantity());
		System.out.println(Other.getSausegesQuantity());
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
}

