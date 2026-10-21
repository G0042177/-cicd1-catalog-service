package ie.atu.cicdcatalogservice.repository;
import java.util.List;
import ie.atu.cicdcatalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query("SELECT p FROM Product p WHERE p.price >= :minpriice ORDER BY p.price ASC ")
    List<Product> findByMinimumPrice(@Param("minPrice")BigDecimal minPrice);
}
