package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import Interface.InterList;
import Interface.InterFile;



public class RawMaterialList implements InterFile,InterList {
	public static RawMaterial[] dsnl = new RawMaterial[0];
	private static String File_NL = "./src/file/RawMaterial";
	Scanner sc=new Scanner(System.in);
	
	public static RawMaterial[] getDsnl() {
		return dsnl;
	}

	public static void setDsnl(RawMaterial[] dsnl) {
		RawMaterialList.dsnl = dsnl;
	}

	public static String getFile_NL() {
		return File_NL;
	}

	public static void setFile_NL(String file_NL) {
		File_NL = file_NL;
	}

	@Override
	public void readFile() throws IOException {
		FileInputStream fis = new FileInputStream(File_NL);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(";");
			String l = arr[5];
			switch (l) {
			case "Meat": {
				dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
				dsnl[dsnl.length-1] = new Meat();
				((Meat)dsnl[dsnl.length-1]).setMoTa(arr[6]);
				break;
			}
			case "Fruit":{
				dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
				dsnl[dsnl.length-1] = new Fruit();
				((Fruit)dsnl[dsnl.length-1]).setNoiNhap(arr[6]);
				((Fruit)dsnl[dsnl.length-1]).setGhiChu(arr[7]);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + l);
			}
			dsnl[dsnl.length-1].setIdRawMaterial(Integer.parseInt(arr[0]));
			dsnl[dsnl.length-1].setNameRawMaterial(arr[1]);
			dsnl[dsnl.length-1].setprice(Double.parseDouble(arr[2]));
			try {
				dsnl[dsnl.length-1].setdate((Date)RawMaterial.df.parse(arr[3]));
			} catch (ParseException e) {
				System.out.println("Loi add ngay vao danh sach");
				e.printStackTrace();
			}
			dsnl[dsnl.length-1].setnumber(Integer.parseInt(arr[4]));
			dsnl[dsnl.length-1].settype(arr[5]);
			
			line = br.readLine();
		}
		br.close();
		isr.close();
		fis.close();
		System.out.println("Doc Thanh Cong");
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(File_NL);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		for(RawMaterial t:dsnl) {
				String line = t.getIdRawMaterial()+";"+t.getNameRawMaterial()+";"+t.getprice()+";"+RawMaterial.df.format(t.getdate())+";"+t.getnumber()+";"+t.gettype()+";" ;
				if(t instanceof Meat) line+=((Meat) t).getMoTa();
				else if(t instanceof Fruit) {
					line += ((Fruit) t).getNoiNhap()+";"+((Fruit) t).getGhiChu();
				}
				bw.write(line);
				bw.newLine();
		}
		bw.close();
		fos.close();
		osw.close();
		System.out.println("Ghi thanh Cong");
	}


	@Override
	public void output() {
		System.out.println("\n\t\t\tDanh sach cac Nguyen Lieu:\n");
        System.out.println("---Danh sach Meat---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-2s | %-25s | %-6s | %-15s | %-11s | %-10s | %-25s |%n",
    	        "ID", "Ten Nguyen Lieu","price","Han Su Dung","So Luong","Loai","Mo Ta");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(RawMaterial nl:dsnl) {
        	if(nl instanceof Meat) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---Danh sach Trai Cay---");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("|%-2s | %-25s | %-6s | %-15s | %-11s | %-10s | %-15s | %-25s |%n",
    	        "ID", "Ten Nguyen Lieu","price","Han Su Dung","So Luong","Loai","Noi Nhap","Ghi Chu");
    	        System.out.println("---------------------------------------------------------------------------------------");
        for(RawMaterial nl:dsnl) {
        	if(nl instanceof Fruit) {
        		System.out.println(nl.toString());
        	}
        }
        System.out.println("---------------------------------------------------------------------------------------------\n\n");

	}

	@Override
	public void add() {
		System.out.println("Nhap so luong Nguyen Lieu muon add:");
        int sl = sc.nextInt();
        while (sl <= 0) {
            System.out.println("So luong add khong the <=0 !, nhap lai:");
            sl = sc.nextInt();
        }
		
		for(int i=0;i<sl;i++) {
			System.out.println("Chon loai nguyen lieu can add: 1)Meat \t 2)Trai Cay");
			int lc = sc.nextInt();
			while (lc<1 || lc>2) {
		            System.out.println("Lua chon khong hop le, chon lai:");
		            lc = sc.nextInt();
		    }
			dsnl = Arrays.copyOf(dsnl, dsnl.length+1);
			switch (lc) {
			case 1: {
				dsnl[dsnl.length-1]= new Meat();
				dsnl[dsnl.length-1].input();
				break;
			}
			case 2:{
				dsnl[dsnl.length-1]= new Fruit();
				dsnl[dsnl.length-1].input();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + lc);
			}
		}
		try {
			writeFile();
		} catch (IOException e) {
			System.out.println("Loi GHi file add");
			//e.printStackTrace();
		}
	}


	@Override
	public void delete() {
		System.out.println("Nhap ID nhan vien muon delete:");
        int DelID =  sc.nextInt();
        Boolean flag = false;
        
       
        
		for(int i=0;i<dsnl.length;i++) {
			if(dsnl[i].getIdRawMaterial() == DelID) {
				flag = true;
				 for(int j = i; j < dsnl.length-1; j++) {
                     dsnl[j] = dsnl[j+1];
                 }
			}
			
			
		}
		if (flag == false){
            System.out.println("Khong tim thay ID da nhap!\n");
        }
		else {
			dsnl = Arrays.copyOf(dsnl, dsnl.length-1);
		}
		
		setDsnl(dsnl);
		try {
			writeFile();
		} catch (IOException e) {
			System.out.println("Loi cho delete nguyen lieu");
		}
	}

	@Override
	public void edit() {
		boolean flag = true;
		System.out.println("Moi ban nhap id ma ban muon edit: ");
		int id = sc.nextInt();
		for(RawMaterial nl:dsnl) {
			if(nl.getIdRawMaterial() == id) {
				flag=false;
				System.out.println("Chon loai nguyen lieu: 1)Meat \t 2)Trai Cay");
				int lc = sc.nextInt();
				while (lc<1 || lc>2) {
			            System.out.println("Lua chon khong hop le, chon lai:");
			            lc = sc.nextInt();
			    }
				if(lc==1) {
					dsnl[dsnl.length-1]= new Meat();
					dsnl[dsnl.length-1].input();
					break;
				}
				else {
					dsnl[dsnl.length-1]= new Fruit();
					dsnl[dsnl.length-1].input();
					break;
				}
			}
		}
		if(flag==true) {
			System.out.println("Id khong ton tai");
		}
		else {
			try {
				writeFile();
			} catch (IOException e) {
				System.out.println("Loi ghi file cho delete");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void search() {
		System.out.println("Moi ban nhap tu can tim: ");
		String key = sc.nextLine();
		for(RawMaterial h:dsnl)
			if(h.getNameRawMaterial().toLowerCase().contains(key))
				System.out.println(h.toString());
		
	}

	@Override
	public void sort() {
		System.out.println("Moi ban chon thu can sap xep ");
		System.out.println("1. id Nguyen Lieu");
		System.out.println("2. price Mon An");
		int n = sc.nextInt();
		
		switch (n) {
		case 1: {
			sortByID();
			break;
		}
		
		case 2: {
			sortByPrice();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
		output();
	}

	

	@Override
	public void sortByPrice() {
		System.out.println("Chon loai nguyen lieu can sap xep theo price: 1)Meat \t 2)Trai Cay");
		int lc = sc.nextInt();
		while (lc<1 || lc>2) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = sc.nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getprice() > dsnl[j].getprice() && dsnl[i] instanceof Meat&& dsnl[j] instanceof Meat  ) {
						RawMaterial t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		else {
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getprice() > dsnl[j].getprice() && dsnl[i] instanceof Fruit&& dsnl[j] instanceof Fruit) {
						RawMaterial t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		
	}

	@Override
	public void sortByID() {
		System.out.println("Chon loai nguyen lieu can sap xep theo Id: 1)Meat \t 2)Trai Cay");
		int lc = sc.nextInt();
		while (lc<1 || lc>2) {
            System.out.println("Lua chon khong hop le, chon lai:");
            lc = sc.nextInt();
		}
		if(lc ==1) {
			
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getIdRawMaterial() > dsnl[j].getIdRawMaterial() && dsnl[i] instanceof Meat&& dsnl[j] instanceof Meat  ) {
						RawMaterial t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
		else {
			for(int i=0;i<dsnl.length;i++) {
				for(int j=i+1;j<dsnl.length;j++) {
					if(dsnl[i].getIdRawMaterial() > dsnl[j].getIdRawMaterial() && dsnl[i] instanceof Fruit&& dsnl[j] instanceof Fruit) {
						RawMaterial t = dsnl[i];
						dsnl[i] = dsnl[j];
						dsnl[j] = t;
					}
				}
			}
		}
	}	
	
}
