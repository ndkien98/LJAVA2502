package buoi4.bt;

import java.util.Scanner;

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
public class Bai1 {

    public static void main(String[] args) {

        // người dùng muốn nhập vào bao nhiêu số tự nhiên
        System.out.println("Nhập vào số lượng số nguyên dương: ");
        int n = new Scanner(System.in).nextInt();
        //Khơi tạo 1 array với số lượng ô nhớ bằng đúng số lượng số tự nhiên mà người dùng muốn nhập
        int[] arrayNumber = new int[n];
        // duyệt mảng để user nhập vào giá trị của các ô nhớ, là danh sách số nguyên
        for(int i = 0;i< arrayNumber.length;i++){
            System.out.println("Nhập vào giá trị của phần thứ: " + i);
            int number = new Scanner(System.in).nextInt();
            // gán giá trị user nhập vào cho array cho vị trí tại index thứ i
            arrayNumber[i] = number;
        }

        hienThi(arrayNumber);

        int tong = tinhTong(arrayNumber);
        System.out.println("Tổng các số: " + tong);
        int soLonNhat = timSoLonNhat(arrayNumber);
        System.out.println("Số lớn nhất: " + soLonNhat);
        int soNhoNhat = timSoNhoNhat(arrayNumber);
        System.out.println("Số nhỏ nhất: " + soNhoNhat);
    }

    public static int timSoNhoNhat(int[] arrayNumber){
        int soNhoNhat = arrayNumber[0];
        for(int i = 1;i< arrayNumber.length;i++){
            // lấy ra giá trị phần tử thứ i của mảng
            int giaTriPhanTuThuI  = arrayNumber[i];
            // so sánh giá trị tại từng phần tử với giá trị min
            if(giaTriPhanTuThuI < soNhoNhat){
                // nếu giá trị tại phần tử đấy < phần tử min => gán giaTriPhanTuThuI làm giá trị min cho soNhoNhat
                soNhoNhat = giaTriPhanTuThuI;
            }
        }
        return soNhoNhat;
    }

    public static int timSoLonNhat(int[] arrayNumber){
        int soLonNhat = 0;
        for(int i = 0;i< arrayNumber.length;i++){
            // lấy ra giá trị phần tử thứ i của mảng
            int giaTriPhanTuThuI  = arrayNumber[i];
            // so sánh giá trị tại từng phần tử với giá trị lớn nhất
            if(giaTriPhanTuThuI > soLonNhat){
                // nếu giá trị tại phần tử đấy > phần tử max => gán nó làm giá trị max
                soLonNhat = giaTriPhanTuThuI;
            }
        }
        return soLonNhat;
    }

    public static int tinhTong(int[] arrayNumber){
        int tong = 0;
        for(int i = 0;i< arrayNumber.length;i++){
            // lấy ra giá trị phần tử có index thứ i của mảng
            int giaTriPhanTu = arrayNumber[i];
            // cộng giá trị đó vào tổng
            tong = tong + giaTriPhanTu;
        }
        return tong;
    }
    public static void hienThi(int[] arrayNumber){
        System.out.println("Hiển thị danh sách số vừa nhập: ");
        for(int i = 0;i< arrayNumber.length;i++){
            int phanTuCuaMang = arrayNumber[i];
            System.out.println("Phần tử tại index số " + i + " là: " + phanTuCuaMang);
        }
    }
}
