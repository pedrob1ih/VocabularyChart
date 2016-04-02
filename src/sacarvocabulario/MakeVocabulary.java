package sacarvocabulario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MakeVocabulary {
    public static ArrayList makeVocabulary(String texto){
        ArrayList l = new ArrayList();
        int i =0;
        String palabra="";
        char c=' ';
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' '){
                palabra+=c;
            }
            else{
                if(!(palabra.contains(" ")) && !(palabra.equals("")))
                    l.add(palabra);
                palabra="";
            }
            i++;
        }
        return l;        
    }
    
    public static ArrayList makeVocabulary(String texto,ArrayList<String> ignoreWords){
        ArrayList<String> l = new ArrayList();
        int i =0;
        String palabra="";
        char c=' ';
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' '){
                palabra+=c;
            }
            else{
                if(!(palabra.contains(" ")) && !(palabra.equals("")))
                    l.add(palabra);
                palabra="";
            }
            i++;
        }
        l.removeAll(ignoreWords);
        return l;        
    }
    
    public static void saveFile(ArrayList<String> lText,String path) throws IOException{
        FileWriter f= new FileWriter(new java.io.File(path));
        String text="";
        for (String o : lText) {
            text+=o+" = \n";
        }
        f.write(text);
        f.close();
    }
}
