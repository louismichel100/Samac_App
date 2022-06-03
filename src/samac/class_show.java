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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author NGONO
 */
public class class_show extends Application {
    
    private String code_fil = new String();
    private String nom_util = new String();
    private String [] tab_mat_nom;
     private GridPane grid = new GridPane();
      private GridPane grid1 = new GridPane();
    private Text matr = new Text("Matricule");
    private Text nam_pre = new Text("Noms et prénoms");
    private Text cct = new Text("CC");
    private Text ext = new Text("EXAM");
     private Text np = new Text("Matière");
     private Text npc = new Text("Crédit");
     private Text ne = new Text("Matière");
     private Text nep = new Text("Matière");
     private Text nec = new Text("Enseignant");
     private TextField npt = new TextField();
     private TextField npct = new TextField();
    private Button p_1 = new Button("Suivant");
    private Button p_2 = new Button("Précédent");
    private Button p_3 = new Button("Nouvelle UE");
    private Button p_33 = new Button("Enregistrer");
    private Button p_4 = new Button("Attribuer UE");
    private Button p_44 = new Button("Envoyer");
    private Button p_5 = new Button("Editer UE");
    private Button p_55 = new Button("Génerer CC");
    private Button p_555 = new Button("Génerer CC/EXAM");
    private Button p_5555 = new Button("Retour");
    private Button p_7 = new Button("Afficher liste de la classe");
    private Button p_6 = new Button("Publier CC");
     private Button p_8 = new Button("Publier CC_EXAM");
    private ChoiceBox spin1 = new ChoiceBox();
    private ChoiceBox spin3 = new ChoiceBox();
    private ChoiceBox spin2 = new ChoiceBox();
    private ImageView bh;
    
     final int port = 8080;
    private Socket s, ss;

    private OutputStream out;
    
    private InputStream in;

    private PrintWriter writer;
    
    private BufferedReader reader;
    
    private TextField t1 = new TextField();
     private TextField t2 = new TextField();
      private TextField t3 = new TextField();
       private TextField t4 = new TextField();
        private TextField t5 = new TextField();
         private TextField t6 = new TextField();
          private TextField t7 = new TextField();
           private TextField t8 = new TextField();
            private TextField t9 = new TextField();
             private TextField t10 = new TextField();
              private TextField t11 = new TextField();
               private TextField t12 = new TextField();
                private TextField t13 = new TextField();
                 private TextField t14 = new TextField();
                  private TextField t15 = new TextField();
                   private TextField t16 = new TextField();
                    private TextField t17 = new TextField();
                     private TextField t18 = new TextField();
                      private TextField t19 = new TextField();
                       private TextField t20 = new TextField();
                       
                       
   private String [] tab_mat;
   private String [] tab_ens;
   private String [] tab_bon;
   
   private TableView<note> tableView = new TableView();
   private TableView<Truc> tablee = new TableView();
   
   private ObservableList<note> noteData = FXCollections.observableArrayList();
   
   private Random random = ThreadLocalRandom.current();
   
   
  
                      
   
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        primaryStage.setTitle("Définition d'une filiere "+code_fil.toUpperCase());
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.jpg")));
        
        
        ////chargement des matieres de la filiere
        
         try{
    
                        int num_serv = 12;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        
                           
                            int kom = Integer.parseInt(reader.readLine());
                            System.out.println(kom);
                            tab_ens = new String [kom];
                            for(int j = 0; j<kom; j++){
                                   tab_ens[j] = reader.readLine();
                                   System.out.println(tab_ens[j]);
                               }
                            
                            int kom2 = Integer.parseInt(reader.readLine());
                            System.out.println(kom2);
                            if(kom2 != 0){
                            tab_mat = new String [kom2];
                            for(int j = 0; j<kom2; j++){
                                   tab_mat[j] = reader.readLine();
                                   System.out.println(tab_mat[j]);
                               }}
                        
                        
                        int kok3 = Integer.parseInt(reader.readLine());
                        System.out.println("taille "+kok3);
                        
                        if(kok3 != 0){
                            
                        } else ;
                  s.close();
                    } catch (Exception p){
                       
                          }
         
         
         
