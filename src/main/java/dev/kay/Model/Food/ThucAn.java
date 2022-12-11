package Food;

public class ThucAn extends Food {
    public ThucAn() {
        super();
    }

    @Override
	public void info() {
		super.info();
		setType("Thuc an");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}