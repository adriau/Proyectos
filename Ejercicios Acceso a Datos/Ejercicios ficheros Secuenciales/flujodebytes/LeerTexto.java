/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodebytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author a13adrianac
 */
public class LeerTexto {
    
    public static void Leer() throws FileNotFoundException{
        FileInputStream fs = new FileInputStream("tema1.dat");
        int nbytes;
        byte[] buffer = new byte[250];
        
        try {
            nbytes=fs.read(buffer,0,250);
            
            String str = new String(buffer, 0 ,nbytes);
            System.out.println(str);
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
