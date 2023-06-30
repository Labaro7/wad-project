package com.example.absolutefitproject.services;

import com.example.absolutefitproject.domain.Subscription;
import com.example.absolutefitproject.repositories.SubscriptionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription save(Subscription s){ return subscriptionRepository.save(s); }
    public Subscription findByName(String name){ return subscriptionRepository.findByName(name); }
    public List<Subscription> findByPrice(Long price){ return subscriptionRepository.findByPrice(price); }
}
