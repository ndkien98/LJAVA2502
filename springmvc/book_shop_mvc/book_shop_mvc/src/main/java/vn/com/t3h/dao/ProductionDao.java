package vn.com.t3h.dao;

import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;

import java.util.List;

public interface ProductionDao {

    public List<ProductionEntity> getProduction();

    ProductionEntity findById(Integer id);
}
