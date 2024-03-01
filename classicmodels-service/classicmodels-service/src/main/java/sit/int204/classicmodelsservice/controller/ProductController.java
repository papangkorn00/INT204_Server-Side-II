package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("")
    public ResponseEntity<Object> searchProduct(@RequestParam(defaultValue = "0") Double lower,
                                                @RequestParam(defaultValue = "0") Double upper,
                                                @RequestParam(defaultValue = "") String productName,
                                                @RequestParam(defaultValue = "") String[] sortBy,
                                                @RequestParam(defaultValue = "ASC") String[] direction,
                                                @RequestParam(defaultValue = "0") int pageNo,
                                                @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(service.searchProductByPriceOrProductName(lower, upper, productName, sortBy, direction, pageNo, pageSize));
    }

    @GetMapping("/product-line/{id}")
    public ResponseEntity<Object> searchByCategory(@PathVariable String id) {
        return ResponseEntity.ok(service.searchProductByCategory(id));
    }


}
