package org.example.product_jms_exerciselearn.repository;

import org.example.product_jms_exerciselearn.entity.ProductOrder;
import org.springframework.data.repository.CrudRepository;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
}
