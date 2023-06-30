package com.example.absolutefitproject.bootstrap;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.domain.Gym;
import com.example.absolutefitproject.domain.Subscription;
import com.example.absolutefitproject.domain.Trainer;
import com.example.absolutefitproject.services.ClientService;
import com.example.absolutefitproject.services.GymService;
import com.example.absolutefitproject.services.SubscriptionService;
import com.example.absolutefitproject.services.TrainerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final ClientService clientService;
    private final GymService gymService;
    private final TrainerService trainerService;
    private final SubscriptionService subscriptionService;

    public DataLoader(ClientService clientService,
                      GymService gymService,
                      TrainerService trainerService,
                      SubscriptionService subscriptionService) {
        this.clientService = clientService;
        this.gymService = gymService;
        this.trainerService = trainerService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void run(String... args) throws Exception {
        String c1_salt = BCrypt.gensalt();
        Client c1 = new Client(
                "Adrian",
                "adri7",
                BCrypt.hashpw("123", c1_salt),
                c1_salt,
                "2000-07-03",
                "123456789A",
                "adrian@gmail.com",
                "male",
                "123456789",
                "Spain");

        String c2_salt = BCrypt.gensalt();
        Client c2 = new Client(
                "Ana",
                "ana5",
                BCrypt.hashpw("321", c2_salt),
                c2_salt,
                "2001-03-07",
                "987654321B",
                "ana@gmail.com",
                "female",
                "987654321",
                "Spain");

        String c3_salt = BCrypt.gensalt();
        Client c3 = new Client(
                "Javi",
                "javi9",
                BCrypt.hashpw("111", c3_salt),
                c3_salt,
                "2002-04-09",
                "853671289G",
                "javi@gmail.com",
                "male",
                "853671289",
                "Spain");

        String c4_salt = BCrypt.gensalt();
        Client c4 = new Client(
                "Florian",
                "florian2",
                BCrypt.hashpw("222", c4_salt),
                c4_salt,
                "2004-06-13",
                "891263456K",
                "florian@gmail.com",
                "male",
                "891263456",
                "Romania");

        Gym g1 = new Gym("Liberty");
        Gym g2 = new Gym("Coccor");
        Gym g3 = new Gym("Pipera");
        Gym g4 = new Gym("Vitan");

        String t1_salt = BCrypt.gensalt();
        Trainer t1 = new Trainer(
                "Alexandru",
                "alexandru2",
                BCrypt.hashpw("456", t1_salt),
                t1_salt,
                "1990-02-01",
                "123123123C",
                "alexandru@gmail.com",
                "male",
                "123123123",
                "Romania");

        String t2_salt = BCrypt.gensalt();
        Trainer t2 = new Trainer(
                "Andreea",
                "andreea9",
                BCrypt.hashpw("789", t2_salt),
                t2_salt,
                "1980-04-03",
                "456456456D",
                "andreea@gmail.com",
                "female",
                "456456456",
                "Romania");

        String t3_salt = BCrypt.gensalt();
        Trainer t3 = new Trainer(
                "Pepe",
                "elpepe",
                BCrypt.hashpw("333", t3_salt),
                t3_salt,
                "1994-03-02",
                "123123124D",
                "pepe@gmail.com",
                "male",
                "123123124",
                "Spain");

        String t4_salt = BCrypt.gensalt();
        Trainer t4 = new Trainer(
                "Manolo",
                "manolitopiesdeplata",
                BCrypt.hashpw("789", t4_salt),
                t4_salt,
                "1997-12-08",
                "456456789P",
                "manolo@gmail.com",
                "male",
                "456456789",
                "Spain");

        Subscription s1 = new Subscription("Student", 15L);
        Subscription s2 = new Subscription("Normal", 20L);
        Subscription s3 = new Subscription("Family", 35L);

        // We set the clients' info
        c1.setSubscription(s1);
        c1.setGym(g1);
        
        c2.setSubscription(s2);
        c2.setGym(g2);

        c3.setSubscription(s3);
        c3.setGym(g3);

        c4.setSubscription(s3);
        c4.setGym(g4);

        // We set the gyms' info
        g1.getClients().add(c1);
        g1.getTrainers().add(t1);
        g1.getSubscriptions().add(s1);
        g1.getSubscriptions().add(s2);
        g1.getSubscriptions().add(s3);

        g2.getClients().add(c2);
        g2.getTrainers().add(t2);
        g2.getSubscriptions().add(s1);
        g2.getSubscriptions().add(s2);
        g2.getSubscriptions().add(s3);

        g3.getClients().add(c3);
        g3.getTrainers().add(t3);
        g3.getSubscriptions().add(s1);
        g3.getSubscriptions().add(s2);
        g3.getSubscriptions().add(s3);

        g4.getClients().add(c4);
        g4.getTrainers().add(t4);
        g4.getSubscriptions().add(s1);
        g4.getSubscriptions().add(s2);
        g4.getSubscriptions().add(s3);

        // We set the trainers' info
        t1.setGym(g1);
        t2.setGym(g2);
        t3.setGym(g3);
        t4.setGym(g4);

        s1.getClients().add(c1);
        s2.getClients().add(c2);
        s3.getClients().add(c3);
        s3.getClients().add(c4);

        clientService.save(c1);
        clientService.save(c2);
        clientService.save(c3);
        clientService.save(c4);
        // gymService.save(g1);
        // gymService.save(g2);
        // trainerService.save(t1);
        // trainerService.save(t2);
        // subscriptionService.save(s1);
        // subscriptionService.save(s2);
    }
}
