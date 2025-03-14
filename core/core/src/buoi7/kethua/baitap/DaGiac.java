package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

import java.util.Scanner;

public class DaGiac extends Hinh{
    private int soCanh;
    private int soGoc;

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("So canh: " + soCanh);
        System.out.println("So goc: " + soGoc);
    }

    @Override
    public void nhanThongTin() {
        super.nhanThongTin();
        this.soCanh = Utils.nhap("Nhap vao so canh");
        this.soGoc = Utils.nhap("Nhap vao so goc");
    }

    @Override
    public void tinhChuVi() {
        this.setChuVi(this.soCanh * soGoc);
    }
}
