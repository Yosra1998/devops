package com.insat.demo.controller;

import com.insat.demo.entity.Journal;
import com.insat.demo.entity.Personality;
import com.insat.demo.service.JournalService;
import com.insat.demo.service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
@CrossOrigin(origins = "*")
public class JournalController {
    @Autowired
    JournalService journalService;


    @GetMapping("/all")
    public List<Journal> getJournals()
    {
        List<Journal> journalList = this.journalService.getAllJournals();
        return journalList;
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable("id") Long Id)
    {
        Journal journal = this.journalService.getJournalById(Id);
        return journal;
    }
    @PostMapping("/create")
    public Journal createNewjournal(@RequestBody Journal newJournal)
    {
        Journal journal = this.journalService.createJournal(newJournal);
        return journal;
    }
}
