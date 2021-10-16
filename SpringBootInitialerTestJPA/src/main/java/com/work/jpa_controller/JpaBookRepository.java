package com.work.jpa_controller;

import org.springframework.data.repository.CrudRepository;

import com.work.beans.Book;

public interface JpaBookRepository extends CrudRepository<Book,Integer>{

}
