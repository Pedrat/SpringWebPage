package com.example.SpringTutorial.repositories;

import com.example.SpringTutorial.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
