package com.example.absolutefitproject.repositories;

import com.example.absolutefitproject.domain.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("SELECT C from Client C")
    List<Client> findAll();

    @Query("SELECT C from Client C WHERE C.name = :name")
    Client findByName(String name);

    @Query("SELECT C from Client C WHERE C.username = :username")
    Client findByUsername(String username);

    @Query("SELECT C from Client C WHERE C.age = :age")
    List<Client> findByAge(Long age);

    @Query("SELECT C from Client C WHERE C.idCard = :idCard")
    Client findByIdCard(String idCard);

    @Query("SELECT C from Client C WHERE C.email = :email")
    Client findByEmail(String email);

    @Query("SELECT C from Client C WHERE C.telephone = :telephone")
    Client findByTelephone(String telephone);

}
