package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SacarVocabulario {

    
    public static void main(String[] args) {
        try {
            ArrayList<String> ignore=new ArrayList();
            ignore.add("hola");
            ignore.add("adios");
            ArrayList l=MakeVocabulary.makeVocabulary("hola          adios asda      |@#|@#|@#|@ tu yo  mi me",ignore);
            for (Object o : l) {
                System.out.println(((String)o));
            }
            MakeVocabulary.saveFile(l, "C:\\Users\\yo\\Desktop\\texto.txt");
        } catch (IOException ex) {
            Logger.getLogger(SacarVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
