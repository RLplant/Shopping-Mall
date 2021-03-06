import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mall {
	protected int opening;
	protected int closing;
	protected boolean open;
	protected String mallName;
	protected ArrayList<Store> stores;
	protected int storeAmount;
	protected Clock theClock;
	protected Scanner scan;
	
	
	Mall(int openingTime, int closingTime, int mallSize) {
		opening = openingTime;
		closing = closingTime;
		storeAmount = mallSize;
		theClock = new Clock();
		scan = new Scanner(System.in);
	}
	public int getTime() {
		return theClock.getTime();
	}
	public boolean isMallOpen() {
		int time = theClock.getTime();
		if((time>opening)&&(time<closing)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return mallName;
	}
	public int getStoreAmount() {
		return stores.size();
	}
	public String getStore(int i) {
		Store s = stores.get(i);
		return s.getName();
	}
	
	public void shop(Shopper theShopper) {
		String input;
		while (isMallOpen()) {
			System.out.println("Which Store would like to visit?");
			for (int i = 0; i < getStoreAmount();i++ ) {
				System.out.println("   " + (i+1) + ". " + getStore(i));
			}
			System.out.println("   i. See Owned Items");
			System.out.println("   b. See Balance");
			System.out.println("   L. Leave");
			input = scan.next();
			int i;
			try {
				i = Integer.parseInt(input)-1;
				Store temp = stores.get(i);
				//do some stuff with time and stuff
				temp.shopAt(theShopper);
			}
			catch(NumberFormatException e){
					switch(input) {

					case "i": 
					case "I": theShopper.showBag();
							break;
					case "b": System.out.println("You have: $" + theShopper.getBalance() + ".");
							break;
					case "l":	
					case "L":
					case "leave":
					case "Leave": theShopper.beDone();
							break;
					default : 
					}
				}
				catch(IndexOutOfBoundsException out) {
					
				}
			
			
			
		}
		
	}
}
