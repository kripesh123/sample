/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Admin
 */
public class Grabber {
    
    public static String grab(String link) throws IOException{
        URL url=new URL(link);
        
        URLConnection conn=url.openConnection();
        
        BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String line="";
        StringBuilder builder=new StringBuilder();
        while((line=reader.readLine())!=null){
            builder.append(line);
        }  
        return builder.toString();
        
    }
}
