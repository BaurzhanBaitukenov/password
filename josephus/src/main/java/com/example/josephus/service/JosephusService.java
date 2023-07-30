package com.example.josephus.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JosephusService {

    public String generatePassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        List<Character> charList = new ArrayList<>();
        for (char c : characters.toCharArray()) {
            charList.add(c);
        }

        int killIndex = 0;
        StringBuilder passwordBuilder = new StringBuilder();

        while (!charList.isEmpty()) {
            killIndex = (killIndex + length - 1) % charList.size();
            char killedChar = charList.remove(killIndex);
            passwordBuilder.append(killedChar);
        }

        return passwordBuilder.toString();
    }

    public String encryptPassword(String password) {
        int length = password.length();
        int k = 2; // Можно выбрать другое значение для шага

        List<Character> charList = new ArrayList<>();
        for (char c : password.toCharArray()) {
            charList.add(c);
        }

        int killIndex = 0;
        StringBuilder encryptedBuilder = new StringBuilder();

        while (!charList.isEmpty()) {
            killIndex = (killIndex + k - 1) % charList.size();
            char killedChar = charList.remove(killIndex);
            encryptedBuilder.append(killedChar);
        }

        return encryptedBuilder.toString();
    }


    //неэффективный
//    public String generatePasswordInefficient(int length) {
//        // List of characters to use for password generation
//        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//
//        // Creating a list of characters from the input string
//        List<Character> charList = new ArrayList<>();
//        for (char c : characters.toCharArray()) {
//            charList.add(c);
//        }
//
//        // Initialize variables for the Josephus algorithm
//        int killIndex = 0;
//        StringBuilder passwordBuilder = new StringBuilder();
//
//        // Applying the Josephus algorithm to generate the password
//        while (!charList.isEmpty()) {
//            // Inefficient part: Repeatedly calculating the killIndex for each iteration
//            for (int i = 0; i < length; i++) {
//                killIndex = (killIndex + 1) % charList.size();
//            }
//            char killedChar = charList.remove(killIndex);
//            passwordBuilder.append(killedChar);
//        }
//
//        return passwordBuilder.toString();
//    }


}
