package com.insat.demo.controller;

import com.insat.demo.entity.Article;
import com.insat.demo.entity.Subject;
import com.insat.demo.service.ArticleService;

import com.insat.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    SubjectService subjectService;


    @GetMapping("/all")
    public List<Subject> getSubjects()
    {
        List<Subject> subjects = this.subjectService.getAllSubject();
        return subjects;
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable("id") Long Id)
    {
        Subject subject = this.subjectService.getSubjectById(Id);
        return subject;
    }
    @PostMapping("/create")
    public Subject createNewsubject(@RequestBody Subject newSubject)
    {
        Subject subject = this.subjectService.createSubject(newSubject);
        return subject;
    }
}
