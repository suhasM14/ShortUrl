package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * program to generate short url with different arguments options
 */
public class TestShortUrl {

    public static void main(String args[]) throws IOException {
        List<String> urls = new ArrayList<String>();
        if (args == null || args.length == 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = reader.readLine()) != null) {
                urls.add(input);
            }
        } else if (args.length > 0) {
            if (args[0].startsWith("-")) {
                urls = handleOptions(args);
            } else {
                urls = Arrays.asList(args);
            }
        }
        ShortUrl shortUrl = new ShortUrl();
        for (int i = 0; i < urls.size(); i++) {
            System.out.println("URL is: " + urls.get(i) + " and Tiny URL is: " + shortUrl.shortenURL(urls.get(i)));
        }
    }

    private static List<String> handleOptions(String[] args) throws IOException {
        List<String> urls = new ArrayList<String>();
        for (int i = 0; i < args.length - 1; i = i + 2) {
            switch (args[i]) {
            case "-f":
                // read from file
                File file = new File(args[i + 1]);
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String input;
                    while ((input = reader.readLine()) != null) {
                        urls.add(input);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + args[i + 1]);
                }
                break;
            case "-u":
                // read url followed by this arg
                urls.add(args[i + 1]);
                break;
            default:
                // nothing for now
                break;

            }
        }
        return urls;
    }

}
