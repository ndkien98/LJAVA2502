package vn.com.t3h.service;

import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.model.response.PageResponse;

import java.util.List;

public interface ProductionService {

    public PageResponse<List<ProductionEntity>> getProductionPaging(Long pageIndex, Long pageSize);

    public List<ProductionEntity> getProductions();

    ProductionEntity findById(Integer id);
}
