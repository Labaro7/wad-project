package com.example.absolutefitproject.repositories;

import com.example.absolutefitproject.domain.Gym;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GymRepository extends CrudRepository<Gym, Long> {
    @Query("SELECT G from Gym G WHERE G.location = :location")
    Gym findByLocation(String location);
}
