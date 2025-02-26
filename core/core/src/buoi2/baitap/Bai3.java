package buoi2.baitap;

import java.util.Scanner;

/*
  Bài 3) Cho phép nhận vào hai cạnh của hình chữ nhật
  tính diện tích hình chữ nhật
  S = chieuDai * chieuRong
 */
public class Bai3 {

    public static void main(String[] args) {
        System.out.println("Nhap vao chieu dai: ");
        int chieuDai = new Scanner(System.in).nextInt();
        System.out.println("Nhap vao chieu rong: ");
        int chieuRong = new Scanner(System.in).nextInt();
        int dienTich = chieuDai * chieuRong;
        System.out.println("Dien tich hinh chu nhat: " + dienTich);

    }
}
