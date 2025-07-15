package viettel;

import java.util.Scanner;

public class ExamA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 1000){
            System.out.println("Error");
            return;
        }
        StringBuilder s = new StringBuilder();
        int i = 1;
        while (s.length() < n) {
            s.append(i);
            i++;
        }
        System.out.println("Data: " + s);
        char result = s.charAt(n - 1);
        System.out.println("Result: " + result);
    }
}
