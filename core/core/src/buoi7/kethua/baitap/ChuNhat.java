package buoi7.kethua.baitap;

import java.util.Scanner;

public class ChuNhat extends Hinh{

    private int chieuDai;
    private int chieuRong;

    @Override
    public void nhanThongTin() {
        // nhap thong tin cua lop superclass
        super.nhanThongTin();
        System.out.println("Nhap chieu dai: ");
        this.chieuDai = new Scanner(System.in).nextInt();
        System.out.println("Nhap chieu rong: ");
        this.chieuRong = new Scanner(System.in).nextInt();
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("Chieu rong: " + chieuRong);
    }

    @Override
    public void tinhDienTich() {
        float dienTich = chieuDai * chieuRong;
        super.setDienTich(dienTich);
    }

    @Override
    public void tinhChuVi() {
        super.setChuVi((this.chieuDai + this.chieuRong) * 2);
    }
}
