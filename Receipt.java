
public class Receipt {
	protected boolean returnable;
	protected float pricePaid;
	protected Item purchased;
	protected Store origin;
	protected String itemName;
	
	
	
	public Receipt(Item item, Store theStore) {
		purchased = item;
		itemName = item.getName();
		origin = theStore;
		pricePaid = theStore.getPrice(item);
		
		
	}

}
