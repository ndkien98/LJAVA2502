package buoi7.kethua.baitap;

import buoi7.kethua.Utils;

public class HinhTron extends Hinh{
    private float banKinh;

    @Override
    public void nhanThongTin() {
        super.nhanThongTin();
        this.banKinh = Utils.nhap("Nhap thong tin ban kinh: ");
    }

    @Override
    public void hienThiThongTin() {
        this.tinhChuVi();
        super.hienThiThongTin();
        System.out.println("Ban kinh: "+ this.banKinh);
    }

    @Override
    public void tinhChuVi() {
        super.setChuVi((float) (3.14 * 2 * this.banKinh));
    }
}
