package vn.com.t3h.service;

import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;

import java.util.List;

public interface ProductionService {


    public List<ProductionEntity> getProductions();

    ProductionEntity findById(Integer id);
}
