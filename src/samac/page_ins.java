/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author NGONO
 */
public class page_ins extends Application {
    
    final Text text_1 = new Text("Veuillez remplir vos informations personnelles");
    final Text text_2 = new Text("Noms");
    final Text text_3 = new Text("Prénoms");
    final Text text_4 = new Text("Date de naissance");
    final Text text_5 = new Text("Numéro de la cni");
    final Text text_6 = new Text("Email");
    final Text text_7 = new Text("Téléphone");
    final Text text_8 = new Text("Statut");
    final Text text_9 = new Text("Matricule");
    final Text text_10 = new Text("Filiere");
    final Text text_100 = new Text("Niveau");
    final Text text_113 = new Text("Grade");
    final Text text_114 = new Text("Département");

    
    
    
    
    
    private TextField text_13 = new TextField();
    private TextField text_14 = new TextField();
    
    private TextField text_15 = new TextField();
    private TextField text_16 = new TextField();
    private TextField text_17 = new TextField();
    
    private TextField text_18 = new TextField();
    private TextField text_19 = new TextField();
    private TextField text_20 = new TextField();
    private TextField text_200 = new TextField();
    private TextField text_23 = new TextField();
    private TextField text_24 = new TextField();
    
    private ChoiceBox spin = new ChoiceBox();
    
    
    private GridPane grid_1 = new GridPane();
    
    private Button p_1 = new Button("Enregistrer");
    
    private Button p_2 = new Button("Générer");
    
    private Button p_3 = new Button("Générer");
    
    private Button p_4 = new Button("Générer");
    
    
    
    
    private ErrorAlert erreur = new ErrorAlert();
    private informationalert inf = new informationalert();
    
    private String t1 = "Erreur de saisie";
    private String h1 = "Email invalide";
    
    private String te1 = "Veuillez entrer une adresse email valide";
    private String hd = "Date de naissance invalide";
    private String td = "Veuillez entrer une date de naissance valide\n jj/mm/aaaa ou jj-mm-aaaa";
    private String st;
     
    
    private String h2 = "Statut non disponible";
    private String te2 = "Veuillez choisir votre statut";
    private String te3 = "Veuillez remplir correctemment tout les champs";
    private DateUtil_s dda;
    
    final int port = 8080;
    private Socket s;
    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    

    
    
    final FileChooser file_chooser_1 = new FileChooser();
    final FileChooser file_chooser_2 = new FileChooser();
    final Button bout_ma = new Button("....");
    final Button bout_me = new Button("....");
    final Text text_11 = new Text("Sélectionner votre\nphoto");
    final Text text_12 = new Text("Veuillez fournir\n une photo");
    private TextField text_21 = new TextField();
    private TextField text_22 = new TextField();
    
    private int loop = 0;
    private int loop2 = 0;
    
   

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bienvenu sur BBS-UD");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
       
             text_1.setTranslateX(225);
             text_1.setTranslateY(35);
         
             text_1.setFont(Font.font("VIVALDI", 25));
             text_1.setFill(Color.WHITE);   
        
             text_2.setFont(Font.font("VIVALDI", 25));
             text_2.setFill(Color.WHITE);
             text_3.setFont(Font.font("VIVALDI", 25));
             text_3.setFill(Color.WHITE);
             text_4.setFont(Font.font("VIVALDI", 25));
             text_4.setFill(Color.WHITE);
             text_5.setFont(Font.font("VIVALDI", 25));
             text_5.setFill(Color.WHITE);
             text_6.setFont(Font.font("VIVALDI", 25));
             text_6.setFill(Color.WHITE);
             text_7.setFont(Font.font("VIVALDI", 25));
             text_7.setFill(Color.WHITE);   
             text_8.setFont(Font.font("VIVALDI", 25));
             text_8.setFill(Color.WHITE);
             text_9.setFont(Font.font("VIVALDI", 25));
             text_9.setFill(Color.WHITE);
             text_10.setFont(Font.font("VIVALDI", 25));
             text_10.setFill(Color.WHITE);
             text_100.setFont(Font.font("VIVALDI", 25));
             text_100.setFill(Color.WHITE);
             text_11.setFont(Font.font("VIVALDI", 25));
             text_11.setFill(Color.WHITE);
             text_12.setFont(Font.font("VIVALDI", 25));
             text_12.setFill(Color.WHITE);
             text_113.setFont(Font.font("VIVALDI", 25));
             text_113.setFill(Color.WHITE);
             text_114.setFont(Font.font("VIVALDI", 25));
             text_114.setFill(Color.WHITE);
             
             
             
