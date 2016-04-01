/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CSVReader {
    
    public static List<String> getURLS(String path)throws IOException{
        List<String> urlList=new ArrayList<>();
        String line="";
        
        BufferedReader reader=new BufferedReader(new FileReader(path));
        
        while((line=reader.readLine())!=null){
            urlList.add(line);
        }          
        return urlList;
    }
    
}
