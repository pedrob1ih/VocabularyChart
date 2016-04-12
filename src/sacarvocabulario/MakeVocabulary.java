package sacarvocabulario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MakeVocabulary {
    public static ArrayList makeVocabulary(String texto){
        ArrayList<String> l = new ArrayList();
        texto=texto.replaceAll("[\\s]+", " ");
        int i =0;
        String palabra="";
        char c=' ';
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' ')
                palabra+=c;
            else{
                l.add(palabra);
                texto=texto.replaceAll(palabra+" ", "");
                i=-1;
                palabra="";
            }
            i++;
        }
        l.add(palabra);
        return l;              
    }
    
    public static ArrayList<String> makeVocabularyRecursive(String texto,ArrayList<String> ignoreWords){
        ArrayList<String> l = new ArrayList();
        texto=texto.replaceAll("[\\s]+", " ");
        l.removeAll(ignoreWords);
        return algoritmVocabR(texto,l);
    }
    private static ArrayList<String> algoritmVocabR(String texto,ArrayList<String> l){
        int i =0;
        String palabra="";
        char c=' ';
        if(i==texto.length())
            return l;
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' '){
                palabra+=c;
            }
            else{
                if(palabra.equals(""))
                l.add(palabra);
                texto=texto.replaceAll(palabra+" ", "");
                algoritmVocabR(texto,l);
            }
            i++;
        }
        return l;
    }
    
    public static ArrayList<String> makeVocabulary(String texto,ArrayList<String> ignoreWords){
        ArrayList<String> l = new ArrayList();
        texto=texto.replaceAll("[\\s]+", " ");
        l.removeAll(ignoreWords);
        int i =0;
        String palabra="";
        char c=' ';
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' ')
                palabra+=c;
            else{
                if(palabra.equals(""))
                    return l;        
                l.add(palabra);
                texto=deleteWord(palabra, texto);
                palabra="";
                i=-1;
            }
            i++;
        }
        l.add(palabra);
        return l;        
    }
    
    public static void saveFile(ArrayList<String> lText,String path) throws IOException{
        FileWriter f= new FileWriter(new java.io.File(path));
        System.out.println("paht "+path);
        String text="";
        for (String o : lText) {
            text+=o+" = \n";
        }
        f.write(text);
        f.close();
    }
    
    
    private static String deleteWord(String regex,String text){
        text=text.replaceAll("[\\s]+", " ");
        String textOutput="";
        String temp="";
        char c=' ';
        for (int i = 0; i < text.length(); i++) {
            c=text.charAt(i);
            if(c==' '){
                if(!(temp.equals(regex))){
//                    temp=temp.deleteWord("[\\s]*", "");
                    textOutput+=temp+" ";    
                }
                temp="";
                c=' ';
            }
            else
                temp+=c;
        }
        if(!(temp.equals(regex)))
            textOutput+=temp+" ";
        return textOutput;
    }
}
