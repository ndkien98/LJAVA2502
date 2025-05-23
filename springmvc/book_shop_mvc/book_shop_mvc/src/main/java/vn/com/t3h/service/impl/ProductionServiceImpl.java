package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.service.ProductionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    @Qualifier("productionHibernateDaoImpl")
    private ProductionDao productionDao;


    @Override
    public List<ProductionEntity> getProductions() {
        return productionDao.getProduction();
    }

    @Override
    public ProductionEntity findById(Integer id) {
        return productionDao.findById(id);
    }


}
