package com.insat.demo.controller;

import com.insat.demo.entity.Journal;
import com.insat.demo.entity.Journaliste;
import com.insat.demo.service.JournalService;
import com.insat.demo.service.JournalisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/journaliste")
@CrossOrigin(origins = "*")
public class JournalisteController {
    @Autowired
    JournalisteService journalisteService;


    @GetMapping("/all")
    public List<Journaliste> getJournalistes()
    {
        List<Journaliste> journalListes = this.journalisteService.getAllJournalistes();
        return journalListes;
    }

    @GetMapping("/{id}")
    public Journaliste getJournalById(@PathVariable("id") Long Id)
    {
        Journaliste journaliste = this.journalisteService.getJournalisteById(Id);
        return journaliste;
    }
    @PostMapping("/create")
    public Journaliste createNewjournaliste(@RequestBody Journaliste newJournaliste)
    {
        Journaliste journaliste = this.journalisteService.createJournaliste(newJournaliste);
        return journaliste;
    }
}
