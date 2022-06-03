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
import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
 * 
 * /**
 * @see javafx.scene.effect.PerspectiveTransform
 * @see javafx.scene.effect.Reflection
 * @see javafx.scene.control.ScrollBar
 * @see javafx.scene.input.MouseEvent
 * @see javafx.scene.input.KeyEvent
 * @resource 1.jpg

 
 */
public class page_p1_s extends Application {
    
    final String t = new String("**************");
    private String [] tap;
    private String [] tab_pub;
    
    private MenuBar menu_p = new MenuBar();
    private Menu Fichier = new Menu("Fichier");
    private Menu Rechercher = new Menu("Rechercher");
    private Menu Aide = new Menu("Aide");
    private MenuItem ap = new MenuItem("Gestion des requetes");  
    //private Menu ap1 = new Menu("Gérer la pharmacie"); 
    private MenuItem init = new MenuItem("Réinitialiser la plate forme"); 
    private MenuItem selv = new MenuItem("Gestion des étudiants");  
    private Menu scomp = new Menu("Services de la comptabilité");
    private MenuItem ens = new MenuItem("Gérer les utilisateurs");
    private MenuItem mess = new MenuItem();
    
    private MenuItem ens_ = new MenuItem("Rechercher une publication");
    private MenuItem ele = new MenuItem("Rechercher un enseignant");
    private MenuItem note = new MenuItem("Rechercher un étudiant");
    private SeparatorMenuItem sep1 = new SeparatorMenuItem();
    private SeparatorMenuItem sep2 = new SeparatorMenuItem();
    private SeparatorMenuItem sep3 = new SeparatorMenuItem();
    private SeparatorMenuItem sep4 = new SeparatorMenuItem();
    private SeparatorMenuItem sep5 = new SeparatorMenuItem();
    private SeparatorMenuItem sep6 = new SeparatorMenuItem();
    private SeparatorMenuItem sep7 = new SeparatorMenuItem();
    private SeparatorMenuItem sep8 = new SeparatorMenuItem();
    private SeparatorMenuItem sep9 = new SeparatorMenuItem();
    private MenuItem p = new MenuItem("Par départements");
    private MenuItem pp = new MenuItem("Par matières");
    private MenuItem ppp = new MenuItem("Par classes");
    
    
    
    
    private MenuItem ab = new MenuItem("Télécharger le manuel d'utilisation");
    private MenuItem ab_ = new MenuItem("Aide");
    private Text con_1 = new Text("Connexion?");
    private Text con_2 = new Text("Déconnexion?");
    private Text salut = new Text("Bonjour ");
    private Text salut2 = new Text("invité(e)");
    private Text c_o = new Text("Utilisateur(s) connecté(s)");
    private Text c_o_o = new Text();
    
    private GridPane grid1 = new GridPane();
    private String nom_u = new String();
    private String code_f = new String();
    private GridPane g = new GridPane();
    private PathTransition pathTransition;
    
    final int port = 8080;
    private Socket s;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private ImageView bh, bhh, bhhh;
    
    private ErrorAlert erreur = new ErrorAlert();
    
    
    
    
    private Button f = new Button("Administration générale");
    private MenuItem d1 = new MenuItem("Historique et dates importantes");
    private MenuItem d2 = new MenuItem("Formations offertes");
    private Menu d3 = new Menu("Constitutions matérielles");
    
    private MenuItem d22 = new MenuItem("Formations offertes");
    private Menu d33 = new Menu("Constitutions matérielles");
    
    
    
    
    private MenuItem d31 = new MenuItem("Batiments");
    private MenuItem d32 = new MenuItem("Annexe");
    private MenuItem f_;
    private Button ed = new Button();
    private Button ge = new Button("Discussion");
    //private Menu add = new Menu("Ajouter un département");
    //private Menu del = new Menu("Supprimer un département");
    private int okk = 0, k1 = 0, k2 = 0;
    
    private ImageView bh2;
    
    
    
            
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Plate Forme de Gestion des Notes");
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/1h.jpg")));
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
        
    
        
        //chargement des utilisateurs connectés  -------- chargement des données directes
        
        try{
    
                        int num_serv = 4;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(code_f);
                        writer.flush();
                        
                        int kok = Integer.parseInt(reader.readLine());
                        k1 = Integer.parseInt(reader.readLine());
                        k2 = Integer.parseInt(reader.readLine());
                        String op = new String(String.valueOf(k1+k2));
                        mess.setText("Messages ("+op+")");
                        
                        if (!code_f.equals("etoile")) {
                             int kokk = Integer.parseInt(reader.readLine());
                             String opp = new String(String.valueOf(kokk / 2));
                             ed.setText("Publications ("+opp+")");
                             
                             if (kokk != 0){
                                 tab_pub = new String[kokk];
                                 
                                 for(int j=0; j<kokk; j++){
                                    tab_pub[j] = reader.readLine();
                                }
                             }

                             
                        } else {
                           ed.setText("Publications"); 
                        }
                        
                        
                        
                        
                        c_o_o.setText(String.valueOf(kok));
                                    
                        
                    s.close();
                    } catch (Exception p){
                        
                          }
        
        
        
        
        
        
        ///////////////////////////////////////////////////////
        
