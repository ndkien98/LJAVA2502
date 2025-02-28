package buoi3.baitap.bt;

import java.util.Scanner;

/**
 bai 2) Viết lại chữ số đảo ngược
 Ví dụ nhập vào số 1357 thì in ra số đảo ngược là 7531
 (Không sử dụng nhập vào chuỗi số là String)
 */
public class Bai2 {

    public static void main(String[] args) {
        System.out.println("Nhap vao so: ");
        int data = new Scanner(System.in).nextInt();
        int soDaoNguoc = 0;
        while (data != 0){
            int soDu = data % 10;
            soDaoNguoc = soDaoNguoc * 10 + soDu;
            data = data / 10;
        }
        System.out.println("So dao nguoc la: " + soDaoNguoc);

    }
}
