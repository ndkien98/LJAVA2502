package buoi2;

import java.util.Scanner;

/*

public: có thể truy cập được ở mọi file class khác
private: chỉ có thể truy cập khi cùng thuộc 1 file class
protected: chỉ có thể truy cập khi cùng package, khác package thì phải là class con của class cha
default: chỉ được truy cập khi cùng chung package
=> phạm vi truy cập
    được sử dụng để bảo vệ dữ liệu của 1 class, giúp dữ liệu của
    các class không bị truy cập và sửa đổi trái phép
 - chưa có lập trình OOP -> hướng câu trúc

* Biến trong Java:
    - là 1 vị trí trong vùng nhớ máy tính được cấp phát khi chương trình bắt đầu chạy
    - được sử dụng để lưu trữ dữ liệu của chương trình
    - mỗi biến sẽ có: tên, kiểu dữ liệu, địa chỉ ô nhớ ( nơi biến tồn tại trong ô nhớ được cấp
                                                        phát khi chương trình chạy )
    - khi khai báo 1 biến trong java tức là đang yêu cầu máy ảo jvm cấp phát 1 vùng nhớ
    nhất định để lưu trữ dữ liệu của chương trình

 + Các kiểu dữ liệu trong Java
    2 kiểu dữ liệu chính
        -) Kiểu dữ liệu nguyên thủy
            int, char, float, boolean, long, double... các kiểu dữ liệu cơ bản được cung cấp sẵn
        -) Kiểu dữ liệu đối tượng
            Interge, String, Double, FLoat, Long, Boolean, là các class được tự định nghĩa ra
            trong quá trình phát triển vd: Person, Main
       => 2 kiểu dữ liệu này khác nhau:
            - nơi được tạo ra khi khai báo
                + kiểu dữ liệu nguyên thủy nằm trong vùng nhớ Stack khi được khai báo
                + kiểu dữ liệu đối tượng có 2 phần
                    - p1: biến được khai báo nằm trong stack
                    - p2: giá trị của biến nằm trong vùng nhớ Heap
            - các miền giá trị có thể chứa được

 - trong lập trình hướng cấu trúc(cũ trong c) có 2 loại biến:
    + biến tham trị:
        - khi truyền 1 tham số vào trong 1 hàm ngoài truyền giá trị của biến còn truyền vào
        cả địa chỉ ô nhớ của biến đó ví dụ gọi là biến a
        => nếu trong method thay đổi giá trị của biến a vậy khi chương trình chạy qua method đó
        biến a cũng sẽ bị thay đổi giá trị
    + biến tham chiếu:
        - khi truyền 1 tham số vào trong 1 hàm chỉ truyền giá trị của biến đó vào method, còn không
        truyền địa chỉ ô nhớ vào method đó
        => khi method thay đổi giá trị của biến a => biến ra sẽ không bị thay đổi giá trị
        khi chạy hết method

    => chỉ được tạo ra trong lập trình hướng cấu trúc đặc biệt là c
    => trong Java tất cả các biến khi truyền vào 1 method thì đều được truyền thông qua kiểu tham trị
       tức là khi tham số(param) được method sử dụng, method sẽ phải copy param đó sang 1 vùng nhớ khác
       và chỉ thay đổi giá trị của biến được copy đó, còn biến ban đầu thì vẫn giữ nguyên giá trị

 - các kiểu biến trong java
    + biến local:
        là các biến được khai báo trong các method, chỉ có phạm vi sử dụng nằm trong method đó, khi
        hết method đó sẽ không thể sử dụng được nữa
        không thể sử dụng phạm vi truy cập
    + biến instance( biến toàn cục)
        được khai báo ở tầng class, đón vài trò là thuộc tính của class, có thể sử dụng ở tất cả
        các method nằm trong class
        có thể sử dụng thêm phạm vi truy cập, private, public, protected, default
    + biến static
        biến đặc biệt được quả lý và truy cập bởi class, là biến dùng chung cho tất cả các đối tượng
        trong cùng class
        biến đặc biệt được khởi tạo trước tiên ngay khi chương trình bắt đầu
        có thể sử dụng thêm phạm vi truy cập private, public, protected, default

 * Toán tử tăng giảm
    - (++)
        -) nếu toán tử ++ nằm phía sau của 1 biến
            vd: a++;
            => biến a sẽ được tăng thêm 1 khi chương trình chạy hết dọng lệnh a++
        -) nếu toán từ ++ nằm phía trước của 1 biến
            vd: ++a;
            => biến a sẽ được tăng thêm 1 trước khi chương trình chạy dòng lệnh ++a
    - (--)
        +) nếu toán từ -- nằm phía sau 1 biến
            vd:
                a--;
            => biến a sẽ bị trừ đi 1 giá trị khi chương trình chạy qua dòng lệnh a--;
        +) nếu toán tử -- nằm phía trước 1 biến
            vd:
                --a;
               => biến a sẽ bị trừ 1 giá trị trước khi chương trình chạy qua dòng lệnh --a;

 */
