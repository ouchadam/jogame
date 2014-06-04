package com.ouchadam.jogame;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocHelper {

    public static Document open(String filename) {
        try {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
        return Jsoup.parse(new Scanner(new File(url.toURI()), "UTF8").useDelimiter("\\Z").next());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
