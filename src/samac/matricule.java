/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

/**
 *
 * @author NGONO
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author NGONO
 */
public class matricule {
    final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    
    public String matricule(){
        
    char [] tab_1 = new char [26];
    int [] tab_2 = new int [10];
    
    
   
    char k;
    
    
    
    int a,b,c,d, i=0, p=0, ok = 0;
    
    StringBuilder bu = new StringBuilder();

        Random random = ThreadLocalRandom.current();
    
        
        for (char q = 'A'; q <= 'Z'; q++) {
            tab_1[i] = q; 
            i++;    
        }
        
        for (int l = 0; l < 10; l++) {
            tab_2[l] = p;
            p++;
        }
        
        
     char e = 'E';   
     k = tab_1[random.nextInt(tab_1.length)];
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_2[random.nextInt(tab_2.length)];
     c = tab_2[random.nextInt(tab_2.length)];
     d = tab_2[random.nextInt(tab_2.length)];
     
     bu.append(e);
     bu.append(k);
     bu.append(a);
     bu.append(b);
     bu.append(c);
     bu.append(d);
     
     String mat = bu.toString();
    
     
     return mat;
     
     
     
     
    
}
    
    
    public String matricule_elev(){
    
    char [] tab_1 = new char [26];
    int [] tab_2 = new int [10];
    
    
   
    char k;
    
    
    
    int a,b,c,d, i=0, p=0, e, okk = 0;
    
    StringBuilder bu = new StringBuilder();

        Random random = ThreadLocalRandom.current();
    
        
        for (char q = 'A'; q <= 'Z'; q++) {
            tab_1[i] = q; 
            i++;    
        }
        
        for (int l = 0; l < 10; l++) {
            tab_2[l] = p;
            p++;
        }
        
        
     e = tab_2[random.nextInt(tab_2.length)];
     k = tab_1[random.nextInt(tab_1.length)];
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_2[random.nextInt(tab_2.length)];
     c = tab_2[random.nextInt(tab_2.length)];
     d = tab_2[random.nextInt(tab_2.length)];
     
     bu.append(e);
     bu.append(a);
     bu.append(k);
     bu.append(b);
     bu.append(c);
     bu.append(d);
     
     String mat = bu.toString();
     
     try{
    
                        int num_serv = 7;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(2);
                        writer.flush();
                        
                        writer.println(mat);
                        writer.flush();
                        
                        String tp = reader.readLine();
                        
                        if(tp.equals("bon")) okk = 1;
                        
                        
                    
                    s.close();
                    } catch (Exception pb){
                            //erreur.showAlertWithoutHeaderText(ttt, mmm);
                          } 
     
     if(okk == 1) return mat;
     
 
     return matricule_elev();
     
     
    
}
    
    public String index_classe(){
    
    char [] tab_1 = new char [26];
    int [] tab_2 = new int [10];
    
    
   
    char k;
    
    
    
    int a,b,c,d, i=0, p=0, e, okkk = 0;
    
    StringBuilder bu = new StringBuilder();

        Random random = ThreadLocalRandom.current();
    
        
        for (char q = 'A'; q <= 'Z'; q++) {
            tab_1[i] = q; 
            i++;    
        }
        
        for (int l = 0; l < 10; l++) {
            tab_2[l] = p;
            p++;
        }
        
     char g = 'C';   
     e = tab_2[random.nextInt(tab_2.length)];
     
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_2[random.nextInt(tab_2.length)];
     
     
     bu.append(g);
     bu.append(a);
     bu.append(e);
     bu.append(b);
    
     
     String mat = bu.toString();
     
     try{
    
                        int num_serv = 7;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(3);
                        writer.flush();
                        
                        writer.println(mat);
                        writer.flush();
                        
                        String tp = reader.readLine();
                        
                        if(tp.equals("bon")) okkk = 1;
             
                        
                    
                    s.close();
                    } catch (Exception pb){
                            //erreur.showAlertWithoutHeaderText(ttt, mmm);
                          } 
     
     if(okkk == 1) return mat;
 
     return index_classe();
     
     
    
}
    
