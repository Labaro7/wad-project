package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client save(Client c){ return clientRepository.save(c); }
    public void delete(Client c){ clientRepository.delete(c); }
    public List<Client> findAll(){ return clientRepository.findAll(); }
    public Client findByName(String name){ return clientRepository.findByName(name); }
    public Client findByUsername(String username){ return clientRepository.findByUsername(username); }
    public List<Client> findByAge(Long age){ return clientRepository.findByAge(age); }
    public Client findByIdCard(String idCard){ return clientRepository.findByIdCard(idCard); }
    public Client findByEmail(String email){ return clientRepository.findByEmail(email); }
    public Client findByTelephone(String telephone){ return clientRepository.findByTelephone(telephone); }
}
