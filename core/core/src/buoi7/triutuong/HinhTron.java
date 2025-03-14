package buoi7.triutuong;

import buoi7.kethua.Utils;

public class HinhTron extends HinhTriuTuong {
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
    public void tinhDienTich() {
        super.setChuVi((float) (this.banKinh * 3.14 * 2));
    }

    @Override
    public void tinhChuVi() {

    }
}
