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
import java.util.function.UnaryOperator;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */
public class requ extends Application {
     final Text text1 = new Text("Veuillez entrer l'unité d'enseignement");
     final Text text2 = new Text("Veuillez entrer le motif de votre requete");
     private TextField text7 = new TextField();
     private TextField text8 = new TextField();
     private Button p_1 = new Button("Valider");
     private Button p_2 = new Button("Retour");
     private ErrorAlert erreur = new ErrorAlert();
     
     final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String code_f = new String();
    private String t = new String("Erreur de saisie");
    
    private String mm = new String("Vérifiez votre connexion à internet et réessayez");
    private String tt = new String("Problème de Connexion");
    
    private String mmm = new String("Votre numéro de CNI ne correspond à aucun utilisateur");
    private String ttt = new String("Problème d'identification");
    private String cc = new String("Veuillez vérifier à nouveau votre numéro de cni ou proceder à une inscription");
    
    private String nu = new String("");
    private String mdp = new String("");
    
    private String apikey = new String("Votre APIKEY");
    private String number = new String("+237691798523");
    private String nom_u = new String();
    
    
    
    @Override
    public void start(Stage primaryStage) {
         primaryStage.initStyle(StageStyle.UTILITY);
         primaryStage.setResizable(false);
        
        text1.setFont(Font.font("VIVALDI", 20));
        text1.setFill(Color.WHITE);
        
        text1.setTranslateX(25);
        text1.setTranslateY(25);
        
        text2.setFont(Font.font("VIVALDI", 20));
        text2.setFill(Color.WHITE);
        
        text2.setTranslateX(25);
        text2.setTranslateY(100);
         
        text7.setTranslateX(75);
        text7.setTranslateY(50);
        
        p_1.setTranslateX(25);
        p_1.setTranslateY(200);
        
        
        
         
        
             p_1.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 
                 if ((text7.getText() != null && !text7.getText().isEmpty()) && (text8.getText() != null && !text8.getText().isEmpty())) {
                     
                     try {
                         
                         int num_serv = 23;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_f);
                        writer.flush();
                        writer.println(nom_u);
                        writer.flush();
                        writer.println(text7.getText());
                        writer.flush();
                        writer.println(text8.getText());
                        writer.flush();
                        
                        JOptionPane.showMessageDialog(null, "Requete enrigistrée avec succès"); 
                        primaryStage.close();
                         
                     } catch (Exception e) {
                         JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                     } 
                     
                     
                 } else JOptionPane.showMessageDialog(null, "Veuillez remplir correctement tous les champs");
                 
             }
         });
             
             
       
        
        text8.setTranslateX(80);
        text8.setTranslateY(120);
        
        text8.setMinSize(250,50);
        
        
        
        
         
         
         
         
        Group root = new Group();
        root.getChildren().addAll(text1, text7, p_1, text8, text2);
        primaryStage.setTitle("Requete "+code_f.toUpperCase());
        Scene scene = new Scene(root, 400, 300, Color.DARKGOLDENROD);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public requ (String h, String po){
        code_f = h;
        nom_u = po;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
