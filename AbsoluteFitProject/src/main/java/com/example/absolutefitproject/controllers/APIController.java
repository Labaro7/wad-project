package com.example.absolutefitproject.controllers;

import com.example.absolutefitproject.domain.Client;
import com.example.absolutefitproject.services.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.Year;

@Controller
@RequestMapping("/api")
public class APIController {
    private final ClientService clientService;
    private final PasswordEncoder bcrypt;

    public APIController(ClientService clientService, PasswordEncoder bcrypt){
        this.clientService = clientService;
        this.bcrypt = bcrypt;
    }

    @PostMapping("/registration")
    public String saveClient(@RequestBody Client client, Model model){
        System.out.println("Client received");
        model.addAttribute("client", client);

        System.out.println("Client was saved:");
        System.out.println(client.getName());
        System.out.println(client.getUsername());
        System.out.println(client.getPassword());
        System.out.println(client.getBirthDate());
        System.out.println(client.getIdCard());
        System.out.println(client.getEmail());
        System.out.println(client.getGender());
        System.out.println(client.getTelephone());
        System.out.println(client.getCountry());

        client.setAge(Year.now().getValue() - Long.parseLong(client.getBirthDate().substring(0, 4)));
        client.setPassword(bcrypt.encode(client.getPassword()));

        clientService.save(client);
        return "index";
    }
}
