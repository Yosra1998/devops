package com.insat.demo.service;

import com.insat.demo.entity.Journal;
import com.insat.demo.entity.Numero;
import com.insat.demo.entity.Subject;

import com.insat.demo.repositories.NumeroRepository;
import com.insat.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NumeroService {
    @Autowired
    NumeroRepository numeroRepository;
    public Numero createNumero(Numero numero) {

        Numero createdNumero = this.numeroRepository.save(numero);
        return createdNumero;
    }

    public List<Numero> getAllNumeros() {

        List<Numero> numeros = (List<Numero>) this.numeroRepository.findAll();
        return numeros;
    }

    public Numero getNumeroById(Long id)  {
        Optional<Numero> numeroData = this.numeroRepository.findById(id);
        Numero numero=numeroData.orElseThrow();
        return numero;
    }
}
