package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByBuyPriceBetweenAndProductNameContains(double lower, double upper, String productName);
    List<Product> findByProductNameContains( String productName);
    List<Product> findByProductLineStartingWith(String productLine);

    // native query
//    @Query("select p from Prodcut p where p.productLine like :category");
//    List<Product> getProductByCategory(String category);
}
