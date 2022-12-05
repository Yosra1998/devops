package com.insat.demo.service;

import com.insat.demo.entity.Journal;
import com.insat.demo.repositories.JournalRepository;
import com.insat.demo.repositories.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;

    public Journal createJournal(Journal journal) {

        Journal createdJournal = this.journalRepository.save(journal);
        return createdJournal;
    }

    public List<Journal> getAllJournals() {

        List<Journal> journals = (List<Journal>) this.journalRepository.findAll();
        return journals;
    }

    public Journal getJournalById(Long id)  {
        Optional<Journal> journalData = this.journalRepository.findById(id);
        Journal journal=journalData.orElseThrow();
        return journal;
    }
}
