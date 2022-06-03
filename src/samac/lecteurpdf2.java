/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.adobe.acrobat.Viewer;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author NGONO
 */
public class lecteurpdf2 extends JPanel {

    /**
     * @param args the command line arguments
     */
   
      private Viewer viewer;
 
    public lecteurpdf2(String nomfichier) throws Exception{
        this.setLayout(new BorderLayout());
 
        //créer le viewer qui va servir à afficher le contenu du pdf
        com.adobe.acrobat.Viewer viewer = new Viewer();
        this.add(viewer, BorderLayout.CENTER);
        FileInputStream fis = new FileInputStream(nomfichier);
        viewer.setDocumentInputStream(fis);
        viewer.activate();
    }
 
    
}

