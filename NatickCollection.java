import java.util.ArrayList;

public class NatickCollection extends Mall {
	private int opening;
	private int closing;
	private boolean open;
	ArrayList<Store> stores;
	private int storeAmount = 1;
	Clock theClock;
	
	NatickCollection() {
		super(1000, 2100);
		mallName = "Natick Collection";
		ArrayList<Store> stores = new ArrayList<Store>(storeAmount);
		Store wegmans = new Wegmans();
		
		stores.add(wegmans);
		
	}
	
	
	
}
