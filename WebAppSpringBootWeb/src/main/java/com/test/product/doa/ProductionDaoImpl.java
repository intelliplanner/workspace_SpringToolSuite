package com.test.product.doa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.product.bean.Product;


@Service
public class ProductionDaoImpl {

@Autowired
ProductRepository productRepository;


public List<Product>  getAllProducts() {
	List<Product> listProduct = new ArrayList<Product>();
	productRepository.findAll().forEach(listProduct::add);
	return listProduct;
}
public Product getProduct(int id) {
	Product product = new Product();
	productRepository.findById(id);
	return product;
} 

public void addProduct(Product product) {
	productRepository.save(product);
	System.out.println("Save Data");
}
public void delete(int id) {
	productRepository.deleteById(id);
	System.out.println("delete Product id:"+id);
}


}
