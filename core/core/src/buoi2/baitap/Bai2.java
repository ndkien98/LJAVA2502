package buoi2.baitap;

import java.util.Scanner;

/*
 Bài 2:
  Nhập vào hai số tính
  1) Tổng
  2) Tích
  3) Thương
  4) Số dư của thương
 */
/*
static: từ khóa đặc biệt giúp quản lý bộ nhớ trong Java
    - có thể áp dụng cho
        + biến static
        + method static
        + khối static
    => tất cả các bọn này đều thuộc quản lý của class, sẽ được khởi tạo ô nhớ ngay khi chương trình được
    khởi tạo, và nó dùng chung cho tất các object
    - với method static:
        + chỉ cho phép gọi tới các method static, ở trong cùng class, còn các method
        non static chỉ được gọi thông qua đối tượng
        + sử dụng biến static từ bên ngoài
    - biến static:

 */
public class Bai2 {
    public static String name;
    public static void main(String[] args) {
        System.out.println("Nhập vào 2 so: ");
        System.out.println("Nhap vao so A: ");
        int soA = new Scanner(System.in).nextInt();
        System.out.println("Nhap vao so B: ");
        int soB = new Scanner(System.in).nextInt();
        Bai2 bai2 = new Bai2();
        System.out.println(bai2.tinhTich(soA,soB));
        chiaHaiSo(soA,soB);

        System.out.println(tinhTong(soA,soB));
        Bai2.name = "";
    }

    static {
        System.out.println("khối static khởi tạo");
    }

    public static int tinhTong(int soA,int soB){
        int tong = (soA + soB);
        System.out.println("Tong so A va B la: " + tong);
        return tong;
    }

    public int tinhTich(int soA,int soB){
        int tich =  (soA * soB);
        System.out.println("Tich so A va B: " + tich);
        return tich;
    }

    public static void chiaHaiSo(int soA,int soB){
        float thuong = (float) soA / soB;
        System.out.println("Thuong cua 2 so la: " + thuong);
        int soDuCuaThuong = soA % soB;
        System.out.println("So du cua thuong A va B la: " + soDuCuaThuong);
    }

}
