package buoi4.btvn;
/*
Cách tính gia thừa của số n = n * (n - 1) * (n - 2) * (n - 3) * .... * 1;
 */
public class Bai3 {

    public static void main(String[] args) {

        int n = Utils.nhapN();
        System.out.println("tinhGiaThuaC1(n): " + tinhGiaThuaC1(n));
        System.out.println("tinhGiaThuaC2(n): " + tinhGiaThuaC2(n));

    }

    private static int tinhGiaThuaC2(int n) {
            if (n == 1 || n == 0){
                return 1;
            }
        return n * tinhGiaThuaC2(n - 1);
    }

    private static int tinhGiaThuaC1(int n) {
        int giaiThua = 1;
        for (int i = n; i >= 1; i--) {
            giaiThua = giaiThua * i;
        }
        return giaiThua;
    }
}
