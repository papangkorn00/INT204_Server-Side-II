package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProduct(double lower, double upper, String productName) {
        if (lower <= 0 && upper <= 0) {
            return productRepository.findByProductNameContains(productName);
        }
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = lower;
        }
        return productRepository.findByBuyPriceBetweenAndProductNameContains(lower, upper, productName);
    }

    public List<Product> getProductByCategory(String productLine) {
        return productRepository.findByProductLineStartingWith(productLine);
    }

}