        text_13.setMinSize(15, 15);
        text_13.fontProperty().set(Font.font("TimesNewRoman", 12));
             
        text_14.setMinSize(15, 15);
        text_14.fontProperty().set(Font.font("TimesNewRoman", 12));
       
        text_15.setMinSize(15, 15);
        text_15.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_16.setMinSize(15, 15);
        text_16.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_17.setMinSize(15, 15);
        text_17.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        
        text_18.setMinSize(15, 15);
        text_18.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_19.setMinSize(15, 15);
        text_19.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_20.setMinSize(15, 15);
        text_20.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_200.setMinSize(15, 15);
        text_200.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_21.setMinSize(15, 15);
        text_21.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_22.setMinSize(15, 15);
        text_22.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_23.setMinSize(15, 15);
        text_23.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text_24.setMinSize(15, 15);
        text_24.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        
        
        text_13.setPromptText("MBALLA");
        text_14.setPromptText("MICHEL");
        text_15.setPromptText("12-12-1990 ou 12/12/1990");
        text_16.setPromptText("Carte nationale d'identité");
        text_17.setPromptText("michel@yahoo.fr");
        text_18.setPromptText("666666666");
        text_19.setPromptText("19G974533");
        text_20.setPromptText("Electronique");
        text_200.setPromptText("3");
        text_21.setPromptText("télécharger une photo");
        text_22.setPromptText("télécharger une photo");
        text_23.setPromptText("Grade");
        text_24.setPromptText("Maths-Info");
       
        
        grid_1.setFocusTraversable(true);
        
        
        spin = new ChoiceBox(FXCollections.observableArrayList("Etudiant", "Enseignant"));
        spin.setAccessibleText(STYLESHEET_MODENA);
        spin.setValue(null);
             //ajout du texte dans le gridpane
             
             grid_1.add(text_2, 0, 0);
             grid_1.add(text_3, 0, 1);
             grid_1.add(text_4, 0, 2);
             grid_1.add(text_5, 0, 3);
             grid_1.add(text_6, 0, 4);
             grid_1.add(text_7, 0, 5);
             grid_1.add(text_9, 0, 6);
             grid_1.add(text_8, 0, 7);
            
             
             grid_1.add(text_13, 2, 0);
             grid_1.add(text_14, 2, 1);
             grid_1.add(text_15, 2, 2);
             grid_1.add(text_16, 2, 3);
             grid_1.add(text_17, 2, 4);
             grid_1.add(text_18, 2, 5);
             grid_1.add(text_19, 2, 6);
             grid_1.add(spin, 2, 7);
            
             grid_1.add(p_1, 13, 10);
             grid_1.add(p_2, 13, 3);
             
             
             
             //// réfléchis comment activer les formatteurs tout en utilisant le bouton generer
             
             
             /*
             
             //controle du telephone
             final UnaryOperator<TextFormatter.Change> integerOnlyFilter = text_18 -> { 
                    final String text = text_18.getText(); 
                    return (text.isEmpty() || text .matches("[0-9]")) ? text_18 : null; 
                     }; 
             final TextFormatter<Integer> integerOnlyFormatter = new TextFormatter(integerOnlyFilter);
             text_18.setTextFormatter(integerOnlyFormatter);
             
             //controle de la cni
             
             final UnaryOperator<TextFormatter.Change> integerOnlyFilte = text_16 -> { 
                    final String text = text_16.getText(); 
                    return (text.isEmpty() || text .matches("[0-9]")) ? text_16 : null; 
                     }; 
             final TextFormatter<Integer> integerOnlyFormatte = new TextFormatter(integerOnlyFilte);
             text_16.setTextFormatter(integerOnlyFormatte);
             
            */ 
             
