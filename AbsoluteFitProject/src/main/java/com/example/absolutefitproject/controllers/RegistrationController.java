package com.example.absolutefitproject.controllers;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.services.ClientService;
import com.example.absolutefitproject.services.GymService;
import com.example.absolutefitproject.services.SubscriptionService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.Year;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final ClientService clientService;
    private final GymService gymService;
    private final SubscriptionService subscriptionService;

    public RegistrationController(ClientService clientService, GymService gymService, SubscriptionService subscriptionService){
        this.clientService = clientService;
        this.gymService = gymService;
        this.subscriptionService = subscriptionService;
    }

    public String encrypt(String password, String salt){
        BCrypt bcrypt = new BCrypt();
        return bcrypt.hashpw(password, salt);
    }

    @GetMapping
    public String registration(){
        return "registrationForm";
    }


    @PostMapping("/add-client")
    public String submit(Client client, String subName, String gymName){
        /*System.out.println(subName);
        System.out.println(gymName);
        System.out.println("Subscription located: " + subscriptionService.findByName(subName));
        System.out.println("Gym located: " + gymService.findByLocation(gymName));*/

        client.setAge(Year.now().getValue() - Long.parseLong(client.getBirthDate().substring(0, 4)));

        client.setSalt(BCrypt.gensalt());
        client.setPassword(encrypt(client.getPassword(), client.getSalt()));

        client.setSubscription(subscriptionService.findByName(subName));
        subscriptionService.findByName(subName).getClients().add(client);

        client.setGym(gymService.findByLocation(gymName));
        gymService.findByLocation(gymName).getClients().add(client);

        clientService.save(client);
        return "index";
    }
}
