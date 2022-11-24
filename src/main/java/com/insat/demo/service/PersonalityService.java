package com.insat.demo.service;

import com.insat.demo.entity.Personality;
import com.insat.demo.repositories.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalityService {
    @Autowired
    PersonalityRepository personalityRepository;

    public Personality createPersonality(Personality personality) {

        Personality createdPersonality = this.personalityRepository.save(personality);
        return createdPersonality;
    }

    public List<Personality> getAllPersonalities() {

        List<Personality> personalities = (List<Personality>) this.personalityRepository.findAll();
        return personalities;
    }

    public Personality getPersonalityById(Long id)  {
        Optional<Personality> personalityData = this.personalityRepository.findById(id);
        Personality personality=personalityData.orElseThrow();
        return personality;
    }

}
