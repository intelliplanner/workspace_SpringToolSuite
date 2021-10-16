package com.work.jpa_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.work.beans.Book;


@RestController
@RequestMapping(value="/jpa")  
public class JpaBookController {
	@Autowired
	JpaBookService JpaBookService;

	

	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String getMsg() {
//		List<Book> data =  JpaBookService.getAllJpaBooks();
		return "Test Success";
	}
	
	
	@RequestMapping(value="/all" ,method = RequestMethod.GET)
	public List<Book> getAllJpaBook() {
		List<Book> data =  JpaBookService.getAllJpaBooks();
		return data;
	}
	
	@RequestMapping(value="/xml", method = RequestMethod.GET, produces = "text/xml")
	public List<Book> getAllJpaBooks() {
		List<Book> data =  JpaBookService.getAllJpaBooks();
		return data;
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		JpaBookService.delete(id);
	}
	
	@RequestMapping(value="/add-JpaBook", method=RequestMethod.POST)
	public void getJpaBook(@RequestBody Book JpaBook){
		JpaBookService.addJpaBook(JpaBook);
	}
	
	
	
	@RequestMapping(value="/JpaBook/{id}", method=RequestMethod.GET)
	public Book getJpaBook(@PathVariable int id){
		return JpaBookService.getJpaBook(id);
	}
}
