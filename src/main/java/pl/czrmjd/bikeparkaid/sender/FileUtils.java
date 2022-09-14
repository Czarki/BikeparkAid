package pl.czrmjd.bikeparkaid.sender;

import com.google.common.io.Resources;


import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FileUtils {

//    metoda ktora czyta plik jako tekst
    public static String readFileAsText(String resourcePath) {
        try {
            URL url = FileUtils.class.getResource(resourcePath);
            return Resources.toString(url, StandardCharsets.UTF_8);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
