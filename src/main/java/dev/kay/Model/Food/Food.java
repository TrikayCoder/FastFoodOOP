package Food;

import java.util.Scanner;

public abstract class Food {
	private String name;
	private int id;
	private String type;
	private int price;
	
	public Food() {
        super();
    }
	
    public Food(String name, int id, String type, int price) {
        super();
        this.name = name;
		this.id = id;
		this.type = type;
		this.price = price;
    }

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void info() {
        Scanner sc = new Scanner(System.in);
        boolean check1 =true;int id = 0;
		do {
			System.out.println("Nhap ID: ");
			id = sc.nextInt();
			boolean flag = true;
			for(Food f:FoodList.lFood) {
				if(f.getId() == id) {
					System.out.println("ID da ton tai, Vui long nhap lai ID");
					flag = false;
				}
			}
			if(flag == true)
				check1 = false;
		}while(check1==true);
		setId(id);
		
		sc.nextLine();
		System.out.println("Nhap ten mon an: ");
		String name = sc.nextLine();
    	setName(name);

		System.out.println("Nhap gia: ");
		int price = sc.nextInt();		
		setPrice(price);
	}
	
	@Override
	    public String toString(){
	        return String.format("|%-3s | %-26s | %-5s |%n",
	        id, name, price);
	    }

	public void setId(String string) {
	};
}
