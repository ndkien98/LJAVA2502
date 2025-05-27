package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.model.response.PageResponse;
import vn.com.t3h.service.ProductionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    @Qualifier("productionHibernateDaoImpl")
    private ProductionDao productionDao;


    @Override
    public PageResponse<List<ProductionEntity>> getProductionPaging(Long pageIndex, Long pageSize) {

        // query lấy ra tổng số phần tử
        Long totalProduction = productionDao.countProduction();
        // tính tổng số page
        Long totalPage = totalProduction / pageSize;
        if (totalProduction % pageSize > 0) {
            totalPage++;
        }
        // tính offset
        Long offset = (pageIndex - 1) * pageSize;
        // query lấy ra data trong page
        List<ProductionEntity> productionEntities = productionDao.findProductionPaging(pageSize, offset);

        PageResponse<List<ProductionEntity>> pageResponse = new PageResponse<>();
        pageResponse.setMessage("Success");
        pageResponse.setCode(HttpStatus.OK.name());
        pageResponse.setData(productionEntities);
        pageResponse.setPageIndex(pageIndex);
        pageResponse.setPageSize(pageSize);
        pageResponse.setTotalPages(totalPage);
        pageResponse.setTotalElements(totalProduction);
        return pageResponse;
    }

    @Override
    public List<ProductionEntity> getProductions() {
        return productionDao.getProduction();
    }

    @Override
    public ProductionEntity findById(Integer id) {
        return productionDao.findById(id);
    }


}
