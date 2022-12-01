   package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class KioskPanel extends JPanel {
	
	public Image img;
	public Graphics graphic;
	private Image background;

	
	public KioskPanel() {
		setBounds(-2, -40, 450, 800);
		setBackground(Color.white);
		setLayout(null);
	}//constructor
	
	public KioskPanel(Image img) {
		this.background = img;
		setBounds(-2, -40, 450, 800);
		setBackground(Color.white);
		setLayout(null);
	}//constructor 


	public void paint(Graphics g) {
		img = createImage(this.getWidth(), this.getHeight());
		graphic = img.getGraphics();
		draw(graphic);
		g.drawImage(img, 0, 0, null);
	}//method

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}//method
}
