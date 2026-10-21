package ie.atu.cicdcatalogservice.repository;

import ie.atu.cicdcatalogservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
