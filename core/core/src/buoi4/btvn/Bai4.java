package buoi4.btvn;

public class Bai4 {

    public static void main(String[] args) {

        int tong = 200000;
        int menhGia1 = 1000;
        int menhGia2 = 2000;
        int menhGia3 = 5000;

        int tongSoToMenhGia1 = tong / menhGia1;
        int tongSoToMenhGia2 = tong / menhGia2;
        int tongSoToMenhGia3 = tong / menhGia3;

        int soToMenhGia1 = 0;
        int soToMenhGia2 = 0;
        int soToMenhGia3 = 0;
        int tongTienManhGia1 = 0;
        int tongTienManhGia2 = 0;
        int tongTienManhGia3 = 0;
        for (int i = 1; i <= tongSoToMenhGia1; i++) {
            soToMenhGia1 = i;
            for (int j = 1; j <= tongSoToMenhGia2; j++) {
                soToMenhGia2 = j;
                for (int k = 1; k <= tongSoToMenhGia3; k++) {
                    soToMenhGia3 = k;

                    tongTienManhGia1 = soToMenhGia1 * menhGia1;
                    tongTienManhGia2 = soToMenhGia2 * menhGia2;
                    tongTienManhGia3 = soToMenhGia3 * menhGia3;

                    if (tong == (tongTienManhGia1 + tongTienManhGia2 + tongTienManhGia3)) {
                        System.out.println(String.format("Số tờ 1000= %d , số tờ 2000 = %d, số tờ 5000 = %d",soToMenhGia1,soToMenhGia2,soToMenhGia3));
                    }
                }
            }

        }

    }
}
