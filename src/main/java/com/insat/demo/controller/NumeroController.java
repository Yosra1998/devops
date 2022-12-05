package com.insat.demo.controller;

import com.insat.demo.entity.Numero;
import com.insat.demo.entity.Personality;
import com.insat.demo.service.NumeroService;
import com.insat.demo.service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numero")
@CrossOrigin(origins = "*")
public class NumeroController {

    @Autowired
    NumeroService numeroService;


    @GetMapping("/all")
    public List<Numero> getNumeros()
    {
        List<Numero> numeroList = this.numeroService.getAllNumeros();
        return numeroList;
    }

    @GetMapping("/{id}")
    public Numero getNumeroById(@PathVariable("id") Long Id)
    {
        Numero numero = this.numeroService.getNumeroById(Id);
        return numero;
    }
    @PostMapping("/create")
    public Numero createNewNumero(@RequestBody Numero newNumero)
    {
        Numero numero = this.numeroService.createNumero(newNumero);
        return numero;
    }
}
