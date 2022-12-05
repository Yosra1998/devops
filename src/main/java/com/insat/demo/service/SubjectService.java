package com.insat.demo.service;

import com.insat.demo.entity.Journal;
import com.insat.demo.entity.Subject;

import com.insat.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {

        Subject createdSubject = this.subjectRepository.save(subject);
        return createdSubject;
    }

    public List<Subject> getAllSubject() {

        List<Subject> subjects = (List<Subject>) this.subjectRepository.findAll();
        return subjects;
    }

    public Subject getSubjectById(Long id)  {
        Optional<Subject> subjectData = this.subjectRepository.findById(id);
        Subject subject=subjectData.orElseThrow();
        return subject;
    }
}
