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
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */
public class consult_s extends Application {
    
    final Text text1 = new Text("Se Connecter");
    final Text text2 = new Text("Accueil"); 
    final Text text3 = new Text("Departements"); 
    
    final Text text8 = new Text("Rechercher");
    final Text text9 = new Text("Options");
    
    
    private Button m1 = new Button();
    
    private Button m7 = new Button("Retour");
    
    
    
    
    
    
    final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private String nom_u, nom_dep;
    
    private ImageView im1, bh;
    private GridPane grid1 = new GridPane();
    private GridPane grid2 = new GridPane();
    private GridPane grid3 = new GridPane();
    //private GridPane grid4 = new GridPane();
    private Text con_1 = new Text("Connexion?");
    private Text file = new Text("Filière(s) enregistrée(s)");
    private Text con_2 = new Text("Déconnexion?");
    private Text salut = new Text("Bonjour ");
    private Text salut2 = new Text("invité(e)");
    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    
    private ErrorAlert erreur = new ErrorAlert();
    private informationalert er_alert = new informationalert();
    private String mmm = new String("Vérifiez votre connexion à internet et réessayez");
    private String ttt = new String("Problème de Connexion");
    
    private Button ok = new Button("Ok");
    private BackgroundImage bg;
    private Background bgg;
    private GridPane g = new GridPane();
    private ChoiceBox spinner_1 = new ChoiceBox();
    private Text text10 = new Text("Critère de recherche");
    
    private String [] tab_med, tab_mem;
    
    
    private Text depo0 = new Text("Maths-Info");
    private Text depo1 = new Text("Physique");
    private Text depo2 = new Text("Chimie");
    private Text depo3 = new Text("Francais");
    private Text depo4 = new Text("LettresBilingues");
    private Text depo5 = new Text("Histoire");
    private Text depo6 = new Text("Géographie");
    private Text depo7 = new Text("Espagnole");
    private Text depo8 = new Text("Allemand");
     private Text depo9 = new Text("Biologie");
     
     private Text d0 = new Text();
    private Text d1 = new Text();
    private Text d2 = new Text();
    private Text d3 = new Text();
    private Text d4 = new Text();
    private Text d5 = new Text();
    private Text d6 = new Text();
    private Text d7 = new Text();
    private Text d8 = new Text();
     private Text d9 = new Text();
     
     private Text d10 = new Text();
    private Text d11 = new Text();
    private Text d12 = new Text();
    private Text d13 = new Text();
    private Text d14 = new Text();
    private Text d15 = new Text();
    private Text d16 = new Text();
    private Text d17 = new Text();
    private Text d18 = new Text();
     private Text d19 = new Text();
    private String [] tabn = null;
   
    //private Button valid = new Button("Envoyer");
    private int okv = 0;
    private ImageView bh2;
    //private String [] tm = {"31Y848", "sanagala.michel@yahoo.fr"};
    
    //private String [] tmed = {"40G963", "sangala.michel@yahoo.fr"};
    
    
    
            
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        primaryStage.setTitle("BBS Administration".toUpperCase());
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        //primaryStage.getIcons().setAll(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        primaryStage.setOnCloseRequest((event) -> {
            
