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

		String btnList[] = {"치즈","계란","떡","소세지"};
		JTextField tfList[] = new JTextField[4];

		for ( int i = 0; i < btnList.length; i++ ) {
			JButton min = new JButton("-");
			JButton plus = new JButton("+");
			JTextField quantity = new JTextField();

			quantity.setFont(new Font("맑은고딕", Font.BOLD, 20));
			quantity.setHorizontalAlignment(0);
			quantity.setText(String.valueOf(Other.quantityList[i]));

			if( i % 2 == 0) {
				min.setBounds(40, 200+180*(i/2), 50, 50);
				quantity.setBounds(90, 200+180*(i/2), 70, 50);
				plus.setBounds(160, 200+180*(i/2), 50, 50);
			}else {
				min.setBounds(250, 200+180*(i/2), 50, 50);
				quantity.setBounds(300, 200+180*(i/2), 70, 50);
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
					Other.quantityList[1]++;
				});
			}else if ( i == 2 ) {
				min.addActionListener(e-> {
					Other.quantityList[2]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[2]++;
				});
			}else {
				min.addActionListener(e-> {
					Other.quantityList[3]--;
				});
				plus.addActionListener(e -> {
					Other.quantityList[3]++;
				});
			}

			add(min); add(plus); add(quantity);
		}

		//취소버튼
		JButton backBtn = new CommonButton(15,650,200,80,"홈으로","backBtn");
		this.add(backBtn);
		backBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose(); //종료
		});

		//선택완료버튼
		JButton choiceBtn = new CommonButton(225,650,200,80,"결제하기","ChargeBtn");
		choiceBtn.addActionListener(e -> {
			new StartFrame().setVisible(true);
			this.dispose();
		});
		
		
		this.add(choiceBtn);

	}

	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

}

