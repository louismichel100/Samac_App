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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGONO
 */





public class generer_green {
    
     private static final Font CAFONT = new Font(Font.getFamily("ALGERIAN"), 25, Font.BOLD);
     private static final Font CATFONT = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD);
     private static final Font CAT = new Font(Font.getFamily("ALGERIAN"), 18, Font.BOLD);
      private static final Font SMALLBOLD = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
     private static final String chemin = "C:\\Users\\NGONO\\Documents\\NetBeansProjects\\SAMAC\\dist\\2rR.pdf";
     String nom = new String("Sangala Mballa");
     String prenom = new String("Louis Michel");
     String dat = new String("27/08/1995");
     String cni = new String("3442232312234");
     String tel = new String("691798523");
     String mail = new String("sangala.michel@yahoo.fr");
     String ville = new String("Douala-Bonabéri");
     String specialité = new String("osdonthologie");
     String grade = new String("A123");
     String ima = new String("images/5h.jpg");
     
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
     
    
    public void generer(String nm, String pm, String dat, String cn, String te, String maill, String vil, String spé, String gra, String photo){
        
        Document document = new Document();
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream(chemin));
      document.open();

      
      Image image = Image.getInstance("images/samac.png"); 
      image.scaleAbsolute(100, 100);
      image.setLeft(10);
      document.add(image);
      
      p1 = new Paragraph("\n\nDossier Médical", CAFONT);
      
      document.add(p1);
      
      
      
      p2 = new Paragraph("NOM : \t\t"+nm, CATFONT);
      document.add(p2);
      
      p3 = new Paragraph("PRENOM : \t\t"+pm, CATFONT);
      document.add(p3);
      
      p4 = new Paragraph("DATE NAISSANCE : \t\t"+dat, CATFONT);
      document.add(p4);
      
      p5 = new Paragraph("CNI : \t\t"+cn, CATFONT);
      document.add(p5);
      
      p6 = new Paragraph("TEL : \t\t"+te, CATFONT);
      document.add(p6);
      
      p7 = new Paragraph("MAIL : \t\t"+maill, CATFONT);
      document.add(p7);
      
      p8 = new Paragraph("RESIDENCE : \t\t"+vil, CATFONT);
      document.add(p8);
      
      p9 = new Paragraph("SPECIALITE : \t\t"+spé, CATFONT);
      document.add(p9);
      
      
      
      
      Image iimage = Image.getInstance(photo); 
      iimage.scaleAbsolute(200, 200);
      
      
      document.add(iimage);
      
      
      
      
      /////////////
 
// Le 2ième paramètre est le numero du chapitre
      

      
      
      
      /////////////
      pp.add(new Paragraph("Rapport généré par: louis_michel, " + new Date(), SMALLBOLD));
      ajouterLigneVide(pp, 3);
      document.add(pp);
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
    
    private void ajouterLigneVide(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}
    
}
