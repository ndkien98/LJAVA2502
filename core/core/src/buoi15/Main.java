package buoi15;

import buoi16.model.ProductionModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            List<ProductionModel> productionsResult = new ArrayList<ProductionModel>();
            int count = 1;
            while (resultSet.next()) { // resultSet.next() vẫn còn bản ghi tiếp theo để đọc
                System.out.println("Đọc dữ liệu bản ghi thứ " + count);
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                Integer total = resultSet.getInt("total");
                System.out.println("Set dữ liệu vào class ");
                ProductionModel productionModel = new ProductionModel();
                productionModel.setId(id);
                productionModel.setName(name);
                productionModel.setPrice(price);
                productionModel.setDescription(description);
                productionModel.setTotal(total);
                System.out.println("Lưu production vào danh sách kết quả " + count);
                productionsResult.add(productionModel);
                count++;
            }

            System.out.println("B5: Hiển thị ra dữ liệu vua đọc được từ database ");
            productionsResult.forEach(System.out::println);
            List<Integer> idProduction = productionsResult.stream().map(ProductionModel::getId).collect(Collectors.toList());
            System.out.println("lấy thông tin detail");
            String sqlDetail = "select production_detail.production_id,color.name,size.name,image.path from production_detail\n" +
                    "inner join color on production_detail.color_id = color.id\n" +
                    "inner join size on production_detail.size_id = size.id\n" +
                    "inner join image on production_detail.image_id = image.id\n" +
                    "where production_id in (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDetail);
            System.out.println("Set value to where condition with index ?,?");
            for (int i = 0; i < idProduction.size(); i++) {
                preparedStatement.setInt(i + 1, idProduction.get(i));
            }
            ResultSet resultSetDetail = preparedStatement.executeQuery();
            while (resultSetDetail.next()) {
                System.out.println(resultSetDetail.getString("production_detail.production_id"));
                System.out.println(resultSetDetail.getString("color.name"));
                System.out.println(resultSetDetail.getString("size.name"));
                System.out.println(resultSetDetail.getString("image.path"));
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return;
        }


    }
}
