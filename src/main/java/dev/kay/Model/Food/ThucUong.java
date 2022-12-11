package Food;

public class ThucUong extends Food {
    public ThucUong() {
        super();
    }

    @Override
	public void info() {
		super.info();
		setType("Do uong");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
