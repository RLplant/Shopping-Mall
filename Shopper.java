import java.util.Scanner;  
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Shopper {
	protected String name;
	protected float balance;
	protected boolean done;
	protected Mall currentLocation;
	//make maps for items and receipts
	protected Map<Receipt,Item> shoppingBag = new HashMap<Receipt,Item>();
	protected ArrayList<Item> owned = new ArrayList<Item>();
	protected ArrayList<Receipt> receiptBook = new ArrayList<Receipt>();
	
	
	/*Iterator <Receipt> iterator = shoppingBag.keySet().iterator();
		while(iterator.hasNext()){
		do stuff
		}
	 */
	
	public Shopper(String nombre, float money) {
		name = nombre;
		balance = money;
		
		
	}

	public void visit(Mall mall) {
		currentLocation = mall;
		done = false;
		while (!done) {
			mall.shop(this);
		}
		System.out.println("Thank you for visiting the " + mall.getName() + ".");
	}
	
	public void buy(Item item, Store store) {
		Receipt receipt = new Receipt(item,store);
		shoppingBag.put(receipt, item);
	}
	public void showBag() {
		System.out.println("You own: ");
		for (Item item: shoppingBag.values()) {
			System.out.println(item.getName() + ", ");
		}
	}
	
	public String getName() {
		return name;
	}
	public void beDone() {
		done = true;
	}
	public int getLocalTime() {
		return currentLocation.getTime();
	}
	public float getBalance() {
		return balance;
	}
	public void subtractBalance(float f) {
		balance = balance - f;
	}
	
	
}
