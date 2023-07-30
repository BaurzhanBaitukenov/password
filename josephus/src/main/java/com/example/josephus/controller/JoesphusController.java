package com.example.josephus.controller;

import com.example.josephus.service.JosephusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoesphusController {

    private final JosephusService josephusService;

    public JoesphusController(JosephusService josephusService) {
        this.josephusService = josephusService;
    }

    @GetMapping("/josephus")
    public String getPage(){
        return "pages/josephus";
    }

    @PostMapping("/generatePassword")
    public String generatePassword(@RequestParam("numberOfNumbers") int numberOfNumbers, Model model) {
        String password = josephusService.generatePassword(numberOfNumbers);
        model.addAttribute("password", password);
        return "passwords/password";
    }

    @PostMapping("/encryptPassword")
    public String encryptPassword(@RequestParam("existingPassword") String existingPassword, Model model) {
        String encryptedPassword = josephusService.encryptPassword(existingPassword);
        model.addAttribute("encryptedPassword", encryptedPassword);
        return "passwords/encrypted_password";
    }
}
