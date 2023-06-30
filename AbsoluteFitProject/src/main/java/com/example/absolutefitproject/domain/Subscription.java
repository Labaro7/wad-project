package com.example.absolutefitproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "clients") // Put in bidirectional lines
@ToString(exclude = "clients")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Long price;
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    List<Client> clients = new ArrayList<>();

    public Subscription(String subscriptionName, Long subscriptionPrice){
        this.name = subscriptionName;
        this.price = subscriptionPrice;
    }
}
