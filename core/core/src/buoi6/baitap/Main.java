package buoi6.baitap;

public class Main {

    public static void main(String[] args) {

        PhanSo phanSo1 = new PhanSo();
        PhanSo phanSo2 = new PhanSo();
        phanSo1.setTuSo(5);
        phanSo1.setMauSo(4);
        phanSo1.hienThi();

        phanSo2.setTuSo(1);
        phanSo2.setMauSo(2);
        phanSo2.hienThi();
        /*
        5/4 + 1/2 =
         */
        phanSo1.congPhanSo(phanSo2);
        phanSo1.hienThi();
        reset(phanSo1, phanSo2);

        phanSo1.truPhanSo(phanSo2);
        phanSo1.hienThi();
        reset(phanSo1, phanSo2);

        phanSo1.nhanPhanSo(phanSo2);
        phanSo1.hienThi();
        reset(phanSo1, phanSo2);

        phanSo1.chiaHaiPhanSo(phanSo2);
        phanSo1.hienThi();
        reset(phanSo1, phanSo2);


    }

    private static void reset(PhanSo phanSo1, PhanSo phanSo2) {
        phanSo1.setTuSo(5);
        phanSo1.setMauSo(4);
        phanSo2.setTuSo(1);
        phanSo2.setMauSo(2);
    }
}
