package com.example.absolutefitproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Person {
    String name; // First name, second name
    String username;
    String password;
    String salt;
    String birthDate; // dd/mm/yy
    Long age; // xx
    String idCard; // 123456789A
    String email; // something@gmail.com
    String gender;
    String telephone; // (+prefix)telephoneNumber
    String country;

    public Person(String name, String username, String password, String salt,
                  String birthDate, String idCard, String email,
                  String gender, String telephone, String country){
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.birthDate = birthDate;
        this.age = Year.now().getValue() - Long.parseLong(birthDate.substring(0, 4));
        this.idCard = idCard;
        this.email = email;
        this.gender = gender;
        this.telephone = telephone;
        this.country = country;
    }
}
