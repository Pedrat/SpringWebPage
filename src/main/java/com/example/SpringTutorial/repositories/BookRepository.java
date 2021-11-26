package com.example.SpringTutorial.repositories;

import com.example.SpringTutorial.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
