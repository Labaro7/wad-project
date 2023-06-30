package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Client;

import java.util.List;

public interface ClientService {
    Client save(Client c);
    void delete(Client c);
    List<Client> findAll();
    Client findByName(String name);
    Client findByUsername(String username);
    List<Client> findByAge(Long age);
    Client findByIdCard(String idCard);
    Client findByEmail(String email);
    Client findByTelephone(String telephone);
}
