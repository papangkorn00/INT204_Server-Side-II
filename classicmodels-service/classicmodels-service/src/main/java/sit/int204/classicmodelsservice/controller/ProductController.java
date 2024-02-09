package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getBuyPriceAndProductName(
            @RequestParam(defaultValue = "0") double lower,
            @RequestParam(defaultValue = "0") double upper,
            @RequestParam(defaultValue = "") String productName) {
        return service.getProduct(lower, upper, productName);
    }

    @GetMapping("/product-line/{productLine}")
    public List<Product> getProductLine(@PathVariable String productLine){
        return service.getProductByCategory(productLine);
    }

}
