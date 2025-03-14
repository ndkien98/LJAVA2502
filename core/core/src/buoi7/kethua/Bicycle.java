package buoi7.kethua;

public class Bicycle extends Vehicle {

    private String loaiXich;


    public void hienThiThongTin(){
        /*
        thay vì phải viết lại toàn bộ các dòng hiển thị
        thông tin của super class
        => sử dụng từ khóa super gọi tới method của superclass để dùng lại

        System.out.println("-----------------");
        System.out.println("Tên: " + this.ten);
        System.out.println("Màu sắc: " + this.mauSac);
        System.out.println("Số lượng bánh: " + this.soLuongBanh);
        System.out.println("Năm sản xuất: " + this.namSanXuat);
         */
        super.hienThiThongTin();
        System.out.println("Loại xích: " + this.loaiXich);
    }

    public String getLoaiXich() {
        return loaiXich;
    }

    public void setLoaiXich(String loaiXich) {
        this.loaiXich = loaiXich;
    }
}
