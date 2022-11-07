package kiosk;

public class Ramen {

	private int price;
	private int second;

	public Ramen (String name) {
		if ( name.equals("진라면") || name.equals("신라면") ) {
			this.price = 1000; this.second = 180;
		}else if ( name.equals("너구리") || name.equals("참깨라면") ) {
			this.price = 1200; this.second = 210;
		}else {
			this.price = 1400; this.second = 180;
		}
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getSecond() {
		return this.second;
	}
	
	
}
