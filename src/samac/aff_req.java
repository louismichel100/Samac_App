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
import static javafx.application.Application.launch;
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
public class aff_req extends Application {
    
    private String code_fil = new String();
    private String nom_util = new String();
    private TableView<rx> table = new TableView();
    private String [] tabp, tabex;
     private ObservableList<rx> noteData = FXCollections.observableArrayList();
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
        primaryStage.setTitle("Requetes "+code_fil.toUpperCase());
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
         TableColumn<rx, String> na = new TableColumn<>("Unité d'enseignement");
         na.setCellValueFactory(new PropertyValueFactory<>("mat"));
         na.setMinWidth(100);
         
         TableColumn<rx, String> notaa = new TableColumn<>("Nom Etudiant");
         notaa.setCellValueFactory(new PropertyValueFactory<>("val"));
         notaa.setMinWidth(100);
         
         TableColumn<rx, String> notaaa = new TableColumn<>("Objet");
         notaa.setCellValueFactory(new PropertyValueFactory<>("val_p"));
         notaa.setMinWidth(100);
         
         table.getColumns().setAll(na, notaa, notaaa);
         table.setTranslateX(0);
         table.setTranslateY(0);
         table.setEditable(false);
         table.setMinHeight(600);
         table.setMinWidth(600);
         
         int lk = tabp.length;
         int v = 0;
         
         while(v<lk){
                                //note hu = new note(tab_bon[v], tab_bon[v+1], 0.0, 0.0);
           rx hu = new rx ();           
                                
           hu.set_mat(tabp[v]);
           hu.set_val(tabp[v+1]);
           hu.set_val_p(tabp[v+2]);
           
           
           
           
           
           
           noteData.add(hu);
           
           v ++;
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
              rx g = noteData.get(val);
              
              
              
             
              
             
            }
            }
        });
         
        
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        root.getChildren().addAll(table);
        Scene scene = new Scene(root, 600, 600, Color.YELLOWGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public aff_req(String [] g){
       
        tabp =g;
        
    }
    
    public aff_req(){
       
        tabp = new String []{"miko", "mika", "molo"};
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
