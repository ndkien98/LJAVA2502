package buoi9;

import java.util.Scanner;

/*
Bài 1:
cho phép người dùng nhập vào 5 số, nếu bất cứ số nào lỗi, bắt nhập lại đúng số đó
 */
public class Ex1 {

    public static void main(String[] args) {
        int n = 5;
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào số thứ: " + i);
            number[i] = nhapSo(i);
        }
        for (int i = 0; i <number.length; i++) {
            System.out.println(number[i]);
        }

    }

    public static int nhapSo(int i){
        int n = 0;
        do {
            try {
                n = new Scanner(System.in).nextInt();
            }catch (Exception e){
                System.out.println(String.format("Nhập lỗi số thứ %d, đề nghị nhập lại: ",i));
            }finally {
                System.out.println("finally số thứ: " + i);
            }
        }while (n == 0);
        return n;
    }
}
