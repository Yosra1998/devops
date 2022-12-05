package com.insat.demo.repositories;

import com.insat.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository  extends CrudRepository<Journal, Long> {
}
