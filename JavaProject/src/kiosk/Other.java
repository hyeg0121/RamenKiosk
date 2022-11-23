package kiosk;

public class Other {
	
	private static  int cheesePrice = 500;
	private static int eggPrice = 500;
	private static int tteokPrice = 700;
	private static int sausagesPrice = 700;
	
	private static int cheeseQuantity = 50;
	private static int eggQuantity = 50;
	private static int tteokQuantity = 50;
	private static int sausegesQuantity = 50;
	public static int[] quantityList = { cheeseQuantity, eggQuantity, tteokQuantity, sausegesQuantity };
	
	public static boolean cheeseChoice = false;
	public static boolean eggChoice = false;
	public static boolean tteokChoice = false;
	public static boolean sausegesChoice = false;
	public static boolean choices[] = {cheeseChoice, eggChoice, tteokChoice, sausegesChoice};
	
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

	public static void setQuantity(String other) {
		if(other.equals("치즈")) {
			--cheeseQuantity;
		}else if(other.equals("계란")) {
			--eggQuantity;
		}else if(other.equals("떡")) {
			--tteokQuantity;
		}else {
			--sausegesQuantity;
		}
	}
	
	public static int getCheeseQuantity() {
		return cheeseQuantity;
	}

	public static void setCheeseQuantity(int cheeseQuantity) {
		Other.cheeseQuantity = cheeseQuantity;
	}

	public static int getEggQuantity() {
		return eggQuantity;
	}

	public static void setEggQuantity(int eggQuantity) {
		Other.eggQuantity = eggQuantity;
	}

	public static int getTteokQuantity() {
		return tteokQuantity;
	}

	public static void setTteokQuantity(int tteokQuantity) {
		Other.tteokQuantity = tteokQuantity;
	}

	public static int getSausegesQuantity() {
		return sausegesQuantity;
	}

	public static void setSausegesQuantity(int sausegesQuantity) {
		Other.sausegesQuantity = sausegesQuantity;
	}
	
	
	
}
