package vn.com.t3h.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.model.ProductionModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductionDaoImpl implements ProductionDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductionModel> getProduction() {

        String sql = "select * from production";
        List<ProductionModel> productionModels = jdbcTemplate.query(sql,new RowMapper<ProductionModel>() {

            @Override
            public ProductionModel mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductionModel model = new ProductionModel();
                model.setId(resultSet.getInt("id"));
                model.setTitle(resultSet.getString("title"));
                model.setAuthor(resultSet.getString("author"));
                model.setDescription(resultSet.getString("description"));
                model.setGenre(resultSet.getString("genre"));
                model.setPublisher(resultSet.getString("publisher"));
                model.setPrice(resultSet.getDouble("price"));
                model.setPublicationYear(resultSet.getInt("publication_year"));
                model.setPageCount(resultSet.getInt("page_count"));
                model.setDiscountPercent(resultSet.getDouble("discount_percent"));
                model.setStockQuantity(resultSet.getInt("stock_quantity"));
                model.setCategory(resultSet.getString("category"));
                return model;
            }
        });

        return productionModels;
    }

    @Override
    public ProductionModel findById(Integer id) {

        String sql = "select * from production where id = " + id;
        ProductionModel productionModel = jdbcTemplate.query(sql, new ResultSetExtractor<ProductionModel>() {
            @Override
            public ProductionModel extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                // b5. tại dao convert dữ liệu dạng ResultSet sang dạng object class Java
                ProductionModel model = new ProductionModel();
                if (resultSet.next()){
                    model.setId(resultSet.getInt("id"));
                    model.setTitle(resultSet.getString("title"));
                    model.setAuthor(resultSet.getString("author"));
                    model.setDescription(resultSet.getString("description"));
                    model.setGenre(resultSet.getString("genre"));
                    model.setPublisher(resultSet.getString("publisher"));
                    model.setPrice(resultSet.getDouble("price"));
                    model.setPublicationYear(resultSet.getInt("publication_year"));
                    model.setPageCount(resultSet.getInt("page_count"));
                    model.setDiscountPercent(resultSet.getDouble("discount_percent"));
                    model.setStockQuantity(resultSet.getInt("stock_quantity"));
                    model.setCategory(resultSet.getString("category"));
                }

                return model;
            }
        });
        return productionModel;
    }
}
