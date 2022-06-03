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
public class page_mm2 extends Application {
     final Text text1 = new Text("Veuillez entrer le code de la filière en un mot");
     private TextField text7 = new TextField();
     private Button p_1 = new Button("Valider");
     
     private ErrorAlert erreur = new ErrorAlert();
     
     final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
   
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
         
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
                
                
          aff_diss pw = new aff_diss(text7.getText());
                           pw.start(new Stage());
                           primaryStage.close();  
                          
                    
                
            } else JOptionPane.showMessageDialog(null, "Veuillez remplir toutes les informations néccessaires");
     }
 });
         
         
         
        Group root = new Group();
        root.getChildren().addAll(text1, text7, p_1);
        
        Scene scene = new Scene(root, 300, 175, Color.YELLOWGREEN);
        
        primaryStage.setTitle("Code de la filière");
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
