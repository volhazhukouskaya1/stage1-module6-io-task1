package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 0;
        String email = null;
        Long phone = null;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split(": ");
                switch (keyValue[0]) {
                    case "Name":
                        name = keyValue[1];
                        break;
                    case "Age":
                        age = Integer.parseInt(keyValue[1]);
                        break;
                    case "Email":
                        email = keyValue[1];
                        break;
                    case "Phone":
                        phone = Long.parseLong(keyValue[1]);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}