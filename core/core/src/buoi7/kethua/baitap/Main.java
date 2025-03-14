package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n = Utils.nhap("Số lượng hinh muốn nhập: ");

        Hinh[] danhSachHinh = new Hinh[10];
        for (int i = 0; i < n; i++) {
            System.out.println("Bạn muốn nhập hình gì: ");
            System.out.println("1: Hinh Vuong");
            System.out.println("2: Hinh Chu Nhat");
            System.out.println("3: Da Giac");
            System.out.println("4: Hinh Tron");
            System.out.println("5: Hinh Tam Giac");
            int loaiHinh = new Scanner(System.in).nextInt();
            Hinh hinh = null;
            switch (loaiHinh){
                case 1:
                    hinh = new HinhVuong();
                    break;
                case 2:
                    hinh = new ChuNhat();
                    break;
                case 3:
                    hinh = new DaGiac();
                    break;
                case 4:
                    hinh = new HinhTron();
                    break;
                case 5:
                    hinh = new TamGiac();
                    break;
                default:
                    System.out.println("Nhập không đúng định dạng");
            }
            if (hinh == null){
                continue;
            }
            hinh.nhanThongTin();
            danhSachHinh[i] =  hinh;
        }
        System.out.println("Hiển thị thông tin tất cả các hình đã nhập");
        for (int i = 0; i < danhSachHinh.length; i++) {
            Hinh hinh = danhSachHinh[i];
            if (hinh == null){
                continue;
            }
            hinh.hienThiThongTin();
        }


    }
}
