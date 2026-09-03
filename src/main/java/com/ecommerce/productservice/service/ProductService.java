package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductRequest;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequest request) {

        Product product = new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getQuantity()
        );

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product getProduct(Long id) {

        return productRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found"
                        ));
    }

    public Product updateProduct(
            Long id,
            ProductRequest request) {

        Product product = productRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found"
                        ));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {

            throw new RuntimeException(
                    "Product not found"
            );
        }

        productRepository.deleteById(id);
    }
}
