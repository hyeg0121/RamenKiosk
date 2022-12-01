package components;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class KioskFrame extends JFrame {

	public final int FRAMEWIDTH = 450;
	public final int FRAMEHEIGHT = 800;
	
	public KioskFrame() {
		setSize(FRAMEWIDTH, FRAMEHEIGHT);
		setLayout(null);
		setTitle("뽀글뽀글 키오스크"	);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(KioskFrame.class.getResource("../image/frameIcon.png")).getImage());
		setResizable(false);
	}//constructor
	
	public Image getImage(String imgName) {
		return new ImageIcon(KioskFrame.class.getResource("../image/"+imgName+".png")).getImage();	
	}//method : 이미지 파일 이름을 입력받으면 그 파일을 이미지아이콘으로 만들어 반환

	
}
