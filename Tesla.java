
public class Tesla extends Store {

	public Tesla() {
		super(1000, 2100);
		name = "Tesla";
		
		Item Model3 = new Model3();
		items.put(Model3, 44000f);
		itemList.add(Model3);
	}

}
