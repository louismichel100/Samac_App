/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.io.InputStream;
//import com . google . api . client . http . GenericUrl ; import com . google . api . client . http . HttpResponse ; import com.google.api.services.conduire.modèle.Fichier ;



/**
 *
 * @author NGONO
 */
public class need_file {

    /**
     * @param args the command line arguments
     */
    
    private static void printFile(Drive service, String fileId) {

    try {
      File file = service.files().get(fileId).execute();

      System.out.println("Title: " + file.getName());
      System.out.println("Description: " + file.getDescription());
      System.out.println("MIME type: " + file.getMimeType());
    } catch (IOException e) {
      System.out.println("An error occurred: " + e);
    }
  }

  /**
   * Download a file's content.
   *
   * @param service Drive API service instance.
   * @param file Drive File instance.
   * @return InputStream containing the file's content if successful,
   *         {@code null} otherwise.
   */
  private static InputStream downloadFile(Drive service, File file) {
    if (file != null) {
      try {
        HttpResponse resp =
            service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDriveId()))
                .execute();
        return resp.getContent();
      } catch (IOException e) {
        // An error occurred.
        e.printStackTrace();
        return null;
      }
    } else {
      // The file doesn't have any content stored on Drive.
      return null;
    }
  }

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        File fi = new File();
        fi.setId("1");
        
        //Drive ser = new Drive(transport, jsonFactory, httpRequestInitializer);
    }
    
}
