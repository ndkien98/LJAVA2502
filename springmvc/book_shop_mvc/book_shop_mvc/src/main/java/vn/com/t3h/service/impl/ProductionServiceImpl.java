package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductionDao;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.service.ProductionService;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDao productionDao;


    @Override
    public List<ProductionModel> getProductions() {
        return productionDao.getProduction();
    }
}