         //// définition de la photo de remplacement
         
        bh = new ImageView(new Image(getClass().getResourceAsStream("images/e.jpg")));
        bh.setFitWidth(500);
        bh.setFitHeight(300);
        bh.setTranslateX(20);
        bh.setTranslateY(20);
        
        /// définition des textes
        
        matr.setFont(Font.font("CALIBRI", 25));
        matr.setFill(Color.WHITE);
        np.setFont(Font.font("CALIBRI", 15));
        np.setFill(Color.AQUA);
        npc.setFont(Font.font("CALIBRI", 15));
        npc.setFill(Color.AQUA);
        ne.setFont(Font.font("CALIBRI", 15));
        ne.setFill(Color.AQUA);
        nep.setFont(Font.font("CALIBRI", 15));
        nep.setFill(Color.AQUA);
        nec.setFont(Font.font("CALIBRI", 15));
        nec.setFill(Color.AQUA);
        nam_pre.setFont(Font.font("CALIBRI", 25));
        nam_pre.setFill(Color.WHITE);
        npt.setMinSize(8, 5);
        npt.fontProperty().set(Font.font("TimesNewRoman", 10));
        
        npct.setMinSize(8, 5);
        npct.fontProperty().set(Font.font("TimesNewRoman", 10));
        t1.setMinSize(5, 5);
        t1.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t2.setMinSize(5, 5);
        t2.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t3.setMinSize(5, 5);
        t3.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t4.setMinSize(5, 5);
        t4.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t5.setMinSize(5, 5);
        t5.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t6.setMinSize(5, 5);
        t6.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t7.setMinSize(5, 5);
        t7.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t8.setMinSize(5, 5);
        t8.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t9.setMinSize(5, 5);
        t9.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t10.setMinSize(5, 5);
        t10.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t11.setMaxSize(5, 5);
        t11.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t12.setMaxSize(5, 5);
        t12.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t13.setMaxSize(5, 5);
        t13.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t14.setMaxSize(5, 5);
        t14.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t15.setMaxSize(5, 5);
        t15.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t16.setMaxSize(5, 5);
        t16.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t17.setMaxSize(5, 5);
        t17.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t18.setMaxSize(5, 5);
        t18.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t19.setMaxSize(5, 5);
        t19.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        t20.setMaxSize(5, 5);
        t20.fontProperty().set(Font.font("TimesNewRoman", 12));
        
        
        
       
        
        //// test de k
       
        
        
