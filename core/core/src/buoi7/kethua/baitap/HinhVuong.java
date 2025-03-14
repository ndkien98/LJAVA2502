package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

public class HinhVuong extends Hinh{
    private int canhA;

    @Override
    public void hienThiThongTin() {
        this.tinhChuVi();
        super.hienThiThongTin();
        System.out.println("Canh A: " + this);
    }

    @Override
    public void nhanThongTin() {
        super.nhanThongTin();
        this.canhA = Utils.nhap("Nhap canh A");
    }

    @Override
    public void tinhChuVi() {
        super.setChuVi(this.canhA * 4);
    }
}
