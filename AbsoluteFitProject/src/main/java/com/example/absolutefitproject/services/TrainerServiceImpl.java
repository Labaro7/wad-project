package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Trainer;
import com.example.absolutefitproject.repositories.TrainerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public Trainer save(Trainer t){ return trainerRepository.save(t); }
    public void delete(Trainer t){ trainerRepository.delete(t); }
    public List<Trainer> findAll(){ return trainerRepository.findAll(); }
    public Trainer findByName(String name){ return trainerRepository.findByName(name); }
    public List<Trainer> findByAge(Long age){ return trainerRepository.findByAge(age); }
    public Trainer findByIdCard(String idCard){ return trainerRepository.findByIdCard(idCard); }
    public Trainer findByEmail(String email){ return trainerRepository.findByEmail(email); }
    public Trainer findByTelephone(String telephone){ return trainerRepository.findByTelephone(telephone); }
}
