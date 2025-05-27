package vn.com.t3h.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("productionJdbcDaoImpl")
public class ProductionJdbcDaoImpl implements ProductionDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductionEntity> getProduction() {

        String sql = "select * from production";
        List<ProductionEntity> productionModels = jdbcTemplate.query(sql,new RowMapper<ProductionEntity>() {

            @Override
            public ProductionEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductionEntity model = new ProductionEntity();
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
//                model.setCategory(resultSet.getString("category"));
                return model;
            }
        });

        return productionModels;
    }

    @Override
    public ProductionEntity findById(Integer id) {

        String sql = "select * from production where id = " + id;
        ProductionEntity productionModel = jdbcTemplate.query(sql, new ResultSetExtractor<ProductionEntity>() {
            @Override
            public ProductionEntity extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                // b5. tại dao convert dữ liệu dạng ResultSet sang dạng object class Java
                ProductionEntity model = new ProductionEntity();
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
//                    model.setCategory(resultSet.getString("category"));
                }

                return model;
            }
        });
        return productionModel;
    }

    @Override
    public List<ProductionEntity> findProductionPaging(Long limit, Long offset) {
        return null;
    }

    @Override
    public Long countProduction() {
        return 0l;
    }
}
