package com.example.absolutefitproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "gym") // Put in bidirectional lines
@ToString(exclude = "gym")
public class Trainer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_id")
    Gym gym;

    public Trainer(String name, String username, String password, String salt,
                   String birthDate, String idCard, String email,
                   String gender, String telephone, String country){
        super(name, username, password, salt, birthDate, idCard, email, gender, telephone, country);
    }
}
