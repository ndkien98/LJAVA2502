package buoi16.dao;

import buoi16.model.ProductionDetailModel;
import buoi16.model.ProductionModel;

import java.util.List;

public interface ProductionDao {

    public void showAllProductions();

    public List<ProductionModel> getProductions();

    public List<ProductionDetailModel> getProductionDetails(List<Integer> idsProduction);
}
