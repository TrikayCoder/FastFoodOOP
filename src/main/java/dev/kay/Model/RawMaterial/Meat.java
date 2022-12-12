package Model;

import java.util.Date;
import java.util.Scanner;

public class Meat extends RawMaterial {
	private String moTa;
	Scanner sc=new Scanner(System.in);
	public Meat() {
		super();
	}
	public Meat(int idRawMaterial, String tenRawMaterial, double gia, Date date, int number, String loai) {
		super(idRawMaterial, tenRawMaterial, gia, date, number, loai);
	}
	public Meat(int idRawMaterial, String tenRawMaterial, double gia, Date date, int number, String loai,
			String moTa) {
		super(idRawMaterial, tenRawMaterial, gia, date, number, loai);
		this.moTa = moTa;
	}
	
	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public void input() {
		super.input();
		System.out.println("Moi ban nhap phan mo ta: ");
		String mt = sc.nextLine();
		setMoTa(mt);
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("|%-26s |", moTa);
	}
}
