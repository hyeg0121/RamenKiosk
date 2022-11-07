package kiosk;

public class Other {
	
	int quantity[] = new int[] {50, 50, 50, 50};
	
	private int price;

	public Other (String name) {
		
		if ( name.equals("지즈")) {
			this.quantity[0] -= 1;
			this.price += 500;
		}else if( name.equals("계란")) {
			this.quantity[1] -= 1;
			this.price += 500;
		}else if( name.equals("떡")) {
			this.quantity[2] -= 1;
			this.price += 700;
		}else {
			this.quantity[3] -= 1;
			this.price += 700;
		}
	}
	
	public int getPrice() {
		return this.price;
	}
	
}
