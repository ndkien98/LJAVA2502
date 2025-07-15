package viettel;

import java.util.Scanner;

public class ExamB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long count = 0;
        while (b != 0) {
            count += a / b;
            long temp = a % b;
            a = b;
            b = temp;
        }
        System.out.println(count);
    }
}
