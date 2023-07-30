package com.example.josephus.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GcdService {

    private static final String characters = "ab)*&^%dfghjkl$#@cqiopcvbnm,leFGHIJKLMNO@#4YZ012@#*$&)^%5";

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private String mixCharacters(String input, int n) {
        Random random = new Random();
        char[] mixedCharacters = input.toCharArray();
        for (int i = 0; i < n; i++) {
            int index1 = random.nextInt(input.length());
            int index2 = random.nextInt(input.length());
            char temp = mixedCharacters[index1];
            mixedCharacters[index1] = mixedCharacters[index2];
            mixedCharacters[index2] = temp;
        }
        return new String(mixedCharacters);
    }

    public String hashPassword(String password) {
        StringBuilder hashedPassword = new StringBuilder();
        for (char ch : password.toCharArray()) {
            int decimalAscii = (int) ch;
            int firstDigit = decimalAscii / 10;
            int secondDigit = decimalAscii % 10;
            int gcdValue = gcd(firstDigit, secondDigit);
            String mixedCharacters = mixCharacters(characters, gcdValue);
            hashedPassword.append(mixedCharacters);
        }
        String fullHashedPassword = hashedPassword.toString();
        int halfLength = fullHashedPassword.length() / 3;
        return fullHashedPassword.substring(0, halfLength);
    }
}
