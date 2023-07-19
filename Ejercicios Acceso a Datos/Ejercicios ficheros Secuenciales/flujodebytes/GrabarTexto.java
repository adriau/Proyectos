/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodebytes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 *
 * @author a13adrianac
 */
public class GrabarTexto {
    
    public static void grabar() throws FileNotFoundException{
        int nbytes;
        FileOutputStream fs = new FileOutputStream("tema1.dat", true);
        byte[] buffer = new byte[250];
        
        try {
            System.out.println("Escribe lo que quiere grabar");
            nbytes=System.in.read(buffer);
            fs.write(buffer, 0, nbytes);
            
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        
    }
}
