package ie.atu.cicdcatalogservice.service;

import ie.atu.cicdcatalogservice.dto.CreateProductRequest;
import ie.atu.cicdcatalogservice.model.Category;
import ie.atu.cicdcatalogservice.model.Product;
import ie.atu.cicdcatalogservice.repository.CategoryRepository;
import ie.atu.cicdcatalogservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        //null for now, we use DTD's next week so will apear naturally
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"));
    }
    public List<Product> getByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinimumPrice(minPrice);
    }

    public Product createProduct(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Category id is required");
        }
        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Category does not exist"));
Product product = new Product();
product.setCategory(category);
product.setName(request.name());
product.setPrice(request.price());

return productRepository.save(product);

}
}
