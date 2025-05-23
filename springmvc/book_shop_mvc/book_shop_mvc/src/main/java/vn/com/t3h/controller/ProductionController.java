package vn.com.t3h.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.t3h.entity.ProductionEntity;
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

    /*
        Các bước làm chức năng hiển thị chi tiết 1 sản phẩm
        - dữ liệu đang nằm trong database
        => mục tiêu lấy dữ liệu sản phẩm từ trong database -> gửi lên UI trình duyệt

        b1. trình duyệt gửi id sản phâm muốn xem chi tiết lên controller qua param hoặc path variable
        b2. controller gọi tới tầng service, truyền vào id
        vì controller sẽ chỉ giao tiếp với tầng service để xử lý logic, không giao tiếp với tầng dao
        -> tạo method findById trong ProductionService
        b3. từ tầng service -> gọi tới tầng dao
        vì tầng dao là tầng duy nhất sử dụng jdbc để giao tiếp thực hiện query được với databas
        -> tạo method findById ở tầng dao
        b4. tầng dao tại method findById thực hiện viết câu query và truyền vào id của sản phẩm
        để lấy ra dữ liệu trong database dưới dạng ResultSet ( dữ liệu dạng table mà database trả ra )
        b5. tại dao convert dữ liệu dạng ResultSet sang dạng object class Java
        b6. trả lại cho tầng service, từ service trả lại tiếp cho tầng controller
        b7. Tại tầng controller này thực hiện gắn model(class java ) vào page jsp
        b8. tại page jsp production-detail.jsp thực hiện sử dụng cú pháp thư viện jstl để hiển thị
        thông tin chi tiết sản phẩm

     */
    @GetMapping("/production-detail")
    public String productionDetail(@RequestParam("id") Integer id, Model model) {

        // b6. trả lại cho tầng service, từ service trả lại tiếp cho tầng controller
        ProductionEntity productionDetail = productionService.findById(id);

        // b7. Tại tầng controller này thực hiện gắn model(class java ) vào page jsp
        model.addAttribute("prodDetail", productionDetail);
        return "production-detail";
    }

    @GetMapping("/production-detail/{id}")
    public String productionDetailV2(@PathVariable("id") Integer id, Model model) {
        ProductionEntity productionDetail = new ProductionEntity();
        model.addAttribute("productionDetail", productionDetail);
        return "production-detail";
    }
}
