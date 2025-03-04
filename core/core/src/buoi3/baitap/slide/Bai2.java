package buoi3.baitap.slide;

import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {

        int soLuongSoAm = 0;
        int soLuongSoDuong = 0;
        int tongAm = 0;
        int tongDuong = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Nhập số thứ: " + i);
            int data = new Scanner(System.in).nextInt();
            System.out.println("Số thứ: " + i + " là " +  data);
            if (data < 0){
                soLuongSoAm++;
                tongAm = tongAm - data;
            }
            if (data > 0){
                soLuongSoDuong++;
                tongDuong = tongDuong + data;
            }
        }
        System.out.println("So luong so Am: " + soLuongSoAm);
        System.out.println("So luong so Duong: " + soLuongSoDuong);
        System.out.println("Tong Am: " + tongAm);
        System.out.println("Tong Duong: " + tongDuong);

    }
}
