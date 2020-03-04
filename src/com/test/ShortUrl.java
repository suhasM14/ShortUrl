package com.test;

import java.util.Random;

/**
 * Creates a short URL with a random key
 */
public class ShortUrl {

    public String shortenURL(String longUrl) {
        StringBuilder shortUrl = new StringBuilder();
        if (longUrl.startsWith("https://")) {
            shortUrl.append("https://");
        } else {
            // default to http
            shortUrl.append("http://");
        }
        // append the domain
        shortUrl.append("tinyurl.com/");
        shortUrl.append(generateHash());
        return shortUrl.toString();
    }

    private String generateHash() {
        int hashLength = 7; // assume the random hash of 7 characters based on example
        String hash = "";
        String randomCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        for (int i = 0; i < hashLength; i++) {
            hash = hash + String.valueOf(randomCharacters.charAt(new Random().nextInt(randomCharacters.length())));
        }
        return hash;
    }

}
