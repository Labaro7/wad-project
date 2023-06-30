package com.example.absolutefitproject.repositories;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    @Query("SELECT T from Trainer T")
    List<Trainer> findAll();

    @Query("SELECT T from Trainer T WHERE T.name = :name")
    Trainer findByName(String name);

    @Query("SELECT T from Trainer T WHERE T.age = :age")
    List<Trainer> findByAge(Long age);

    @Query("SELECT T from Trainer T WHERE T.idCard = :idCard")
    Trainer findByIdCard(String idCard);

    @Query("SELECT T from Trainer T WHERE T.email = :email")
    Trainer findByEmail(String email);

    @Query("SELECT T from Trainer T WHERE T.telephone = :telephone")
    Trainer findByTelephone(String telephone);
}