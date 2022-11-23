package kiosk;

public class Ramen {

	private int price;
	private int jinPrice = 1000;
	private int sinPrice = 1000;
	private int neguriPrice = 1200;
	private int chamPrice = 1200;
	private int firePrice = 1400;
	private int blackPrice = 1400;
	
	private int second;
	private int jinSecond = 1000;
	private int sinSecond = 1000;
	private int neguriSecond = 1200;
	private int chamSecond = 1200;
	private int fireSecond = 1400;
	private int blackSecond = 1400;

	public int getPrice(String name) {
		if ( name.equals("진라면")) {
			return this.jinPrice;
		}else if ( name.equals("신라면")) {
			return this.sinPrice;
		}else if ( name.equals("너구리")) {
			return this.neguriPrice;
		}else if ( name.equals("참깨라면")) {
			return this.chamPrice;
		}else if ( name.equals("불닭볶음면")) {
			return this.firePrice;
		}else {
			return this.blackPrice;
		}
	}
	
	public int getSecond(String name) {
		if ( name.equals("진라면")) {
			return this.jinSecond;
		}else if ( name.equals("신라면")) {
			return this.sinSecond;
		}else if ( name.equals("너구리")) {
			return this.neguriSecond;
		}else if ( name.equals("참깨라면")) {
			return this.chamSecond;
		}else if ( name.equals("불닭볶음면")) {
			return this.fireSecond;
		}else {
			return this.blackPrice;
		}
	}	
	
}
