/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NGONO
 */
public class testedb {
    
    //private static Connection con;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
       String [] k = get_c();
       
       for(int j=0; j<k.length; j++){
                System.out.println(k[j]);
            }
    
}
    
    
    private static Connection con_miki() throws SQLException, ClassNotFoundException {
        
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url, user, motdepasse;
        url="jdbc:mysql://databases.000webhost.com:21/id14491897_ktzinfo";
        //url="jdbc:mysql://127.0.0.1:3306/samac";
        user="id14491897_francois17";
        //user = "localhost";
        motdepasse="PWDfrancois.1998";
        Connection con = DriverManager.getConnection(url, user, motdepasse);
        //Connection con = DriverManager.getConnection(url, "root", "");
        
        return con;
        }catch(Exception e){
            System.out.println("vous n'etes pas connecté à internet");
            e.printStackTrace();
        }
        return null;
    }
    
    private static String [] get_c(){
        
        String [] tabb;
        int n = 0, i = 0;
        
        try{
            Connection con = con_miki();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM filiere m ");
            while(res.next()){
                n++;
                
            }
            
            
        }catch(Exception e){
           
        }
        
        
        
        tabb = new String[n];
  
        try{
            Connection con = con_miki();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM filiere m ORDER BY libelle ");
            while(res.next()){
                String s = res.getString("libelle");
                tabb[i] = s;
                i++;
                
            }
            
            
        }catch(Exception e){
            
        }
        
        
       if(n == 0) return null;
        
       return tabb;
        
    }
}
