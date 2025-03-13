package com.apolline.exercicespringboot.repository;

import com.apolline.exercicespringboot.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Long> {
}
