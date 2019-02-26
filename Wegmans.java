
public class Wegmans extends Store {
	
	
	public Wegmans() {
		super(600,2400);
		name = "Wegmans";
		
		
		Item carrots = new Carrots();
		items.put(carrots, 1.49f);
		itemList.add(carrots);
		Item eggs = new Eggs();
		items.put(eggs, 3.99f);
		itemList.add(eggs);
		
		
	}
	
		
		
	

}
