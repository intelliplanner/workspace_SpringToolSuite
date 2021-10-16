package com.test.product.doa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.product.bean.Product;



@RestController
@RequestMapping(value="/product")
public class ProductController {

@Autowired
ProductionDaoImpl  pDao;
	
@RequestMapping(value="/")
public String get() {
	return "login";
}

@RequestMapping("/productForm")    
public String showform(Model m){    
    m.addAttribute("command", new Product());  
    return "productform";   
}  

@PostMapping("/employees")
public String save(@RequestBody Product p) {
	pDao.addProduct(p);
	return "list";
}


@RequestMapping(value="/get" ,method = RequestMethod.GET)
@JsonProperty("Product")
public List<Product> loadAll(Model m) {
	List<Product>  list =pDao.getAllProducts();
	m.addAttribute("list", list );
	return list;
}


@RequestMapping(value="/getNew" ,method = RequestMethod.GET)
public String loadAllNew(Model m) throws JsonProcessingException {
	List<Product>  list =pDao.getAllProducts();
	m.addAttribute("list", list );
	ObjectMapper mapper = new ObjectMapper();
	mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
	String result = mapper.writeValueAsString(list);
//	result.replaceAll("ArrayList", "Product");
//	result = master.replace(target, replacement);
	result = result.replace("ArrayList", "Product");
	return result;
}




//@RequestMapping(value="/xml", method = RequestMethod.GET, produces = "text/xml")
@RequestMapping(value="/xml", method = RequestMethod.GET, produces = "application/xml")
public List<Product> getAllProducts() {
	List<Product> data =  pDao.getAllProducts();	
	return data;
}

}
