package org.example;

import org.example.core.TuDien;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String path = new File("src/main/resources/application.properties").getAbsolutePath();
            properties.load(new FileReader(path));

            properties.forEach((key, value) -> {
                PluginManager.loadPlugin(value.toString());
                String test = PluginManager.get(TuDien.class).traTuDien("hello");
                System.out.println(test);

            });


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}