public class Person {

    // khai bóa biến instance
    private String name;
    protected int age;
    String email;

    // khai báo biến static
    public static String address;

    public static void main(String[] args) {
        // cách khai báo biến nguyên thủy
        int soLon = 0;
        int SoLon = 10;
        double soBe = 1;
        // cách khai báo biến đối tượng thông qua từ khóa new
        Person nguoi = new Person();
        // gọi tói hàm cộng hai số
        int tong = congHaiSo(1,2);
        // in ra giá trị của biến
        System.out.println("giá trị của tổng: " + tong);
        // gọi method
        int a = 20;
        thayDoiGiaTriBienNguyenThuy(a);
        System.out.println(a); // giá trị a = ? 20

        Person kien = new Person();
        kien.age = 20;
        thayDoiGiaTriBienDoiTuong(kien);
        System.out.println(kien.age); // giá trị kien.age = 10

        /*
        1) 11-10-11  19-20-19
        2) 11 10  19 20
        3) 11 10 11 19 20 19
        4) 10, 11 , 10
        5) 11 10 11 19 20 19
        6) 11 11 10 19 19 20
        7) 19, 20, 20
        8) 11 10 10 19 20 20
        9) 11 10 11 19 20 19
        10) 11-10-11-19-20-19
        11) 10-12-12 10-18-18
        12) 11 10 10 19 20 20
        13) 20-18-18
        14) 11 11 12
        15) 10-12-12 20-18-18
        16) 11 12 12  19 18 18
        17) 11 10 11 19 19 19
        18) 11 11 12 19 19 18
         */
        int demo = 10;
        // ++demo <=> demo = demo + 1 = 11
        System.out.println(++demo); // trước khi chạy câu lệnh sẽ gán demo = demo + 1 = 11 => in ra 11, giá trị hiện tại demo = 11
        System.out.println(demo++); // in ra demo = 11 trước, demo đang mang giá trị 11, khi chạy hết dòng lệnh này thực hiện tiếp demo = demo + 1 = 11 + 1 = 12
        System.out.println(demo); // in ra 12 vì câu lệnh phía trước đã gán giá trị demo = 11 + 1 = 12 rồi

        int demo2 =20;
        System.out.println(--demo2); // ? 19 | trước khi chạy câu lệnh --demo2 => giảm demo2 = demo2 - 1 = 19, tiếp tục in ra demo2
        System.out.println(demo2--); // 19 | in ra demo2 trước rồi sau đó demo2 = demo2 - 1 = 19 -1 = 18
        System.out.println(demo2); // 18 cứ thế in ra 18

        System.out.println("Nhập vào ngày sinh: ");
        int ngaySinh = new Scanner(System.in).nextInt();
        ngaySinh +=2; // tương đương câu lệnh ngaySinh = ngaySinh + 2;
        System.out.println(ngaySinh);

    }
    public static void thayDoiGiaTriBienNguyenThuy(int a){
        a = 10; // thay đổi giá trị biến đã được copy sang 1 vùng nhớ khác, và là biến khác
        System.out.println("đã thay đổi giá trị thành công: " + a); // 10
    }
    public static void thayDoiGiaTriBienDoiTuong(Person nguoi){
        nguoi.age = 10;
        System.out.println("đã thay đổi tuổi thành công");
    }


    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int congHaiSo(int soA, int soB){
        // khai báo biến local: tong
        int tong = soA + soB;
        return tong;
    }

}
