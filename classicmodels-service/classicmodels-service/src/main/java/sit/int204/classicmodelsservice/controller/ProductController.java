package sit.int204.classicmodelsservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.dtos.VerySimpleProductDTO;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.services.ListMapper;
import sit.int204.classicmodelsservice.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public ResponseEntity<Object> searchProduct(@RequestParam(defaultValue = "0") Double lower,
                                                @RequestParam(defaultValue = "0") Double upper,
                                                @RequestParam(defaultValue = "") String productName,
                                                @RequestParam(defaultValue = "") String[] sortBy,
                                                @RequestParam(defaultValue = "ASC") String[] direction,
                                                @RequestParam(defaultValue = "0") int pageNo,
                                                @RequestParam(defaultValue = "10") int pageSize)
    {
         Page<Product> productPage = service.searchProductByPriceOrProductName(lower, upper, productName, sortBy, direction, pageNo, pageSize);
            return ResponseEntity.ok(listMapper.toPageDTO(productPage, VerySimpleProductDTO.class, modelMapper));
    }

    @GetMapping("/product-line/{id}")
    public ResponseEntity<Object> searchByCategory(@PathVariable String id) {
        List<Product> productList = service.getProductByCategory(id);
        List<VerySimpleProductDTO> vsp = productList.stream().map(product -> modelMapper.
                map(product, VerySimpleProductDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(vsp);
    }


}
