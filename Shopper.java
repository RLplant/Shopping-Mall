import java.util.Scanner;

public class Shopper {
	private String name;
	private int balance;
	private boolean done;
	
	public Shopper(String nombre, int money) {
		name = nombre;
		balance = money;
	
	}

	public void visit(Mall mall) {
		done = false;
		while (!done) {
			mall.shop(this);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isDone() {
		return done;
	}
}
