import java.util.ArrayList;
 

public abstract class Mall {
	private int opening;
	private int closing;
	private boolean open;
	protected String mallName;
	ArrayList<Store> stores;
	private int storeAmount;
	Clock theClock;
	
	
	Mall(int openingTime, int closingTime) {
		opening = openingTime;
		closing = closingTime;
		ArrayList<Store> stores = new ArrayList<Store>(storeAmount);
		theClock = new Clock();
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
		while (isMallOpen()) {
			System.out.println("Which Store would like to visit?");
			for (int i = 0; i < getStoreAmount();i++ ) {
				System.out.println("   " + i + ". " + getStore(i));
			}
		}
	}
}
