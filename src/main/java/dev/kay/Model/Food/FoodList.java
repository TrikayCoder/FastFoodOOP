package Food;

import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Scanner;

import Interface.IFood;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FoodList implements IFood {
	Scanner sc = new Scanner(System.in);
	private int n;

	public void setN(int n) {
		this.n = n;
	}
	public  int getN() {
		return n;
	}
    
    public static Food lFood[] = new Food[0];
    
    public Food[] getlFood() {
        return this.lFood;
    }
	public void setlFood(Food[] lFood) {
		this.lFood = lFood;
	}
	
	public int Update(){
		int count = 0;
		try {
			BufferedReader rd = new BufferedReader(new FileReader("./src/file/FileFood.txt"));
			while ((rd.readLine())!=null) {
				count+=1;
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void ReadFile(){
		n = Update();
		lFood = new Food[n];
		try {
			BufferedReader r = new BufferedReader(new FileReader("./src/file/FileFood.txt"));
			String line;
			for (int i = 0; i < lFood.length; i++) {
				line = r.readLine();
				String split[] = line.split(", ");
				String l = split[2];
				switch (l) {
					case "thucAn": {
						lFood[i] = new ThucAn();
						break;
					}
					case "thucUong": {
						lFood[i] = new ThucUong();
						break;
					}
					default:
						i-=1; break;
					}
				lFood[i].setId(Integer.parseInt(split[0]));
				lFood[i].setName(split[1]);
				lFood[i].setPrice(Integer.parseInt(split[2]));
				lFood[i].setType(split[3]);
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public void WriteFile(){
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("./src/file/FileFood.txt"));
			for (int i = 0; i < lFood.length; i++) {
				w.write(lFood[i].getId() + ", ");
				w.write(lFood[i].getName() + ", ");
				w.write(lFood[i].getType() + ", ");
				w.write(lFood[i].getPrice() + ", ");
				if (i != (lFood.length-1)) {
					w.newLine();
				}
			}
			w.close();
			System.out.println("Ghi thanh cong");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

    @Override
	public void ExportList() {
		System.out.println("\n\t\t\tThuc Don:\n");
        System.out.println("---Danh sach Thuc An---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s |%n",
    	        "ID", "Name", "Price");
    	System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:lFood) {
        	if(nl instanceof ThucAn) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---Danh sach Do Uong---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-3s | %-26s | %-5s |%n",
    	        "ID", "Name", "Price");
    	System.out.println("---------------------------------------------------------------------------------------");
        for(Food nl:lFood) {
        	if(nl instanceof ThucUong) {
        		System.out.println(nl.toString());
        	}
        }
	}

    @Override
	public void Add() {
		System.out.println("Nhap so luong muon them:");
        int sl = sc.nextInt();
        while (sl <= 0) {
            System.out.println("So luong them khong the <=0 !, nhap lai:");
            sl = sc.nextInt();
        }
		
		sc.nextLine();

		n = lFood.length;
	    Food newlFood[] = Arrays.copyOf(lFood, lFood.length+sl);
		for(int i=0;i<sl;i++) {
			System.out.println("Chon loai can them: 1)Thuc an \t 2)Nuoc uong");
			int choice = Integer.parseInt(sc.nextLine());
			while (choice<1 || choice>2) {
		            System.out.println("Lua chon khong hop le, chon lai:");
		            choice = Integer.parseInt(sc.nextLine());
		    }
			switch (choice) {
				case 1: {
					newlFood[n]= new ThucAn();
					newlFood[n].info();
					break;
				}
				case 2:{
					newlFood[n]= new ThucUong();
					newlFood[n].info();
					break;
				}
			}
			n += 1;
		}
		setlFood(newlFood);
		WriteFile();
	}

	@Override
	public void Edit() {
		boolean flag = true;
		System.out.println("Moi ban nhap id ma ban muon sua: ");
		int id = sc.nextInt();
		for(Food nl:lFood) {
			if(nl.getId() == id) {
				flag=false;
				System.out.println("Chon loai nguyen lieu: 1)Thuc an \t 2)Nuoc uong");
				int lc = sc.nextInt();
				while (lc<1 || lc>4) {
			            System.out.println("Lua chon khong hop le, chon lai:");
			            lc = sc.nextInt();
			    }
				if(lc==1) {
					lFood[lFood.length-1]= new ThucAn();
					lFood[lFood.length-1].info();
					break;
				}
				else if(lc==2) {
					lFood[lFood.length-1]= new ThucUong();
					lFood[lFood.length-1].info();
					break;
				}
			}
		}
		if(flag==true) {
			System.out.println("Id khong ton tai");
		}
		WriteFile();
	}

    @Override
	public void Remove() {
		System.out.println("Nhap ID muon xoa:");
        int DelID =  sc.nextInt();
        Boolean flag = false;
		for(int i=0;i<lFood.length;i++) {
			if(lFood[i].getId() == DelID) {
				flag = true;
				 for(int j = i; j < lFood.length-1; j++) {
                     lFood[j] = lFood[j+1];
                 }
			}	
		}
		if (flag == false){
            System.out.println("Khong tim thay ID da nhap!\n");
        }
		else {
			lFood = Arrays.copyOf(lFood, lFood.length-1);
		}
		
		setlFood(lFood);
		WriteFile();
	}
}