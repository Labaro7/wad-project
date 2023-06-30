package com.example.absolutefitproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Year;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"gym", "subscriptions"}) // Put in bidirectional lines
@ToString(exclude = {"gym", "subscriptions"})
public class Client extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_id")
    Gym gym;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    Subscription subscription;

    public Client(String name, String username, String password, String salt,
                  String birthDate, String idCard, String email,
                  String gender, String telephone, String country){
        super(name, username, password, salt, birthDate, idCard, email, gender, telephone, country);
    }
}
