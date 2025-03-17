package com.apolline.exercicespringboot.repository;

import com.apolline.exercicespringboot.model.MaisonEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonEditionRepository extends CrudRepository<MaisonEdition, Long> {
}
