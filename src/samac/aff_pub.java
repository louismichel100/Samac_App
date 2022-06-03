/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.sun.activation.viewers.TextViewer;
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
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author NGONO
 */
public class aff_pub extends Application {
    
    private String code_fil = new String();
    private String nom_util = new String();
    private TableView<publication> table = new TableView();
    private String [] tabp, tabex;
     private ObservableList<publication> noteData = FXCollections.observableArrayList();
     private int ki = 0;
     
     final int port = 8080;
    private Socket s, ss;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String [] tapu;
    private generer1 dossier;
    
    
     
     
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setTitle("Publication de "+code_fil.toUpperCase());
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
         TableColumn<publication, String> na = new TableColumn<>("Unité d'enseignement");
         na.setCellValueFactory(new PropertyValueFactory<>("mat"));
         na.setMinWidth(100);
         
         TableColumn<publication, String> notaa = new TableColumn<>("Titre");
         notaa.setCellValueFactory(new PropertyValueFactory<>("val"));
         notaa.setMinWidth(100);
         
         table.getColumns().setAll(na, notaa);
         table.setTranslateX(0);
         table.setTranslateY(0);
         table.setEditable(false);
         table.setMinHeight(600);
         table.setMinWidth(600);
         
         int lk = tabp.length;
         int v = 0;
         
         while(v<lk){
                                //note hu = new note(tab_bon[v], tab_bon[v+1], 0.0, 0.0);
           publication hu = new publication ();           
                                
           hu.set_mat(tabp[v]);
           int op = Integer.parseInt(tabp[v+1]);
           if (op == 1) hu.set_val("NOTE DE CC");
           if (op == 2) hu.set_val("NOTE DE CC_EXAM");
           
           
           
           
           noteData.add(hu);
           
           v ++;
           v ++;
           
           
         }
        
        
         table.getItems().addAll(noteData);
        
         
        
          table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
       @Override
       public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
           //Check whether item is selected and set value of selected item to Label
           if(table.getSelectionModel().getSelectedItem() != null) 
           {    
              TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
              ObservableList selectedCells = selectionModel.getSelectedCells();
              TablePosition tablePosition = (TablePosition) selectedCells.get(0);
              int val = tablePosition.getRow();             //getCellData(newValue);
              publication g = noteData.get(val);
              System.out.println(g.get_mat()+"  "+g.get_nom());
              if(g.get_nom().equals("NOTE DE CC")) ki = 1;
              else ki = 2;
              
              try{
    
                        int num_ser = 19;
  

                        ss = new Socket("localhost", port);
                        out = ss.getOutputStream();
                        in = ss.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);
                                   
                                    writer.println(num_ser);
                                    writer.flush();
                        
                                    writer.println(code_fil);
                                    writer.flush();
                                    
                                    writer.println(g.get_mat());
                                    writer.flush();
                        
                                    writer.println(ki);
                                    writer.flush();
                                    
                                    int kom = Integer.parseInt(reader.readLine());
                                    
                                     tapu = new String [kom];
                            for(int j = 0; j<kom; j++){
                                   tapu[j] = reader.readLine();
                                   System.out.println(tapu[j]);
                               }
                            
                            if (ki==1){
                                int jl = (kom/3);
                                String h = ""+jl;
                                
                                dossier.generer3(tapu, code_fil, h, g.get_mat().toUpperCase());
                            }
                            
                            if (ki==2){
                                int jl = (kom/4);
                                String h = ""+jl;
                                
                                dossier.generer4(tapu, code_fil, h, g.get_mat().toUpperCase());
                            }
                                    
                                   
                        
                         ss.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
            }
            }
        });
         
        
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        root.getChildren().addAll(table);
        Scene scene = new Scene(root, 600, 600, Color.YELLOWGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public aff_pub(String nom_ut, String nom , String [] g){
        code_fil = nom_ut;
        nom_util = nom;
        tabp =g;
        
    }
    
    public aff_pub(){
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
