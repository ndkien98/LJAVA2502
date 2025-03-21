package buoi9;

import java.io.IOException;
import java.util.Scanner;

/*
Bài 1:
cho phép người dùng nhập vào 5 số, nếu bất số nào lỗi, bắt nhập lại đúng số đó

Bài 2:
Bài tập: Xử lý lỗi trong phép chia
Yêu cầu:
    - Viết một chương trình Java có một phương thức để thực hiện phép chia hai số nguyên.
    - Phương thức này phải xử lý các ngoại lệ có thể xảy ra như: chia cho 0 (ArithmeticException)
    và nhập sai kiểu dữ liệu (NumberFormatException).
    - Phương thức chia có thể throw lỗi nếu người dùng nhập vào giá trị không hợp lệ.
    - Sử dụng finally để in ra thông báo bất kể lỗi có xảy ra hay không.
    - Chương trình cần phải throws lỗi nếu nhập vào giá trị không hợp lệ.
 */
public class Demo1 {


    public static void main(String[] args) {

        System.out.println("Nhập vào số nguyên: ");
        try {
            int n = new Scanner(System.in).nextInt();
            System.out.println("Số bạn vừa nhập là: " + n);
        }catch (Exception e){
            System.out.println("Lỗi nhập dữ liệu");
        }
        System.out.println("end");

    }
}
