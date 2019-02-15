import java.util.ArrayList;

public class NatickCollection extends Mall {

	
	NatickCollection() {
		super(1000, 2100, 2);
		mallName = "Natick Collection";
		stores = new ArrayList<Store>(storeAmount);
		Store wegmans = new Wegmans();

		stores.add(wegmans);
		
	}
	
	
	
}
