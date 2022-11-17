package org.gfg.projectmanagement.controller;

import org.gfg.projectmanagement.model.Product;
import org.gfg.projectmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    private long id;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/products/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
   @DeleteMapping("/products/{id}")
	public HttpStatus deleteProducts(@PathVariable long id) {

       if (this.productService.deleteProducts(id)) {
           return HttpStatus.OK;
       } else {
           return HttpStatus.INTERNAL_SERVER_ERROR;
       }
    }
}
