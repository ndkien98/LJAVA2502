package buoi9;

import java.io.IOException;
import java.util.Scanner;

/*
Bài 1:
cho phép người dùng nhập vào 5 số, nếu bất số nào lỗi, bắt nhập lại đúng số đó
 */
public class Demo1 {


    public static void main(String[] args) {

        System.out.println("Nhập vào số nguyên: ");
        try {
            int n = new Scanner(System.in).nextInt();
            System.out.println("Số bạn vừa nhập là: " + n);
        }catch (Exception e){
            System.out.println("Lỗi nhập dữ liệu");
        }
        System.out.println("end");

    }
}
