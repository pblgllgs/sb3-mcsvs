package com.pblgllgs.productservice.service;

import com.pblgllgs.productservice.dto.ProductRequest;
import com.pblgllgs.productservice.dto.ProductResponse;
import com.pblgllgs.productservice.model.Product;
import com.pblgllgs.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        log.info("{} -> Product request: {}", ProductService.log.getName(), productRequest);
        Product product = Product.builder()
                .price(productRequest.price())
                .description(productRequest.description())
                .name(productRequest.name())
                .build();
        Product productSaved = productRepository.save(product);
        log.info("{} -> Product response: {}", ProductService.log.getName(), productSaved);
        return new ProductResponse(productSaved.getId(), productSaved.getName(), product.getDescription(), productSaved.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        log.info("{} -> Response: {}", ProductService.log.getName(), productList);
        return productList.stream().map(product -> new ProductResponse(
                product.getId(), product.getName(), product.getDescription(), product.getPrice()
        )).toList();
    }

    public ProductResponse findProductById(String id) {
        log.info("{} -> Product id request: {}", ProductService.log.getName(), id);
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            log.error("{} -> Product not found with id: {}", ProductService.log.getName(), id);
            throw new RuntimeException("PRODUCT_NOT_FOUND_WITH_ID: " + id);
        }
        Product productDb = productOptional.get();
        log.info("{} -> Product response: {}", ProductService.log.getName(), productDb);
        return new ProductResponse(productDb.getId(), productDb.getName(), productDb.getDescription(), productDb.getPrice());
    }
}
