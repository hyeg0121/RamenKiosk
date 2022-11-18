package kiosk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class ManagerFrame extends CommonFrame {
	
	Image background = new ImageIcon(StartFrame.class.getResource("../image/ManagerFrame.png")).getImage();
	
	public ManagerFrame() {
		
		var menu = new JPopupMenu();
		var show = new JMenuItem("현재 재고 확인");
		var add = new JMenuItem("재고 추가");
	
		var btnList = "치즈,계란,떡,소세지".split(",");
		for (int i = 0; i < btnList.length; i++) {
			//버튼 생성
			var btn = new JButton(btnList[i]);
			//위치 조정
			if ( i % 2 == 0 ) {
				btn.setBounds(50, 100+170*(i/2), 160, 160);
			}else {
				btn.setBounds(240, 100 + 170*(i/2), 160, 160);
			}
			
			int num = i;
			//버튼 기능
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					var menu = new JPopupMenu();
					var show = new JMenuItem(Other.getQuantity(num)+"개");
					
					
				}
			});
			
			add(btn);
			
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
}

