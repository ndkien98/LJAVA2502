package buoi6;

// cú pháp khai báo class Car: tên class
public class Car {

    // khai báo các thuộc tính của class
    public String mauSac;
    public int namSanXuat;
    public String ten;

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

    public void showInfo(){
        System.out.println("----------------------------");
        System.out.println("Tên xe: " + ten);
        System.out.println("Màu sắc: " + mauSac);
        System.out.println("Năm sản xuất: " + namSanXuat);
    }


}
