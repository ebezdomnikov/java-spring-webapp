package com.evgenii.petprojects.initialbootapp.repositories;

import com.evgenii.petprojects.initialbootapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
