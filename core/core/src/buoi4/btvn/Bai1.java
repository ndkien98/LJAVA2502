package buoi4.btvn;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int n = Utils.nhapN();
        Long tong = tinhTongLapPhuong(n);
        System.out.println("Tong lap phuong: " + tong);
    }

    public static long tinhTongLapPhuong(int n){
        long tong = 0;
        for(int i = 1; i <= n; i++){
            tong += Math.pow(i,3);
        }
        return tong;
    }
}
