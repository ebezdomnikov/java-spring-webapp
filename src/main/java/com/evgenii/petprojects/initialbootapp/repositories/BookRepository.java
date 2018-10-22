package com.evgenii.petprojects.initialbootapp.repositories;

import com.evgenii.petprojects.initialbootapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
