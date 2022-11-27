package frame;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import components.KioskFrame;
import components.KioskPanel;
import kiosk.Consumer;

public class TimerFrame extends KioskFrame implements Runnable{

	private JLabel label;
	int sec = Consumer.getSecond();
	
	public TimerFrame() {
		//패널생성
		KioskPanel panel = new KioskPanel(getImage("Cooking"));
		add(panel);
		
		//label에 시간 표시 
		label = new JLabel((sec/60)+" : "+(sec%60));
		label.setFont(new Font("맑은고딕", Font.BOLD, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(100,200,250,80);
		panel.add(label);
		
		Thread t1 = new Thread(this);
		t1.start();
		
	}//constructor
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				--sec;
				label.setText((sec/60)+" : "+(sec%60));
				
				if( sec == 0) {
					JOptionPane.showMessageDialog(null, "조리가 완료되었습니다! 맛있게드세요", "완료", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("basic").getScaledInstance(60, 60, 4)));
					new StartFrame().setVisible(true);
					this.dispose();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//run
	

}//class

