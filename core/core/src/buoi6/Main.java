package buoi6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // tạo ra các đối tượng xe xe1
        Car xe1 = new Car(); // new Car(): constructor khởi tạo ra đối tượng từ class
        // set giá trị cho các thuộc tính của đối tượng xe1
        xe1.setNamSanXuat(2025);
//        xe1.ten = "Xe 1";
//        xe1.mauSac = "Màu đỏ";
        // gọi tới các phương thức của đối tượng xe 1
        xe1.run();
        xe1.showInfo();

        // tạo ra đối tượng xe xe2
        Car xe2 = new Car();
//        xe2.namSanXuat = 2024;
//        xe2.ten = "Xe 2";
//        xe2.mauSac = "Màu vàng";
        // gọi tới các phương thức của đối tượng xe 1
        xe2.run();
        xe2.showInfo();

        Scanner scanner = new Scanner(System.in); // khai 1 đối tượng scanner, gọi tới constructor truyền tham số System.in
        String a = new String("t3h"); // 1 đối tượng String

        // Khai báo 1 mảng danh sách các đối tượng xe
        Car[] danhSachXe = new Car[6];
        // khai 1 báo 1 vòng for để tạo ra các xe, đưa vào mảng
        for (int i = 0; i < 6; i++) {
            // khởi tạo ra 1 đối tượgn xe
            Car car = new Car();
            // truy cập vào thuộc tính của đối tượng xe để set value có các thuộc tính thông qua "."
            car.setTen("Xe " + i);
            car.setNamSanXuat(i + 2000);
            car.setMauSac("Mau " + i);
            // gọi tới method của đối tượng xe thông qua "."
            car.run();
            // thêm xe vào danh sách xe
            danhSachXe[i] = car;
        }

    }
    /*
    Bài tập ví dụ:
    1) Tạo class Animal cho các con vật tại hình
    2) tạo ra 2 method run, ăn hiển thị tên vật đang làm
    3) tạo ra 6 con vật với các thông tin khác nhau
     */
}
