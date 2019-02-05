
public class ShoppingTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mall theMall = new NatickCollection();
		Shopper theShopper = new Shopper("Ranen", 6000);
		
		
		System.out.println("Welcome to the " + theMall.getName() + ", " + theShopper.getName() + ".");
		theShopper.visit(theMall);
		//theMall.visit(theShopper);
	}

}
