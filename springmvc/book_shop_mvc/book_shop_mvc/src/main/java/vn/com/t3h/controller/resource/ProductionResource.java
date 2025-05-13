package vn.com.t3h.controller.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.model.ProductionModel;
import vn.com.t3h.service.ProductionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductionResource {

    private ProductionService productionService;

    public ProductionResource(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping(value = "/production",produces = "application/json")
    public ResponseEntity<List<ProductionModel>> getAll() {
        List<ProductionModel> productionModels = productionService.getProductions();
        ResponseEntity<List<ProductionModel>> response = new ResponseEntity<>(productionModels, HttpStatus.OK);
        return response;
    }

    @PostMapping("/production")
    public ResponseEntity<ProductionModel> add(@RequestBody ProductionModel productionModel) {
        return ResponseEntity.ok(null);
    }
}
