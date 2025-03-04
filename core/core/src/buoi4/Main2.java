package buoi4;

/*

 */
public class Main2 {

    public static void main(String[] args) {

        // cách tạo ra String
        // c1: khai báo kiểu nguyên thủy literal
        String name = "Java";
        // c2: Khai báo theo kiểu đối tượng
        String name2 = new String("Java");

        String name3 = "Java";

        String name4 = new String("Java");

        name3 = "Java0001";

        /**
        - Đặc điểm String:
            + bất biến: không thể thay đổi được 1 string đã được tạo ra, nếu muốn thay đổi
                        Java sẽ tạo ra 1 String khác, chứ không thay đổi trên chính String đã
                        được tạo ra
            + xử lý String tương tự như mảng các ký tự
                Java < => [J][a][v][a]
            + Chỉ tồn tại duy nhất 1 String trong String pool
        - Nơi Lưu trữ String:
            + nếu khai báo kiểu literal thì String sẽ được lưu trữ trong String pool,
                String pool là 1 vùng nhớ nhỏ nằm trong heap, chuyên được sử dụng để lưu trữ
                các biến String được khai báo kiểu literal
            + nếu khai baos kiểu đối tượng bằng từ khóa new => String sẽ được lưu tại heap
            như 1 object thông thường
         - So sánh 2 String
            + (==) hoặc (equal), áp dụng cho các biến kiểu dối tượng, không áp dụng cho các biến nguyên thủy
            + so sánh (==)
                - so sánh địa chỉ ô nhớ của 2 biến
            + so sánh equal
                + so sánh giá trị của 2 biến
         */

        String name5 = "T3h";
        String name6 = new String("T3h");
        String name7 = "T3h";
        String name8 = new String("T3h");
        String name9 = name6;

        System.out.println(name5 == name6); // false
        System.out.println(name5.equals(name6)); // true
        System.out.println(name5 == name7); // true
        System.out.println(name8.equals(name6)); // true
        System.out.println(name8 == name6);// false
        System.out.println(name9 == name6); // true

        StringBuilder stringBuilder = new StringBuilder("T3h");
        stringBuilder.append("Java");

        StringBuffer stringBuffer = new StringBuffer("Java");
        stringBuffer.append("Java");

        System.out.println(stringBuilder.toString());
        char[] string = new char[10];

    }
}
