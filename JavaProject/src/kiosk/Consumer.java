package kiosk;

public class Consumer {

	private static int price = 0; //ppt
	private static int second = 0;
	
	public void setPrice(int p) {
		price += p;
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
