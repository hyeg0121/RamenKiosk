package kiosk;

public class Consumer {

	public static int price = 0; 
	public static int second = 0;
	
	public void setPrice(int price) {
		Consumer.price = price;
	}
	
	public void addPrice(int price) {
		Consumer.price = price;
	}
	public static void setSecond(int second) {
		Consumer.second = second;
	}
	
	public void clear() {
		price = 0;
		second = 0;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getSecond() {
		return second;
	}

	
	
}
