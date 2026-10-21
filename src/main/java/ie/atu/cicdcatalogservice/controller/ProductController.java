package ie.atu.cicdcatalogservice.controller;

import ie.atu.cicdcatalogservice.model.Product;
import ie.atu.cicdcatalogservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll() {

        return productService.getAll();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productService.create(product);
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }
    @GetMapping("/min-price")
    public List<Product>getByMinimumPrice(@RequestParam("price") BigDecimal price) {
        return productService.getByMinimumPrice(price);
    }
}
