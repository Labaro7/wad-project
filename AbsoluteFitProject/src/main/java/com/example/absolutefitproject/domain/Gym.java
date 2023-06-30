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
@EqualsAndHashCode(exclude = {"clients", "trainers"}) // Put in bidirectional lines
@ToString(exclude = {"clients", "trainers"})
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String location;
    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    List<Client> clients = new ArrayList<Client>();
    @ManyToMany(cascade = CascadeType.ALL) // This does not have "mappedBy" because it is not bidirectional.
    List<Subscription> subscriptions = new ArrayList<>();
    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL)
    List<Trainer> trainers = new ArrayList<Trainer>();

    public Gym(String location){
        this.location = location;
    }
}
