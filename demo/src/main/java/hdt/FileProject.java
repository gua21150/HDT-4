package hdt;


/*
 * Universidad del Valle de Guatemala
 * @author Aaron Beltrán 21092
* @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
 * Clase que maneja archivos
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileProject {
    
    InfixPostfix changer;

    public FileProject() {
       changer = new InfixPostfix();
    }    
    
    public String LeerArchivo(){
      
        int contador=0;
        int tamaño=0;
        String string ="";
        BufferedReader br = null;
 
        try {
                String sCurrentLine;
                File file = new File("datos.txt");
                br = new BufferedReader(new FileReader(file.getAbsoluteFile()));

               while ((sCurrentLine = br.readLine()) != null) {
                    tamaño++;
                }
               br = new BufferedReader(new FileReader(file));
              
                while ((sCurrentLine = br.readLine()) != null) {
                    sCurrentLine = changer.conversion(sCurrentLine); // realiza el cambio de infix a postfix
                    string = string.concat(sCurrentLine);
                }
                
        return string;
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
        return null;
    }        
}
