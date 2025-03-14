package buoi7.kethua;

/**

 - Thời điểm chạy trong Java
    + compile time
        + trình biên dịch biên dịch code
    + runtime
        + thời điểm chương trình đã được chạy

  - override phương thức:
    * định nghĩa:
        + xảy ra tại 2 class có mối quan hệ kế thừa
        + khi class con tồn tại 1 method y hệt(kiểu dữ liệu trả về, tên, tham số truyền vào)
        => method tại subclass được gọi là override method
    * được sử dụng khi nào:
        + khi subclass muốn viết lại 1 hành động(phương thức) của super class

 - từ khóa super:
    * định nghĩa:
        + tương tự từ khóa this, nhưng được sử dụng để gọi
        tới các thuộc tính, method của superclass để sử dụng
        trong subclass
  - instanceOf:
       -  kiểm tra xem object của superclass tại thời điểm runtime đó có phải là instance( có được khởi tạo bằng từ khóa new subclass không)
       - nếu trả về true => cho phép gọi tới tất cả các thuộc tính, method của subclass

 */
public class Main1 {

    public static void main(String[] args) {

        // khai báo subclass khởi tạo subclass
        Bicycle xeDap1 = new Bicycle();
        // có thể truy cập tới tất cả các phương thức và method của cả superclass và subclass
        xeDap1.setMauSac("màu đỏ");
        xeDap1.setTen("Thống nhất");
        xeDap1.setSoLuongBanh(2);
        xeDap1.setNamSanXuat(2024);
        xeDap1.setLoaiXich("thong nhat");
        // khai báo bằng superclass và khởi tạo bằng sublcass
        Vehicle xeDap2 = new Bicycle();
        // ở thời điểm compile time chỉ có thể truy cập tới các method, thuộc tính của superclass
        xeDap2.setMauSac("màu đỏ");
        xeDap2.setTen("Thống nhất");
        xeDap2.setSoLuongBanh(2);
        xeDap2.setNamSanXuat(2024);
        // nếu muốn truy cập tới các thuộc tính và method của sub class => ép kiểu từ superclass -> subclass
        ((Bicycle) xeDap2).setLoaiXich("xich thong nhat");
        // sử dụng từ khóa instanceOf
        if (xeDap2 instanceof Bicycle){
            ((Bicycle) xeDap2).setLoaiXich("xich thong nhat2");
        }

        MotoBicycle xeMay1 = new MotoBicycle();
        xeMay1.setMauSac("Dream");
        xeMay1.setTen("Honda");
        xeMay1.setSoLuongBanh(2);
        xeMay1.setNamSanXuat(1998);
        Vehicle xeMay2 = new MotoBicycle();

        Car oTo1 = new Car();
        Vehicle oTo2 = new Car();

        xeDap1.hienThiThongTin();
        xeMay1.hienThiThongTin();;
        xeDap2.hienThiThongTin();
    }
}
