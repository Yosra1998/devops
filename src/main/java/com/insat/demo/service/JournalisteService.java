package com.insat.demo.service;

import com.insat.demo.entity.Journaliste;
import com.insat.demo.repositories.JournalisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JournalisteService {
    @Autowired
    JournalisteRepository journalisteRepository;

    public Journaliste createJournaliste(Journaliste journaliste) {

        Journaliste createdJournaliste = this.journalisteRepository.save(journaliste);
        return createdJournaliste;
    }

    public List<Journaliste> getAllJournalistes() {

        List<Journaliste> journalistes = (List<Journaliste>) this.journalisteRepository.findAll();
        return journalistes;
    }

    public Journaliste getJournalisteById(Long id)  {
        Optional<Journaliste> journalisteData = this.journalisteRepository.findById(id);
        Journaliste journaliste=journalisteData.orElseThrow();
        return journaliste;
    }
}
