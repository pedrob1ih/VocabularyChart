package sacarvocabulario;

import java.util.ArrayList;


public class SacarVocabulario {

    
    public static void main(String[] args) {
        ArrayList<String> ignore=new ArrayList();
        ignore.add("hola");
        ignore.add("adios");
        ArrayList l=MakeVocabulary.makeVocabulary("hola          adios asda      |@#|@#|@#|@ tu yo  mi me",ignore);
        for (Object o : l) {
            System.out.println(((String)o));
        }
    }
    
}