         // mettons y un petit listerner
         
         spin.valueProperty().addListener(new ChangeListener(){

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                
                if(newValue != null){
                st = spin.getValue().toString();
                System.out.println("miki voici ca"+st);

                if(st.equals("Enseignant")){
                    //System.out.println("Medecin");
                    grid_1.add(text_113, 0, 8);
                    grid_1.add(text_23, 2, 8);
                    
                    grid_1.add(text_114, 0, 10);
                    grid_1.add(text_24, 2, 10);
                    
                     grid_1.add(text_12, 0, 9);
                     grid_1.add(bout_me, 2, 9);
                     grid_1.add(text_22, 3, 9);
                     grid_1.add(p_4, 13, 8);
                     
                     text_20.clear();
                     text_21.clear();
                     text_200.clear();
                     grid_1.getChildren().removeAll(text_21, text_11, bout_ma,text_20, text_10, text_100, text_200, p_3);
                     
                     loop = 2;
                }
                
                if(st.equals("Etudiant")){
                    //System.out.println("Malade");
                     grid_1.add(text_10, 0, 8);
                     grid_1.add(text_20, 2, 8);
                     
                     grid_1.add(text_100, 0, 9);
                     grid_1.add(text_200, 2, 9);
                     
                     grid_1.add(text_11, 0, 10);
                     grid_1.add(bout_ma, 2, 10);
                     grid_1.add(text_21, 3, 10);
                     grid_1.add(p_3, 13, 8);
                     
                     text_22.clear();
                     text_23.clear();
                     text_24.clear();
                     grid_1.getChildren().removeAll(text_22, text_12, bout_me,text_23, text_113, text_24, text_114, p_4);
                     
                     loop = 1;
                }
                
            }
            }
            
         });
         
         ////////configuration des boutons
         
          bout_ma.setMinWidth(75);
        
        bout_ma.setOnAction(new EventHandler<ActionEvent>() {
            
           @Override
           public void handle(ActionEvent event) {
              //Get image url
              
              try{
                  
              
                  File file_2 = file_chooser_2.showOpenDialog(primaryStage);
                  
                  if(file_2.isFile() && (file_2.getName().contains(".bmp") || file_2.getName().contains(".jpg") || file_2.getName().contains(".png") || file_2.getName().contains(".gif"))){
                      
                      String url_e = file_2.toURI().toURL().toString();
                      text_21.setText(url_e);
                  }
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(javafx.scene.image.Image.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
              
           }
       });
        
        
        ///////////
        
         bout_me.setMinWidth(75);
         
         
         
         p_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generer1();
            }
        });
         
         p_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generer2();
            }
        });
         
          p_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generer3();
            }
        });
        
        bout_me.setOnAction(new EventHandler<ActionEvent>() {
            
           @Override
           public void handle(ActionEvent event) {
              //Get image url
              
              try{
                  
              
                  File file_2 = file_chooser_2.showOpenDialog(primaryStage);
                  
                  if(file_2.isFile() && (file_2.getName().contains(".bmp") || file_2.getName().contains(".jpg") || file_2.getName().contains(".png") || file_2.getName().contains(".gif"))){
                      
                      String url_e = file_2.toURI().toURL().toString();
                      text_22.setText(url_e);
                  }
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(javafx.scene.image.Image.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
              
           }
       });
        
        
             
        
        //le bouton
        
        p_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                int n, ok=0, temp = 0;
                if((text_13.getText() != null && !text_13.getText().isEmpty()) & (text_14.getText() != null && !text_14.getText().isEmpty()) & (text_15.getText() != null && !text_15.getText().isEmpty()) & (text_16.getText() != null && !text_16.getText().isEmpty()) & (text_17.getText() != null && !text_17.getText().isEmpty()) & (text_18.getText() != null && !text_18.getText().isEmpty()) & (text_19.getText() != null && !text_19.getText().isEmpty())){
                    
                    
                    //controle du spinner
                    if(spin.getValue() == null){
                    erreur.showAlertWithHeaderText(t1, h2, te2);
                    temp = 1;
                    }
                    //controle de l'email    
                           char [] tab = text_17.getText().toCharArray();
                           
                           int i = 0;
                           while(i<tab.length-1 && tab[i] != '@') i++;
                           
                        n = tab.length;
                        
                        if(i == n-1 || i==0){
                          erreur.showAlertWithHeaderText(t1, h1, te1);
           
                        } else if((i+9 == n-1 & tab[i+1] == 'y') || i+8 == n-1){
                            if(tab[i+1] == 'y'){
                                if(tab[i+2] == 'a'){
                                    if(tab[i+3] == 'h'){
                                        if(tab[i+4] == 'o'){
                                            if(tab[i+5] == 'o'){
                                                if(tab[i+6] == '.'){
                                                    if(tab[i+7] == 'c' || (tab[i+7] == 'f' & i+8 == n-1)){
                                                        if((tab[i+8] == 'o' & i+9 == n-1) || (tab[i+8] == 'r' & i+8 == n-1)){
                                                            if((tab[i+7] == 'f' & tab[i+8] == 'r' & i+8 == n-1) || (tab[i+8] == 'o' & tab[i+9] == 'm' & i+9 == n-1)) ok = 1;
                                                            else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                        }else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                    }else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                }else erreur.showAlertWithHeaderText(t1, h1, te1);
                                            } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                        } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                    } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                } else erreur.showAlertWithHeaderText(t1, h1, te1);
                            } else erreur.showAlertWithHeaderText(t1, h1, te1);
                        } else if(i+9 == n-1 & tab[i+1] == 'g'){
                            if(tab[i+1] == 'g'){
                                if(tab[i+2] == 'm'){
                                    if(tab[i+3] == 'a'){
                                        if(tab[i+4] == 'i'){
                                            if(tab[i+5] == 'l'){
                                                if(tab[i+6] == '.'){
                                                    if(tab[i+7] == 'c'){
                                                        if(tab[i+8] == 'o'){
                                                            if(tab[i+9] == 'm'){
                                                                ok = 1;
                                                            } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                        } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                    } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                                } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                            } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                        } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                    } else erreur.showAlertWithHeaderText(t1, h1, te1);
                                } else erreur.showAlertWithHeaderText(t1, h1, te1);
                            }
                        } else erreur.showAlertWithHeaderText(t1, h1, te1);
                    
                    
                    //controle de la date
                    
                    if((!dda.validDate(text_15.getText())) & (!dda.validDate_2(text_15.getText()))){
                        erreur.showAlertWithHeaderText(t1, hd, td);
                        temp = 1;
                    }
                    
                    
                    
                  
                  
                 
                   //System.out.println("suppréssion des ligne dans la table réussie, un pas vers la gloire");
                    
                } else erreur.showAlertWithoutHeaderText(t1, te3); 
                
                if((text_13.getText() != null && !text_13.getText().isEmpty()) & (text_14.getText() != null && !text_14.getText().isEmpty()) & (text_15.getText() != null && !text_15.getText().isEmpty()) & (text_16.getText() != null && !text_16.getText().isEmpty()) & (text_17.getText() != null && !text_17.getText().isEmpty()) & (text_18.getText() != null && !text_18.getText().isEmpty()) & (text_19.getText() != null && !text_19.getText().isEmpty()) & temp == 0 & ok == 1){
                    //System.out.println("suppréssion des ligne dans la table réussie, un pas vers la gloire");
                    
                   
                
                    
                    if(loop == 2){
                        
                      if((text_24.getText() != null && !text_24.getText().isEmpty()) & (text_22.getText() != null && !text_22.getText().isEmpty()) & (text_23.getText() != null && !text_23.getText().isEmpty())){
                        loop2 = 2;
                    } else {
                          //loop2 = 1;
                          erreur.showAlertWithoutHeaderText("Erreur de saisie", "Veuillez remplir correctement \n votre grade et votre diplome");
                      }
                    
                    }
                    
                    if(loop == 1){
                        
                      if((text_20.getText() != null && !text_20.getText().isEmpty()) & (text_21.getText() != null && !text_21.getText().isEmpty())){
                        loop2 = 1;
                    } else {
                          //loop2 = 1;
                          erreur.showAlertWithoutHeaderText("Erreur de saisie", "Veuillez remplir correctement \n votre maladie et votre dossier médical");
                      }
                    
                    }
                    
                    if((loop2 == 1) || (loop2 == 2)){
                    
                    try{
    
                        int num_serv = 2;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                       
                         //controle sur le nom  
                  try {
                 
                 BufferedReader buf = new BufferedReader(new CharArrayReader(test_ap(text_13.getText().toCharArray())));
                 String ligne = buf.readLine();
                 while (ligne!=null){
                     System.out.println(ligne);
                     writer.println(ligne);
                     writer.flush();                     // envoie de chaque lignes du text area
                 ligne = buf.readLine();
                }
        
                buf.close();
                 }catch (Exception err) { }  
                  
                  
                  //controle sur le prénom  
                  try {
                 
                 BufferedReader buff = new BufferedReader(new CharArrayReader(test_ap(text_14.getText().toCharArray())));
                 String ligne = buff.readLine();
                 while (ligne!=null){
                     System.out.println(ligne);
                     writer.println(ligne);
                     writer.flush();                     // envoie de chaque lignes du text area
                 ligne = buff.readLine();
                }
        
                buff.close();
                 }catch (Exception err) { }  
                       
                         
                        
                       
                        writer.println(text_15.getText());
                        writer.flush();                       // date de naissance 
                        
                        
                        writer.println(text_16.getText());    /// cni
                        writer.flush();
                        
                        
                        writer.println(text_17.getText());
                        writer.flush();                       ///email

                       
                        writer.println(text_18.getText());
                        writer.flush();                         /// telephone
                        
                       
                        writer.println(text_19.getText());   // envoie du matricule
                        writer.flush();
                        
                      
                        
                        if(loop2 == 1){   /// etudiant
                            
                        writer.println(1);
                        writer.flush();
                           
                        
                        writer.println(text_20.getText());   /////// filière
                        writer.flush();
                        
                        writer.println(text_200.getText());  /////// envoie du niveau
                        writer.flush();
                        
                       
                        writer.println(text_21.getText());   ////// envoie de la photo au serveur
                        writer.flush();   
                            
                        }
                        
                        
                        if(loop2 == 2){   /////enseignant
                            
                        writer.println(2);
                        writer.flush();
                        
                       
                        writer.println(text_23.getText());    /// grade
                        writer.flush();
                        
                       
                        writer.println(text_22.getText());    /// envoie de la photo
                        writer.flush();
                        
                        writer.println(text_24.getText());    /// départément
                        writer.flush();
                        
                        
                            
                        }
                        
                       
                        
                      
                       temp = 1;
                       ok = 2; 
                 
                                               
                        s.close();
                    } catch (Exception p){
                        //System.out.println("erreur 7");
                        p.printStackTrace();
                          }
                    
                    
                
                    // nettoyage
                    
                    text_13.clear();
                    text_14.clear();
                    text_15.clear();
                    text_16.clear();
                    text_17.clear();
                    text_18.clear();
                    text_19.clear();
                    text_20.clear();
                    text_21.clear();
                    text_22.clear();
                    text_23.clear();
                    text_200.clear();
                    text_24.clear();
                    
                   
                    spin.setValue(null);
                    
                  } else erreur.showAlertWithoutHeaderText("Erreur de saisie", "Veuillez remplir correctemment tout les champs");  
                    
                } else erreur.showAlertWithoutHeaderText("Erreur de saisie", "Veuillez remplir correctement tout les champs");

               if(temp == 1 & ok == 2){
                       inf.showAlertWithoutHeaderText("Informations Archivées", "Votre inscription est en attente de validation");
                       page_cons page_2 = new page_cons();
                       page_2.start(new Stage());
                       primaryStage.close();
                   }
                
              
            };
            
        });
        
        //background
        
       
        
        //gridpane
     
        
        grid_1.setVgap(5);
        grid_1.setHgap(5);
        grid_1.setTranslateX(100);
        grid_1.setTranslateY(63);
        //grid_1.getChildren().add(rec);
       
        
        Group root = new Group();
        root.getChildren().addAll(text_1, grid_1);
        root.setId("pane");
        
        
        Scene scene = new Scene(root, 810, 550, Color.AQUAMARINE);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        primaryStage.setScene(scene);
        
        
        primaryStage.show();
    }
    
    
    public char [] test_ap(char [] cc){
        
        
        int ok = 0;
        int ww = 1;
        while(ww<cc.length){
                    if(cc[ww] == '\'' & cc[ww-1] != '\\'){
                        ok = 1;
                        char [] ccc = new char[cc.length+1];
                        for(int w=0; w<ww; w++){
                            ccc[w] = cc[w];
                        }
                        ccc[ww] = '\\';
                        for(int w=ww+1; w<ccc.length; w++){
                            ccc[w] = cc[ww];
                            ww++;
                        }
                        
                        return test_ap(ccc);
                    }
                    
                   
                    
              ww++;      
                    
                   }
        return cc;
        
    }
    
    public void generer1(){
    
     matricule yu = new matricule();
     
     text_13.setText(yu.nom_pre());
     text_14.setText(yu.nom_pre());
     text_15.setText(yu.date());
     text_16.setText(yu.tel());
     text_18.setText(yu.tel());
     //text_17.setText(yu.mail());
     text_17.setText("sangala.michel@yahoo.fr");
     text_19.setText(yu.matricule());
        
}
    
    public void generer3(){
        
        Random random = ThreadLocalRandom.current();
        String [] tab_1 = new String [6];
        String [] tab_2 = new String [7];
        int i = 0;
        
        int a = random.nextInt(6); 
        while(a == 0){
        a = random.nextInt(6); 
       }
        
        
        
        tab_1[0] = "PROFESSEUR";
        tab_1[1] = "MAITRE DE CONFERENCE";
        tab_1[2] = "ASSISTANT";
        tab_1[3] = "CHARGE DE TD";
        tab_1[4] = "DOCTEUR";
        tab_1[5] = "INGENIEUR";
        
        tab_2[0] = "MATHS-INFO";
        tab_2[1] = "PHYSIQUE";
        tab_2[2] = "CHIMIE";
        tab_2[3] = "HISTOIRE";
        tab_2[4] = "GEOGRAPHIE";
        tab_2[5] = "FRANCAIS";
        tab_2[6] = "LETTRESBILINGUES";
        
        
        
        
        text_23.setText(tab_1[random.nextInt(tab_1.length)]);
        text_24.setText(tab_2[random.nextInt(tab_2.length)]);
        text_22.setText("C:\\Users\\NGONO\\Pictures"+a+".jpg");
        
        
    }
    
    
    public void generer2(){
        
        Random random = ThreadLocalRandom.current();
        String [] tab_1 = new String [12];
        int i = 0;
        
        int a = random.nextInt(6); 
        while(a == 0){
        a = random.nextInt(6); 
       }
        
        
        
        tab_1[0] = "IF";
        tab_1[1] = "IN";
        tab_1[2] = "AAG";
        tab_1[3] = "MAP";
        tab_1[4] = "PHYSIQUE";
        tab_1[5] = "CHIMIE";
        tab_1[6] = "LMF";
        tab_1[7] = "LETTRES BILINGUES";
        tab_1[8] = "HISTOIRE";
        tab_1[9] = "GEOGRAPHIE";
        tab_1[10] = "ESPAGNOLE";
        tab_1[11] = "ALLEMAND";
        
        text_20.setText(tab_1[random.nextInt(tab_1.length)]);
        text_200.setText(a+"");
        text_21.setText("C:\\Users\\NGONO\\Pictures"+a+".jpg");
        
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
