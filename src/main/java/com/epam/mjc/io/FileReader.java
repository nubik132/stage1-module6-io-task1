package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (java.io.FileReader in = new java.io.FileReader(file)){
            String profileString;
            char[] buffer = new char[128];
            in.read(buffer);
            profileString = new String(buffer);
            String[] profileData = profileString.split("\\s+");

            return new Profile(profileData[1], Integer.parseInt(profileData[3]),
                    profileData[5], Long.parseLong(profileData[7]));
        } catch (IOException e){
            e.printStackTrace();
        }
        return new Profile();
    }
}
