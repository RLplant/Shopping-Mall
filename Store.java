
public abstract class Store {
	private String name;
	private int opening;
	private int closing;
	private boolean open;
	
		
	public Store(int openingTime, int closingTime){
		opening = openingTime;
		closing = closingTime;
		//open = isStoreOpen();
		
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
	
}
