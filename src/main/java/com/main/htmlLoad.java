package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class htmlLoad {
    public static void load(String url){

        HttpURLConnection connection = null;

        try{
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new FileWriter("downloadFile.html"));
                String str;
                while ((str = br.readLine()) != null){
                   bw.write(str);
                   bw.newLine();
                }
                br.close();
                bw.close();
                System.out.println("Download success");
            } else {
                System.out.println("Fail connection");
            }

        }  catch (Throwable cause){
            cause.printStackTrace();
        }
        finally {
            if (connection != null){
                connection.disconnect();
            }
        }
    }
}
