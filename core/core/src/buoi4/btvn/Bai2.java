package buoi4.btvn;

import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {

        int number = 0;
        System.out.println("Nhap so nguyen tu ban phim: ");
        number = new Scanner(System.in).nextInt();
        int reverse = 0;
        int digit = 0;
        while (number != 0) {
            digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        System.out.println(reverse);
    }
}
