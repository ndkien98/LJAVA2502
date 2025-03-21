package buoi9.checkedexception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            /*
            Có thể gây lỗi FileNotFoundException
            khi không tìm thấy file example.txt
             */
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Đọc file lỗi!");
        }
    }
}
