package buoi9;

import java.io.IOException;
import java.util.Scanner;

/*
Nhập vào tuổi, nếu tuổi < 0
=> bắt ra lỗi RuntimeException
 */
public class Demo2 {

    public static void main(String[] args) {

        try {
            int tuoi = nhapTuoi3();
            System.out.println("Tuoi: " + tuoi);
        }catch (AgeException e){
            System.out.println(e.getMessage());
        }
    }

    public static int nhapTuoi(){
        System.out.println("Nhap Tuoi");
        int tuoi = new Scanner(System.in).nextInt();
        if (tuoi < 0){
            throw new RuntimeException("Tuoi phai > 0");
        }
        return tuoi;
    }

    public static int nhapTuoi2() throws IOException{
        System.out.println("Nhap Tuoi");
        int tuoi = new Scanner(System.in).nextInt();
        if (tuoi < 0){
            throw new IOException("Tuoi phai > 0");
        }
        return tuoi;
    }

    public static int nhapTuoi3() throws AgeException{
        System.out.println("Nhap Tuoi");
        int tuoi = new Scanner(System.in).nextInt();
        if (tuoi < 0){
            throw new AgeException("Tuoi phai > 0");
        }
        return tuoi;
    }
}
