package org.example.product_jms_exerciselearn.repository;

import org.example.product_jms_exerciselearn.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
