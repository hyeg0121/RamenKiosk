package frame;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import components.KioskButton;
import components.KioskFrame;
import components.KioskPanel;

import kiosk.Consumer;
import kiosk.Manager;

public class StartFrame extends KioskFrame {

	public StartFrame() {
		//소비자의 가격과 시간 초기화
		Consumer.clear();  

		//패널생성
		KioskPanel panel = new KioskPanel(getImage("StartFrame"));
		add(panel);

		//시작하기
		KioskButton startBtn = new KioskButton(94, 400, 245, 85, "시작하기", "startBtn");
		startBtn.addActionListener(e -> {

			new RamenFrame().setVisible(true);
			Consumer.clear();
			this.dispose();
		});
		panel.add(startBtn);

		//관리자페이지
		KioskButton managerBtn = new KioskButton(175, 665, 95, 35, "관리자페이지", "ManagerBtn");
		managerBtn.addActionListener(e -> {
			int pw = Integer.parseInt(JOptionPane.showInputDialog("비밀번호를 입력하세요."));
			if (pw != Manager.getPw()) {
				JOptionPane.showMessageDialog(null, "비밀번호가 알맞지 않습니다.", "경고", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getImage("error").getScaledInstance(60, 60, 4)));
				return ;
			}
			new ManagerFrame().setVisible(true);
			this.dispose();
		});
		panel.add(managerBtn);

	}//constructor

}//class
