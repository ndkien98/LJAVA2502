package buoi4.btvn;

import java.util.Scanner;

public class Utils {

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
