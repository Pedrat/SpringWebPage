package com.example.SpringTutorial.bootstrap;

import com.example.SpringTutorial.model.Author;
import com.example.SpringTutorial.model.Book;
import com.example.SpringTutorial.model.Publisher;
import com.example.SpringTutorial.repositories.AuthorRepository;
import com.example.SpringTutorial.repositories.BookRepository;
import com.example.SpringTutorial.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

//    Since AuthorRepository and BookRepository are final, and in the constructor, spring knows to inject them at startup
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "12345");
        Publisher portoEditora = new Publisher("Porto Editora", "¯\\_(ツ)_/¯");
        publisherRepository.save(portoEditora);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(portoEditora);
        portoEditora.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(portoEditora);
        Author rod = new Author("Rod", "Jonhson");
        Book noEJB = new Book("J2EE development without EJB", "12345567");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(portoEditora);
        portoEditora.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(portoEditora);



        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of books on publisher: " + portoEditora.getBooks().size());

    }
}
