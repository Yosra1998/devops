package com.insat.demo.repositories;

import com.insat.demo.entity.Journaliste;
import org.springframework.data.repository.CrudRepository;

public interface JournalisteRepository extends CrudRepository<Journaliste,Long> {
}
