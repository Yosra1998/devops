package com.insat.demo.controller;

import com.insat.demo.entity.Personality;
import com.insat.demo.service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personality")
@CrossOrigin(origins = "*")
public class PersonalityController {

    @Autowired
    PersonalityService personalityService;


    @GetMapping("/all")
    public List<Personality> getPersonalities()
    {
        List<Personality> personalityList = this.personalityService.getAllPersonalities();
        return personalityList;
    }

    @GetMapping("/{id}")
    public Personality getPersonalityById(@PathVariable("id") Long Id)
    {
        Personality personality = this.personalityService.getPersonalityById(Id);
        return personality;
    }
    @PostMapping("/create")
    public Personality createNewPersonality(@RequestBody Personality newPersonality)
    {
        Personality personality = this.personalityService.createPersonality(newPersonality);
        return personality;
    }
}
