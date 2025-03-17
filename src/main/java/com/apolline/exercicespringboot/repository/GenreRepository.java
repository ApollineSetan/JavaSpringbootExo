package com.apolline.exercicespringboot.repository;

import com.apolline.exercicespringboot.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
