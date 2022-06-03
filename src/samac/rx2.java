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
import static javafx.application.Application.launch;
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
public class rx2 extends Application {
     final Text text1 = new Text("Veuillez entrer la filière");
     private TextField text7 = new TextField();
     private Button p_1 = new Button("Valider");
     
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
        
       
        
       
            
             
             
       
        
        
         p_1.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {
        
            if ((text7.getText() != null && !text7.getText().isEmpty())){
                
                
            
                
                try{
    
                        int num_serv = 24 ;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(text7.getText());
                        writer.flush();
                        
                        
                        int k1 = Integer.parseInt(reader.readLine());
                        
                        
                        if(k1 == 0){
                            JOptionPane.showMessageDialog(null, "Pas de requetes pour cette filière");
                        } else{
                        
                               String t1 [] = new String [k1];
                               for(int j = 0; j<10; j++){
                                   t1[j] = reader.readLine();
                               }
                               
                           aff_req w= new aff_req(t1);
                           w.start(new Stage());
                           primaryStage.close();  
                           
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
        root.getChildren().addAll(text1, text7, p_1);
        
        Scene scene = new Scene(root, 300, 175, Color.DARKGOLDENROD);
        
        primaryStage.setTitle("Consultation des requetes");
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
