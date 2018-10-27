package com.evgenii.petprojects.initialbootapp.bootstrap;

import com.evgenii.petprojects.initialbootapp.model.Author;
import com.evgenii.petprojects.initialbootapp.model.Book;
import com.evgenii.petprojects.initialbootapp.model.Publisher;
import com.evgenii.petprojects.initialbootapp.repositories.AuthorRepository;
import com.evgenii.petprojects.initialbootapp.repositories.BookRepository;
import com.evgenii.petprojects.initialbootapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Author evgenii = new Author("Evgenii", "Bezdomnikov");
        Publisher p1 = new Publisher("name", "address");
        Book ddd = new Book("DDD", "111", p1);

        evgenii.getBooks().add(ddd);
        ddd.getAuthors().add(evgenii);

        publisherRepository.save(p1);
        authorRepository.save(evgenii);
        bookRepository.save(ddd);

        Author john = new Author("John", "Doe");
        Publisher p2 = new Publisher("name2", "address3");
        Book other = new Book("Book title", "1234", p2);
        john.getBooks().add(other);
        publisherRepository.save(p2);
        authorRepository.save(john);
        bookRepository.save(other);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
