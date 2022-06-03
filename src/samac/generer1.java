/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JFrame;

/**
 *
 * author NGONO
 */
public class generer1 {

    /**
     * @param args the command line arguments
     */
    private static final Font CAFONT = new Font(Font.getFamily("ALGERIAN"), 35, Font.BOLD);
    private static final Font CATFONT = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
    private static  Font CAT = new Font(Font.getFamily("Algerian"), 14, Font.BOLDITALIC);
    private static final Font SD = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.UNDERLINE);
    private static final String chemin = "C:\\linux\\AZ.pdf";
    private static final String chemin1 = "C:\\linux\\AZQ.pdf";

    private static String n = new String("République du Cameroun                                                                 Republic of Cameroon");
    private static String p = new String("          *   *   *   *   *                                                                                       *   *   *   *   *");
    private static String t = new String(" Paix - Travail - Patrie                                                                       Peace - Work - Fatherland");
    private static String s = new String("Ministère des Enseignements                                                    Ministry of Higher Education Supérieurs");
    private static String u = new String("Université de Douala                                                                            University of Douala");
    private static String x = new String("Ecole Nationale d'Enseignement                                                      Higher Tecnical Teacher's \n               Technique                                                                                     Training School");
    private static String ima1 = new String("images/doul1.jpg");
    private static String ima2 = new String("images/miki.jpg");
    private static String pho_abs = new String("images/1.jpg");
    private static String fi = new String("Filière :");
    private static String eff = new String("Effectif :");
    private static String [] mt = {"XFGES", "Atangana Jean Felix", "17", "DFETR", "Mbollo Franck Albert", "25"};
    //private static String y = new String("Douala-Bonabéri");

    private static String nom = new String("République du Cameroun\t\tRepublic of Cameroon");
    private static String prenom = new String("Louis Michel");
    private static String dat = new String("27/08/1995");
    private static String cni = new String("3442232312234");
    private static String tel = new String("691798523");
    private static String mail = new String("sangala.michel@yahoo.fr");
    private static String ville = new String("Douala-Bonabéri");
    private static String specialité = new String("osdonthologie");
    private static String grade = new String("A123");
    private static String ima = new String("images/5h.jpg");
    
    

    public static Paragraph p11;
    public static Paragraph p22;
    public static Paragraph p33;
    public static Paragraph p44;
    public static Paragraph p55;
    public static Paragraph p66;
    
    
    
    public static Paragraph p11_1;
    public static Paragraph p2_2;
    public static Paragraph p3_3;
    public static Paragraph p4_4;
    public static Paragraph p5_5;
    public static Paragraph p6_6;
    public static Paragraph pp1;
    public static Paragraph p7_7;
    public static Paragraph p8_8;
    public static Paragraph p9_9;
     public static Paragraph p11_0,k1,k2,k3,k4;
    //public static Paragraph p11_1;
    
    
    
    

    public static Paragraph p1;
    public static Paragraph p2;
    public static Paragraph p3;
    public static Paragraph p4;
    public static Paragraph p5;
    public static Paragraph p6;
    //public static Paragraph pp;
    public static Paragraph p7;
    public static Paragraph p8;
    public static Paragraph p9;
     public static Paragraph p1_0;
    public static Paragraph p1_1;

    public static void main(String[] args) {
        // TODO code application logic here
        
    }

    private static void ajouterLigneVide(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public static void generer (String nom, String prenom, String date, String cni, String mail, String tel, String mat, String fili, String niv, String pho) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(chemin));
            document.open();

            p11 = new Paragraph(n, CATFONT);
            document.add(p11);

            p22 = new Paragraph(p, CATFONT);
            document.add(p22);

            p33 = new Paragraph(t, CATFONT);
            document.add(p33);

            p44 = new Paragraph(s, CATFONT);
            document.add(p44);

            p55 = new Paragraph(u, CATFONT);
            document.add(p55);

            p66 = new Paragraph(x, CATFONT);
            document.add(p66);
            
            Image iimage = Image.getInstance(ima1);
            iimage.scaleAbsolute(70, 80);
            iimage.setAbsolutePosition(265, 720);
            //iimage.setIndentationLeft(50);

            document.add(iimage);
            
            p1 = new Paragraph("Fiche d'identification d'étudiant", CAT);
            p1.setIndentationLeft(150);
            
            
     
            document.add(p1);
            
            p1_1 = new Paragraph("\nPhoto : ", SD);
            p1_1.setIndentationLeft(420);
            document.add(p1_1);
            p2 = new Paragraph("\n\nNom : \t\t"+nom.toUpperCase(), SD);
      document.add(p2);
      
      p3 = new Paragraph("\nPrénom : \t\t"+prenom.toUpperCase(), SD);
      document.add(p3);
      
      p4 = new Paragraph("\nDate de naissance : \t\t"+date, SD);
      document.add(p4);
      
      p5 = new Paragraph("\nCni : \t\t"+cni, SD);
      document.add(p5);
      
      p6 = new Paragraph("\nTéléphone : \t\t+237 "+tel, SD);
      document.add(p6);
      
      p7 = new Paragraph("\nMail : \t\t"+mail, SD);
      document.add(p7);
      
      p8 = new Paragraph("\nFilière : \t\t"+fili.toUpperCase(), SD);
      document.add(p8);
      
      p9 = new Paragraph("\nNiveau : \t\t"+niv, SD);
      document.add(p9);
      
       p1_0 = new Paragraph("\nMatricule : \t\t"+mat, SD);
      document.add(p1_0);
      
      
      
      
    
     

            /////////////
            try{
               Image iimagee = Image.getInstance(pho);
            iimagee.scaleAbsolute(70, 80);
            iimagee.setAbsolutePosition(450, 500);
            //iimage.setIndentationLeft(50);

            document.add(iimagee);  
            }catch(Exception ee){
                Image iimagee = Image.getInstance(pho_abs);
            iimagee.scaleAbsolute(70, 80);
            iimagee.setAbsolutePosition(450, 500);
            //iimage.setIndentationLeft(50);

            document.add(iimagee);
            }
            
            document.addTitle("fiche_etudiant");
            document.addSubject("Samac's Validation");
            document.addKeywords("jackson");

            Desktop d = Desktop.getDesktop();
            d.open(new File(chemin));

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException dee) {
            dee.printStackTrace();
        }

        document.close();

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
    }

    public static void genererr(String nom, String prenom, String cni, String tel, String mail, String grad, String dep, String mat, String pho) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(chemin1));
            document.open();
            
            p11 = new Paragraph(n, CATFONT);
            document.add(p11);

            p22 = new Paragraph(p, CATFONT);
            document.add(p22);

            p33 = new Paragraph(t, CATFONT);
            document.add(p33);

            p44 = new Paragraph(s, CATFONT);
            document.add(p44);

            p55 = new Paragraph(u, CATFONT);
            document.add(p55);

            p66 = new Paragraph(x, CATFONT);
            document.add(p66);
            
            Image iimage = Image.getInstance(ima1);
            iimage.scaleAbsolute(70, 80);
            iimage.setAbsolutePosition(265, 720);
            //iimage.setIndentationLeft(50);

            document.add(iimage);
            
            
            
            
            
            
            
            pp1 = new Paragraph("Fiche d'identification enseignant", CAT);
            pp1.setIndentationLeft(150);
            
            
     
            document.add(pp1);
            
            p11_1 = new Paragraph("\nPhoto : ", SD);
            p11_1.setIndentationLeft(420);
            document.add(p11_1);
            p2_2 = new Paragraph("\n\nNom : \t\t"+nom.toUpperCase(), SD);
      document.add(p2_2);
      
      p3_3 = new Paragraph("\nPrénom : \t\t"+prenom.toUpperCase(), SD);
      document.add(p3_3);
      
      
      p5_5 = new Paragraph("\nCni : \t\t"+cni, SD);
      document.add(p5_5);
      
      p6_6 = new Paragraph("\nTéléphone : \t\t+237 "+tel, SD);
      document.add(p6_6);
      
      p7_7 = new Paragraph("\nMail : \t\t"+mail, SD);
      document.add(p7_7);
      
      p8_8 = new Paragraph("\nGrade : \t\t"+grad, SD);
      document.add(p8_8);
      
      p9_9 = new Paragraph("\nDépartement : \t\t"+dep.toUpperCase(), SD);
      document.add(p9_9);
      
       p11_0 = new Paragraph("\nMatricule : \t\t"+mat, SD);
      document.add(p11_0);
      
      try{
               Image iimagee = Image.getInstance(pho);
            iimagee.scaleAbsolute(70, 80);
            iimagee.setAbsolutePosition(450, 500);
            //iimage.setIndentationLeft(50);

            document.add(iimagee);  
            }catch(Exception ee){
                Image iimagee = Image.getInstance(pho_abs);
            iimagee.scaleAbsolute(70, 80);
            iimagee.setAbsolutePosition(450, 500);
            //iimage.setIndentationLeft(50);

            document.add(iimagee);
            }
      
      
     

            
            /////////////
