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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */



public class aff_diss extends Application {
    
    
    private String code_fil = new String();
    private TableView<mess> tablee = new TableView();
    
    final int port = 8080;
    private Socket s, ss;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    
    
    private ObservableList<mess> noteData = FXCollections.observableArrayList();
    
    private Text t1 = new Text("Méssage");

     private TextField t2 = new TextField();
      private TextField t3 = new TextField();
      private GridPane grid1 = new GridPane();
     private Button p_1 = new Button("Envoyer");
     private Button p_2 = new Button("Actualiser");
     
     
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        
        
        
        
        tablee.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         TableColumn<mess, String> na = new TableColumn<>("Message");
         na.setCellValueFactory(new PropertyValueFactory<>("mes"));
         na.setMinWidth(300);
         
         
         TableColumn<mess, String> notaa = new TableColumn<>("Auteur");
         notaa.setCellValueFactory(new PropertyValueFactory<>("aut"));
         notaa.setMinWidth(100);
         
         
         TableColumn<mess, String> nomaa = new TableColumn<>("Date-heure");
         nomaa.setCellValueFactory(new PropertyValueFactory<>("tp"));
         nomaa.setMinWidth(100);
         
         tablee.getColumns().setAll(na, notaa, nomaa);
         
         tablee.setTranslateX(20);
         tablee.setTranslateY(50);
         tablee.setEditable(true);
         tablee.setMinSize(600, 500);
         //tablee.setMinWidth(400);
         
         try {
             
              int num_serv = 21;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        int lk = Integer.parseInt(reader.readLine());
                        System.out.println(lk);
                        
                        if (lk > 0) {
                            
                           int ok = 0;
                           
                           while (ok < lk) {
                               mess gm = new mess () ;
                               
                               gm.set_mes(reader.readLine());
                               gm.set_aut(reader.readLine());
                               gm.set_tp(reader.readLine());
                               
                               ok ++;
                               ok ++;
                               ok ++;
                               
                               noteData.add(gm);
                           }
                            
                        }
                        
                        
                        tablee.getItems().addAll(noteData);
             
             
         }catch (Exception e) {
             e.printStackTrace();
         }
         
          tablee.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
       @Override
       public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
           
           if(tablee.getSelectionModel().getSelectedItem() != null) 
           {    
              TableView.TableViewSelectionModel selectionModel = tablee.getSelectionModel();
              ObservableList selectedCells = selectionModel.getSelectedCells();
              TablePosition tablePosition = (TablePosition) selectedCells.get(0);
              int val = tablePosition.getRow();             //getCellData(newValue);
              mess g = noteData.get(val);
              
              JOptionPane.showMessageDialog(null, g.get_mes());
              
           }
           
           
       }
       
          });
         
         
         //Configuration du gridpane
         
         grid1.add(t1, 0, 0);
        grid1.add(t2, 2, 0);
        grid1.add(t3, 4, 0);
        grid1.add(p_1, 0, 3);
        grid1.add(p_2, 1, 3);
        
        grid1.setTranslateX(20);
        grid1.setTranslateY(600);
        
        grid1.setHgap(1);
        grid1.setVgap(5);
        grid1.setFocusTraversable(true);
        
        
        t2.setMinSize(450, 50);
        t3.setPromptText("@author");
        
        //// configuration des boutons
        
        p_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if ((t2.getText() != null && !t2.getText().isEmpty())) {
                    
                    if ((t3.getText() != null && !t3.getText().isEmpty())) {
                        
                        try {
                            
                            int num_serv = 22;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        writer.println(t2.getText());
                        writer.flush();
                        writer.println(t3.getText());
                        writer.flush();
                        
                        aff_diss pw = new aff_diss(code_fil);
                           pw.start(new Stage());
                           primaryStage.close();  
                            
                            
                            
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                        }
                        
                    } else {
                      try {
                            
                            int num_serv = 22;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        writer.println(t2.getText());
                        writer.flush();
                        writer.println("anonyme");
                        writer.flush();
                        
                        aff_diss pw = new aff_diss(code_fil);
                           pw.start(new Stage());
                           primaryStage.close();  
                            
                            
                            
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                        }  
                        
                    }
                    
                    
                } else JOptionPane.showMessageDialog(null, "Veuillez completer le message");
                
            }
        });
        
        p_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                aff_diss pw = new aff_diss(code_fil);
                           pw.start(new Stage());
                           primaryStage.close(); 
                
            }
        });
        
        
        
        
        
        
        root.getChildren().addAll(tablee, grid1);
        Scene scene = new Scene(root, 700, 700, Color.YELLOWGREEN);
        primaryStage.setTitle("Centre de discussion "+code_fil.toUpperCase());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public aff_diss(String nom_ut){
        code_fil = nom_ut;
       
        
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
