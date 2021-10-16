package com.test.product.doa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<com.test.product.bean.Product, Integer> {

}
