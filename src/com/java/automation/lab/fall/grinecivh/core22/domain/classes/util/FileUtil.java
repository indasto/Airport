package com.java.automation.lab.fall.grinecivh.core22.domain.classes.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileUtil {

    public static String read(String path) {

        StringBuffer result = new StringBuffer();
        try {
            Files.readAllLines(Path.of((path))).forEach(result::append);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return result.toString();
    }

    public static void overwrite (String str, String path){
        write(str,path,false);
    }

    public static void append (String str, String path){
        write(str,path,true);
    }

    private static void write(String str, String path, boolean append){
        try {
            if (append){
                Files.writeString(Path.of(path),str, StandardOpenOption.APPEND);
            } else {
                Files.writeString(Path.of(path),str);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
