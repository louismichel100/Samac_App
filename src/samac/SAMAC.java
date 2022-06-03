/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author NGONO
 */
public class SAMAC extends Application {
    

    public int ok;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Timeline to = new Timeline();
        
        samac_preloader pré = new samac_preloader();
        
        
        StackPane root = new StackPane();
        
     
        
        Scene scene = new Scene(root, 600, 650);
        
        ok = 1;
        if(ok == 1){
            Stage stage = new Stage();
            
            try{
                ok=2;
                primaryStage.close();
                pré.start(stage);
            } catch (Exception e){
                
            }
            ok = 2;
            
        } else{
             primaryStage.setTitle("SAMAC");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
