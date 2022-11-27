package kiosk;

public class Ramen {


	private static int jinPrice = 1000;
	private static int sinPrice = 1000;
	private static int neguriPrice = 1200;
	private static int chamPrice = 1200;
	private static int firePrice = 1400;
	private static int blackPrice = 1400;
	
	private static int jinSecond = 180;
	private static int sinSecond = 180;
	private static int neguriSecond = 210;
	private static int chamSecond = 210;
	private static int fireSecond = 180;
	private static int blackSecond = 180;

	public static int getPrice(String name) {
		if ( name.equals("진라면")) {
			return jinPrice;
		}else if ( name.equals("신라면")) {
			return sinPrice;
		}else if ( name.equals("너구리")) {
			return neguriPrice;
		}else if ( name.equals("참깨라면")) {
			return chamPrice;
		}else if ( name.equals("불닭볶음면")) {
			return firePrice;
		}else {
			return blackPrice;
		}
	}
	
	public static int getSecond(String name) {
		if ( name.equals("진라면")) {
			return jinSecond;
		}else if ( name.equals("신라면")) {
			return sinSecond;
		}else if ( name.equals("너구리")) {
			return neguriSecond;
		}else if ( name.equals("참깨라면")) {
			return chamSecond;
		}else if ( name.equals("불닭볶음면")) {
			return fireSecond;
		}else {
			return blackSecond;
		}
	}	
	
}
