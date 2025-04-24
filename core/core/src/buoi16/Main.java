package buoi16;

import buoi16.dao.ProductionDao;
import buoi16.dao.impl.ProductionDaoImpl;

public class Main {

    public static void main(String[] args) {
        ProductionDao productionDao = new ProductionDaoImpl();
        productionDao.showAllProductions();
    }
}
