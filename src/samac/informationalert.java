/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class informationalert extends Application {
 
    // Show a Information Alert with header Text
    public void showAlertWithHeaderText(String a, String b, String c) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(a);
        alert.setHeaderText(b);
        alert.setContentText(c);
 
        alert.showAndWait();
    }
 
    // Show a Information Alert with default header Text
    public void showAlertWithDefaultHeaderText(String a, String b) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(a);
 
        // alert.setHeaderText("Results:");
        alert.setContentText(b);
 
        alert.showAndWait();
    }
 
    // Show a Information Alert without Header Text
    public void showAlertWithoutHeaderText(String a, String b) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(a);
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(b);
 
        alert.showAndWait();
    }
 
    @Override
    public void start(Stage stage) {
 
    }
 
    public static void main(String args[]) {
        launch(args);
    }
 
}