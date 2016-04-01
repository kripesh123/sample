/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper;
import com.leapfrog.scrapper.util.CSVReader;
import com.leapfrog.scrapper.util.Grabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
        try{
            System.out.println("Enter URL:");
            Scanner input=new Scanner(System.in);
            String cyberData=Grabber.grab(input.nextLine());
            String modelRegEx="graphics/model/(.*?)/thumb/(.*?).jpg";
            Pattern pattern=Pattern.compile(modelRegEx);
            Matcher matcher=pattern.matcher(cyberData);
            while(matcher.find()){
                String imagePath="http://cybersansar.com/"+matcher.group(0).replace("/thumb", "");
               
                URLConnection conn=new URL(imagePath).openConnection();
               
                
                InputStream fs=conn.getInputStream();
                String[] data=imagePath.split("/");
                FileOutputStream os=new FileOutputStream(data[data.length-1]);
                
                byte[] token=new byte[1024];
                int i=0;
                while((i=fs.read(token))!=-1){
                    os.write(token,0,i);
                }
                
                os.close();
                fs.close();
                
            }
            
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
