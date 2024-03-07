package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Page<Product> getProducts(Double lower, Double upper, String productName, String[] sortBy, String[] direction, int pageNo, int pageSize){
        if (lower <= 0 && upper <= 0) {
            upper = productRepository.findFirstByOrderByPriceDesc().getPrice();
        }
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
//        Sort.Order sortOrder = null;
        if (sortBy != null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0; i < sortBy.length ; i++) {
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i]), sortBy[i]));
            }
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrderList));
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName, pageable);
        } else {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName,pageable);
        }
    }

    public List<Product> getProducts(Double lower, Double upper, String productName, String[] sortBy, String[] direction) {
        if (lower <= 0 && upper <= 0) {
            upper = productRepository.findFirstByOrderByPriceDesc().getPrice();
        }
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }
//        Sort.Order sortOrder = null;
        if (sortBy != null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0; i < sortBy.length ; i++) {
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i]), sortBy[i]));

            }
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName, Sort.by(sortOrderList));
        } else {
            return productRepository.findByPriceBetweenAndProductNameContains(lower, upper, productName);
        }
    }


    public List<Product> getProducts(Double lower, Double upper, String productName) {
        return getProducts(lower, upper, productName, null, null);
    }

    public List<Product> getProductByCategory(String productLine) {
        return productRepository.findByProductLineStartingWith(productLine);
    }

}

