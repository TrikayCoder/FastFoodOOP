package Model;

import java.util.Date;
import java.util.Scanner;

public class Fruit extends RawMaterial {
	private String noiNhap;
	private String ghiChu;
	Scanner sc=new Scanner(System.in);
	public Fruit() {
		super();
	}
	public Fruit(int idRawMaterial, String tenRawMaterial, double gia, Date date, int soLuong, String loai) {
		super(idRawMaterial, tenRawMaterial, gia, date, soLuong, loai);
	}
	public Fruit(int idRawMaterial, String tenRawMaterial, double gia, Date date, int soLuong, String loai,
			String noiNhap, String ghiChu) {
		super(idRawMaterial, tenRawMaterial, gia, date, soLuong, loai);
		this.noiNhap = noiNhap;
		this.ghiChu = ghiChu;
	}

	public String getNoiNhap() {
		return noiNhap;
	}
	public void setNoiNhap(String noiNhap) {
		this.noiNhap = noiNhap;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Override
	public void input() {
		super.input();
		System.out.println("Moi ban nhap Noi nhap hang: ");
		String nn = sc.nextLine();
		System.out.println("Moi ban nhap ghi chu: ");
		String gc = sc.nextLine();
		
		setGhiChu(gc);
		setNoiNhap(nn);
	}
	
	@Override
	public String toString() {
		return super.toString()+String.format("|%-15s | %-26s |", noiNhap,ghiChu);
	}
}
