package com.example.SpringTutorial.repositories;

import com.example.SpringTutorial.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
