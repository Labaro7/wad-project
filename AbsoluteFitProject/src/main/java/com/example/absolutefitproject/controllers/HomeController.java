package com.example.absolutefitproject.controllers;

import com.example.absolutefitproject.services.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final ClientService clientService;

    public HomeController(ClientService clientService){
        this.clientService = clientService;
    }

    public String encrypt(String password, String salt){
        BCrypt bcrypt = new BCrypt();
        return bcrypt.hashpw(password, salt);
    }

    @GetMapping
    public String home(){
        System.out.println("Hola");
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        String encryptedPassword = encrypt(password, clientService.findByUsername(username).getSalt());
        System.out.println("Password Encrypted: " + encryptedPassword);

        System.out.println("Password Database: " + clientService.findByUsername(username).getPassword());
        System.out.println("Salt Database: " + clientService.findByUsername(username).getSalt());

        Boolean clientFound = clientService.findByUsername(username) != null;
        Boolean passwordCheck = encryptedPassword.equals(clientService.findByUsername(username).getPassword());

        if(clientFound && passwordCheck){
            model.addAttribute("authenticated", true);
            model.addAttribute("name", clientService.findByUsername(username).getName());
            System.out.println("User is logged in");
        }
        else{
            model.addAttribute("authenticated", false);
            System.out.println("User failed log in");
        }

        return "index";
    }

    /*@GetMapping("/login-error")
    public String loginError(Model model){
        return "login-error";
    }*/

    @GetMapping("/subscriptions")
    public String subscriptions(){
        return "subscriptions";
    }

    @GetMapping("/membercard")
    public String memberCard(){
        return "membercard";
    }

}