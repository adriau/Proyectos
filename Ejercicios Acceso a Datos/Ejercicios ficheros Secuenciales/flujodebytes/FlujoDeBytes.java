/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodebytes;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author a13adrianac
 */
public class FlujoDeBytes {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc = new Scanner(System.in);
        byte op;

        do {            
            
            System.out.println("Menu");
            System.out.println("Opcion 1:  Grabar Texto");
            System.out.println("Opcion 2:  Leer Texto");
            System.out.println("Opcion 3:  Fin");
            System.out.println("Escoge una opcion:");
            
            op=sc.nextByte();
            
            switch (op){
                case 1: GrabarTexto.grabar();
                    break;
                case 2: LeerTexto.Leer();
                    break;
                case 3:
                    break;
                default: System.out.println("Esa opcion no existe");
            }
        } while (op!=3);   
    }
}
