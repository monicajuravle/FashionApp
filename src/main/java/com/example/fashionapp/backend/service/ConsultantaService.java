package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Consultanta;
import com.example.fashionapp.backend.repository.ConsultantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantaService {

    private final ConsultantaRepository consultantaRepository;

    @Autowired
    public ConsultantaService(ConsultantaRepository consultantaRepository) {
        this.consultantaRepository = consultantaRepository;
    }

    // Creare consultanță
    public Consultanta createConsultanta(Consultanta consultanta) {
        return consultantaRepository.save(consultanta);
    }

    // Obținerea consultanțelor pentru un utilizator
    public List<Consultanta> getConsultanteByUser(Long idUtilizator) {
        return consultantaRepository.findByUtilizator_IdUtilizator(idUtilizator);
    }
}
