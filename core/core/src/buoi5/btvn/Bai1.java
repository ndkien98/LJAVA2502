package buoi5.btvn;

/**

 */
public class Bai1 {

    public static void main(String[] args) {

        String data = "Tôi Học lập trình, học lập trình rất hay!, hay hay";
        // chuẩn hóa lọc bỏ hết các ký tự đặc biệt tồn tại trong chuỗi, sử dụng method replaceAll()
//        data = data.replaceAll(",","").replaceAll("!","").replaceAll("\\.","");
        String[] danhSachKyTuDacBiet = {"\\.",":","!","-",","};
        data = chuanHoaChuoi(data,danhSachKyTuDacBiet);

        // biến string thành mảng sử dụng hàm split, cắt bỏ toàn bộ khoảng trắng hở giữa các chữ cái
        String[] arrayData = data.split(" ");

        for (int i = 0; i < arrayData.length; i++) {
            String chuoiCanDem = arrayData[i];
            // kiểm tra xem chuỗi đã được đếm chưa, kiểm tra từ đầu chuỗi (index =0) đến trước vị trí hiện tại(index = i - 1)
            // nếu đã tồn tại 1 chuỗi tượng tự chuỗi chuoiCanDem => chuoiCanDem đã được đếm 1 lần, ví dụ lập
            boolean chuoiDaDuocKiemTra = false;
            for (int j = 0; j < i; j++) {
                String chuoiDaDuocDem = arrayData[j];
                if (chuoiCanDem.equalsIgnoreCase(chuoiDaDuocDem)) {
                    chuoiDaDuocKiemTra = true;
                    break;
                }
            }
            // nếu thật sự chuỗi chuoiCanDem đax được kiểm tra rồi => bỏ qua không đếm chuỗi này nữa
            if (chuoiDaDuocKiemTra){
                continue;
            }

            int demSoLanXuatHien = 0;
            for (int j = i; j < arrayData.length; j++) {
                String chuoiCuaMang = arrayData[j];
                if (chuoiCanDem.equalsIgnoreCase(chuoiCuaMang)){
                    demSoLanXuatHien++;
                }
            }
            System.out.println("Chuỗi |" + chuoiCanDem + "| xuất hiện: |" + demSoLanXuatHien);

        }
    }

    public static String chuanHoaChuoi(String data,String[] danhSachKyTuDacBiet){
        for (int i = 0; i < danhSachKyTuDacBiet.length; i++) {
            String kyTuDacBiet = danhSachKyTuDacBiet[i];
            if (!data.contains(kyTuDacBiet)){
                continue;
            }
            data = data.replaceAll(kyTuDacBiet,"");
        }
        return data;
    }
}
