package com.example.absolutefitproject.repositories;

import com.example.absolutefitproject.domain.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Query("SELECT S from Subscription S WHERE S.name = :name")
    Subscription findByName(String name);

    @Query("SELECT S from Subscription S WHERE S.price = :price")
    List<Subscription> findByPrice(Long price);
}
