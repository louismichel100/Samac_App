/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * author NGONO
 */
public class generer_final {

    /**
     * @param args the command line arguments
     */
    
    private static final Font CAFONT = new Font(Font.getFamily("ALGERIAN"), 35, Font.BOLD);
     private static final Font CATFONT = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD);
     private static final Font CAT = new Font(Font.getFamily("ALGERIAN"), 18, Font.BOLD);
      private static final Font SMALLBOLD = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
     private static final String chemin = "C:\\linux\\2rR.pdf";
     private static String nom = new String("Sangala Mballa");
     private static String prenom = new String("Louis Michel");
     private static String dat = new String("27/08/1995");
     private static String cni = new String("3442232312234");
     private static String tel = new String("691798523");
     private static String mail = new String("sangala.michel@yahoo.fr");
     private static String ville = new String("Douala-Bonabéri");
     private static String specialité = new String("osdonthologie");
     private static String grade = new String("A123");
     private static String ima = new String("images/5h.jpg");
     
     public static Paragraph p1;
     public static Paragraph p2;
     public static Paragraph p3;
     public static Paragraph p4;
     public static Paragraph p5;
     public static Paragraph p6;
     public static Paragraph pp;
     public static Paragraph p7;
     public static Paragraph p8;
     public static Paragraph p9;
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        generer(nom, prenom, dat, cni, tel, mail, ville, specialité, grade, ima);
    }
    
    
    
    
    private static void ajouterLigneVide(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}
    
    
    
    
    
    
    public static void generer(String nm, String pm, String dat, String cn, String te, String maill, String vil, String spé, String gra, String photo){
        
        Document document = new Document();
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream(chemin));
      document.open();

      
      //Image image = Image.getInstance("images/samac.png"); 
      //image.scaleAbsolute(100, 100);
      //image.setLeft(10);
      //document.add(image);
      
      p1 = new Paragraph("Dossier Médical", CAFONT);
      p1.setIndentationLeft(150);
      
      document.add(p1);
      
      
      
      p2 = new Paragraph("\nNOM : \t\t"+nm, CATFONT);
      document.add(p2);
      
      p3 = new Paragraph("\nPRENOM : \t\t"+pm, CATFONT);
      document.add(p3);
      
      p4 = new Paragraph("\nDATE NAISSANCE : \t\t"+dat, CATFONT);
      document.add(p4);
      
      p5 = new Paragraph("\nCNI : \t\t"+cn, CATFONT);
      document.add(p5);
      
      p6 = new Paragraph("\nTEL : \t\t"+te, CATFONT);
      document.add(p6);
      
      p7 = new Paragraph("\nMAIL : \t\t"+maill, CATFONT);
      document.add(p7);
      
      p8 = new Paragraph("\nRESIDENCE : \t\t"+vil, CATFONT);
      document.add(p8);
      
      p9 = new Paragraph("\nSPECIALITE : \t\t"+spé, CATFONT);
      document.add(p9);
      
      p9 = new Paragraph("\nGRADE : \t\t"+gra, CATFONT);
      document.add(p9);
      
      
      
      
      Image iimage = Image.getInstance(photo); 
      iimage.scaleAbsolute(400, 400);
      iimage.setIndentationLeft(50);
      
      
      document.add(iimage);
      
      
      
      
      /////////////
 
// Le 2ième paramètre est le numero du chapitre
      

      
      
      
      /////////////
     
      document.addTitle("Dossier Médical");
      document.addSubject("Samac's Validation");
      document.addKeywords("jackson");
      
   
      
      /////////////////////
      
      
         
      
       /* 
        lecteurpdf2 lecteur;
            try {
                lecteur = new lecteurpdf2(chemin);
                 JFrame f = new JFrame("Afficheur de document");
        
        f.setSize(1024,768);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.getContentPane().add(lecteur);
            } catch (Exception ex) {
                //Logger.getLogger(generer_final.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    */
      
      Desktop d = Desktop.getDesktop();
      d.open(new File(chemin));
      //99787c26293a433dc25b8237a8bffb9a

    } catch (DocumentException de) {
      de.printStackTrace();
    } catch (IOException dee) {
      dee.printStackTrace();
    }
   
    document.close();
    
    }
    
    
    public static void genererr(String nm, String pm, String dat, String cn, String te, String maill, String vil, String mal, String photo){
        
        Document document = new Document();
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream(chemin));
      document.open();

      
      Image image = Image.getInstance("images/samac.png"); 
      image.scaleAbsolute(100, 100);
      //image.setLeft(10);
      document.add(image);
      
      p1 = new Paragraph("Dossier Médical", CAFONT);
      p1.setIndentationLeft(150);
      
      document.add(p1);
      
      
      
      p2 = new Paragraph("\nNOM : \t\t"+nm, CATFONT);
      document.add(p2);
      
      p3 = new Paragraph("\nPRENOM : \t\t"+pm, CATFONT);
      document.add(p3);
      
      p4 = new Paragraph("\nDATE NAISSANCE : \t\t"+dat, CATFONT);
      document.add(p4);
      
      p5 = new Paragraph("\nCNI : \t\t"+cn, CATFONT);
      document.add(p5);
      
      p6 = new Paragraph("\nTEL : \t\t"+te, CATFONT);
      document.add(p6);
      
      p7 = new Paragraph("\nMAIL : \t\t"+maill, CATFONT);
      document.add(p7);
      
      p8 = new Paragraph("\nRESIDENCE : \t\t"+vil, CATFONT);
      document.add(p8);
      
      p9 = new Paragraph("\nMALADIE : \t\t"+mal, CATFONT);
      document.add(p9);
      
      
      
      
      Image iimage = Image.getInstance(photo); 
      iimage.scaleAbsolute(400, 400);
      iimage.setIndentationLeft(50);
      
      
      document.add(iimage);
      
      
      
      
      /////////////
 
// Le 2ième paramètre est le numero du chapitre
      

      
      
      
      /////////////
     
      document.addTitle("Dossier Médical");
      document.addSubject("Samac's Validation");
      document.addKeywords("jackson");
   
      
      /////////////////////
      
      Desktop d = Desktop.getDesktop();
      d.open(new File(chemin));

    } catch (DocumentException de) {
      de.printStackTrace();
    } catch (IOException dee) {
      dee.printStackTrace();
    }
   
    document.close();
    
    }
    
    
    
}
