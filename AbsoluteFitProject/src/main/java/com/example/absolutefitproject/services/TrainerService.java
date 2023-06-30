package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.domain.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer save(Trainer t);
    void delete(Trainer t);
    List<Trainer> findAll();
    Trainer findByName(String name);
    List<Trainer> findByAge(Long age);
    Trainer findByIdCard(String idCard);
    Trainer findByEmail(String email);
    Trainer findByTelephone(String telephone);
}
