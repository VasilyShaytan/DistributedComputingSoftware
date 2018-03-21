package org.edu.kspt.repository;

import org.edu.kspt.entity.ProductInStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInStockRepository extends JpaRepository<ProductInStock, Integer> {

    List<ProductInStock> findAllByOrderByProductNameAsc();
    List<ProductInStock> findAllByOrderByProductNameDesc();
}
