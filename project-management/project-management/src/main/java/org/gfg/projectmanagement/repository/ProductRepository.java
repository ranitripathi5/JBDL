package org.gfg.projectmanagement.repository;

import org.gfg.projectmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long > {

}
