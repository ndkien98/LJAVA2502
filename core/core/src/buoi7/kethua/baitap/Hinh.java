package buoi7.kethua.baitap;

import java.util.Scanner;

public class Hinh {

    private float dienTich;
    private float chuVi;
    private String ten;

    public void hienThiThongTin(){
        System.out.println("-------------------");
        System.out.println(this.toString());
    }

    public void nhanThongTin(){
        System.out.println("Nhap Ten: ");
        this.ten = new Scanner(System.in).nextLine();
    }
    public void tinhChuVi(){

    }

    public void tinhDienTich(){

    }

    @Override
    public String toString() {
        return "dienTich=" + dienTich +
                ", chuVi=" + chuVi +
                ", ten='" + ten + '\'' +
                '}';
    }


    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public float getChuVi() {
        return chuVi;
    }

    public void setChuVi(float chuVi) {
        this.chuVi = chuVi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
