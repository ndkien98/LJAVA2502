package buoi7.triutuong;

import java.util.Scanner;

/*
abstract: biến class thành class trìu tượng(abstract)
* Định nghĩa:
    - cũng là 1 class thông thường nhưng có thêm các method trìu tượng
    - method trìu tượng: là các method thông thường nhưng không có thân hàm và thêm từ khóa abstract
    - là class chuyên được sử dụng để cho các subclass có cùng bản chất kế thừa
    - nó không thể tạo ra được đối tượng trưc tiếp bằng từ khóa new mà bắt buộc phải được khởi tạo thông qua subclass

 */
public abstract class HinhTriuTuong {

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

    /*
    demo method abstract:
        - không có thân hàm
        - có thể có tham số truyền vào
        - tất cả các subclass khi kế thừa từ abstract class -> phải ghi đè (override) lại hết tất cả các method abstract
     */
    public abstract void tinhChuVi();

    public abstract void tinhDienTich();

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