        ////description de l'action du mess
        
       mess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if (nom_u.equals("miki")){
                    JOptionPane.showMessageDialog(null, k1+" inscription(s) d'enseignant(s) en attente(s)\n"+k2+" inscription(s) d'étudiant(s) en entente(s)");
               } else erreur.showAlertWithoutHeaderText("Autorisation refusée", "Vous ne disposez pas des droits d'administrateur");
            }
        });
       
       ////// dscription du menuitem init
         
       init.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if (nom_u.equals("miki")){
                  
               } else erreur.showAlertWithoutHeaderText("Autorisation refusée", "Vous ne disposez pas des droits d'administrateur");
            }
        });
       
       //// gestion des utilisateurs
       ens.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if (nom_u.equals("miki")){
                  class_user gh = new class_user();
                  gh.start(new Stage());
                 
               } else erreur.showAlertWithoutHeaderText("Autorisation refusée", "Vous ne disposez pas des droits d'administrateur");
            }
        });
       
       ap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if (!(nom_u.equals("anonyme")) && code_f.equals("")){
                  
                   /// admin ou enseignant
                   
                   rx2 gh = new rx2();
                   gh.start(new Stage());
                   
                   
               } else if (!(nom_u.equals("anonyme")) && !(code_f.equals(""))){
                   
                   // étudiant
                   
                   requ gh = new requ(code_f, nom_u);
                   gh.start(new Stage());
               }
            }
        });
       
       
       
       ed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              
                
                if (nom_u.equals("miki")) {
                    erreur.showAlertWithoutHeaderText("Autorisation refusée", "Action non configurée pour l'Administrateur que vous etes");
                }
                
                if((code_f.equals("etoile")) && !(nom_u.equals("miki"))) erreur.showAlertWithoutHeaderText("Action impossible", "Action non configurée pour l'enseignant que vous etes");
                
                if(!(code_f.equals("etoile")) && (tab_pub == null))  erreur.showAlertWithoutHeaderText("Action impossible", "Vous n'avez pas de publications en attentes");
                
                if(!(code_f.equals("etoile")) && (tab_pub != null)) {
                  aff_pub gh = new aff_pub(code_f, nom_u, tab_pub);
                 
                  gh.start(new Stage());
                  //primaryStage.close();
                }
      
               /*String fg = JOptionPane.showInputDialog(null, "Veuillez entrer le nom du document que vous rechercher");
               
               if(!fg.equals("")){
                   erreur.showAlertWithoutHeaderText("Problème d'authentification", "Veuillez réessayer");
               }*/
            }
        });
       
        // configuration du grdp de connection
        
        grid1.setTranslateX(500);
        grid1.setTranslateY(5);
        grid1.setHgap(10);
        grid1.setVgap(10);
        
        con_1.setFont(Font.font("VIVALDI", 20));
        con_1.setFill(Color.WHITE);
        con_2.setFont(Font.font("VIVALDI", 20));
        con_2.setFill(Color.WHITE);
        c_o.setFont(Font.font("VIVALDI", 20));
        c_o.setFill(Color.BLACK);
        c_o_o.setFont(Font.font("VIVALDI", 30));
        c_o_o.setFill(Color.BLACK);
        
         con_1.setOnMouseEntered((MouseEvent e1) -> {
             con_1.cursorProperty().set(Cursor.HAND);
             con_1.setUnderline(true);
        });
        
        con_1.setOnMouseExited((MouseEvent e1) -> {
            con_1.cursorProperty().set(Cursor.DEFAULT);
            con_1.setUnderline(false);
        }); 
        
        
        ////////pour charger les différents users qui sont connectés
        
        c_o.setTranslateX(620);
        c_o.setTranslateY(540);
        
        c_o_o.setTranslateX(790);
        c_o_o.setTranslateY(540);
        
        c_o.setOnMouseEntered((MouseEvent e1) -> {
             con_1.cursorProperty().set(Cursor.HAND);
             con_1.setUnderline(true);
        });
        
        c_o.setOnMouseExited((MouseEvent e1) -> {
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
                            erreur.showAlertWithoutHeaderText("Problème de connexion", "Veuillez vérifier votre connexion internet puis réessayer");
                          } 
            }
        });
        
        menu_p.getMenus().addAll(Fichier, Rechercher, Aide);
        Fichier.setGraphic(new Circle(8, Color.DARKGOLDENROD));
        Rechercher.setGraphic(new Circle(6, Color.DARKGOLDENROD));
        Aide.setGraphic(new Circle(4, Color.DARKGOLDENROD));
        Fichier.getItems().addAll(ap, sep4, ens, sep3, mess, init);
        Rechercher.getItems().addAll(ens_, sep1, ele, sep2, note);
        Aide.getItems().addAll(ab, sep5, ab_);
        
        
        // définition de la ligne de séparation et du nom de l'établissement
        
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
                    new MoveTo(0,90),
                    //new CubicCurveTo(380, 0, 380, 120, 200, 120),
                    //new CubicCurveTo(0, 120, 0, 240, 380, 240)
                    new CubicCurveTo(0, 90, 405, 40, 810, 90)
                    //new CubicCurveTo(400, 50, 200, 150, 0, 50),
                    //new CubicCurveTo(0, 50, 200, 500, 400, 50)
                    //new CubicCurveTo(400, 0, 200, 200, 0, 0)
                )
                .build();
        pathh.setStroke(Color.BLUE);
        pathh.getStrokeDashArray().setAll(10d,5d);
        
        
        
        
        // définition de l'entete
        
        bh = new ImageView(new Image(getClass().getResourceAsStream("images/1.jpg")));
        bh.setFitWidth(25);
        bh.setFitHeight(25);
        grid1.add(bh, 0, 0);      
        if(nom_u.equals("anonyme")){
            Text fin = new Text(salut.getText()+salut2.getText());
            grid1.add(fin, 1, 0);
            grid1.add(con_1, 3, 0);
            grid1.getChildren().removeAll(con_2);
            
        } else {
            grid1.add(con_2, 3, 0);
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
                        String hm = reader.readLine();
                        
                        System.out.println(hm);
                        
                        Text fin = new Text(salut.getText()+hm.toLowerCase());
                        fin.setFont(Font.font("CALIBRI", 20));
                        fin.setFill(Color.WHITE);
                        grid1.add(fin, 1, 0);                       
                        
                    s.close();
                    } catch (Exception p){
                          Text fin = new Text("Problème de connexion");
                          fin.setFont(Font.font("VIVALDI", 20));
                          fin.setFill(Color.WHITE);
                          grid1.add(fin, 1, 0);
                          }
                  }
        
        
        
        
        /////////////gestions des consultations
        
        f.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(nom_u.equals("anonyme")) JOptionPane.showMessageDialog(null, "Accès impossible, vous n'etes pas inscrit à la plateforme");
                else{
                    try{
    
                        int num_serv = 9;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        
                        writer.println(nom_u);
                        writer.flush();
                        
                       int okk = Integer.parseInt(reader.readLine());
                       if(okk == 0) JOptionPane.showMessageDialog(null, "Espace interdit aux étudiants");
                       else {
                         consult_s gh = new consult_s(nom_u);
                         gh.start(new Stage());
                         primaryStage.close();   
                       }
                        
                       
                        
                        
                       
                        
                        
                                    
                        
                    s.close();
                    } catch (Exception p){
                           JOptionPane.showMessageDialog(null, "Vérifier votre connexion à internet et réessayez");
                          }
                }
                    
                
            }
        });
        
        ////////configuration des discussion
        
        ge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (code_f.equals("")) {
            
            //ge.getItems().addAll(depo0, depo1, depo2, depo3, depo4, depo5, depo6, depo7, depo8, depo9);
            
                      page_mm pw = new page_mm();
                           pw.start(new Stage());
                           
            
        } else {
                    aff_diss pw = new aff_diss(code_f);
                           pw.start(new Stage());
                           //primaryStage.close();  
                }
            }
        });
        
       
        
        
        
        
       // définition des sous entetes
       
        g.setTranslateX(50);
        g.setTranslateY(35);
        g.setHgap(60);
        g.setVgap(10);
        
        
        g.add(ed, 0, 0);
        g.add(f, 1, 0);
        g.add(ge, 2, 0);
        
       
        d3.getItems().addAll(d31, d32);
        
      
     
        
        bhh = new ImageView(new Image(getClass().getResourceAsStream("images/add.jpg")));
        bhh.setFitHeight(10);
        bhh.setFitWidth(10);
        bhhh = new ImageView(new Image(getClass().getResourceAsStream("images/del.png")));
        bhhh.setFitHeight(10);
        bhhh.setFitWidth(10);
        
        //définition du background
        
        bh2 = new ImageView(new Image(getClass().getResourceAsStream("images/5h.jpg")));
        bh2.setFitHeight(350);
        bh2.setFitWidth(450);
        bh2.setTranslateX(100);
        bh2.setTranslateY(100);
      
        
     
       
       
        
        Group root = new Group();
        root.getChildren().addAll(menu_p, grid1, path, pathh, g, bh2, c_o, c_o_o);
        Scene scene = new Scene(root, 810, 550, Color.YELLOWGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    public page_p1_s(String nom_util){
        nom_u = nom_util;
        code_f = "";
    }
    
    public page_p1_s(String nom_util, String cs){
        nom_u = nom_util;
        code_f = cs;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
