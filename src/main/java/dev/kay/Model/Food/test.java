package Food;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		FoodList fl = new FoodList();
		
        fl.ReadFile();
		int function = 0;
        do{
            System.out.println("\t•~•quan ly ban hang•~•");
            System.out.println(" 1.Hien thi danh sach cac mon\n 2.Them mon\n 3.Chinh sua\n 4.Xoa\n 5.Quay lai");
            try{
            	System.out.println("Nhap chuc nang: ");
                function=Integer.parseInt(sc.nextLine());
                switch(function) {
                    case 1:fl.ExportList();break;
                    case 2:fl.Add(); break;
                    case 3:fl.Edit(); break;
                    case 4:fl.Remove(); break;
                    case 5:break;
                    default: System.out.println("Vui long nhap dung chuc nang!!");break;
                }
            }catch(NumberFormatException E)
            {
                System.out.println("Gia tri can nhap la so!!");
            }
        }while(function!=5);
    }
}
