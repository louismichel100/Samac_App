/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.adobe.acrobat.Viewer;

/**
 *
 * @author NGONO
 */
public class Lecteurpdf extends JPanel {

    /**
     * @param args the command line arguments
     */
   
      private Viewer viewer;
 
    public Lecteurpdf(String nomfichier) throws Exception{
        this.setLayout(new BorderLayout());
 
        //créer le viewer qui va servir à afficher le contenu du pdf
        com.adobe.acrobat.Viewer viewer = new Viewer();
        this.add(viewer, BorderLayout.CENTER);
        FileInputStream fis = new FileInputStream(nomfichier);
        viewer.setDocumentInputStream(fis);
        viewer.activate();
    }
 
    public static void main(String[] args) throws Exception {
 
        String nomfichier = "delphi.pdf";
        Lecteurpdf lecteur = new Lecteurpdf(nomfichier);
        //créer le JFrame
        JFrame f = new JFrame("Lecteur PDF");
        
        f.setSize(1024,768);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.getContentPane().add(lecteur);
    }
}
