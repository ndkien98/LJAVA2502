package buoi2.baitap;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Bai1 {


    public static void main(String[] args) {
        // biến đối tượng dùng để nhận dữ liệu từ console
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ tên: ");
        String ten = sc.nextLine(); // nhận vào string từ console
        System.out.println("Nhập vào ngày tháng năm sinh: ");
        String ngaySinh = sc.nextLine();
        System.out.println("Quê quán: ");
        String queQuan = sc.nextLine();
        System.out.println("Trường học: ");
        String truongHoc = new Scanner(System.in).nextLine();
        System.out.println("Xin chào " + ten + " đến từ " + queQuan + " , ngày sinh " + ngaySinh + " , học tại " + truongHoc);
    }
}
