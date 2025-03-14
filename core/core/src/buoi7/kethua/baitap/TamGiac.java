package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

public class TamGiac extends Hinh{

    private int canhA;
    private int canhB;
    private int canhC;

    @Override
    public void hienThiThongTin() {
        this.tinhChuVi();
        super.hienThiThongTin();
        System.out.println("Canh a: " + this.canhA);
        System.out.println("Canh b: " + this.canhB);
        System.out.println("Canh c: " + this.canhC);
    }

    @Override
    public void nhanThongTin() {
        super.nhanThongTin();
        this.canhA = Utils.nhap("Nhap vao canh a");
        this.canhB = Utils.nhap("Nhap vao canh b");
        this.canhC = Utils.nhap("Nhap vao canh c");
    }

    @Override
    public void tinhChuVi() {
        super.setChuVi(this.canhA + this.canhB + this.canhC);
    }
}
