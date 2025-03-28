package buoi11;

import java.util.Scanner;

public class Utils {

    private static Utils instance = null;

    //b1 private constructor để không cho tạo ra các object khác
    private Utils(){
    }

    // b2 tạo ra method static để trả về 1 object instance duy nhất
    public static Utils getInstance(){
        if (instance == null){
            instance = new Utils();
        }
        return instance;
    }

    public int nhapN(){
        int n = 0;
        do {
            System.out.println("Nhap vao n: ");
            n = new Scanner(System.in).nextInt();
            if (n < 0){
                System.out.println("N phai > 0");
            }
        }while (n < 0);
        return n;
    }
}
