import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public abstract class Store {
	protected String name;
	protected int opening;
	protected int closing;
	protected boolean open;
	protected Map<Item, Float> items;
	protected ArrayList<Item> itemList;
	protected Scanner scan = new Scanner(System.in);
	protected ArrayList<Item> cart;
	
		
	public Store(int openingTime, int closingTime){
		opening = openingTime;
		closing = closingTime;
		//open = isStoreOpen();
		items = new HashMap<Item, Float>();
		itemList = new ArrayList<Item>();
		
	}
	public boolean isStoreOpen(int time) {
		if((time>opening)&&(time<closing)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getName() {
		return name;
	}
	
	public void shopAt(Shopper theShopper) {
		String input;
		int inputInt;
		System.out.println("walking..."); 
			System.out.println("Welcome to " + name + "."); 

		while (isStoreOpen(theShopper.getLocalTime())){
			System.out.println("What would you like to do at " + name + "? (enter number)");
			System.out.println("   1. Purchase");
			System.out.println("   2. Return");
			System.out.println("   3. Leave");
			inputInt = scan.nextInt();
			
			if(inputInt == 1) {
				//time stuff?
				cart = new ArrayList<Item>(1);// have chunk to extend cart to fit more items if needed.
				purchaseMenu(theShopper);
			}
			else if (inputInt == 2) {
				
			}
			else if (inputInt == 3) {
				System.out.println("Thank You for visiting " + name +".");
				break;
			}
		}
		
	}
	public void purchaseMenu(Shopper theShopper) {
		boolean checkout = false;
		boolean exit = false;
		while((checkout == false)&&(exit == false)) {
			System.out.println("To add Item to your cart, enter the indicated number.");
			printItems();
			System.out.println("   c. View Cart");
			System.out.println("   b. View Balance");
			System.out.println("   E. Exit Puchase Menu");
			System.out.println("   Check. Checkout");
			
			String s = scan.next(); // use try catch so don't have to hard code numbers
			int i;
			try {
				i = Integer.parseInt(s)-1;
				cart.ensureCapacity(cart.size() + 1);
				cart.add(itemList.get(i));
				String temp = itemList.get(i).getName();
				System.out.println("You have added a " + temp + " to your cart.");
			}
			catch(NumberFormatException e){
				switch(s) {

				case "c": 
				case "C": printCart();
						break;
				case "b": System.out.println("You have: $" + theShopper.getBalance());
						break;
				case "check":	
				case "Check": checkout = true;
						break;
				case "e":
				case "E": exit = true;
						break;
				default : 
				}
			}
			catch(IndexOutOfBoundsException out) {
				
			}
		}
		if(checkout == true) {
			checkout(theShopper);
		}
	}
	
	
	public void printItems() {
		for (int i = 0; i<itemList.size(); i++) {
			float f = items.get(itemList.get(i));
			String s = itemList.get(i).getName();
			System.out.println("   "+ (i+1) + ". " + s + " = $" + f);
			
		}
	}
	public void printCart() { // bunch same items together (for example 4x carrots)?
		System.out.print("Cart: ");
		for (int i = 0; i<cart.size(); i++) {
			String s = cart.get(i).getName();
			System.out.print(s + ", ");
		}
		System.out.println();
	}
	public float getPrice(Item item) {
		return items.get(item);
	}
	public void checkout(Shopper theShopper) { // 
		boolean confirm = false;
		while (confirm == false) {
			System.out.println("Welcome to checkout. Is there anything you would like to remove from cart?" );
			for (int i = 0; i<cart.size(); i++) {
				float f = items.get(cart.get(i));
				String s = cart.get(i).getName();
				System.out.println("   " + (i+1) + ". " + s + " = $" + f);
			}
			System.out.println("   c. Confirm and proceed to next step.");
			System.out.println("   e. Exit");
			String s = scan.next();
			int e;
			try {
				e = Integer.parseInt(s)-1;
				if (e <= cart.size()) {
					System.out.println("One " + cart.get(e).getName() + "has been removed from your cart.");
					cart.remove(e);
					
				}
			} catch(NumberFormatException err) {
				if (s.equals("e")) {
					purchaseMenu(theShopper);
				}
				else if (s.equals("c")) {
					confirm = true;
				}
			}
			catch(IndexOutOfBoundsException out) {
				
			}
		}
		
		transaction(theShopper);
	}
	
	public void transaction(Shopper theShopper) { //not done, balance check and stuff
		float totalTransaction = 0;
		for (int i = 0; i<cart.size();i++) {
			float iprice = items.get(cart.get(i));
			totalTransaction = totalTransaction + iprice;
		}
		if (totalTransaction < theShopper.getBalance()) {
			System.out.println("Your transaction is $" + totalTransaction);
			boolean signed = false;
			while (signed == false){
				System.out.println("Please sign your name below:");
				String s = scan.next();
				if (s.equals(theShopper.getName())) {
					signed = true;
				}
			}
			theShopper.subtractBalance(totalTransaction);
			for(int i = 0; i<cart.size();i++) {
				theShopper.buy(cart.get(i),this);
				
			}
			//make transaction: go through cart and make reciepts and add both r and i to shopping bag
			
		}
		else {
			System.out.println("You cannot afford that transaction. Returning to purchase menu.");
		}
		
		
	}
}
