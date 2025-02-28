package buoi3.btvn;

import java.util.Scanner;

/**
 Bài 1
 Viết chương trình Java tính điểm của sinh viên.
 Chương trình này sẽ đọc vào các loại điểm của sinh viên
 (điểm chuyên cần, điểm giữa kỳ, và điểm cuối kỳ) và xếp loại điểm theo quy luật sau:
 – if điểm trung bình >=9 =>loại=A
 – if điểm trung bình >= 7 và <9 => loại=B
 – if điểm trung bình>=5 and <7 =>loại=C
 – if điểm trung bình<5 =>loại=D
 */
public class Bai1 {

    public static void main(String[] args) {
        System.out.println("Nhap vào điểm chuyên cần: ");
        int chuyenCan = new Scanner(System.in).nextInt();
        System.out.println("Nhập vào điểm giữa kỳ: ");
        int giuaKy = new Scanner(System.in).nextInt();
        System.out.println("Nhập vào điểm cuối kỳ: ");
        int cuoiKy = new Scanner(System.in).nextInt();
        int diemTrungBinh = tinhSoDiem(chuyenCan, giuaKy, cuoiKy);
        if (diemTrungBinh >= 9){
            System.out.println("Điểm A");
        }else if (diemTrungBinh >= 7){
            System.out.println("Điểm B");
        }else if (diemTrungBinh >= 5){
            System.out.println("Điểm C");
        }else {
            System.out.println("Điểm D");
        }

    }

    private static int tinhSoDiem(int chuyenCan, int giuaKy, int cuoiKy) {
        int diemTrungBinh = (chuyenCan + giuaKy + cuoiKy) / 3;
       return diemTrungBinh;
    }
}
