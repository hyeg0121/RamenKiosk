package frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Point;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.Iterator;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;
import kiosk.Other;

public class ManagerFrame extends KioskFrame {

	public ManagerFrame() {
		//패널 생성
		KioskPanel panel = new KioskPanel(getImage("ManagerFrame"));
		add(panel);

		//-, + 메뉴 버튼과 수량 필드 
		String btnList[] = {"치즈","계란","떡","소세지"};
		JTextField tfList[] = new JTextField[4];
		for ( int i = 0; i < btnList.length; i++ ) {
			tfList[i] = new JTextField();
			tfList[i].setText(String.valueOf(Other.quantityList[i]));
			tfList[i].setEditable(false);
			tfList[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
			tfList[i].setHorizontalAlignment(0);
			
			JLabel imgLb = new JLabel(new ImageIcon(getImage("MngOther"+(i+1))));
			KioskButton min = new KioskButton("-","min");
			KioskButton plus = new KioskButton("+", "plus");
			
			if( i % 2 == 0) {
				imgLb.setBounds(40, 120+220*(i/2),160, 160);
				min.setBounds(40, 290+220*(i/2), 30, 30);
				plus.setBounds(160, 290+220*(i/2), 30, 30);
				tfList[i].setBounds(70, 290+220*(i/2), 80, 30);
			}else {
				imgLb.setBounds(250, 120+220*(i/2), 160, 160);
				min.setBounds(250, 290+220*(i/2), 30, 30);
				plus.setBounds(370, 290+220*(i/2), 30, 30);
				tfList[i].setBounds(280, 290+220*(i/2), 80, 30);
			}
			
			if ( i == 0 ) {
				min.addActionListener(e-> {
					if( Integer.parseInt(tfList[0].getText()) == 0 ) {
						JOptionPane.showMessageDialog(null, "재고를 삭제할 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					}else {
						tfList[0].setText(String.valueOf(Integer.parseInt(tfList[0].getText())-1));
					}
				});
				plus.addActionListener(e -> {
					tfList[0].setText(String.valueOf(Integer.parseInt(tfList[0].getText())+1));
				});
			}else if ( i == 1 ) {
				min.addActionListener(e-> {
					if( Integer.parseInt(tfList[1].getText()) == 0 ) {
						JOptionPane.showMessageDialog(null, "재고를 삭제할 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					}else {
						tfList[1].setText(String.valueOf(Integer.parseInt(tfList[1].getText())-1));
					}
				});
				plus.addActionListener(e -> {
					tfList[1].setText(String.valueOf(Integer.parseInt(tfList[1].getText())+1));
				});
			}else if ( i == 2 ) {
				min.addActionListener(e-> {
					if( Integer.parseInt(tfList[2].getText()) == 0 ) {
						JOptionPane.showMessageDialog(null, "재고를 삭제할 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					}else {
						tfList[2].setText(String.valueOf(Integer.parseInt(tfList[2].getText())-1));
					}
				});
				plus.addActionListener(e -> {
					tfList[2].setText(String.valueOf(Integer.parseInt(tfList[2].getText())+1));
				});
			}else {
				min.addActionListener(e-> {
					if( Integer.parseInt(tfList[3].getText()) == 0 ) {
						JOptionPane.showMessageDialog(null, "재고를 삭제할 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
					}else {
						tfList[3].setText(String.valueOf(Integer.parseInt(tfList[3].getText())-1));
					}
				});
				plus.addActionListener(e -> {
					tfList[3].setText(String.valueOf(Integer.parseInt(tfList[3].getText())+1));
				});
			}

			panel.add(min); panel.add(plus); panel.add(tfList[i]); panel.add(imgLb);
		}

		//홈으로
		KioskButton backBtn = new KioskButton(15,650,200,80,"홈으로","goHomeBtn");
		backBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose(); 
		});
		panel.add(backBtn);

		//재고투입완료
		KioskButton choiceBtn = new KioskButton(225,650,200,80,"재고투입완료","stockBtn");
		choiceBtn.addActionListener(e -> {
			
			for(int i = 0; i < Other.quantityList.length; i++) {
			Other.quantityList[i] = Integer.parseInt(tfList[i].getText());
			}
			
			JOptionPane.showMessageDialog(null, "재료를 추가하였습니다", "정보", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("info").getScaledInstance(60, 60, 4)));
			new StartFrame().setVisible(true);
			this.dispose();
		});
		panel.add(choiceBtn);

	}//constructor

}//class

