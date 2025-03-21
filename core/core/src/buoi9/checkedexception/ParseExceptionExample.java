package buoi9.checkedexception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseExceptionExample {
    public static void main(String[] args) {
        String dateStr = "2025-03-19"; // Định dạng ngày sai: Năm-tháng-ngày
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày đúng: ngày/tháng/năm
        try {
            // Cố gắng phân tích chuỗi thành đối tượng Date theo định dạng sai
            Date date = sdf.parse(dateStr); // Lỗi xảy ra tại đây nếu chuỗi không khớp định dạng
            System.out.println("Ngày hợp lệ: " + date);
        } catch (ParseException e) {
            System.out.println("Lỗi phân tích chuỗi ngày: " + e.getMessage());
        }
    }
}

