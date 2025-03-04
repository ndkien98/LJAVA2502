package buoi3.btvn;

import java.util.Scanner;

/*
Bài 3
Viết chương trình nhập vào số điện sử dụng của tháng và tính tiền điện theo phương pháp lũy tiến
ü Nếu số điện sử dụng từ 0 đến 50 thì giá mỗi số điện là 1000
ü Nếu số điện sử dụng trên 50 thì giá mỗi số điện vượt hạn mức là 1200
Bậc 1: Cho kWh từ 0 - 50 1.678
Bậc 2: Cho kWh từ 51 - 100 1.734
Bậc 3: Cho kWh từ 101 - 200 2.014
Bậc 4: Cho kWh từ 201 - 300 2.536
Bậc 5: Cho kWh từ 301 - 400 2.834
Bậc 6: Cho kWh từ 401 trở lên 2.927
Ví dụ:
40 số: 1.678 x 40 số điện
60 sô: 1.678 x 50 + 10 x 1_734 số điện
110 số: 1.678 x 50 + 50 x 1.734 + 10 x 2.014 số điệ
 */
public class Bai3 {
    public static void main(String[] args) {

        System.out.println("Nhập vào số điện sử dụng: ");
        int soDien = new Scanner(System.in).nextInt();
        int tienDien = 0;
        if (soDien <= 0){
            System.out.println("Số điện không hợp lệ");
            return;
        }
        if (soDien <= 50){
            tienDien = 1678 * soDien;
        }else if (soDien <= 100){
            tienDien = (1678 * 50) + (soDien - 50) * 1734;
        }else if (soDien <= 200){
            tienDien = (1678 * 50) + (50 * 1734) + (soDien - 100) * 2014;
        }else if (soDien <= 300){
            tienDien = (1678 * 50) + (50 * 1734) + 100 * 2014 + (soDien - 200) * 2536;
        }else if (soDien <= 400){
            tienDien = (1678 * 50) + (50 * 1734) + 100 * 2014 + 100 * 2536 + (soDien - 300) * 2834;
        }else {
            tienDien = (1678 * 50) + (50 * 1734) + 100 * 2014 + 100 * 2536 + 100 * 2834 + (soDien - 400) * 2927;
        }
        System.out.println("Tiền điện là: " + tienDien);
    }
}