            if(!nom_u.equals("anonyme")){
             try{
    
                        int num_serv = 105;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(nom_u);
                        writer.flush();
                                    
                        
                    s.close();
                    } catch (Exception p){
                        
                          }
            }
        });
        
        
        ///////////
        
        depo0.setFont(Font.font("VIVALDI", 20));
        depo0.setFill(Color.WHITE);
        file.setFont(Font.font("VIVALDI", 25));
        file.setFill(Color.WHITE);
        depo1.setFont(Font.font("VIVALDI", 20));
        depo1.setFill(Color.WHITE);
        depo2.setFont(Font.font("VIVALDI", 20));
        depo2.setFill(Color.WHITE);
        depo3.setFont(Font.font("VIVALDI", 20));
        depo3.setFill(Color.WHITE);
        depo4.setFont(Font.font("VIVALDI", 20));
        depo4.setFill(Color.WHITE);
        depo5.setFont(Font.font("VIVALDI", 20));
        depo5.setFill(Color.WHITE);
        depo6.setFont(Font.font("VIVALDI", 20));
        depo6.setFill(Color.WHITE);
        depo7.setFont(Font.font("VIVALDI", 20));
        depo7.setFill(Color.WHITE);
        depo8.setFont(Font.font("VIVALDI", 20));
        depo8.setFill(Color.WHITE);
        depo9.setFont(Font.font("VIVALDI", 20));
        depo9.setFill(Color.WHITE);
        
        d0.setFont(Font.font("CALIBRI", 20));
        d0.setFill(Color.WHITE);
        d10.setFont(Font.font("CALIBRI", 25));
        d10.setFill(Color.WHITE);
        d1.setFont(Font.font("CALIBRI", 20));
        d1.setFill(Color.WHITE);
        d2.setFont(Font.font("CALIBRI", 20));
        d2.setFill(Color.WHITE);
        d3.setFont(Font.font("CALIBRI", 20));
        d3.setFill(Color.WHITE);
        d4.setFont(Font.font("CALIBRI", 20));
        d4.setFill(Color.WHITE);
        d5.setFont(Font.font("CALIBRI", 20));
        d5.setFill(Color.WHITE);
        d6.setFont(Font.font("CALIBRI", 20));
        d6.setFill(Color.WHITE);
        d7.setFont(Font.font("CALIBRI", 20));
        d7.setFill(Color.WHITE);
        d8.setFont(Font.font("CALIBRI", 20));
        d8.setFill(Color.WHITE);
        d9.setFont(Font.font("CALIBRI", 20));
        d9.setFill(Color.WHITE);
        
        d11.setFont(Font.font("CALIBRI", 20));
        d11.setFill(Color.WHITE);
        d12.setFont(Font.font("CALIBRI", 20));
        d12.setFill(Color.WHITE);
        d13.setFont(Font.font("CALIBRI", 20));
        d13.setFill(Color.WHITE);
        d14.setFont(Font.font("CALIBRI", 20));
        d14.setFill(Color.WHITE);
        d15.setFont(Font.font("CALIBRI", 20));
        d15.setFill(Color.WHITE);
        d16.setFont(Font.font("CALIBRI", 20));
        d16.setFill(Color.WHITE);
        d17.setFont(Font.font("CALIBRI", 20));
        d17.setFill(Color.WHITE);
        d18.setFont(Font.font("CALIBRI", 20)); 
        d18.setFill(Color.WHITE);
        d19.setFont(Font.font("CALIBRI", 20));
        d19.setFill(Color.WHITE);
   
        
        depo0.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo0.cursorProperty().set(Cursor.HAND);
                depo0.setUnderline(true);
               
            }
            
        });
        
        depo0.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo0.cursorProperty().set(Cursor.DEFAULT);
                depo0.setUnderline(false);
               
            }
            
        }); 
        
        depo1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo1.cursorProperty().set(Cursor.HAND);
                depo1.setUnderline(true);
               
            }
            
        });
        
        depo1.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo1.cursorProperty().set(Cursor.DEFAULT);
                depo1.setUnderline(false);
               
            }
            
        }); 
        
        depo2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo2.cursorProperty().set(Cursor.HAND);
                depo2.setUnderline(true);
               
            }
            
        });
        
        depo2.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo2.cursorProperty().set(Cursor.DEFAULT);
                depo2.setUnderline(false);
               
            }
            
        }); 
        
        depo3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo3.cursorProperty().set(Cursor.HAND);
                depo3.setUnderline(true);
               
            }
            
        });
        
        depo3.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo3.cursorProperty().set(Cursor.DEFAULT);
                depo3.setUnderline(false);
               
            }
            
        }); 
        
        depo4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo4.cursorProperty().set(Cursor.HAND);
                depo4.setUnderline(true);
               
            }
            
        });
        
        depo4.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo4.cursorProperty().set(Cursor.DEFAULT);
                depo4.setUnderline(false);
               
            }
            
        }); 
        
        
        depo5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo5.cursorProperty().set(Cursor.HAND);
                depo5.setUnderline(true);
               
            }
            
        });
        
        depo5.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo5.cursorProperty().set(Cursor.DEFAULT);
                depo5.setUnderline(false);
               
            }
            
        }); 
        
        depo6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo6.cursorProperty().set(Cursor.HAND);
                depo6.setUnderline(true);
               
            }
            
        });
        
        depo6.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo6.cursorProperty().set(Cursor.DEFAULT);
                depo6.setUnderline(false);
               
            }
            
        }); 
        
        depo7.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo7.cursorProperty().set(Cursor.HAND);
                depo7.setUnderline(true);
               
            }
            
        });
        
        depo7.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo7.cursorProperty().set(Cursor.DEFAULT);
                depo7.setUnderline(false);
               
            }
            
        }); 
        
        depo8.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo8.cursorProperty().set(Cursor.HAND);
                depo8.setUnderline(true);
               
            }
            
        });
        
        depo8.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo8.cursorProperty().set(Cursor.DEFAULT);
                depo8.setUnderline(false);
               
            }
            
        }); 
        
        depo9.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo9.cursorProperty().set(Cursor.HAND);
                depo9.setUnderline(true);
               
            }
            
        });
        
        depo9.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                depo9.cursorProperty().set(Cursor.DEFAULT);
                depo9.setUnderline(false);
               
            }
            
        }); 
        
        //////
        
        d0.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d0.cursorProperty().set(Cursor.HAND);
                d0.setUnderline(true);
               
            }
            
        });
        
        d0.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d0.cursorProperty().set(Cursor.DEFAULT);
                d0.setUnderline(false);
               
            }
            
        }); 
        
        d1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d1.cursorProperty().set(Cursor.HAND);
                d1.setUnderline(true);
               
            }
            
        });
        
        d1.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d1.cursorProperty().set(Cursor.DEFAULT);
                d1.setUnderline(false);
               
            }
            
        }); 
        
        d2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d2.cursorProperty().set(Cursor.HAND);
                d2.setUnderline(true);
               
            }
            
        });
        
        d2.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d2.cursorProperty().set(Cursor.DEFAULT);
                d2.setUnderline(false);
               
            }
            
        }); 
        
        d3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d3.cursorProperty().set(Cursor.HAND);
                d3.setUnderline(true);
               
            }
            
        });
        
        d3.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d3.cursorProperty().set(Cursor.DEFAULT);
                d3.setUnderline(false);
               
            }
            
        }); 
        
        d4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d4.cursorProperty().set(Cursor.HAND);
                d4.setUnderline(true);
               
            }
            
        });
        
        d4.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d4.cursorProperty().set(Cursor.DEFAULT);
                d4.setUnderline(false);
               
            }
            
        }); 
        
        
        d5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d5.cursorProperty().set(Cursor.HAND);
                d5.setUnderline(true);
               
            }
            
        });
        
        d5.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d5.cursorProperty().set(Cursor.DEFAULT);
                d5.setUnderline(false);
               
            }
            
        }); 
        
        d6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d6.cursorProperty().set(Cursor.HAND);
                d6.setUnderline(true);
               
            }
            
        });
        
        d6.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d6.cursorProperty().set(Cursor.DEFAULT);
                d6.setUnderline(false);
               
            }
            
        }); 
        
        d7.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d7.cursorProperty().set(Cursor.HAND);
                d7.setUnderline(true);
               
            }
            
        });
        
        d7.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d7.cursorProperty().set(Cursor.DEFAULT);
                d7.setUnderline(false);
               
            }
            
        }); 
        
        d8.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d8.cursorProperty().set(Cursor.HAND);
                d8.setUnderline(true);
               
            }
            
        });
        
        d8.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d8.cursorProperty().set(Cursor.DEFAULT);
                d8.setUnderline(false);
               
            }
            
        }); 
        
        d9.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d9.cursorProperty().set(Cursor.HAND);
                d9.setUnderline(true);
               
            }
            
        });
        
        d9.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d9.cursorProperty().set(Cursor.DEFAULT);
                d9.setUnderline(false);
               
            }
            
        }); 
        
        
        /////////
        
        d10.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d10.cursorProperty().set(Cursor.HAND);
                d10.setUnderline(true);
               
            }
            
        });
        
        d10.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d10.cursorProperty().set(Cursor.DEFAULT);
                d10.setUnderline(false);
               
            }
            
        }); 
        
        d11.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d11.cursorProperty().set(Cursor.HAND);
                d11.setUnderline(true);
               
            }
            
        });
        
        d11.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d11.cursorProperty().set(Cursor.DEFAULT);
                d11.setUnderline(false);
               
            }
            
        }); 
        
        d12.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d12.cursorProperty().set(Cursor.HAND);
                d12.setUnderline(true);
               
            }
            
        });
        
        d12.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d12.cursorProperty().set(Cursor.DEFAULT);
                d12.setUnderline(false);
               
            }
            
        }); 
        
        d13.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d13.cursorProperty().set(Cursor.HAND);
                d13.setUnderline(true);
               
            }
            
        });
        
        d13.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d13.cursorProperty().set(Cursor.DEFAULT);
                d13.setUnderline(false);
               
            }
            
        }); 
        
        d14.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d14.cursorProperty().set(Cursor.HAND);
                d14.setUnderline(true);
               
            }
            
        });
        
        d14.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d14.cursorProperty().set(Cursor.DEFAULT);
                d14.setUnderline(false);
               
            }
            
        }); 
        
        
        d15.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d15.cursorProperty().set(Cursor.HAND);
                d15.setUnderline(true);
               
            }
            
        });
        
        d15.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d15.cursorProperty().set(Cursor.DEFAULT);
                d15.setUnderline(false);
               
            }
            
        }); 
        
        d16.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d16.cursorProperty().set(Cursor.HAND);
                d16.setUnderline(true);
               
            }
            
        });
        
        d16.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d16.cursorProperty().set(Cursor.DEFAULT);
                d16.setUnderline(false);
               
            }
            
        }); 
        
        d17.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d17.cursorProperty().set(Cursor.HAND);
                d17.setUnderline(true);
               
            }
            
        });
        
        d17.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d17.cursorProperty().set(Cursor.DEFAULT);
                d17.setUnderline(false);
               
            }
            
        }); 
        
        d18.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d18.cursorProperty().set(Cursor.HAND);
                d18.setUnderline(true);
               
            }
            
        });
        
        d18.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d18.cursorProperty().set(Cursor.DEFAULT);
                d18.setUnderline(false);
               
            }
            
        }); 
        
        d19.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d19.cursorProperty().set(Cursor.HAND);
                d19.setUnderline(true);
               
            }
            
        });
        
        d19.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                d19.cursorProperty().set(Cursor.DEFAULT);
                d19.setUnderline(false);
               
            }
            
        }); 
        
        
        
        // définition des actions
        
        depo0.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo0,depo1,depo2,depo3,depo4,depo5,depo6,depo7,depo8,depo9);
                           depo0.setFont(Font.font("VIVALDI", 35));
                           depo0.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo0.getText());
                        writer.flush();
                        
                       // System.out.println(depo0);
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         
                        grid2.add(b, 2, 0);
                        grid2.add(depo0, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");   
                        else {
                        String [] tab_co = new String [ko];
                        for(int j=0; j<ko; j++){
                            tab_co[j] = reader.readLine();
                        }
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(tab_co[j]);
                            
                            
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                    
                     
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        } 
                    s.close();
                    } catch (Exception p){
                          //JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          p.printStackTrace();
                          System.out.println("pomo");
                          }
                             
            }
        });
        
         depo1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo0, depo1,depo2,depo3,depo4,depo5,depo6,depo7,depo8,depo9);
                           depo1.setFont(Font.font("VIVALDI", 35));
                           depo1.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo1.getText());
                        writer.flush();
                        
                       
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                        
                        grid2.add(b, 2, 0);
                         grid2.add(depo1, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");   
                        else {
                        String [] tab_co = new String [ko];
                        for(int j=0; j<ko; j++){
                            tab_co[j] = reader.readLine();
                        }
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(tab_co[j]);
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                           
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                      
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                      }   
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
         
         
         
         
         ///// continu la configuration des autres dépo
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
          depo2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1, depo2,depo0,depo3,depo4,depo5,depo6,depo7,depo8,depo9);
                           depo2.setFont(Font.font("VIVALDI", 35));
                           depo2.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo2.getText());
                        writer.flush();
                        
                       
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                        
                        grid2.add(b, 2, 0);
                        grid2.add(depo2, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                           
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                     
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
          
          
           depo3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo3,depo2,depo0,depo4,depo5,depo6,depo7,depo8,depo9);
                           depo3.setFont(Font.font("VIVALDI", 35));
                           depo3.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo3.getText());
                        writer.flush();
                        
                       
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                        
                        grid2.add(b, 2, 0);
                        grid2.add(depo3, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            System.out.println(a.getText());
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                      
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
           
            depo4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo3, depo4,depo0,depo5,depo6,depo7,depo8,depo9);
                           depo4.setFont(Font.font("VIVALDI", 35));
                           depo4.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo4.getText());
                        writer.flush();
                        
                        
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                        
                        grid2.add(b, 2, 0);
                        grid2.add(depo4, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                      
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
            
            
             depo5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo5,depo3,depo4,depo0,depo6,depo7,depo8,depo9);
                           depo5.setFont(Font.font("VIVALDI", 35));
                           depo5.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo5.getText());
                        writer.flush();
                        
                       
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         System.out.println(b);
                        grid2.add(b, 2, 0);
                        grid2.add(depo5, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                      
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
             
             
              depo6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo3,depo4,depo6,depo5,depo0,depo7,depo8,depo9);
                           depo6.setFont(Font.font("VIVALDI", 35));
                           depo6.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo6.getText());
                        writer.flush();
                        
                        
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         System.out.println(b);
                        grid2.add(b, 2, 0);
                        grid2.add(depo6, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        String [] tab_co = new String [ko];
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            System.out.println(a.getText());
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                     
                       
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
              
               depo7.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo3,depo4,depo5,depo6, depo7,depo0,depo8,depo9);
                           depo7.setFont(Font.font("VIVALDI", 35));
                           depo7.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo7.getText());
                        writer.flush();
                        
                        
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         System.out.println(b);
                        grid2.add(b, 2, 0);
                        grid2.add(depo7, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        String [] tab_co = new String [ko];
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            System.out.println(a.getText());
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                   
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
               
               
                depo8.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo3,depo4,depo5,depo6,depo8,depo7,depo0,depo9);
                           depo8.setFont(Font.font("VIVALDI", 35));
                           depo8.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo8.getText());
                        writer.flush();
                        
                       
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         System.out.println(b);
                        grid2.add(b, 2, 0);
                        grid2.add(depo8, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        String [] tab_co = new String [ko];
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            System.out.println(a.getText());
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                      
                       
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           //ppprimaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
                
                 depo9.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           grid2.getChildren().removeAll(depo1,depo2,depo3,depo4,depo5,depo6,depo7,depo8,depo0, depo9);
                           depo9.setFont(Font.font("VIVALDI", 35));
                           depo9.setFill(Color.GOLDENROD);
                           
                            file.setTranslateX(300);
                            file.setTranslateY(140);
                            root.getChildren().add(file);
                           
                           try{
    
                        int num_serv = 10;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(depo9.getText());
                        writer.flush();
                        
                        
                        
                        Text b = new Text("CD: M."+reader.readLine());
                         b.setFont(Font.font("", 35));
                         b.setFill(Color.WHEAT);
                         System.out.println(b);
                        grid2.add(b, 2, 0);
                        grid2.add(depo9, 0, 0);
                        
                        int ko = Integer.parseInt(reader.readLine());
                        if(ko == 0) JOptionPane.showMessageDialog(null, "Action impossible. Pas de filiere dans ce departement");
                        String [] tab_co = new String [ko];
                        int po = 0;
                        int x = 0;
                        int y = 0;
                        
                        for(int j=0; j<ko; j++){
                            po++;
                            Text a = new Text(reader.readLine());
                            a.setFont(Font.font("CALIBRI", 20));
                            a.setFill(Color.WHITE);
                            System.out.println(a.getText());
                            
                            a.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                a.cursorProperty().set(Cursor.HAND);
                a.setUnderline(true);
               
            }
            
        });
        
                            a.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
               a.cursorProperty().set(Cursor.DEFAULT);
               a.setUnderline(false);
               
            }
            
        });
                       grid3.add(a, x, y); 
                       if(po%2 == 1){
                           x++;
                       } else {
                           x=0;
                           y++;
                       }
                       
                       
                       
                       
                       
                       
                       a.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           class_show pw = new class_show(a.getText(), nom_u);
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
                            
                            
                        }  /// fin du for
                        
                        
                        
                    s.close();
                    } catch (Exception p){
                          JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                          }
                             
            }
        });
        
        
        ////////////////////////////////////////////////////////////////////
        
        // définition des entetes et du gridpane des recherches
        
        bh = new ImageView(new Image(getClass().getResourceAsStream("images/1.jpg")));
        bh.setFitWidth(25);
        bh.setFitHeight(25);
        grid1.add(bh, 0, 0);      
        
            grid1.add(con_2, 2, 0);
            grid1.getChildren().removeAll(con_1);
            
            
            try{
    
                        int num_serv = 3;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(nom_u);
                        writer.flush();
                        
                        Text fin = new Text(salut.getText()+reader.readLine().toLowerCase());
                        fin.setFont(Font.font("VIVALDI", 20));
                        fin.setFill(Color.WHITE);
                        grid1.add(fin, 1, 0);                       
                        
                    s.close();
                    } catch (Exception p){
                          Text fin = new Text("Problème de connexion");
                          fin.setFont(Font.font("VIVALDI", 20));
                          fin.setFill(Color.WHITE);
                          grid1.add(fin, 1, 0);
                          }
                  
        
        
        ///////////////////////////
        
        /////// configuration des options de recherches
        
        
        
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        
        
         // configuration du grdp de connection
        
        grid1.setTranslateX(450);
        grid1.setTranslateY(5);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setGridLinesVisible(true);
        
        grid2.setTranslateX(250);
        grid2.setTranslateY(50);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setGridLinesVisible(true);
        
        grid3.setTranslateX(350);
        grid3.setTranslateY(200);
        grid3.setHgap(25);
        grid3.setVgap(25);
        grid3.setGridLinesVisible(true);
        
    
        bg = new BackgroundImage(new Image(getClass().getResourceAsStream("images/bg1.jpg")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        //autre gridpane
        
        g.setTranslateX(510);
        g.setTranslateY(80);
        g.add(spinner_1, 1, 0);
        g.add(text10, 0, 0);
        
        
        
        con_1.setFont(Font.font("VIVALDI", 20));
        con_1.setFill(Color.WHITE);
        con_2.setFont(Font.font("VIVALDI", 20));
        con_2.setFill(Color.WHITE);
        
         con_1.setOnMouseEntered((MouseEvent e1) -> {
             con_1.cursorProperty().set(Cursor.HAND);
             con_1.setUnderline(true);
        });
        
        con_1.setOnMouseExited((MouseEvent e1) -> {
            con_1.cursorProperty().set(Cursor.DEFAULT);
            con_1.setUnderline(false);
        }); 
        
        con_2.setOnMouseEntered((MouseEvent e1) -> {
            con_2.cursorProperty().set(Cursor.HAND);
            con_2.setUnderline(true);
        });
        
        con_2.setOnMouseExited((MouseEvent e1) -> {
            con_2.cursorProperty().set(Cursor.DEFAULT);
            con_2.setUnderline(false);
        }); 
        
        con_1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           page_cons pw = new page_cons();
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
        
        text1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           page_cons pw = new page_cons();
                           pw.start(new Stage());
                           primaryStage.close();  
            }
        });
        
        text2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           page_p1_s gh = new page_p1_s(nom_u);
                           gh.start(new Stage());
                           primaryStage.close();
            }
        });
        
        text9.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                root.getChildren().add(g);
                
            }
        });
        
        con_2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle (MouseEvent e){
                           try{
    
                        int num_serv = 105;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(nom_u);
                        writer.flush();
                        
                        page_p1_s pw = new page_p1_s("anonyme");
                           pw.start(new Stage());
                           primaryStage.close();  
                                    
                        
                    s.close();
                    } catch (Exception p){
                            erreur.showAlertWithoutHeaderText(ttt, mmm);
                          } 
            }
        });
        
        //////////////////////////
        
        
        Path path = PathBuilder.create()
                .elements(
                    new MoveTo(200,40),
                    //new CubicCurveTo(380, 0, 380, 120, 200, 120),
                    //new CubicCurveTo(0, 120, 0, 240, 380, 240)
                    new CubicCurveTo(200, 120, 250, 150, 200, 195),
                    new CubicCurveTo(200, 195, 200, 300, 200, 510)
                    //new CubicCurveTo(0, 50, 200, 500, 400, 50)
                    //new CubicCurveTo(400, 0, 200, 200, 0, 0)
                )
                .build();
        path.setStroke(Color.WHITESMOKE);
        path.getStrokeDashArray().setAll(5d,5d);
        
        // définition du coté gauche
        
        im1 = new ImageView(new Image(getClass().getResourceAsStream("images/etoile.png")));
        im1.setFitWidth(20);
        im1.setFitHeight(20);
        im1.setTranslateX(10);
        im1.setTranslateY(40);
        
        //traitement ds textes
        
        text1.setFont(Font.font("VIVALDI", 20));
        text1.setFill(Color.WHITE);
        
        text2.setFont(Font.font("VIVALDI", 20));
        text2.setFill(Color.WHITE);
        
        text8.setFont(Font.font("VIVALDI", 20));
        text1.setFill(Color.WHITE);
        
        text9.setFont(Font.font("VIVALDI", 20));
        text2.setFill(Color.WHITE);
        
        m1.setFont(Font.font("VIVALDI", 16));
        
        
        
        
      
        
        text1.setTranslateX(30);
        text1.setTranslateY(60);
        
        text2.setTranslateX(30);
        text2.setTranslateY(100);
        
        m1.setTranslateX(30);
        m1.setTranslateY(140);
        
       
        
        m7.setTranslateX(30);
        m7.setTranslateY(300);
        
        m1.setText(text3.getText());
       
        
        text1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text1.cursorProperty().set(Cursor.HAND);
                text1.setUnderline(true);
                text1.fillProperty().setValue(Color.TURQUOISE);
            }
            
        });
        
        text1.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text1.cursorProperty().set(Cursor.DEFAULT);
                text1.setUnderline(false);
                text1.fillProperty().setValue(Color.WHITE);
               
            }
            
        });
        
        text9.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text9.cursorProperty().set(Cursor.HAND);
                text9.setUnderline(true);
                text9.fillProperty().setValue(Color.TURQUOISE);
            }
            
        });
        
        text9.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text9.cursorProperty().set(Cursor.DEFAULT);
                text9.setUnderline(false);
                text9.fillProperty().setValue(Color.WHITE);
               
            }
            
        });
        
        text2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text2.cursorProperty().set(Cursor.HAND);
                text2.setUnderline(true);
                text2.fillProperty().setValue(Color.TURQUOISE);
            }
            
        });
        
        text2.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                text2.cursorProperty().set(Cursor.DEFAULT);
                text2.setUnderline(false);
                text2.fillProperty().setValue(Color.WHITE);
               
            }
            
        }); 
        
        m1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                m1.cursorProperty().set(Cursor.HAND);
                m1.setUnderline(true);
                m1.textFillProperty().setValue(Color.TURQUOISE);
            }
            
        });
        
        m1.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent e){
                m1.cursorProperty().set(Cursor.DEFAULT);
                m1.setUnderline(false);
                 m1.textFillProperty().setValue(Color.BLACK);
               
            }
            
        });
        
        
        
        
        
        
        
       
        
       
        
        
        
        
        
        
        m1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                    grid2.add(depo0, 0, 0);
                    grid2.add(depo1, 1, 0);
                    grid2.add(depo2, 0, 1);
                    grid2.add(depo3, 1, 1);
                     grid2.add(depo4, 0, 2);
                     grid2.add(depo5, 1, 2);
                     grid2.add(depo6, 0, 3);
                     grid2.add(depo7, 1, 3);
                     grid2.add(depo8, 0, 4);
                     grid2.add(depo9, 1, 4);
                
            }
        });
        
        
        
        bh2 = new ImageView(new Image(getClass().getResourceAsStream("images/2h.jpg")));
        bh2.setFitHeight(950);
        bh2.setFitWidth(200);
        bh2.setTranslateX(750);
        bh2.setTranslateY(0);
        
        
        
       
        // option de recherche
        
        text8.setTranslateX(497);
        text8.setTranslateY(60);
        
        ok.setTranslateX(780);
        ok.setTranslateY(40);
        text9.setTranslateX(497);
        text9.setTranslateY(80);
        ok.setFont(Font.font("VIVALDI", 12));
       
        m7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid2.getChildren().clear();
                grid3.getChildren().clear();
                root.getChildren().remove(file);
                
        depo0.setFont(Font.font("VIVALDI", 20));
        depo0.setFill(Color.WHITE);
        depo1.setFont(Font.font("VIVALDI", 20));
        depo1.setFill(Color.WHITE);
        depo2.setFont(Font.font("VIVALDI", 20));
        depo2.setFill(Color.WHITE);
        depo3.setFont(Font.font("VIVALDI", 20));
        depo3.setFill(Color.WHITE);
        depo4.setFont(Font.font("VIVALDI", 20));
        depo4.setFill(Color.WHITE);
        depo5.setFont(Font.font("VIVALDI", 20));
        depo5.setFill(Color.WHITE);
        depo6.setFont(Font.font("VIVALDI", 20));
        depo6.setFill(Color.WHITE);
        depo7.setFont(Font.font("VIVALDI", 20));
        depo7.setFill(Color.WHITE);
        depo8.setFont(Font.font("VIVALDI", 20));
        depo8.setFill(Color.WHITE);
        depo9.setFont(Font.font("VIVALDI", 20));
        depo9.setFill(Color.WHITE);
        
        grid3.setGridLinesVisible(true);
        
       
        grid2.setGridLinesVisible(true);
            }
        });
        
      
        
        
        
        root.getChildren().addAll(path, im1, text1, text2, m1, grid1, bh2,grid2, grid3, m7);       
        Scene scene = new Scene(root, 810, 550, Color.YELLOWGREEN);
        root.setId("pane");

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    
    public consult_s(String user, String [] med, String [] mem){
        nom_u = user; tab_med = med;
        tab_mem = mem;
    }
    
    public consult_s(String user){ 
        nom_u = user;
    }
    
    public consult_s(){
        nom_u = "miki";
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
