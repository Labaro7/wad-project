package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Subscription;
import java.util.List;

public interface SubscriptionService {
    Subscription save(Subscription s);
    Subscription findByName(String name);
    List<Subscription> findByPrice(Long price);
}
