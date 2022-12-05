package com.insat.demo.repositories;

import com.insat.demo.entity.Numero;
import org.springframework.data.repository.CrudRepository;

public interface NumeroRepository extends CrudRepository<Numero,Long> {
}
