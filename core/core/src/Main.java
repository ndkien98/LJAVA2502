import buoi2.Person;

import java.util.Scanner;
/**
 Bai 1:
 Tính S(n) = 1^3 + 2^3 + 3^3 + … + n^3  n nhập từ bàn phím
 Nhập n từ bàn phím (n dương, bắt nhập lại nếu n âm)
 và in ra màn hình dãy S(n)

 bai 2) Viết lại chữ số đảo ngược
 Ví dụ nhập vào số 1357 thì in ra số đảo ngược là 7531
 (Không sử dụng nhập vào chuỗi số là String)

 bài 3) nhập vào n, tính giai thừa của n
 n! = n * (n-1) * (n-2) * ... * 1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập vào số câu chào: ");
        int n = new Scanner(System.in).nextInt();
        // ieetst trước số lần lặp
        for(int i = 0; i <n;i++){
            System.out.println("Xin chào");
        }
        System.out.println("Kết thúc");
        int j = 0;
        while (j < n){
            System.out.println("Xin chào while");

            j++;
        }
        /*
        chỉ k = số chẵn mới in ra, còn số lẻ không in ra
        và chỉ cho phép chào max 5 câu

         */
        int k = 0;
        do {
            k++;
            if (k == 5){
                break;
            }
            if (k % 2 != 0){
                continue;
            }
            System.out.println("Xin chào do while");
        }while (k < n);
    }
}