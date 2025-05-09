package vn.com.t3h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.service.ProductionService;
import vn.com.t3h.service.impl.ProductionServiceImpl;

import java.util.List;

@Controller
public class ProductionController {

    /*
    productionService: là dependence của ProductionController
    có 2 hướng dể khởi tạo được đối tượng cho productionService
        1.sử dụng constructor và từ khóa new khởi tạo ngay trong class ProductionController
        vd:
                public ProductionController() {
                    productionService = new ProductionServiceImpl();
                }


        2. Sử dụng cơ DI thay vì khởi tạo trực tiếp đối tượng productionService này trong class ProductionController
        thì sẽ tiêm đối tượng productionService từ ngoài vào trong class ProductionController
        thông qua constructor có tham số hoặc setter

        public void setProductionService(ProductionService productionService) {
            this.productionService = productionService;
        }
        public ProductionController(ProductionService productionService) {
            this.productionService = productionService;
        }
        và spring container đã sử dụng các thứ 2, áp dụng DI để tiêm các dependence cho các class

        tóm lại:
            + bean được tạo ra bằng cơ chế IOC
            + Cơ chế IOC đọc các config trong file spring config bean, hoặc tìm kiếm các class đánh dấu annotaion để khởi tạo object
            thành các bean, để hoàn thiện được việc khởi tạo các bean vì chắc chắn các bean sẽ có các dependence bên trong
            => IOC sử dụng cơ chế DI để tiêm các dependence cho các bean


     */
    @Autowired
    private ProductionService productionService;

    @GetMapping("/production-detail")
    public String productionDetail(Model model) {
        List<ProductionModel> productionModels = productionService.getProductions();
        model.addAttribute("models", productionModels);
        return "production-detail";
    }
}
