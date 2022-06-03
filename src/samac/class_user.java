/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */
public class class_user extends Application {
   
     private GridPane g = new GridPane();
     
     //private Button p_2 = new Button("Retour");
     private Text t = new Text("Vouss etes ici pour administrer les utilisateurs.\n Vous pouvez consuluter les fiches, \nrejeter ou accepter l'inscription d'un membre");
     String nom_u = "miki";
     private Button p_3 = new Button("Enseignants en attente");
     private Button p_4 = new Button("Etudiants en attente");
     private Button p_5 = new Button("Afficher__Dossier");
     private Button p_6 = new Button("Valider_inscription");
     
     ProgressBar bar;
    
    private Timeline animation;
   
     
    final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String t1 [] = new String [10];
    private String t2 [] = new String [10];
    private String t3 [] = new String [10];
    private String t4 [] = new String [10];
    private String t5 [] = new String [10];
    private String t6 [] = new String [10];
    
    private String tt1 [] = new String [10];
    private String tt2 [] = new String [10];
    private String tt3 [] = new String [10];
    private String tt4 [] = new String [10];
    private String tt5 [] = new String [10];
    private String tt6 [] = new String [10];
    
    private RadioButton [] tar;
    private String [] tap;
    
    private ToggleGroup group = new ToggleGroup();
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private RadioButton r6;
    
    private int yu = 0;
    
    private generer1 dossier;
    private int kio = 0;
     
     
     
