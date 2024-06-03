package com.pblgllgs.productservice.controller;
/*
 *
 * @author pblgl
 * Created on 08-04-2024
 *
 */

import com.pblgllgs.productservice.dto.ProductRequest;
import com.pblgllgs.productservice.dto.ProductResponse;
import com.pblgllgs.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.createProduct(productRequest),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
//        try{
//            Thread.sleep(5000);
//        }catch (InterruptedException ex ){
//            throw new RuntimeException(ex);
//        }
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable String id) {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }

}
