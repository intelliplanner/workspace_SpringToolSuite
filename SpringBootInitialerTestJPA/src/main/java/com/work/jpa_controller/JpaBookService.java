package com.work.jpa_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.beans.Book;

@Service
public class JpaBookService {
 
@Autowired 
JpaBookRepository JpaBookRepository;


public List<Book>  getAllJpaBooks() {
	List<Book> listJpaBook = new ArrayList<Book>();
	JpaBookRepository.findAll().forEach(listJpaBook::add);
	return listJpaBook;
}
public Book getJpaBook(int id) {
	Book JpaBook = new Book();
	JpaBookRepository.findById(id);
	return JpaBook;
} 

public void addJpaBook(Book JpaBook) {
	JpaBookRepository.save(JpaBook);
}
public void delete(int id) {
	JpaBookRepository.deleteById(id);
}
}
