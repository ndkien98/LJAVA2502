package buoi7.triutuong;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // khởi abtract class thông qua subclass
        HinhTriuTuong hinhTron = new HinhTron();

        /*
        khởi tạo đối tượng hinhTriuTuong bằng anonymous class
        anonymous class:
               + class được trực tiếp trong code thực thi, không được
               xác định tên class rõ ràng
               + tên class sẽ được jvm tự động đặt cho
               + cách viết ngắn gọn khi không muốn tạo ra class kế thừa
               từ class abstract
         */
        HinhTriuTuong hinhTriuTuong = new HinhTriuTuong() {
            private int hinhDemo;
            private String ten;
            @Override
            public void tinhChuVi() {

            }

            @Override
            public void tinhDienTich() {

            }
        };


    }
}
