package ie.atu.cicdcatalogservice.service;

import ie.atu.cicdcatalogservice.model.Product;
import ie.atu.cicdcatalogservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        //null for now, we use DTD's next week so will apear naturally
        return productRepository.save(product);
    }
}
