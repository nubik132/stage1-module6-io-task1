package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (java.io.FileReader in = new java.io.FileReader(file)){
            String profileLine;
            String[] buffer = new String[4];

            try (BufferedReader br = new BufferedReader(in)) {
                for(int i = 0; (profileLine = br.readLine()) != null; i++){
                    buffer[i] = profileLine.split("\\s")[1];
                }
            }

            return new Profile(buffer[0], Integer.parseInt(buffer[1]),
                    buffer[2], Long.parseLong(buffer[3]));
        } catch (IOException e){
            e.printStackTrace();
        }
        return new Profile();
    }
}
