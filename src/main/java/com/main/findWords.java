package com.main;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class findWords {
    public static HashMap find(String html) throws IOException{
        File file = new File(html);
        String wr;
        HashMap<String, Integer> words = new HashMap<>();
        String str = Jsoup.parse(file,"UTF-8").text();
        str = str.toUpperCase();
        str = str.replaceAll(", "," ");
        str = str.replaceAll("\\. "," ");
        str = str.replaceAll("  "," ");
        str = str.replaceAll("\\? "," ");
        str = str.replaceAll("\\?","");
        str = str.replaceAll("\\(","");
        str = str.replaceAll("\\) ", " ");
        str = str.replaceAll(" — "," ");
        str = str.replaceAll("-","");
        str = str.replaceAll("!","");
        str = str.replaceAll(":","");
        str = str.replaceAll("\"","");
        str = str.replaceAll("\\d","");
        String[] parts = str.split("[\\s]");

        Iterator i = Arrays.stream(parts).iterator();
        while (i.hasNext()) {
            String current = (String) i.next();
            if (current != "") {
                if (!words.containsKey(current)) {
                    words.put(current, 1);
                } else {
                    int l = words.get(current) + 1;
                    words.put(current, l);
                }
            }
        }
        return words;
    }
}
