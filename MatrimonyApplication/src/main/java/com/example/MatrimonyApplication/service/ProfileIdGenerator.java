package com.example.MatrimonyApplication.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProfileIdGenerator {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final SecureRandom random = new SecureRandom();
    private AtomicInteger counter = new AtomicInteger(1);

    public synchronized String generateProfileId() {
        int sequenceNumber = counter.getAndIncrement();
        if (sequenceNumber > 99) {
            counter.set(1);
            sequenceNumber = counter.getAndIncrement();
        }
        String prefix = generateRandomPrefix();
        return prefix + String.format("%02d", sequenceNumber);
    }

    private String generateRandomPrefix() {
        StringBuilder prefix = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            prefix.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return prefix.toString();
    }
}
