package com.insat.demo.repositories;

import com.insat.demo.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository <Subject,Long> {
}
