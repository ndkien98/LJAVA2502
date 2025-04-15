package buoi15;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    Bai toan:
        lấy được danh sách sản phẩm từ mysql lên java
     bài làm:
        b1: tạo connection
        b2: tạo ra câu sql select * from production
        b3: gửi câu sql đến database, query lay ra dữ liệu, Nhan dữ lieu dạng ResultSet
        b4: convert dữ liệu dạng resultSet thành class java
        b5: Hiển thị dữ liệu tử class Java
     */
    public static void main(String[] args) {
        System.out.println("b1: tạo connection");
        /*
        b1: tạo connection
            username,
            password,
            database,
            url
            driver name
         */

        String url = "jdbc:mysql://localhost:3306/antino";
        String username = "root";
        String password = "root";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);

            System.out.println("b2: tạo ra câu sql select * from production");
            String sql = "select * from production";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("b3: gửi câu sql đến database, query lay ra dữ liệu, Nhan dữ lieu dạng ResultSet");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("b4: convert dữ liệu dạng resultSet thành class java");
            List<Production> productionsResult = new ArrayList<Production>();
            int count = 1;
            while (resultSet.next()) { // resultSet.next() vẫn còn bản ghi tiếp theo để đọc
                System.out.println("Đọc dữ liệu bản ghi thứ " + count);
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                Integer total = resultSet.getInt("total");
                System.out.println("Set dữ liệu vào class ");
                Production production = new Production();
                production.setId(id);
                production.setName(name);
                production.setPrice(price);
                production.setDescription(description);
                production.setTotal(total);
                System.out.println("Lưu production vào danh sách kết quả " + count);
                productionsResult.add(production);
                count++;
            }

            System.out.println("B5: Hiển thị ra dữ liệu vua đọc được từ database ");
            productionsResult.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return;
        }


    }
}
