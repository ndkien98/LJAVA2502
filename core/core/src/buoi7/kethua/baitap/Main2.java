package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {

        int n = Utils.nhap("Số lượng hinh muốn nhập: ");
        Hinh[] danhSachHinh = nhapThongTinDanhSachHinh(n);
        hienThiThongTinDanhSachHinh(danhSachHinh);
    }

    private static Hinh[] nhapThongTinDanhSachHinh(int n) {
        Hinh[] danhSachHinh = new Hinh[n];
        Hinh hinh = null;
        for (int i = 0; i < n; i++) {
            hinh = getHinh(hinh);
            if (hinh == null){
                continue;
            }
            hinh.nhanThongTin();
            danhSachHinh[i] =  hinh;
        }
        return danhSachHinh;
    }

    private static Hinh getHinh(Hinh hinh) {
        int loaiHinh;
        System.out.println("Bạn muốn nhập hình gì: ");
        System.out.println("1: Hinh Vuong");
        System.out.println("2: Hinh Chu Nhat");
        System.out.println("3: Da Giac");
        System.out.println("4: Hinh Tron");
        System.out.println("5: Hinh Tam Giac");
        loaiHinh = new Scanner(System.in).nextInt();
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
        return hinh;
    }

    private static void hienThiThongTinDanhSachHinh(Hinh[] danhSachHinh) {
        Hinh hinh;
        System.out.println("Hiển thị thông tin tất cả các hình đã nhập");
        for (int i = 0; i < danhSachHinh.length; i++) {
            hinh = danhSachHinh[i];
            if (hinh == null){
                continue;
            }
            hinh.hienThiThongTin();
        }
    }
}
