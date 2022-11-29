package kiosk;

public class Other {
	
	private static  int cheesePrice = 500;
	private static int eggPrice = 500;
	private static int tteokPrice = 700;
	private static int sausagesPrice = 700;
	public static int priceList[] = { cheesePrice, eggPrice, tteokPrice, cheesePrice };
	
	public static int quantityList[] = {0, 50, 50, 50};//치즈, 계란, 떡, 소세지

	public static boolean cheeseChoice = false;
	public static boolean eggChoice = false;
	public static boolean tteokChoice = false;
	public static boolean sausegesChoice = false;
	public static boolean choiceList[] = {cheeseChoice, eggChoice, tteokChoice, sausegesChoice};
	
	public Other() {}

	public static int getPrice(String other) {
		if(other.equals("치즈")) {
			return cheesePrice;
		}else if(other.equals("계란")) {
			return eggPrice;
		}else if(other.equals("떡")) {
			return eggPrice ;
		}else {
			return sausagesPrice;
		}
	}

	public static void minQuantity(String other) {
		if(other.equals("치즈")) {
			quantityList[0]--;
		}else if(other.equals("계란")) {
			quantityList[1]--;
		}else if(other.equals("떡")) {
			quantityList[2]--;
		}else {
			quantityList[3]--;
		}
	}
	
	public static void changeChoiceValue(String other) {
		if(other.equals("치즈")) {
			cheeseChoice = !(cheeseChoice);
		}else if(other.equals("계란")) {
			eggChoice = !(eggChoice);
		}else if(other.equals("떡")) {
			tteokChoice = !(tteokChoice);
		}else {
			sausegesChoice = !(sausegesChoice);
		}
	}
	
	public static boolean getChoiceValue(String other) {
		if(other.equals("치즈")) {
			return cheeseChoice;
		}else if(other.equals("계란")) {
			return eggChoice;
		}else if(other.equals("떡")) {
			return tteokChoice;
		}else {
			return sausegesChoice;
		}
	}
	
	public static int getQuantity(String other) {
		if(other.equals("치즈")) {
			return quantityList[0];
		}else if(other.equals("계란")) {
			return quantityList[1];
		}else if(other.equals("떡")) {
			return quantityList[2];
		}else {
			return quantityList[3];
		}
	}
	
}
