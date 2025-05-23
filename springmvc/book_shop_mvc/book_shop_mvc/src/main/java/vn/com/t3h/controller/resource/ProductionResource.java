package vn.com.t3h.controller.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.entity.ProductionEntity;
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
    public ResponseEntity<List<ProductionEntity>> getAll() {
        List<ProductionEntity> productionModels = productionService.getProductions();
        ResponseEntity<List<ProductionEntity>> response = new ResponseEntity<>(productionModels, HttpStatus.OK);
        return response;
    }

    @PostMapping("/production")
    public ResponseEntity<ProductionEntity> add(@RequestBody ProductionEntity productionModel) {
        return ResponseEntity.ok(null);
    }
}
