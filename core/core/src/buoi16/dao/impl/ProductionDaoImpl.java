package buoi16.dao.impl;

import buoi16.dao.Datasource;
import buoi16.dao.ProductionDao;
import buoi16.model.ProductionDetailModel;
import buoi16.model.ProductionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductionDaoImpl implements ProductionDao {

    /*
    get list production hiển thị lên tầng console thông tin sản phẩm tuwf databas e
        -  lấy ra được các thông tin
             + ten, giá, danh sách các màu sac, danh sách size, danh sách các ảnh
        - làm thế nào để lấy ra được ?
            b1: tạo model Production, ProductionDetail để hứng dữ liệu từ database trả ra
            b2: lấy ra danh sách production
            b3: lấy ra danh sách id của production tại b2
            b4: dùng danh sách id đó đưa vào câu query
                select production.id,
                       c.name color,
                       s.name size,
                       i.path image,
                       pd.quality
                from production
                left join antino.production_detail pd on production.id = pd.production_id
                left join antino.color c on pd.color_id = c.id
                left join antino.image i on pd.image_id = i.id
                left join antino.size s on pd.size_id = s.id;
            để lấy ra thông tin chi tiết của production
            b5: lọc ra danh sách sản phẩm chi tiết dựa vào id production và ghép vào object production tương ứng
            b6: Hiển thị production kèm danh sách các thông tin chi tiết của sản phẩm
     */
    //  b2: lấy ra danh sách production
    public List<ProductionModel> getProductions() {
        Connection connection = null;
        List<ProductionModel> productionsResult = new ArrayList<ProductionModel>();
        try {
            connection = Datasource.getConnection();
            String sql = "select * from production";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("gửi câu sql đến database, query lay ra dữ liệu, Nhan dữ lieu dạng ResultSet");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("convert dữ liệu dạng resultSet thành class java");
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Datasource.closẹ(connection);
        }
        return productionsResult;
    }

    public List<ProductionDetailModel> getProductionDetails(List<Integer> idsProduction) {
        Connection connection = null;
        List<ProductionDetailModel> detailModels = new ArrayList<>();
        try {
            connection = Datasource.getConnection();
            String sql = "select pd.production_id,\n" +
                    "       c.name color,\n" +
                    "       s.name size,\n" +
                    "       i.path image,\n" +
                    "       pd.quality\n" +
                    "from production_detail pd\n" +
                    "left join antino.color c on pd.color_id = c.id\n" +
                    "left join antino.image i on pd.image_id = i.id\n" +
                    "left join antino.size s on pd.size_id = s.id\n";

            if (idsProduction != null && idsProduction.size() > 0) {
                sql += "where pd.production_id in (";
                for (int i = 0; i < idsProduction.size(); i++) {
                    sql += idsProduction.get(i) + ",";
                }
                sql = sql.substring(0, sql.length() - 1);
                sql += ")";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProductionDetailModel productionDetailModel = new ProductionDetailModel();
                productionDetailModel.setProductionId(resultSet.getInt("production_id"));
                productionDetailModel.setColor(resultSet.getString("color"));
                productionDetailModel.setSize(resultSet.getString("size"));
                productionDetailModel.setImage(resultSet.getString("image"));
                productionDetailModel.setQuality(resultSet.getInt("quality"));
                detailModels.add(productionDetailModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailModels;
    }

    public void showAllProductions() {

        List<ProductionModel> productionModels = getProductions();

        List<Integer> idProduction = productionModels.stream().map(ProductionModel::getId).toList();

        List<ProductionDetailModel> productionDetailModels = getProductionDetails(idProduction);

        for (ProductionModel production : productionModels) {
            List<ProductionDetailModel> productionDetails = productionDetailModels.stream()
                    .filter(data -> data.getProductionId() == production.getId()).toList();
            production.setDetailModels(productionDetails);
        } ;
        for (ProductionModel production : productionModels) {
            System.out.println(production.toString());
        }
    }
}
