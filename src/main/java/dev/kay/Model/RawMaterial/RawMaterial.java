package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public abstract class RawMaterial {
	private int idRawMaterial;
	private String NameRawMaterial;
	private double price;
	private Date date;
	private int number;
	private String type;
	public static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc= new Scanner(System.in);
	public RawMaterial() {
		super();
	}
	public RawMaterial(int idRawMaterial, String NameRawMaterial, double price, Date date, int number,String type) {
		super();
		this.idRawMaterial = idRawMaterial;
		this.NameRawMaterial = NameRawMaterial;
		this.price = price;
		this.date = date;
		this.number = number;
		this.type = type;
	}
	
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public int getIdRawMaterial() {
		return idRawMaterial;
	}
	public void setIdRawMaterial(int idRawMaterial) {
		this.idRawMaterial = idRawMaterial;
	}
	public String getNameRawMaterial() {
		return NameRawMaterial;
	}
	public void setNameRawMaterial(String NameRawMaterial) {
		this.NameRawMaterial = NameRawMaterial;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date = date;
	}
	public int getnumber() {
		return number;
	}
	public void setnumber(int number) {
		this.number = number;
	}
	public static DateFormat getDf() {
		return df;
	}
	public static void setDf(DateFormat df) {
		RawMaterial.df = df;
	}
	
	public void input() {
		boolean check1 = true;int id =0;
		while(check1==true) {
			System.out.println("Moi ban nhap id ");
			id = sc.nextInt();
			boolean flag = true;
			for(RawMaterial nl:RawMaterialList.dsnl) {
				if(nl.getIdRawMaterial()==id) {
					System.out.println("Id nay da ton tai");
					flag = false;
				}
					
			}
			if(flag==true) {
				check1 = false;
			}
		}
		System.out.println("Moi ban nhap ten nguyen lieu");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap gia nguyen lieu: ");
		double price = sc.nextDouble();
		System.out.println("Moi ban nhap han su dung: ");
		String date = sc.nextLine();
		Date ngayhh = null;
		try {
			ngayhh = (Date)df.parse(date);
		} catch (ParseException e) {
			System.out.println("Loi add Ngay");
			e.printStackTrace();
		}
		System.out.println("Moi ban nhap so luong ton: ");
		int slg = sc.nextInt();
		
		boolean check2 = true;	String l = "error";
		while(check2==true) {
			System.out.println("Moi ban nhap loai nguyen lieu ('Meat','Fruit'): ");
			l = sc.nextLine();
			l = l.toLowerCase();
			if(l.equals("Meat") || l.equals("Fruit")) {
				check2 = false;
			}
			else {
				System.out.println("Ban da nhap sai Loai ");
			}
		}
		
		
		
		setIdRawMaterial(id);
		setNameRawMaterial(name);
		setdate(ngayhh);
		setprice(price);
		setnumber(slg);
		settype(l);
	}
	
	@Override
	public String toString() {
		
		return String.format("|%-2s | %-25s | %-6s | %-15s | %-10s | %-10s ",
		        idRawMaterial, NameRawMaterial,price,df.format(date),number,type);
	}
	
}
