/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samac;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
///import com.google.api.services.drive.model.ParentReference;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author NGONO
 */
public class need_file2 {

    /**
     * @param args the command line argument
     */
    

// ...



  // ..

  /**
   * Insert new file.
   *
   * @param service Drive API service instance.
   * @param title Title of the file to insert, including the extension.
   * @param description Description of the file to insert.
   * @param parentId Optional parent folder's ID.
   * @param mimeType MIME type of the file to insert.
   * @param filename Filename of the file to insert.
   * @return Inserted file metadata if successful, {@code null} otherwise.
   */
  private static File insertFile(Drive service, String title, String description,
      String parentId, String mimeType, String filename) {
    // File's metadata.
    File body = new File();
    //body.setTitle(title);
    body.setDescription(description);
    body.setMimeType(mimeType);

    /*/ Set the parent folder.
    if (parentId != null && parentId.length() > 0) {
      body.setParents(
          Arrays.asList(new ParentReference().setId(parentId)));
    } */

    // File's content.
    java.io.File fileContent = new java.io.File(filename);
    //FileContent mediaContent = new FileContent(mimeType, fileContent);
   // try {
      //File file = service.files().insert(body, mediaContent).execute();

      // Uncomment the following line to print the File ID.ee
      // System.out.println("File ID: " + file.getId());e

      //return file;
   // } catch (IOException e) {
      //System.out.println("An error occurred: " + e);
      return null;
    }
  }

  // ...


    
    //public static void main(String[] args) {
        // TODO code application logic here
    //}
    
//}
