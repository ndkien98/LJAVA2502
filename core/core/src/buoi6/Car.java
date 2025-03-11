package buoi6;

// cú pháp khai báo class Car: tên class
public class Car {

    // khai báo các thuộc tính của class
    /*
    - các thuộc tính khai báo phải để phạm vi truy cập private để bảo vệ dữ liệu của các thuộc tính, tránh
    bị sửa đổi 1 cách tùy tiện, chỉ cho phép sửa đổi giá trị của thuộc tính thông qua các method getter, setter
     */
    private String mauSac;
    private int namSanXuat;
    private String ten;
    /*
    - các method getter, setter là các method thông thường, nhưng chuyên được sử dụng để sửa đổi hoặc trả về giá trị
    của thuộc tính
     */
    public void setTen(String ten){
        this.ten = ten;
    }

    public String getTen(){
        return ten;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMauSac() {
        return mauSac;
    }

    /*
                    Khai báo constructor dùng để khởi tạo đối tượng
                    - constructor luôn được gọi tới đầu tiên khi khởi tạo 1 object
                     */
    public Car(){ // constructor không tham số
        System.out.println("constructor được khởi tạo");
    }
    // các constructor có tham số
    public Car(String mauSac, int namSanXuat){
        this.mauSac = mauSac;
        this.namSanXuat = namSanXuat;
        System.out.println("constructor được khởi tạo");
    }
    public Car(String mauSac, int namSanXuat, String ten){
        this.mauSac = mauSac;
        this.namSanXuat = namSanXuat;
        this.ten = ten;
        System.out.println("constructor được khởi tạo");
    }

    // khai báo các phương thức của class
    public void run(){
        System.out.println("Xe " + ten + " đang chạy");
    }

    public String run(String ten){
        System.out.println("Xe " + ten + " đang chạy");
        return "";
    }

    public void showInfo(){
        System.out.println("----------------------------");
        System.out.println("Tên xe: " + ten);
        System.out.println("Màu sắc: " + mauSac);
        System.out.println("Năm sản xuất: " + namSanXuat);
    }




}
