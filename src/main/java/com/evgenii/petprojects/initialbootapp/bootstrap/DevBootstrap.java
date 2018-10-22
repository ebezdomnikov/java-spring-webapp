package com.evgenii.petprojects.initialbootapp.bootstrap;

import com.evgenii.petprojects.initialbootapp.model.Author;
import com.evgenii.petprojects.initialbootapp.model.Book;
import com.evgenii.petprojects.initialbootapp.repositories.AuthorRepository;
import com.evgenii.petprojects.initialbootapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {
        Author evgenii = new Author("Evgenii", "Bezdomnikov");
        Book ddd = new Book("DDD", "111", "My publisher");
        evgenii.getBooks().add(ddd);
        ddd.getAuthors().add(evgenii);

        authorRepository.save(evgenii);
        bookRepository.save(ddd);

        Author john = new Author("John", "Doe");
        Book other = new Book("Book title", "1234", "Publisher");
        john.getBooks().add(other);

        authorRepository.save(john);
        bookRepository.save(other);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
