package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductionController {


    @GetMapping("/production-detail")
    public String productionDetail() {
        return "production-detail";
    }
}
