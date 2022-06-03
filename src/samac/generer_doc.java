

package samac;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import  com.itextpdf.text.List;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGONO
 */
public class generer_doc {

    /**
     * @param args the command line arguments
     */
    public static final String chemin = "C:\\Users\\NGONO\\Documents\\NetBeansProjects\\SAMAC\\dist\\2rR.pdf";
    public static Paragraph p1 = new Paragraph("made by Rayap's Group");
    public static Text t1 = new Text();
    private static final Font CATFONT = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD);
 
/** Times Roman 12 Normal */
    private static final Font REDFONT = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.NORMAL);
 
/** Times Roman 16 Bold */
    private static final Font SUBFONT = new Font(Font.getFamily("TIMES_ROMAN"), 16, Font.BOLD);
 
/** Times Roman 12 Bold */
    private static final Font SMALLBOLD = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
    
    public static void main(String[] args)
  {
    Document document = new Document();
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream(chemin));
      document.open();

      document.add(new Paragraph("Hello World"));
      document.add(premierTableau());
      
      Image image = Image.getInstance("images/5h.jpg"); 
      image.scaleAbsolute(200, 200);
      
      
      document.add(image);
      
      
      //////////////
      Anchor anchor = new Anchor("Premier Chapitre", CATFONT);
      anchor.setName("Premier Chapitre");
 
// Le 2ième paramètre est le numero du chapitre
      Chapter catPart = new Chapter(new Paragraph(anchor), 1);
 
      Paragraph subPara = new Paragraph("Sous-Catégorie 1", SUBFONT);
      Section subCatPart = catPart.addSection(subPara);
      subCatPart.add(new Paragraph("Coucou (pour ne pas mettre toto...)."));
 
      subPara = new Paragraph("Sous-catégorie 2", SUBFONT);
      subCatPart = catPart.addSection(subPara);
      subCatPart.add(new Paragraph("Paragraphe 1"));
      subCatPart.add(new Paragraph("Paragraphe 2"));
      subCatPart.add(new Paragraph("Paragraphe 3"));
      
      
      
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
 
//Classe permmettant de déssiner un tableau.

  public static PdfPTable premierTableau()
  {
      //On créer un objet table dans lequel on intialise ça taille.
      PdfPTable table = new PdfPTable(3);
      
      //On créer l'objet cellule.
      PdfPCell cell;
      
      cell = new PdfPCell(new Phrase("Fusion de chaque première cellule de chaque colonne"));
      cell.setColspan(3);
      table.addCell(cell);
 
      cell = new PdfPCell(new Phrase("Fusion de 2 cellules de la première colonne"));
      cell.setRowspan(2);
      table.addCell(cell);
 
      //contenu du tableau.
      table.addCell("Colonne 1; Cellule 1");
      table.addCell("Colonne 1; Cellule 2");
      table.addCell("Colonne 2; Cellule 1");
      table.addCell("Colonne 2; Cellule 2");
      
      return table;  
  }
  
  
  private void ajouterLigneVide(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}
  
  private void addTitlePage(Document document) throws DocumentException {
    Paragraph preface = new Paragraph();
 
    // Ajout d'une ligne vide
    ajouterLigneVide(preface, 1);
 
    // Ecriture du header
    preface.add(new Paragraph("Titre du document", CATFONT));
    ajouterLigneVide(preface, 1);
 
    preface.add(new Paragraph("Rapport généré par: louis_michel, " + new Date(), SMALLBOLD));
    ajouterLigneVide(preface, 3);
 
    preface.add(new Paragraph("Ce document décrit quelque chose de très important ", SMALLBOLD));
    ajouterLigneVide(preface, 8);
 
    preface.add(new Paragraph("Ce document est une version préliminaire et n'est sujet à aucune restriction.", REDFONT));
    document.add(preface);
 
    // Debut d'une nouvelle page
    document.newPage();
}
  
  
  private void createTable(Section subCatPart) throws BadElementException {
    // Creation d'une PdfPTable avec 3 colonnes
    final PdfPTable table = new PdfPTable(3);
 
    // Creation d'une PdfPCell avec un paragraphe
    final PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
 
    // Changement du colspan de la PdfCell
    cell.setColspan(3);
 
    // Ajout de la PdfCell custom à la PdfPTable
    table.addCell(cell);
 
    // Ajout d'objets String à la PdfPTable
    table.addCell("1.1");
    table.addCell("2.1");
    table.addCell("3.1");
    table.addCell("1.2");
    table.addCell("2.2");
    table.addCell("3.2");
 
    // Ajout d'un espace entre la PdfPTable et l'élément précédent.
    table.setSpacingBefore(15f);
 
    subCatPart.add(table);
}
  
  private void createList(Section subCatPart) {
    final List list = new List(true, false, 10);
    list.add(new ListItem("Premier point"));
    list.add(new ListItem("Deuxième point"));
    list.add(new ListItem("Troisième point"));
    subCatPart.add(list);
}
    
}
