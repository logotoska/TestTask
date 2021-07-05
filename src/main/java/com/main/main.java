package com.main;

import java.io.IOException;
import java.util.*;

public class main {

    public static void main(String args[]){

        try{
            String url;
            HashMap<String, Integer> words = new HashMap<>();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter URL");
            url = in.nextLine();
            htmlLoad.load(url);
            words = findWords.find("downloadFile.html");
            Set set = words.entrySet();
            Iterator i = set.iterator();
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.print(me.getKey() + " - ");
                System.out.println(me.getValue());
            }
        }
        catch (IOException exp){
            System.out.println("Input exception");
        }
    }
}
