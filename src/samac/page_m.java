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
public class page_m extends Application {
     final Text text1 = new Text("Veuillez entrer le numéro de votre Cni");
     private TextField text7 = new TextField();
     private Button p_1 = new Button("Valider");
     private Button p_2 = new Button("Retour");
     private ErrorAlert erreur = new ErrorAlert();
     
     final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String m = new String("Veuillez entrer votre numéro de cni puis validez");
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
    private String message = new String("Envoi réussi, un pas vers la gloire");
    
    private ChoiceBox spin = new ChoiceBox();
    
    @Override
    public void start(Stage primaryStage) {
         primaryStage.initStyle(StageStyle.UTILITY);
         primaryStage.setResizable(false);
        
        text1.setFont(Font.font("VIVALDI", 20));
        text1.setFill(Color.WHITE);
        
        text1.setTranslateX(25);
        text1.setTranslateY(25);
         
        text7.setTranslateX(75);
        text7.setTranslateY(50);
        
        p_1.setTranslateX(75);
        p_1.setTranslateY(140);
        
        p_2.setTranslateX(140);
        p_2.setTranslateY(140);
        
        
         //controle de la cni
             
             final UnaryOperator<TextFormatter.Change> integerOnlyFilte = text7 -> { 
                    final String text = text7.getText(); 
                    return (text.isEmpty() || text .matches("[0-9]")) ? text7 : null; 
                     }; 
             final TextFormatter<Integer> integerOnlyFormatte = new TextFormatter(integerOnlyFilte);
             text7.setTextFormatter(integerOnlyFormatte);
        
             p_2.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 page_cons w= new page_cons();
                           w.start(new Stage());
                           primaryStage.close();  
             }
         });
             
             
        ///// configuration du spin
        
        spin = new ChoiceBox(FXCollections.observableArrayList("Etudiant", "Enseignant"));
        spin.setAccessibleText(STYLESHEET_MODENA);
        spin.setValue(null);
        
        spin.setTranslateX(80);
        spin.setTranslateY(90);
        
        
        
         p_1.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {
        
            if ((text7.getText() != null && !text7.getText().isEmpty()) && (spin.getValue() != null)){
                
                
            
                
                try{
    
                        int num_serv = 20 ;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(text7.getText());
                        writer.flush();
                        
                        writer.println(spin.getValue().toString());
                        writer.flush();
                        
                        int k1 = Integer.parseInt(reader.readLine());
                        
                        if(k1 == 1) {
                        
                        nu = reader.readLine();
                        mdp = reader.readLine();
                        
                        } else if (k1 == 2) JOptionPane.showMessageDialog(null, "Action intérrompue, vous n'etes pas connecté à internet");
                        else JOptionPane.showMessageDialog(null, "Le numéro de cni que vous avez entrée n'est pas valide");
                        
                        System.out.println("envoyé1 :"+text7.getText());
                        System.out.println("recu1 :"+nu+" et "+mdp);
                        
                        if(nu.equals("") || mdp.equals("")){
                            erreur.showAlertWithHeaderText(ttt, mmm, cc);
                            text7.clear();
                        } else {
                            
                            
                           
                        }
                        
                       
                        
                        
                  s.close();
                    } catch (Exception p){
                        //System.out.println("erreur 7");
                        //p.printStackTrace();
                        erreur.showAlertWithoutHeaderText(tt, mm);
                        text7.clear();
                          }
                    
            
                
            } else JOptionPane.showMessageDialog(null, "Veuillez remplir toutes les informations néccessaires");
     }
 });
         
         
         
        Group root = new Group();
        root.getChildren().addAll(text1, text7, p_1, p_2, spin);
        
        Scene scene = new Scene(root, 300, 175, Color.DARKGOLDENROD);
        
        primaryStage.setTitle("Mot de passe oublié");
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
