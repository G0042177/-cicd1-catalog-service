package ie.atu.cicdcatalogservice.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
    String name,
    BigDecimal price,
    Long categoryId
) {}