    public String tel(){
    
    
    int [] tab_2 = new int [10];
    
    
   
    char k;
    
    
    
    int a,b,c,d, i=0, p=0, e, okkkk=0;
    int f,g,h,t;
    
    StringBuilder bu = new StringBuilder();

        Random random = ThreadLocalRandom.current();
    
        
        
        
        for (int l = 0; l < 10; l++) {
            tab_2[l] = p;
            p++;
        }
        
        

     int a1 = 6;
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_2[random.nextInt(tab_2.length)];
     c = tab_2[random.nextInt(tab_2.length)];
     d = tab_2[random.nextInt(tab_2.length)];
     
     f = tab_2[random.nextInt(tab_2.length)];
     g = tab_2[random.nextInt(tab_2.length)];
     h = tab_2[random.nextInt(tab_2.length)];
     t = tab_2[random.nextInt(tab_2.length)];
     
     bu.append(a1);
     bu.append(a);
     bu.append(b);
     bu.append(c);
     bu.append(d);
     
     bu.append(f);
     bu.append(g);
     bu.append(h);
     bu.append(t);
    
     
     String mat = bu.toString();
     
     
     
     return mat;
 
    
}
    
    
    public String nom_pre(){
    
    char [] tab_1 = new char [20];
    char [] tab_2 = new char [6];
    String nm;
    
    
   
    char k;
    
    
    
    char a,b,c,d,e,f,g,h;
    int i=0;
    int ii=0;
    
    StringBuilder bu = new StringBuilder();
    StringBuilder buu = new StringBuilder();

        Random random = ThreadLocalRandom.current();
    
        
        for (char q = 'A'; q <= 'Z'; q++) {
            if(!(q == 'A') & !(q == 'E') & !(q == 'I') & !(q == 'O') & !(q == 'Y') & !(q == 'U')){
              tab_1[i] = q; 
              i++;  
                
            }
                
        }
        
        for (char q = 'A'; q <= 'Z'; q++) {
            if((q == 'A') || (q == 'E') || (q == 'I') || (q == 'O') || (q == 'Y') || (q == 'U')){
              tab_2[ii] = q; 
              ii++;  
                
            }
                
        }
        
       
        
        

     k = tab_1[random.nextInt(tab_1.length)];
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_1[random.nextInt(tab_1.length)];
     c = tab_2[random.nextInt(tab_2.length)];
     d = tab_1[random.nextInt(tab_1.length)];
     e = tab_2[random.nextInt(tab_2.length)];
     
     
     bu.append(k);
     bu.append(a);
     bu.append(b);
     bu.append(c);
     bu.append(d);
     bu.append(e);
    
     
     String nm1 = bu.toString();
     String nm2;
     
     if(random.nextInt(3) == 2){
         return nm1;
     } else {
     
     a = tab_2[random.nextInt(tab_2.length)];
     b = tab_1[random.nextInt(tab_1.length)];
     c = tab_2[random.nextInt(tab_2.length)];
     d = tab_1[random.nextInt(tab_1.length)];
    
     
     
     
     buu.append(a);
     buu.append(b);
     buu.append(c);
     buu.append(d);
     
     nm2 = buu.toString();
         
     }
     
     
   return nm1+" "+nm2;
 
    
}
    
     public String mail(){
    
    char [] tab_1 = new char [26];
    
    String nm;
 char a,b,c,d,e,f,g,h,k;
    int i=0;
    
    StringBuilder bu = new StringBuilder();
    StringBuilder buu = new StringBuilder();
        Random random = ThreadLocalRandom.current();
    
        for (char q = 'a'; q <= 'z'; q++) {
            tab_1[i] = q; 
              i++;    
        }
 
     k = tab_1[random.nextInt(tab_1.length)];
     a = tab_1[random.nextInt(tab_1.length)];
     b = tab_1[random.nextInt(tab_1.length)];
     c = tab_1[random.nextInt(tab_1.length)];
     d = tab_1[random.nextInt(tab_1.length)];
   
     bu.append(k);
     bu.append(a);
     bu.append(b);
     bu.append(c);
     bu.append(d);
    String nm1 = bu.toString();
 
   return nm1+"@yahoo.fr";
 
    
}
     
     public String date(){
    
    int [] tab_1 = new int [41];
    
    String nm;
 char a,b,c,d,e,f,g,h,k;
    int i=0;
    
   
        Random random = ThreadLocalRandom.current();
    
        for (int q = 1970; q <= 2010; q++) {
            tab_1[i] = q; 
              i++;    
        }
 
     int a0= tab_1[random.nextInt(tab_1.length)];
     int a1 = random.nextInt(10);
     int a2 = random.nextInt(10);
     
     while(a1 == 0){
        a1 = random.nextInt(9); 
     }
     
     while(a2 == 0){
        a1 = random.nextInt(10); 
     }
     
    
  
 
   return "0"+a1+"/0"+a2+"/"+a0;
 
    
}
    
}
