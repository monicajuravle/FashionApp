package com.example.fashionapp.backend.service;

import com.example.fashionapp.backend.model.Utilizator;
import com.example.fashionapp.backend.repository.UtilizareRepository;
import com.example.fashionapp.backend.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private UtilizareRepository utilizareRepository;

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    // Verifică utilizatorii care au folosit aplicația de cel puțin 4 ori în ultima lună
    public List<Utilizator> getEligibleUsersForDiscount() {
        LocalDateTime startOfLastMonth = LocalDateTime.now().minusMonths(1);
        List<Utilizator> eligibleUsers = new ArrayList<>();

        List<Utilizator> allUsers = utilizatorRepository.findAll();

        for (Utilizator utilizator : allUsers) {
            long usageCount = utilizareRepository.countByUtilizatorAndDataUtilizareAfter(utilizator, startOfLastMonth);
            if (usageCount >= 4) {
                eligibleUsers.add(utilizator);
            }
        }

        return eligibleUsers;
    }
}
