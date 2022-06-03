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
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */
public class page_cons extends Application {
    
    final Text text1 = new Text("Veuillez entrer votre nom d'utilisateur et votre mot de passe");
    final Text text2 = new Text("Nom d'utilisateur");
    final Text text3 = new Text("Mot de passe"); 
    final Text text4 = new Text("Mot de passe oublié"); 
    final Text text5 = new Text("Inscription");
    final Text text6 = new Text("Connexion anonyme");
    final Text text9 = new Text("Filière");
    private TextField text7 = new TextField();
    private PasswordField text8 = new PasswordField();
    
    private GridPane grid = new GridPane();
    
    private Button p_1 = new Button("Valider");
   
    
    private ErrorAlert erreur = new ErrorAlert();
     
    final int port = 8080;
    //final int port = 8888;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String mm = new String("Vérifiez votre connexion à internet et réessayez");
    private String tt = new String("Problème de Connexion");
    
    private String mmm = new String("Nom d'utilisateur ou mot de passe éronnés");
    private String ttt = new String("Problème de Connexion");
    
    private String m = new String("Veuillez remplir tous les champs puis valider");
    private String t = new String("Erreur de saisie");
    
    private ChoiceBox spin3 = new ChoiceBox();
    
     private String [] tab_bon;
     private int okt = 0;
    
    @Override
    public void start(Stage primaryStage) {
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        
        /// chargement des filiere de choix
        
        try{
    
                        int num_serv = 17;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        int lk = Integer.parseInt(reader.readLine());
                        System.out.println(lk);
                        tab_bon = new String [lk];
                        for(int j = 0; j<lk; j++){
                                   tab_bon[j] = reader.readLine();
                                   System.out.println(tab_bon[j]);
                        }
                        
                        spin3 = new ChoiceBox(FXCollections.observableArrayList(tab_bon));
                        spin3.setAccessibleText(STYLESHEET_CASPIAN);
                        spin3.setValue(null);
                        
                        s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          p.printStackTrace();
                          }
        
        
        ///// configuration du spin
        
        spin3.valueProperty().addListener(new ChangeListener(){

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                
                if(newValue != null){
                //String st = spin3.getValue().toString();
                //System.out.println(st);
                okt = 1;
                
                }
            }
            
         });
       
        
        
        //traitement du texte
        
        text1.setFont(Font.font("VIVALDI", 20));
        text1.setFill(Color.WHITE);
        
        text2.setFont(Font.font("VIVALDI", 20));
        text2.setFill(Color.WHITE);
        
        text9.setFont(Font.font("VIVALDI", 20));
        text9.setFill(Color.WHITE);
        
        text3.setFont(Font.font("VIVALDI", 20));
        text3.setFill(Color.WHITE);
        
        text4.setFont(Font.font("VIVALDI", 20));
        text4.setFill(Color.WHITE);
        
        text5.setFont(Font.font("VIVALDI", 20));
        text5.setFill(Color.WHITE);
        
        text6.setFont(Font.font("VIVALDI", 20));
        text6.setFill(Color.WHITE);
        
        text1.setTranslateX(25);
        text1.setTranslateY(25);
             
        // configuration du gridpane
        
        grid.setTranslateX(15);
        grid.setTranslateY(50);
        
        
        grid.add(text2, 0, 0);
        grid.add(text3, 0, 1);
        grid.add(text4, 2, 2);
        grid.add(text5, 2, 3);
        grid.add(text6, 2, 4);
        grid.add(text7, 1, 0);
        grid.add(text8, 1, 1);
        
        grid.add(text9, 0, 2);
        grid.add(spin3, 1, 2);
        
        grid.add(p_1, 1, 3);
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setFocusTraversable(true);
        
        text7.setMinSize(10, 10);
        text7.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        text8.setMinSize(10, 10);
        text8.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        // mot de passe oublié
        
       
        text4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text4.cursorProperty().set(Cursor.HAND);
                text4.setUnderline(true);
               
            }
            
        });
        
        text4.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text4.cursorProperty().set(Cursor.DEFAULT);
                text4.setUnderline(false);
               
            }
            
        }); 
        
        text5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text5.cursorProperty().set(Cursor.HAND);
                text5.setUnderline(true);
               
            }
            
        });
                          
        text5.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text5.cursorProperty().set(Cursor.DEFAULT);
                text5.setUnderline(false);
               
            }
            
        });
        
        text6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text6.cursorProperty().set(Cursor.HAND);
                text6.setUnderline(true);
               
            }
            
        });
        
        text6.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text6.cursorProperty().set(Cursor.DEFAULT);
                text6.setUnderline(false);
             
            }
            
        });
        
        text4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           page_m pw = new page_m();
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
        
        text5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           page_ins pww = new page_ins();
                           pww.start(new Stage());
                           primaryStage.close();  
            }
        });
        
        text6.setOnMouseClicked((MouseEvent e) -> {
            page_p1_s p = new page_p1_s("anonyme");
            p.start(new Stage());
            primaryStage.close();
        });
        
        
        p_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if((text7.getText() != null && !text7.getText().isEmpty()) & (text8.getText() != null && !text8.getText().isEmpty())){
                    
                    try{
    
                        int num_serv = 1;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(text7.getText());
                        writer.flush();
                        
                        writer.println(text8.getText());
                        writer.flush();
                        
                        int ok = Integer.parseInt(reader.readLine());
                        
                        if (ok == 1){
                            if(okt == 0){
                            page_p1_s p = new page_p1_s(text7.getText());
                            //page_p1_s p = new page_p1_s(); spin3.getValue().toString();
                            
                            p.start(new Stage());
                            System.out.println("ouvre toi");
                           primaryStage.close();  }
                            else {
                               page_p1_s p = new page_p1_s(text7.getText(), spin3.getValue().toString());
                            //page_p1_s p = new page_p1_s(); spin3.getValue().toString();
                            
                            p.start(new Stage());
                            System.out.println("ouvre toi");
                           primaryStage.close(); 
                            }
                        } else {
                            erreur.showAlertWithoutHeaderText(ttt, mmm);
                            text7.clear();
                            text8.clear();
                        }
                       
                        
                        
                  s.close();
                    } catch (Exception p){
                        //System.out.println("erreur 7");
                        //p.printStackTrace();
                        erreur.showAlertWithoutHeaderText(tt, mm);
                        text7.clear();
                        text8.clear();
                          }
                    
                   
            } else erreur.showAlertWithoutHeaderText(t, m);
                    
                    
                }
            
        });
        
        
        
        
        
        
        
        
        Group root = new Group();
        root.getChildren().addAll(grid, text1);
        
        Scene scene = new Scene(root, 440, 230, Color.DARKGOLDENROD);
        
        primaryStage.setTitle("Connexion");
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



/// le principe est le suivant; enrigistré un repertoire sur le serveur, et stoccker le path dans la bd
