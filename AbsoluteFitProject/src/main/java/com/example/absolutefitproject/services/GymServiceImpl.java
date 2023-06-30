package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Gym;
import com.example.absolutefitproject.repositories.GymRepository;
import org.springframework.stereotype.Service;

@Service
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepository;

    public GymServiceImpl(GymRepository gymRepository){
        this.gymRepository = gymRepository;
    }

    public Gym save(Gym g){
        return gymRepository.save(g);
    }
    public Gym findByLocation(String location){ return gymRepository.findByLocation(location); }
}
