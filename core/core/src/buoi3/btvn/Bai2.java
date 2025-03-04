package buoi3.btvn;

import java.util.Scanner;

/**
 Bài 2

 Nhập vào chương trình 2 số nguyên dương a,b,c
 In ra màn hình kết luận về tam giác có 3 cạnh trên
 (tam giác thường: tổng 2 cajnh còn lại
 tam giác vuông: a^2 + c^2 = b^2 | c^2 + b^2 = c^2 | b^2 + c^2 = a^2 (2)
 tam giác cân: 2 trong 3 cạnh bằng nhau ( a = b | a = c | c = b ) (3)
 tam giác vuông cân: (2) và (3) == true => đây là vuông cân
 tam giác đều: tam giác đều
 hoặc không phải tam giác) :
 */
public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a: ");
        int a = scanner.nextInt();
        System.out.println("Nhập cạnh b: ");
        int b = scanner.nextInt();
        System.out.println("Nhập cạnh c: ");
        int c = scanner.nextInt();
        if (!((a + b > c) && (a + c > b) && (b + c > a))){
            System.out.println("đây không phải tam giác");
            return;
        }
        if ((a == b) && (b == c)){
            System.out.println("Tam giác đều");
        }else if(tamGiacCan(a,b,c) && tamGiacVuong(a,b,c)){
            System.out.println("Tam giác vuông cân");
        }else if (tamGiacCan(a,b,c)){
            System.out.println("Tam giác cân");
        }else if (tamGiacVuong(a,b,c)){
            System.out.println("Tam giác vuông");
        }else{
            System.out.println("Đây là tam giác thường");
        }

    }

    public static boolean tamGiacCan(int a,int b, int c){
        return (a == b) || (a == c) || (b == c);
    }
    public static boolean tamGiacVuong(int a,int b,int c){
        return (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);
    }
}
