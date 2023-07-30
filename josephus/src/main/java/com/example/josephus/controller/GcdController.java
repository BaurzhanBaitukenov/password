package com.example.josephus.controller;

import com.example.josephus.service.GcdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GcdController {

    private final GcdService gcdService;

    @Autowired
    public GcdController(GcdService gcdService) {
        this.gcdService = gcdService;
    }

    @GetMapping("/gcd")
    public String getPage() {
        return "pages/gcd";
    }

    @PostMapping("/gcdPassword")
    public String encryptPassword(@RequestParam("existingPassword") String existingPassword, Model model) {
        String encryptedPassword = gcdService.hashPassword(existingPassword);
        model.addAttribute("encryptedPassword", encryptedPassword);
        return "passwords/gcdPassword";
    }

}

