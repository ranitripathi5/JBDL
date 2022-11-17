package org.gfg.projectmanagement.service;

import org.gfg.projectmanagement.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Optional<Product> getProductById(long id)throws Exception;
    List<Product>getAllProducts();
    boolean deleteProducts(long id);
    /*	Product createProduct(Product product);
	Product getProductById(long id) throws Exception;
	List<Product> getAllProducts();
	boolean deleteProducts(long id);*/
}
