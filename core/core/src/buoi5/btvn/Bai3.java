package buoi5.btvn;

public class Bai3 {

    // là biến globe để tất cả các hàm trong class đều có thể sử dụng, thay đổi được value
    public static int soLuongPhanTuCuaMangHienTai;

    public static void main(String[] args) {
//        int[] mangSoNguyen =  {0,9,2,5,3,4,3,7,7,2};
        int[] mangSoNguyen =  {1,2,3,4,5,6,7,8};
        // khởi tạo số lượng phần từ của mảng
        soLuongPhanTuCuaMangHienTai = mangSoNguyen.length;

        int soXoa = 3;
        xoaPhanTuCuaMang(mangSoNguyen, soXoa);
        hienThiMang(mangSoNguyen);
        themPhanTuVaoMang(mangSoNguyen,4,3);
        hienThiMang(mangSoNguyen);
        sapXepTuLonDenBe(mangSoNguyen);
        hienThiMang(mangSoNguyen);
        daoNguocMang(mangSoNguyen);
    }

    public static void daoNguocMang(int[] mangSoNguyen){
        for (int i = soLuongPhanTuCuaMangHienTai - 1; i  >= 0; i--) {
            System.out.print( " " + mangSoNguyen[i]);
        }
    }

    public static void sapXepTuLonDenBe(int[] mangSoNguyen){
        for (int i = 0; i < soLuongPhanTuCuaMangHienTai; i++) {
            for (int j = i; j < soLuongPhanTuCuaMangHienTai; j++) {
                if (mangSoNguyen[i] < mangSoNguyen[j]) {
                    int term = mangSoNguyen[i];
                    mangSoNguyen[i] = mangSoNguyen[j];
                    mangSoNguyen[j] = term;
                }
            }

        }
    }

    public static void themPhanTuVaoMang(int[] mangSoNguyen,int soThem, int viTriThem){
        if (soLuongPhanTuCuaMangHienTai == mangSoNguyen.length){
            System.out.println("Mảng đã đầy, không thể thêm được phần tử, đề nghị xóa bớt");
            return;
        }
        // thêm tiếp 1 ô nhớ để chứa số them vào
        soLuongPhanTuCuaMangHienTai = soLuongPhanTuCuaMangHienTai + 1;
        // duyệt mảng tìm ra vị trí muốn thêm
        for (int i = 0; i < soLuongPhanTuCuaMangHienTai; i++) {
            // nếu i khác ví trí muốn thêm => bỏ qua i
            if (i != viTriThem){
                continue;
            }
            // nếu không vào if ở trên => i chính là vị trí muốn thêm
            // duyệt mảng để lùi tất cả các phần tử phía sau i
            for (int j = soLuongPhanTuCuaMangHienTai - 1; j > i; j--) {
                mangSoNguyen[j] = mangSoNguyen[j - 1];
            }
            // thêm số vào trong vị trí đã chỉ định
            mangSoNguyen[viTriThem] = soThem;
            break;
        }

    }

    private static void xoaPhanTuCuaMang(int[] mangSoNguyen, int soXoa) {
        int soPhanTuDaXoa = 0;
        for (int i = 0; i < soLuongPhanTuCuaMangHienTai; i++) {
            int soNguyen = mangSoNguyen[i];
            // duyệt toàn bộ mảng, tìm danh sách các số trùng với số Xóa
            if (soXoa == soNguyen) {
                // nếu tìm thấy => duyệt từ index i cho đến cuối mảng
                for (int j = i; j < soLuongPhanTuCuaMangHienTai; j++) {
                    if (j == soLuongPhanTuCuaMangHienTai - 1){
                        continue;
                    }
                    // lùi lại 1 số cho tất cả phần tử phía sau số cần xóa
                    mangSoNguyen[j] = mangSoNguyen[j + 1];
                }
                // lùi lại cả index i phục vụ cho trường hợp 2 số cần xóa cạnh nhau
                i--;
                // lưu lại số lượng số đã xóa
                soPhanTuDaXoa++;
            }
        }
        // update lại số lượng phần tử của mảng
        soLuongPhanTuCuaMangHienTai = soLuongPhanTuCuaMangHienTai - soPhanTuDaXoa;
    }

    public static void hienThiMang(int[] arr){
        System.out.println("\nDanh sách phần tử: \n");
        for (int i = 0; i < soLuongPhanTuCuaMangHienTai; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println("\n");
    }
}
