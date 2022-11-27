package frame;

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

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Other;

public class ManagerFrame extends KioskFrame {

	public ManagerFrame() {
		KioskPanel panel = new KioskPanel(setImage("ManagerFrame"));
		add(panel);

		String btnList[] = {"치즈","계란","떡","소세지"};
		JTextField tfList[] = new JTextField[4];

		for ( int i = 0; i < btnList.length; i++ ) {
			JTextField quantity = new JTextField();
			quantity.setEditable(false);
			quantity.setFont(new Font("맑은고딕", Font.BOLD, 20));
			quantity.setHorizontalAlignment(0);
			quantity.setText(String.valueOf(Other.quantityList[i]));
			
			JLabel imgLb = new JLabel(new ImageIcon(setImage("MngOther"+(i+1))));
			KioskButton min = new KioskButton("-","min");
			KioskButton plus = new KioskButton("+", "plus");
			
			if( i % 2 == 0) {
				imgLb.setBounds(40, 120+220*(i/2),160, 160);
				min.setBounds(40, 290+220*(i/2), 30, 30);
				plus.setBounds(160, 290+220*(i/2), 30, 30);
				quantity.setBounds(70, 290+220*(i/2), 80, 30);
			}else {
				imgLb.setBounds(250, 120+220*(i/2), 160, 160);
				min.setBounds(250, 290+220*(i/2), 30, 30);
				plus.setBounds(370, 290+220*(i/2), 30, 30);
				quantity.setBounds(280, 290+220*(i/2), 80, 30);
			}

			if ( i == 0 ) {
				min.addActionListener(e-> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())-1));
				});
				plus.addActionListener(e -> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())+1));
				});
			}else if ( i == 1 ) {
				min.addActionListener(e-> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())-1));
				});
				plus.addActionListener(e -> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())+1));
				});
			}else if ( i == 2 ) {
				min.addActionListener(e-> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())-1));
				});
				plus.addActionListener(e -> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())+1));
				});
			}else {
				min.addActionListener(e-> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())-1));
				});
				plus.addActionListener(e -> {
					quantity.setText(String.valueOf(Integer.parseInt(quantity.getText())+1));
				});
			}

			panel.add(min); panel.add(plus); panel.add(quantity); panel.add(imgLb);
		}

		
		JButton backBtn = new KioskButton(15,650,200,80,"홈으로","goHomeBtn");
		backBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose(); //종료
		});
		panel.add(backBtn);


		JButton choiceBtn = new KioskButton(225,650,200,80,"재고투입완료","stockBtn");
		choiceBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose();
		});
		panel.add(choiceBtn);

	}

}

