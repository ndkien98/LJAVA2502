package buoi8.interfacedemo.demofuntional.ex;

import java.util.Scanner;

/*
Bai 1:
    Tạo 1 funtional interface có phương thức chia 2 số
    , cho người dùng nhập vào 2 số từ màn hình, triển khai interface đấy
    tính thương của 2 số
    triển khai bằng 2 cách:
    c1: sử dụng anonymous class
    c2: sử dụng Lambda expression
 */
public class Main {

    public static void main(String[] args) {

        float soA = new Scanner(System.in).nextFloat();
        float soB = new Scanner(System.in).nextFloat();
        // C1: triển khai thông thường qua class Impl
        IMath math1 = new IMathImpl();
        System.out.println(math1.phepChia(soA,soB));

        // c2: triển khai thông qua anonymous class
        IMath math2 = new IMath() {
            @Override
            public float phepChia(float soA, float soB) {
                return soA / soB;
            }
        };
        System.out.println(math2.phepChia(soA,soB));
        // C3: triển khai bằng lamda
        IMath math3 = (a,b) -> a / b;
        System.out.println(math3.phepChia(soA,soB));
    }
}
