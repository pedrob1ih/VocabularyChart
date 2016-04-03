package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SacarVocabulario {

    
    public static void main(String[] args) {
        try {
            ArrayList<String> ignore=new ArrayList();
            ArrayList l=MakeVocabulary.makeVocabulary("El panel A de la figura adjunta muestra un esquema de una región del genoma de ratón en cuya  secuencia se han detectado" ,ignore);
            for (Object o : l) {
                System.out.println(((String)o));
            }
            MakeVocabulary.saveFile(l, "C:\\Users\\yo\\Desktop\\texto.txt");
        } catch (IOException ex) {
            Logger.getLogger(SacarVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
