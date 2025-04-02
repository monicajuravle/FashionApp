package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Cos;
import com.example.fashionapp.backend.model.CosProdus;
import com.example.fashionapp.backend.model.Produs;
import com.example.fashionapp.backend.repository.CosProdusRepository;
import com.example.fashionapp.backend.repository.CosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosService {

    @Autowired
    private CosProdusRepository cosProdusRepository;

    @Autowired
    private CosRepository cosRepository;

    @Autowired
    private ProdusService produsService;

    // Metodă pentru a obține un coș după ID
    public Cos getCosById(Long cosId) {
        return cosRepository.findById(cosId).orElse(null);
    }

    // Metodă pentru a adăuga un produs într-un coș
    public CosProdus addProdusInCos(Long cosId, Long produsId, int cantitate) {
        Cos cos = getCosById(cosId);
        Produs produs = produsService.getProdusById(produsId).orElse(null);

        if (cos == null || produs == null) {
            return null;  // Dacă coșul sau produsul nu există, returnăm null
        }

        CosProdus cosProdus = new CosProdus();
        cosProdus.setCos(cos);
        cosProdus.setProdus(produs);
        cosProdus.setCantitate(cantitate);

        return cosProdusRepository.save(cosProdus);  // Salvăm și returnăm entitatea CosProdus
    }
}
