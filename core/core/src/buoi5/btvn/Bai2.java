package buoi5.btvn;

/**
 Mô tả bài toán:
 Viết hàm kiểm tra một chuỗi nhập vào có phải là số điện thoại hợp lệ hay không?
 Điều kiện:
 •	Số điện thoại có 9 chữ số (không bao gồm số 0 ở đầu).
 •	Có thể có ký tự như "-" hoặc ".".
 •	Các dạng hợp lệ:
     o	+84xxxxxxxxx
     o	0xxxxxxxxx
     o	84xxxxxxxxx
     o	0xxx.xxx.xxx
     o	0xxx-xxx-xxx
 Test case:
 Test case 1:
 •	Đầu vào: "+84912345678"
 •	Kết quả: Hợp lệ
 Test case 2:
 •	Đầu vào: "091-234-5678"
 •	Kết quả: Hợp lệ
 Test case 3:
 •	Đầu vào: "8481234567"
 •	Kết quả: Không hợp lệ
 Test case 4:
 •	Đầu vào: "0912.345.678"
 •	Kết quả: Hợp lệ
 Test case 5:
 •	Đầu vào: "0123456789"
 •	Kết quả: Hợp lệ
 Test case 6:
 •	Đầu vào: "0841234"
 •	Kết quả: Không hợp lệ

 */
public class Bai2 {
    public static void main(String[] args) {

        String[] data = {"+84912345678","091-234-5678","8481234567","0912.345.678","0841234","0912.345.aaa"};
        for (int i = 0; i < data.length; i++) {
            soDienThoaiHopLe(data[i]);
        }
    }

    public static void soDienThoaiHopLe(String soDienThoai){
        // B1: kiếm tra chuỗi có bắt đầu bằng +84,0,84 không
        System.out.println("Bắt đầu kiểm tra số điện thoại: " + soDienThoai);
        String[] danhSachKyTuBatDau = {"+84","0","84"};
        boolean kyTuBatDauHopLe = false;
        String kyTuBatDauCuaSdt = "";
        for (int i = 0; i < danhSachKyTuBatDau.length; i++) {
            String kyTuBatDau = danhSachKyTuBatDau[i];
            if (soDienThoai.startsWith(kyTuBatDau)){
                kyTuBatDauHopLe = true;
                kyTuBatDauCuaSdt = kyTuBatDau;
                break;
            }

        }
        // nếu ký tự bắt đầu không hợp lệ => kết thúc
        if (!kyTuBatDauHopLe){
            System.out.println("Số điện thoại phải bắt đầu bằng \"+84\",\"0\",\"84\"");
            return;
        }
        // B2: loại bỏ ký tự "-"m "." trong chuỗi
        soDienThoai = soDienThoai.replaceAll("-","").replaceAll("\\.","");
        // B3: đếm xem ngoại trừ các ký tự +84,0,84 thì text còn lại có mấy ký tự
        soDienThoai = soDienThoai.substring(kyTuBatDauCuaSdt.length(),soDienThoai.length());
        if (soDienThoai.length() != 9){
            System.out.println("Số điện thoại phải có 9 chữ số");
            return;
        }
        // b4: kiểm tra các text còn lại xem có phải là số hay không
        for (int i = 0; i < soDienThoai.length(); i++) {
            char data = soDienThoai.charAt(i);
            // Biến chuỗi thành số
            try {
                Integer.parseInt(String.valueOf(data));
            }catch (NumberFormatException e){
                System.out.println("Tồn tại 1 ký tự không phải là số");
                return;
            }
        }
        System.out.println("Số điện thoại hợp lệ");
        return;

    }
}