// Le 2ième paramètre est le numero du chapitre
            /////////////
            document.addTitle("fiche_enseignant");
            document.addSubject("Samac's Validation");
            document.addKeywords("jackson");

            /////////////////////
            Desktop d = Desktop.getDesktop();
            d.open(new File(chemin1));

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException dee) {
            dee.printStackTrace();
        }

        document.close();

    }
    
    public static void generer3(String [] mt, String cf, String efff, String mate){
        
        String chemina = "C:\\linux\\"+cf+mate+".pdf";
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(80);
        PdfPCell cell = null;
        
        // matricule
        table.addCell(getCellc("Matricule", PdfPCell.ALIGN_CENTER));
        
        // nom de l'étudiant
        table.addCell(getCellc("Nom Etudiant", PdfPCell.ALIGN_CENTER));
        
        // note
        table.addCell(getCellc("Note de CC /30", PdfPCell.ALIGN_CENTER));
        
        Date dp = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        String dat = df.format(dp);
        
        
        
        int i = 0;
        
        while(i<mt.length) {
          table.addCell(getCell(mt[i], PdfPCell.ALIGN_CENTER));
          table.addCell(getCell(mt[i+1], PdfPCell.ALIGN_CENTER));
          table.addCell(getCell(mt[i+2], PdfPCell.ALIGN_CENTER));
          
          i++;
          i++;
          i++;
        }
        
        Document document = new Document();
        try {
            
            
            PdfWriter.getInstance(document, new FileOutputStream(chemina));
            document.open();
            
            p11 = new Paragraph(n, CATFONT);
            document.add(p11);

            p22 = new Paragraph(p, CATFONT);
            document.add(p22);

            p33 = new Paragraph(t, CATFONT);
            document.add(p33);

            p44 = new Paragraph(s, CATFONT);
            document.add(p44);

            p55 = new Paragraph(u, CATFONT);
            document.add(p55);

            p66 = new Paragraph(x, CATFONT);
            document.add(p66);
            
            k1 = new Paragraph(fi+cf, CATFONT);
            document.add(k1);
            
            k2 = new Paragraph(eff+" :"+efff, CATFONT);
            document.add(k2);
            
            pp1 = new Paragraph("BORDEREAU DE NOTE "+mate.toUpperCase(), CAT);
            pp1.setIndentationLeft(170);
            document.add(pp1);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            
            document.add(table);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            k4 = new Paragraph(""+dat);
            
            document.add(k4);
            
            
            Image iimage = Image.getInstance(ima1);
            iimage.scaleAbsolute(70, 80);
            iimage.setAbsolutePosition(265, 720);
            //iimage.setIndentationLeft(50);

            document.add(iimage);
            
            
            document.addTitle("Publication de note");
            document.addSubject("Samac's Validation");
            document.addKeywords("jackson");

            /////////////////////
            Desktop d = Desktop.getDesktop();
            d.open(new File(chemina));

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException dee) {
            dee.printStackTrace();
        }

        document.close();
        
    }
    
    public static void generer4 (String [] mt, String cf, String efff, String mate){
        
        String cheminn = "C:\\linux\\"+cf+mate+".pdf";
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        PdfPCell cell = null;
        
        // matricule
        table.addCell(getCellc("Matricule", PdfPCell.ALIGN_CENTER));
        
        // nom de l'étudiant
        table.addCell(getCellc("Nom Etudiant", PdfPCell.ALIGN_CENTER));
        
        // note
        table.addCell(getCellc("Note de CC /30", PdfPCell.ALIGN_CENTER));
        
        // note exam
        table.addCell(getCellc("EXAMEN /70", PdfPCell.ALIGN_CENTER));
        
        Date dp = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        String dat = df.format(dp);
        
        
        
        int i = 0;
        
        while(i<mt.length) {
          table.addCell(getCell(mt[i], PdfPCell.ALIGN_CENTER));
          table.addCell(getCell(mt[i+1], PdfPCell.ALIGN_CENTER));
          table.addCell(getCell(mt[i+2], PdfPCell.ALIGN_CENTER));
          table.addCell(getCell(mt[i+3], PdfPCell.ALIGN_CENTER));
          
          i++;
          i++;
          i++;
          i++;
        }
        
        Document document = new Document();
        try {
            
            
            PdfWriter.getInstance(document, new FileOutputStream(cheminn));
            document.open();
            
            p11 = new Paragraph(n, CATFONT);
            document.add(p11);

            p22 = new Paragraph(p, CATFONT);
            document.add(p22);

            p33 = new Paragraph(t, CATFONT);
            document.add(p33);

            p44 = new Paragraph(s, CATFONT);
            document.add(p44);

            p55 = new Paragraph(u, CATFONT);
            document.add(p55);

            p66 = new Paragraph(x, CATFONT);
            document.add(p66);
            
            k1 = new Paragraph(fi+cf, CATFONT);
            document.add(k1);
            
            k2 = new Paragraph(eff+" :"+efff, CATFONT);
            document.add(k2);
            
            pp1 = new Paragraph("BORDEREAU DE NOTE "+mate.toUpperCase(), CAT);
            pp1.setIndentationLeft(170);
            document.add(pp1);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            
            document.add(table);
            
            k3 = new Paragraph(" ");
            document.add(k3);
            k4 = new Paragraph(""+dat);
            
            document.add(k4);
            
            
            Image iimage = Image.getInstance(ima1);
            iimage.scaleAbsolute(70, 80);
            iimage.setAbsolutePosition(265, 720);
            //iimage.setIndentationLeft(50);

            document.add(iimage);
            
            
            document.addTitle("Publication de note");
            document.addSubject("Samac's Validation");
            document.addKeywords("jackson");

            /////////////////////
            Desktop d = Desktop.getDesktop();
            d.open(new File(cheminn));

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException dee) {
            dee.printStackTrace();
        }

        document.close();
        
    }
    
    public static PdfPCell getCellc (String text, int align) {
       
        PdfPCell cell = new PdfPCell(new Phrase(text, CATFONT));
        cell.setPadding(2);
        cell.setHorizontalAlignment(align);
        cell.setBorder(2);
        
        return cell;
    }
    
    public static PdfPCell getCell (String text, int align) {
       
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(2);
        cell.setHorizontalAlignment(align);
        cell.setBorder(14);
        
        return cell;
    }

}
