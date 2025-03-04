package buoi4;

/**
 bai 1:
 cho nguoi dung nhap vao n số tự nhiên
 + n do người dùng nhập
 + sau đó cho phép người dùng nhập vào n số tự nhiên
 yếu cầu:
 1) Hiển thị các số người dùng nhập vào
 2) Tính tổng các số trong mảng
 3) Tìm số lớn nhất và nhỏ nhất trong mảng
 */
public class Main {

    public static void main(String[] args) {

        // khai báo mảng danh sách các số nguyên
        int[] array = new int[10];

        String[] arrString = {"A", "B", "C", "D", "E", "F"};
        // cho phép truy cập thông qua index
        String phanTuDau = arrString[0];
        String phanTuCuoi = arrString[5];
        System.out.println(String.format("phan dau: %s, phan tu cuoi: %s", phanTuDau, phanTuCuoi));

        arrString[0] = "K";
        arrString[5] = "H";

        // duyệt danh sách các phần tử
        for (int i = 0; i < arrString.length; i++) {
            String str = arrString[i];
            System.out.println(String.format("Phần tử thứ: %d là : %s",i,str));
        }


    }
}