        p_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
            }
        });
        
        p_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
            }
        });
        
        
        //// ajout dans le gridpane
        
        grid.add(matr, 0, 0);
        grid.add(nam_pre, 1, 0);
        
    
        
        
        
       
       
        
        
         
         /// définition du bouton p_3
         
        grid1.add(p_3, 0, 0);
        grid1.add(p_4, 0, 6);
        grid1.add(p_5, 0, 11);
        
         
         p_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(nom_util.equals("miki")){
                    grid1.add(np, 0, 3);
                    grid1.add(npc, 1, 3);
                    grid1.add(npt, 0, 5);
                    grid1.add(npct, 1, 5);
                    grid1.add(p_33, 1, 0);
                } else JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à éffectuer cette action");
             
               
            }
        });
         
         /// set de la tableview
         
         tablee.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         TableColumn<Truc, String> na = new TableColumn<>("Numéro");
         na.setCellValueFactory(new PropertyValueFactory<>("na"));
         na.setMinWidth(100);
         
         TableColumn<Truc, String> notaa = new TableColumn<>("Matricule");
         notaa.setCellValueFactory(new PropertyValueFactory<>("mat"));
         notaa.setMinWidth(100);
         
         
         TableColumn<Truc, String> nomaa = new TableColumn<>("Noms et Prénoms");
         nomaa.setCellValueFactory(new PropertyValueFactory<>("nom"));
         nomaa.setMinWidth(250);
         
         tablee.getColumns().setAll(na, notaa, nomaa);
         
         tablee.setTranslateX(20);
         tablee.setTranslateY(350);
         tablee.setEditable(true);
         tablee.setMaxHeight(200);
         
         
         tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         TableColumn<note, String> naa = new TableColumn<>("Numéro");
         naa.setCellValueFactory(new PropertyValueFactory<>("na"));
         naa.setMinWidth(100);
         
         TableColumn<note, String> nota = new TableColumn<>("Matricule");
         nota.setCellValueFactory(new PropertyValueFactory<>("mat"));
         nota.setEditable(true);
         
         TableColumn<note, String> noma = new TableColumn<>("Noms et Prénoms");
         noma.setCellValueFactory(new PropertyValueFactory<>("nom"));
         noma.setMinWidth(200);
         noma.setEditable(true);
         
         TableColumn<note, String> cca = new TableColumn<>("CC/30");
         cca.setCellValueFactory(new PropertyValueFactory<>("cc"));
         cca.setEditable(true);
         
         
         TableColumn<note, String> exa = new TableColumn<>("EXAM/70");
         exa.setCellValueFactory(new PropertyValueFactory<>("exam"));
         exa.setEditable(true);
         //exa.setCellValueFactory(cellData -> cellData.getValue().get_exam_property().asObject());
         
         cca.setCellFactory(TextFieldTableCell.forTableColumn());
         exa.setCellFactory(TextFieldTableCell.forTableColumn());
         

         
         tableView.getColumns().setAll(naa, nota, noma, cca, exa);
         
         tableView.setTranslateX(20);
         tableView.setTranslateY(20);
         tableView.setEditable(true);
         tableView.setMaxHeight(300);
   
         
         
         
         /// configuration du spiner d'édition (choix de l'ue a édité)
         
                       if(tab_mat != null){
                            spin1 = new ChoiceBox(FXCollections.observableArrayList(tab_mat));
                        spin1.setAccessibleText(STYLESHEET_MODENA);
                        
              spin3 = new ChoiceBox(FXCollections.observableArrayList(tab_mat));
              spin3.setAccessibleText(STYLESHEET_MODENA);
              spin3.setValue(null);
                       }
                       
                        spin2 = new ChoiceBox(FXCollections.observableArrayList(tab_ens));
                        spin2.setAccessibleText(STYLESHEET_MODENA);
                        spin1.setValue(null);
                        spin2.setValue(null);
                        
             
        
         
         
         spin3.valueProperty().addListener(new ChangeListener(){

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                
                if(newValue != null){
                String st = spin3.getValue().toString();
                System.out.println(st);
                
                if(oldValue != null){
                    tableView.getItems().removeAll(noteData);
                    noteData.clear();
                }
                
                root.getChildren().remove(bh);
                
                if (!(root.getChildren().contains(tableView))) root.getChildren().add(tableView);
                
                

                try{
    
                        int num_serv = 14;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        writer.println(st);
                        writer.flush();
                        writer.println(nom_util);
                        writer.flush();
                        
                        ///
                        
                       //tableView.getItems().removeAll(noteData);
                        
                        int lk = Integer.parseInt(reader.readLine());
                        
                        if(lk != 0) {
                        
                        int v = 1;
                        tab_bon = new String [lk];
                        
                        for(int j = 0; j<lk; j++){
                                   tab_bon[j] = reader.readLine();
                                   System.out.println(tab_bon[j]);
                               }
                        
                        int vk = 1;
                                
                                
                                
                        if(tab_bon[0].equals("0")){
                            
                            int ret = 0;
                            while(v<lk){
                                //note hu = new note(tab_bon[v], tab_bon[v+1], 0.0, 0.0);
                                note hu = new note ();
                                
                                
                                hu.set_nom(tab_bon[v+1]);
                                hu.set_mat(tab_bon[v]);
                                hu.set_cc("0.0");
                                hu.set_exam("0.0");
                                hu.set_na(""+vk);
                                
                                
                                
                                hu.ccProperty().addListener((ObservableValue<? extends String> observableValuef, String oldValuef, String newValuef) -> {
                                    
                                    try{
    
                        int num_ser = 15;
  

                        ss = new Socket("localhost", port);
                        out = ss.getOutputStream();
                        in = ss.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);
                                   
                                    writer.println(num_ser);
                                    writer.flush();
                        
                                    writer.println(code_fil);
                                    writer.flush();
                                    
                                    writer.println(st);
                                    writer.flush();
                        
                                    writer.println(hu.get_mat());
                                    writer.flush();
                                    
                                    writer.println("cc");
                                    writer.flush();
                                    
                                    writer.println(newValuef);
                                    writer.flush();
                        
                         ss.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
                                    
                                
                                        });
                                hu.examProperty().addListener((ObservableValue<? extends String> observableValueff, String oldValueff, String newValueff) -> {
                                              try{
    
                        int num_ser = 15;
  

                        ss = new Socket("localhost", port);
                        out = ss.getOutputStream();
                        in = ss.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);
                                   
                                    writer.println(num_ser);
                                    writer.flush();
                        
                                    writer.println(code_fil);
                                    writer.flush();
                                    
                                    writer.println(st);
                                    writer.flush();
                        
                                    writer.println(hu.get_mat());
                                    writer.flush();
                                    
                                    writer.println("exam");
                                    writer.flush();
                                    
                                    writer.println(newValueff);
                                    writer.flush();
                        
                         ss.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
                                        });
                                
                                
                                
                                noteData.add(hu);
                                //tableView.getItems().add(hu);
                                vk++;
                                v++;
                                v++;
                            }
                        }
                        
                        if(tab_bon[0].equals("1")){
                            while(v<lk){
                               note hu = new note ();
                                
                                
                                hu.set_nom(tab_bon[v+1]);
                                hu.set_mat(tab_bon[v]);
                                hu.set_cc(tab_bon[v+2]);
                                hu.set_exam(tab_bon[v+3]);
                                hu.set_na(""+vk);
                                
                                hu.ccProperty().addListener((ObservableValue<? extends String> observableValuef, String oldValuef, String newValuef) -> {
                                    
                                    try{
    
                        int num_ser = 15;
  

                        ss = new Socket("localhost", port);
                        out = ss.getOutputStream();
                        in = ss.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);
                                   
                                    writer.println(num_ser);
                                    writer.flush();
                        
                                    writer.println(code_fil);
                                    writer.flush();
                                    
                                    writer.println(st);
                                    writer.flush();
                        
                                    writer.println(hu.get_mat());
                                    writer.flush();
                                    
                                    writer.println("cc");
                                    writer.flush();
                                    
                                    writer.println(newValuef);
                                    writer.flush();
                        
                         ss.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
                                    
                                
                                        });
                                hu.examProperty().addListener((ObservableValue<? extends String> observableValueff, String oldValueff, String newValueff) -> {
                                              try{
    
                        int num_ser = 15;
  

                        ss = new Socket("localhost", port);
                        out = ss.getOutputStream();
                        in = ss.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);
                                   
                                    writer.println(num_ser);
                                    writer.flush();
                        
                                    writer.println(code_fil);
                                    writer.flush();
                                    
                                    writer.println(st);
                                    writer.flush();
                        
                                    writer.println(hu.get_mat());
                                    writer.flush();
                                    
                                    writer.println("exam");
                                    writer.flush();
                                    
                                    writer.println(newValueff);
                                    writer.flush();
                        
                         ss.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
                                        });
                                
                                
                                
                                noteData.add(hu);
                                //tableView.getItems().add(hu);
                                vk++;
                                v++;
                                v++;
                                v++;
                                v++;
                            }
                        }
                        
                        tableView.getItems().addAll(noteData);
                        
                        
                        //root.getChildren().addAll(tableView);
                        
                        } else JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé(e) à éditer cette UE");
                        
                        
                  s.close();
                    } catch (Exception p){
                            p.printStackTrace();
                          }
                
           if(!(grid1.getChildren().contains(p_55))) {
                grid1.add(p_55, 0, 15);
                grid1.add(p_555, 1, 15);
                grid1.add(p_6, 0, 17);
                grid1.add(p_8, 1, 17);
                
            }}
            }
            
         });
         
         p_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              if(tab_mat != null) grid1.add(spin3, 0, 13);
              else JOptionPane.showMessageDialog(null, "Action impossible. Pas de matière enregistrée pour cette filière");   
            }
        });
         
         p_55.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int p = noteData.size();
                for(int i = 0; i<p; i++){
                    note kl = noteData.get(i);
                    int n = random.nextInt(31);
                    kl.set_cc(""+n);
                    noteData.remove(i);
                    noteData.add(i, kl);
                }
            }
        });
         
         //// setting de l'enregistrement
         
        
         
         p_555.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int p = noteData.size();
                for(int i = 0; i<p; i++){
                    note kl = noteData.get(i);
                    int n = random.nextInt(31);
                    int nn = random.nextInt(71);
                    kl.set_cc(""+n);
                    kl.set_exam(""+nn);
                    noteData.remove(i);
                    noteData.add(i, kl);
                }
            }
        });
         
         
         
         p_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(nom_util.equals("miki")){
                    if(tab_mat == null) JOptionPane.showMessageDialog(null, "Pas de matière enregistrée pour cette filière");
                    else {
                        
                        grid1.add(ne, 0, 8);
                        grid1.add(nec, 1, 8);
                        grid1.add(spin1, 0, 10);
                        grid1.add(spin2, 1, 10);
                        grid1.add(p_44, 1, 6);
                       
                    }
                } else JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à éffectuer cette action");
             
               
            }
        });
         
         p_33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if((npt.getText() != null && !npt.getText().isEmpty()) & (npct.getText() != null && !npct.getText().isEmpty())){
                    
                    try{
    
                        int num_serv = 11;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        writer.println(npt.getText());
                        writer.flush();
                        
                        writer.println(npct.getText());
                        writer.flush();
                        
                        //int ok = Integer.parseInt(reader.readLine());
                        
                        
                         //root.getChildren().removeAll(bh, grid1, tablee);
                          class_show pw = new class_show(code_fil, nom_util);
                           pw.start(new Stage());
                           primaryStage.close(); 
                           //primaryStage.close();
                          
                        
                           //
                        /*if (ok == 1){
                           JOptionPane.showMessageDialog(null, "Action réalisée avec succès"); 
                           class_show pw = new class_show();
                           pw.start(new Stage());
                           primaryStage.close();  
                            
                        } else JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                       
                        */
                        
                  s.close();
                    } catch (Exception p){
                       
                          }
                    
                   
            } else JOptionPane.showMessageDialog(null, "Veuillez remplir le nom de la matière ainsi que le nombre de crédit");
             
               
            }
        });
         
         p_44.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(!(spin1.getValue() == null) && !(spin2.getValue() == null)){
                    
                    try{
    
                        int num_serv = 13;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        writer.println(spin1.getValue().toString());
                        writer.flush();
                        
                        writer.println(spin2.getValue().toString());
                        writer.flush();
                        
                        int ok = Integer.parseInt(reader.readLine());
                        
                        if (ok == 1){
                           JOptionPane.showMessageDialog(null, "Action réalisée avec succès"); 
                           class_show pw = new class_show(code_fil, nom_util);
                           pw.start(new Stage());
                           primaryStage.close();  
                            
                        } else JOptionPane.showMessageDialog(null, "Vous n'etes pas connecté à internet");
                       
                        
                        
                  s.close();
                    } catch (Exception p){
                       
                          }
                    
                   
            } else JOptionPane.showMessageDialog(null, "Veuillez choisir correctement les valeurs");
             
               
            }
        });
         
         
         p_5555.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                consult_s p = new consult_s(nom_util);
                            //page_p1_s p = new page_p1_s();
                            
                            p.start(new Stage());
                           
                           primaryStage.close(); 
            }
        });
         
         //////// configuration des boutons de publications
         
         p_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               try{
    
                        int num_serv = 18;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        writer.println(spin3.getValue().toString());
                        writer.flush();
                        
                        writer.println(1);
                        writer.flush();
                        
                      
                           JOptionPane.showMessageDialog(null, "Notes Publiées avec succès"); 
                        
                        
                  s.close();
                    } catch (Exception p){
                       
                          }
            }
        });
         
         p_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               try{
    
                        int num_serv = 18;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        writer.println(spin3.getValue().toString());
                        writer.flush();
                        
                        writer.println(2);
                        writer.flush();
                        
                        
                        
                       
                           JOptionPane.showMessageDialog(null, "Notes Publiées avec succès"); 
                        
                        
                  s.close();
                    } catch (Exception p){
                       
                          }
            }
        });
         
         p_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
    
                        int num_serv = 16;
  

                        s = new Socket("localhost", port);
                        out = s.getOutputStream();
                        in = s.getInputStream();
                        
                        reader = new BufferedReader(new InputStreamReader(in));
                        writer = new PrintWriter(out);

                        writer.println(num_serv);
                        writer.flush();
                        writer.println(code_fil);
                        writer.flush();
                        
                        int ok = Integer.parseInt(reader.readLine());
                        
                        if (ok == 0) JOptionPane.showMessageDialog(null, "Cette filiere n'a pas d'étudiants pour l'instant");
                        else {
                            
                            tab_mat_nom = new String[ok];
                            for(int j = 0; j<ok; j++){
                                   tab_mat_nom[j] = reader.readLine();
                                   System.out.println(tab_mat_nom[j]);
                                   
                               }
                            int v = 0;
                            int de = 1;
                            while (v<ok) {
                                Truc t = new Truc();
                                t.set_mat(tab_mat_nom[v]);
                                t.set_nom(tab_mat_nom[v+1]);
                                t.set_na(""+de);
                                tablee.getItems().add(t);
                                v++;
                                v++;
                                de++;
                            }
                         
                        }
                        
                         s.close();
                    } catch (Exception p){
                       
                          }
            }
        });
        
       ///définition du 1er gridpane
       
        grid.setTranslateX(15);
        grid.setTranslateY(50);
        grid.setHgap(10);
        grid.setVgap(0);
        grid.setFocusTraversable(true);
        grid.setGridLinesVisible(true);
        
        grid1.setTranslateX(700);
        grid1.setTranslateY(50);
        
        p_5555.setTranslateX(850);
        p_5555.setTranslateY(500);
        
        p_7.setTranslateX(550);
        p_7.setTranslateY(500);
        grid1.setHgap(5);
        grid1.setVgap(5);
        grid1.setFocusTraversable(true);
        //grid1.setGridLinesVisible(true);
        
        
        
        root.getChildren().addAll(grid1, bh, tablee, p_5555, p_7);
        Scene scene = new Scene(root, 950, 550, Color.YELLOWGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public class_show(String nom_ut, String nom){
        code_fil = nom_ut;
        nom_util = nom;
        
    }
    
    /*public class_show(){
        code_fil = "if3";
        nom_util = "miki";
        tab_mat_nom = null;
       
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
