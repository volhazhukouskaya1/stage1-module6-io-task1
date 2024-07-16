package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 0;
        String email = null;
        Long phone = null;

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                String[] keyValue = l.split(": ");
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
                    default: continue;
                }
            }
        } catch (IOException e) {  e.getCause(); }


        return new Profile(name, age, email, phone);
    }
}