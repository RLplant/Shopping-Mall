
public abstract class Store {
	private String name;
	private int opening;
	private int closing;
	private boolean open;
		
	public Store(int openingTime, int closingTime){
		opening = openingTime;
		closing = closingTime;
		open = isOpen();
		
	}
	public boolean isOpen() {
		if((Clock.getTime()>opening)&&(Clock.getTime()<closing)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
