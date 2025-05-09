package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.service.ProductionService;
import vn.com.t3h.service.impl.ProductionServiceImpl;

import java.lang.reflect.Field;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }



    public static void main(String[] args) {

        ProductionService productionService1 = new ProductionServiceImpl();
        ProductionController productionController = new ProductionController();
//        productionController.productionService = productionService1;
        try {
            Field field = productionController.getClass().getDeclaredField("productionService");
            field.setAccessible(true);
            field.set(productionController,productionService1);
            System.out.printf("");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        /*
        reflection
            + cho phep lấy ra tất cả các thuộc tính, tất cả các method của 1 object và thay đổi giá trị cua chúng
            cho dù là private
         */

    }
}
