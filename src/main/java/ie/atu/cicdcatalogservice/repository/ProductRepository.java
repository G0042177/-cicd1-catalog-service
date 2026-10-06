package ie.atu.cicdcatalogservice.repository;

import ie.atu.cicdcatalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