     @Override
     public void start(Stage primaryStage) {
         
         Group root = new Group();
         
        primaryStage.setResizable(true);
        primaryStage.setTitle("Gestions des inscriptions");
        
        t.setFont(Font.font("VIVALDI", 20));
        t.setFill(Color.WHITE);
        
        t.setTranslateX(75);
        t.setTranslateY(20);
        
        p_3.setTranslateX(20);
        p_3.setTranslateY(100);
        
        p_4.setTranslateX(300);
        p_4.setTranslateY(100);
        
        p_6.setTranslateX(100);
        p_6.setTranslateY(500);
        
       
       
        g.setTranslateX(20);
        g.setTranslateY(150);
        g.setHgap(10);
        g.setVgap(10);
       
         
         
         ///////////bouton de retour
         
         
         
        //g.add(p_2, 10, 13); 
        g.add(p_5, 1, 13);
        
        ///////////animation d'enregistrement
        
        bar = new ProgressBar();
        bar.setMinSize(400, 10);
        bar.setMaxSize(400, 10);
        bar.setTranslateX(200);
        bar.setTranslateY(450);
        
        animation = new Timeline();
         animation.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(bar.progressProperty(), 0.0)
                       
                ),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(bar.progressProperty(), 0.1)
                ),
                new KeyFrame(Duration.seconds(2), new KeyValue(bar.progressProperty(), 0.2)),
                new KeyFrame(Duration.seconds(3), new KeyValue(bar.progressProperty(), 0.3)),
                new KeyFrame(Duration.seconds(4), new KeyValue(bar.progressProperty(), 0.4)),
                new KeyFrame(Duration.seconds(5), new KeyValue(bar.progressProperty(), 0.5)),
                new KeyFrame(Duration.seconds(6), new KeyValue(bar.progressProperty(), 0.6))
               
               
                
                );
         
         animation.autoReverseProperty();
         //animation.play();
         animation.onFinishedProperty().set((event) -> {
             class_user first = new class_user();
             Stage stagge = new Stage();
             first.start(stagge);
             primaryStage.close();
         });
        
        
        ////////////enregistrer un utilisateur
        
        p_6.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 
                 if(yu == 0) JOptionPane.showMessageDialog(null, "Veuillez choisir l'utilisateur\ndont vous voulez enregistrer l'inscription");
                 else{
                     if(kio == 1){
                         Toggle po = group.getSelectedToggle();
                         String nom = new String();
                         String mail = new String();
                         String mat = new String();
                         
                         
                     if(po.equals(r1)){
                       nom = t1[0];
                       mail = t1[4];
                       mat = t1[6];
                     }
                     
                     if(po.equals(r2)){
                        nom = t2[0];
                        mail = t2[4];
                       mat = t2[6];
                     }
                     
                     if(po.equals(r3)){
                         nom = t3[0];
                         mail = t3[4];
                       mat = t3[6];
                     }
                     
                     if(po.equals(r4)){
                         nom = t4[0];
                         mail = t4[4];
                       mat = t4[6];
                     }
                     
                     if(po.equals(r5)){
                         nom = t5[0];
                         mail = t5[4];
                       mat = t5[6];
                     }
                     
                     if(po.equals(r6)){
                         nom = t6[0];
                         mail = t6[4];
                       mat = t6[6];
                     }
                     
                     ////////
                     
                      try{
    
                        int num_serv = 7;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(mail);
                        writer.flush();
                        
                        writer.println(mat);
                        writer.flush();
                        JOptionPane.showMessageDialog(null, "Envoie des paramètres de connexion");
  
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "problème de connexion à internet");
                          
                          }
                      
                      
                     
                     //////
                         
                     } else if(kio == 2){
                         
                         Toggle po = group.getSelectedToggle();
                         String nom = new String();
                         String mail = new String();
                         String mat = new String();
                         String fil = new String();
                         String niv = new String();
                     if(po.equals(r1)){
                       nom = tt1[0]+" "+tt1[1];
                       mail = tt1[4];
                       mat = tt1[6];
                       fil = tt1[7];
                       niv = tt1[8];
                     }
                     
                     if(po.equals(r2)){
                        nom = tt2[0]+" "+tt2[1];
                        mail = tt2[4];
                       mat = tt2[6];
                       fil = tt2[7];
                       niv = tt2[8];
                     }
                     
                     if(po.equals(r3)){
                         nom = tt3[0]+" "+tt3[1];
                         mail = tt3[4];
                       mat = tt3[6];
                       fil = tt3[7];
                       niv = tt3[8];
                     }
                     
                     if(po.equals(r4)){
                         nom = tt4[0]+" "+tt4[1];
                         mail = tt4[4];
                       mat = tt4[6];
                       fil = tt4[7];
                       niv = tt4[8];
                     }
                     
                     if(po.equals(r5)){
                         nom = tt5[0]+" "+tt5[1];
                         mail = tt5[4];
                       mat = tt5[6];
                       fil = tt5[7];
                       niv = tt5[8];
                     }
                     
                     if(po.equals(r6)){
                         nom = tt6[0]+" "+tt6[1];
                         mail = tt6[4];
                       mat = tt6[6];
                       fil = tt6[7];
                       niv = tt6[8];
                     }
                     
                     
                     try{
    
                        int num_serv = 8;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(mail);
                        writer.flush();
                        
                        writer.println(mat);
                        writer.flush();
                        
                        writer.println(fil.toUpperCase());
                        writer.flush();
                        
                        writer.println(niv);
                        writer.flush();
                        
                        writer.println(nom);
                        writer.flush();
                        JOptionPane.showMessageDialog(null, "Envoie des paramètres de connexion");
                        //root.getChildren().add(bar);
                        //animation.play();
                        
                        int okk = Integer.parseInt(reader.readLine());
                        if (okk != 2){
        
                            JOptionPane.showMessageDialog(null, "Traitement non effectué, problème de connexion");
                       } else JOptionPane.showMessageDialog(null, "Un mail vous a été envoyé");
                        
                       
                        
                        System.out.println(mat+" "+fil+" "+niv+" "+nom);
  
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "problème de connexion à internet");
                          
                          }
                     
                     
                     
                     
                     }
                 }
             }
         });
        
        
        ////////instructions pour afficher le dossier de chaque medecins
        
        p_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if(yu == 0) JOptionPane.showMessageDialog(null, "Veuillez choisir l'utilisateur\ndont vous voulez afficher le dossier");
                 else {
                     if(kio == 1){
                     Toggle po = group.getSelectedToggle();
                     if(po.equals(r1)){
                         dossier.genererr(t1[0], t1[1], t1[3], t1[5], t1[4], t1[7], t1[9], t1[6], t1[8]);
                         r1.setSelected(false);
                     }
                     
                     if(po.equals(r2)){
                         dossier.genererr(t2[0], t2[1], t2[3], t2[5], t2[4], t2[7], t2[9], t2[6], t2[8]);
                         r2.setSelected(false);
                     }
                     
                     if(po.equals(r3)){
                         dossier.genererr(t3[0], t3[1], t3[3], t3[5], t3[4], t3[7], t3[9], t3[6], t3[8]);
                         r3.setSelected(false);
                     }
                     
                     if(po.equals(r4)){
                         dossier.genererr(t4[0], t4[1], t4[3], t4[5], t4[4], t4[7], t4[9], t4[6], t4[8]);
                         r4.setSelected(false);
                     }
                     
                     if(po.equals(r5)){
                         dossier.genererr(t5[0], t5[1], t5[3], t5[5], t5[4], t5[7], t5[9], t5[6], t5[8]);
                         r5.setSelected(false);
                     }
                     
                     if(po.equals(r6)){
                         dossier.genererr(t6[0], t6[1], t6[3], t6[5], t6[4], t6[7], t6[9], t6[6], t6[8]);
                         r6.setSelected(false);
                     }
                     
                 } else if(kio == 2){
                     Toggle po = group.getSelectedToggle();
                     if(po.equals(r1)){
                         dossier.generer(tt1[0], tt1[1], tt1[2], tt1[3], tt1[4], tt1[5], tt1[6], tt1[7], tt1[8], tt1[9]);
                         r1.setSelected(false);
                     }
                     
                     if(po.equals(r2)){
                         dossier.generer(tt2[0], tt2[1], tt2[2], tt2[3], tt2[4], tt2[5], tt2[6], tt2[7], tt2[8], tt2[9]);
                         r2.setSelected(false);
                     }
                     
                     if(po.equals(r3)){
                         dossier.generer(tt3[0], tt3[1], tt3[2], tt3[3], tt3[4], tt3[5], tt3[6], tt3[7], tt3[8], tt3[9]);
                         r3.setSelected(false);
                     }
                     
                     if(po.equals(r4)){
                         dossier.generer(tt4[0], tt4[1], tt4[2], tt4[3], tt4[4], tt4[5], tt4[6], tt4[7], tt4[8], tt4[9]);
                         r4.setSelected(false);
                     }
                     
                     if(po.equals(r5)){
                         dossier.generer(tt5[0], tt5[1], tt5[2], tt5[3], tt5[4], tt5[5], tt5[6], tt5[7], tt5[8], tt5[9]);
                         r5.setSelected(false);
                     }
                     
                     if(po.equals(r6)){
                         dossier.generer(tt6[0], tt6[1], tt6[2], tt6[3], tt6[4], tt6[5], tt6[6], tt6[7], tt6[8], tt6[9]);
                         r6.setSelected(false);
                     }
                     
                     
                 }
                     yu = 0;
                }
            }
        });
        
        
        /// gestion ds medecins
        
        p_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                g.getChildren().removeAll(r1, r2, r3, r4, r5, r6);
                kio = 1;
                 try{
    
                        int num_serv = 5;
                        int com = 0;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        int kok = Integer.parseInt(reader.readLine());
                        
                        if(kok == 0){
                            JOptionPane.showMessageDialog(null, "Pas de medecin en attente d'inscription");
                        } else{
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t1[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t2[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t3[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t4[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t5[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   t6[j] = reader.readLine();
                               }
                           }
                           
                           
                           
                           if(kok == 1){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                           } 
                           if(kok == 2){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(t2[0]+" "+t2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                           }
                           
                           if(kok == 3){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(t2[0]+" "+t2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(t3[0]+" "+t3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                           }
                           
                           if(kok == 4){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(t2[0]+" "+t2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(t3[0]+" "+t3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(t4[0]+" "+t4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                           }
                           
                           if(kok == 5){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(t2[0]+" "+t2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(t3[0]+" "+t3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(t4[0]+" "+t4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               
                               r5 = new RadioButton(t5[0]+" "+t5[1]);
                               r5.setTextFill(Color.WHITE);
                               r5.setToggleGroup(group);
                               r5.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                               g.add(r5, 1, 1);
                           }
                           
                           if(kok == 6){
                               r1 = new RadioButton(t1[0]+" "+t1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(t2[0]+" "+t2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(t3[0]+" "+t3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(t4[0]+" "+t4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               
                               r5 = new RadioButton(t5[0]+" "+t5[1]);
                               r5.setTextFill(Color.WHITE);
                               r5.setToggleGroup(group);
                               r5.setFocusTraversable(false);
                               
                               r6 = new RadioButton(t6[0]+" "+t6[1]);
                               r6.setTextFill(Color.WHITE);
                               r6.setToggleGroup(group);
                               r6.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                               g.add(r5, 1, 1);
                               g.add(r6, 2, 1);
                           }
                           
                        }
                        
                       
                        
                       
                                             
                    s.close();
                    } catch (Exception p){
                            
                                                    }
            }
        });
        
        //////////
        
        
        
        
        
        
        p_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                g.getChildren().removeAll(r1, r2, r3, r4, r5, r6);
                kio = 2;
                 try{
    
                        int num_serv = 6;
                        int com = 0;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        int kok = Integer.parseInt(reader.readLine());
                        
                        if(kok == 0){
                            JOptionPane.showMessageDialog(null, "Pas d'étudiant en attente d'inscription");
                        } else{
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt1[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt2[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt3[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt4[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt5[j] = reader.readLine();
                               }
                           }
                           if(com < kok){
                               com++;
                               for(int j = 0; j<10; j++){
                                   tt6[j] = reader.readLine();
                               }
                           }
                            int pm = com;
                            while(pm < kok){
                                String [] temp = new String [10];
                                for(int j = 0; j<10; j++){
                                   temp[j] = reader.readLine();
                               }
                                pm++;
                            }
                            
                            System.out.println("vooici kok = "+kok);
                           
                           if(com == 1){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                           } 
                           if(com == 2){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(tt2[0]+" "+tt2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                           }
                           
                           if(com == 3){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(tt2[0]+" "+tt2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(tt3[0]+" "+tt3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                           }
                           
                           if(com == 4){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(tt2[0]+" "+tt2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(tt3[0]+" "+tt3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(tt4[0]+" "+tt4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                           }
                           
                           if(com == 5){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(tt2[0]+" "+tt2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(tt3[0]+" "+tt3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(tt4[0]+" "+tt4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               
                               r5 = new RadioButton(tt5[0]+" "+tt5[1]);
                               r5.setTextFill(Color.WHITE);
                               r5.setToggleGroup(group);
                               r5.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                               g.add(r5, 1, 1);
                           }
                           
                           if(com == 6){
                               r1 = new RadioButton(tt1[0]+" "+tt1[1]);
                               r1.setTextFill(Color.WHITE);
                               r1.setToggleGroup(group);
                               r1.setFocusTraversable(false);
                               
                               r2 = new RadioButton(tt2[0]+" "+tt2[1]);
                               r2.setTextFill(Color.WHITE);
                               r2.setToggleGroup(group);
                               r2.setFocusTraversable(false);
                               
                               r3 = new RadioButton(tt3[0]+" "+tt3[1]);
                               r3.setTextFill(Color.WHITE);
                               r3.setToggleGroup(group);
                               r3.setFocusTraversable(false);
                               
                               r4 = new RadioButton(tt4[0]+" "+tt4[1]);
                               r4.setTextFill(Color.WHITE);
                               r4.setToggleGroup(group);
                               r4.setFocusTraversable(false);
                               
                               r5 = new RadioButton(tt5[0]+" "+tt5[1]);
                               r5.setTextFill(Color.WHITE);
                               r5.setToggleGroup(group);
                               r5.setFocusTraversable(false);
                               
                               r6 = new RadioButton(tt6[0]+" "+tt6[1]);
                               r6.setTextFill(Color.WHITE);
                               r6.setToggleGroup(group);
                               r6.setFocusTraversable(false);
                               g.add(r1, 0, 0);
                               g.add(r2, 1, 0);
                               g.add(r3, 2, 0);
                               g.add(r4, 0, 1);
                               g.add(r5, 1, 1);
                               g.add(r6, 2, 1);
                           }
                           
                        }
                        
                       
                        
                       
                                             
                    s.close();
                    } catch (Exception p){
                            
                                                    }
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        ///////////////
        
        group.selectedToggleProperty().addListener(new ChangeListener(){

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                
                yu = 1; 

            }

        }); 
         
         
         
        
        
        root.getChildren().addAll(t, g, p_3, p_4, p_6);
        
        Scene scene = new Scene(root, 540, 600, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
