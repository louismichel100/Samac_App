/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author NGONO
 */
public class testdb {

    /**
     * @param args the command line arguments
     */
    
    private Socket s;
private int ok;
private String ligne, ligne_1, ob, spi, li2;
private String type_ec, nom_ec, logo_ec, pho_ec, type_pay;
private static Connection con;


    private static Connection con_miki() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url, user, motdepasse;
        url="jdbc:mysql://localhost:3306/";
        user="root";
        motdepasse="";
        Connection con = DriverManager.getConnection(url+"samac", user, motdepasse);
        con.setAutoCommit(false);
        return con;
    }
    
     private static  void Updatetable_cc_exam(String nomtab, String mat, String col, String val){
        
     try{
     
            con = con_miki();
            PreparedStatement pstat = con.prepareStatement("UPDATE `"+nomtab+"` SET `"+col+"` = ?  WHERE `Matricule` = ? ");
            con.setAutoCommit(false);   
            pstat.setString(1, val);
             pstat.setString(2, mat);
            int low = pstat.executeUpdate();
            if (low==1) {System.out.println("modification de la ligne dans la table réussie, un pas vers la gloire");
            con.commit();
            }
            else con.rollback();
            
            
     }catch(Exception e){
         System.out.println("problème de mise à jour de la table d'inscription");
         e.printStackTrace();
     }
}
    
    public static void main(String[] args) {
        // TODO code application logic here
      
    Updatetable_cc_exam("if3", "EB7904", "Analysecc", "27a");
}}
