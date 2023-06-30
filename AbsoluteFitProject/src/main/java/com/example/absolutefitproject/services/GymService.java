package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Gym;

public interface GymService {
    Gym save(Gym g);
    Gym findByLocation(String location);
}
