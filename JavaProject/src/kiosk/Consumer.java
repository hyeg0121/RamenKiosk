package kiosk;

public class Consumer {

	private static int price; 
	private static int second;
	
	public static void setPrice(int price) {
		Consumer.price = price;
	}
	
	public static void addPrice(int price) {
		Consumer.price += price;
	}
	public static void setSecond(int second) {
		Consumer.second = second;
	}
	
	public static void clear() {
		price = 0;
		second = 0;
	}
	
	public static int getPrice() {
		return price;
	}
	
	public static int getSecond() {
		return second;
	}

	
	
}
