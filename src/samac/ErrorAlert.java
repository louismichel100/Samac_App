/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

/**
 *
 * @author NGONO
 */
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
 
public class ErrorAlert extends Application {
 
    // Show a Warning Alert with header Text
    public void showAlertWithHeaderText(String titre, String header, String content_text) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(header);
        alert.setContentText(content_text);
 
        alert.showAndWait();
    }
 
    // Show a Warning Alert with default header Text
    public void showAlertWithDefaultHeaderText(String titre, String content_text) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titre);
 
        // alert.setHeaderText("Battery Status:");
        alert.setContentText(content_text);
 
        alert.showAndWait();
    }
 
    // Show a Warning Alert without Header Text
    public void showAlertWithoutHeaderText(String titre, String content_text) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titre);
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(content_text);
 
        alert.showAndWait();
    }
 
    @Override
    public void start(Stage stage) {
 
        VBox root = new VBox();
        String a = new String(), b = new String(), c = new String();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
 
        Button button1 = new Button("Warning Alert");
        Button button2 = new Button("Warning Alert with default Header Text");
        Button button3 = new Button("Warning Alert without Header Text");
 
        button1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithHeaderText(a, b, c);
            }
        });
 
        button2.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithDefaultHeaderText(a, b);
            }
        });
 
        button3.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                showAlertWithoutHeaderText(a,b);
            }
        });
 
        root.getChildren().addAll(button1, button2, button3);
 
        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("Erreur de Saisie");
        stage.setScene(scene);
 
        stage.show();
 
    }
 
    public static void main(String args[]) {
        launch(args);
    }
 
}