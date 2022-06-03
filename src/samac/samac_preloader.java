/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author NGONO
 */
public class samac_preloader extends Preloader {
    
    ProgressBar bar;
    Stage stage;
    private Timeline animation;
    private ImageView bh2;
    
   
    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        Group p = new Group();
        bar.setMinSize(600, 10);
        bar.setMaxSize(600, 10);
        bar.setTranslateX(0);
        bar.setTranslateY(450);
        
        
     
        
               
        Text content = new Text("Chargement");
        content.setFont(Font.font("VIVALDI", 30));
        content.setFill(Color.BLACK);
        content.setTranslateX(210);
        content.setTranslateY(430);
        
        Text contentt = new Text("PGN OF UNIVERSITY OF DOUALA");
        contentt.setFont(Font.font("CALIBRI", 40));
        contentt.setFill(Color.BROWN);
        contentt.setTranslateX(35);
        contentt.setTranslateY(30);
        
       animation = new Timeline();
         animation.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(bar.progressProperty(), 0.0)
                       
                ),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(bar.progressProperty(), 0.1)
                ),
                new KeyFrame(Duration.seconds(2), new KeyValue(bar.progressProperty(), 0.2))
                
               
                
                );
         animation.play();
         animation.autoReverseProperty();
         animation.onFinishedProperty().set((event) -> {
             page_cons first = new page_cons();
             Stage stagge = new Stage();
             first.start(stagge);
             this.stage.close();
         });
         
         
         
         //////////added
         
         Path path = PathBuilder.create()
                .elements(
                    new MoveTo(0,30),
                    //new CubicCurveTo(380, 0, 380, 120, 200, 120),
                    //new CubicCurveTo(0, 120, 0, 240, 380, 240)
                    new CubicCurveTo(0, 30, 405, 30, 810, 30)
                    //new CubicCurveTo(400, 50, 200, 150, 0, 50),
                    //new CubicCurveTo(0, 50, 200, 500, 400, 50)
                    //new CubicCurveTo(400, 0, 200, 200, 0, 0)
                )
                .build();
        path.setStroke(Color.WHITESMOKE);
        path.getStrokeDashArray().setAll(5d,5d);
        
        Path pathh = PathBuilder.create()
                .elements(
                    new MoveTo(0,50),
                    //new CubicCurveTo(380, 0, 380, 120, 200, 120),
                    //new CubicCurveTo(0, 120, 0, 240, 380, 240)
                    new CubicCurveTo(0, 0, 505, 0, 600, 50)
                    //new CubicCurveTo(400, 50, 200, 150, 0, 50),
                    //new CubicCurveTo(0, 50, 200, 500, 400, 50)
                    //new CubicCurveTo(400, 0, 200, 200, 0, 0)
                )
                .build();
        pathh.setStroke(Color.BLUE);
        pathh.getStrokeDashArray().setAll(10d,5d);
        
        
         //définition du background
        
        bh2 = new ImageView(new Image(getClass().getResourceAsStream("images/b.jpg")));
        bh2.setFitHeight(350);
        bh2.setFitWidth(600);
        bh2.setTranslateX(0);
        bh2.setTranslateY(50);
         
         
          
        //p.setBottom(bar);
        //p.setCenter(content);
        p.getChildren().addAll(content, bar, path, pathh, bh2, contentt);///// really important to know how to add somethings else
        

        Scene scene = new Scene (p, 600, 500, Color.CORAL);
        
                      return scene;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene()); 
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    
    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }
    
    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        bar.setProgress(pn.getProgress());
    }    
    
}
