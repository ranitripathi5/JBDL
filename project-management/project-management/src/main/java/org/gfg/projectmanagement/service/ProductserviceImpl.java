package org.gfg.projectmanagement.service;

import org.gfg.projectmanagement.model.Product;
import org.gfg.projectmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductserviceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(long id) throws Exception {
        Optional<Product> product= productRepository.findById(id);
        if(product.isPresent()){
            return Optional.of(product.get());
        }else{
            throw new Exception("product is absent");
        }
       // return productRepository.findById(id);
    }
    @Override
    public java.util.List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public boolean deleteProducts(long id) {
        // TODO Auto-generated method stub
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            this.productRepository.delete(product.get());
            return true;
        }else {
            return false;
        }

    }
}
