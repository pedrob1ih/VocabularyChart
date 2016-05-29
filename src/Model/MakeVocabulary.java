package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MakeVocabulary{
    public static ArrayList makeVocabulary(String texto){
        ArrayList<String> l = new ArrayList();
        boolean existe=false;
        System.out.println("TEXTO CON CARATERES ::"+texto);
        texto=excludedCharacters(texto);
        System.out.println("TEXTO SIN CARATERES ::"+texto);
        int i =0;
        String palabra="";
        char c=' ';
        while(texto.length()>i){
            c=texto.charAt(i);
            if(c!=' ')
                palabra+=c;
            else{
                if(l.isEmpty()){
                    l.add(palabra);
                    existe=true;
                }   
                else
                    for (String l1 : l) {
                        if(l1.compareTo(palabra)==0 ){
                            existe=true;
                            break;
                        }
                    }   
                    if(!existe)
                        l.add(palabra);
                palabra="";
                existe=false;
            }
            i++;
        }
        if(!l.contains(palabra) && !(palabra.equals("")))
            l.add(palabra);
        return l;              
    }
    private static String excludedCharacters(String texto){
        boolean vervose=false;
        texto=texto.replaceAll("[\\s]+", " ");
        texto=texto.replaceAll("[“]+", " ");
        texto=texto.replaceAll("[„]+", " ");
        texto=texto.replaceAll("[—]+", " ");
        
        
        
        for (int i = 32; i < 64; i++) {
            char c=(char)i;
            texto=texto.replaceAll("[*"+c+"*]+", " ");
            if(vervose)
                System.out.println("c :: "+c+" i:: "+i);
        }
        
        for (int i = 91; i < 96; i++) {
            char c=(char)i;
            texto=texto.replaceAll("[*\\"+c+"*]+", " ");
            if(vervose)
                System.out.println("c :: "+c+" i:: "+i);
        }
        
        for (int i = 123; i < 126; i++) {
            char c=(char)i;
            texto=texto.replaceAll("[*\\"+c+"*]+", " ");
            if(vervose)
                System.out.println("c :: "+c+" i:: "+i);
        }
        
        for (int i = 168; i < 223; i++) {
            char c=(char)i;
            texto=texto.replaceAll("[*\\"+c+"*]+", " ");
            if(vervose)
                System.out.println("c :: "+c+" i:: "+i);
        }
        for (int i = 238; i < 254; i++) {
            char c=(char)i;
            texto=texto.replaceAll("[*\\"+c+"*]+", " ");
            if(vervose)
                System.out.println("c :: "+c+" i:: "+i);
        }
        String nEspacios="";
        for (int i = 0; i < 50; i++) {
            nEspacios+=" ";
            texto=texto.replaceAll("["+nEspacios+"]+", " ");
            if(vervose)
                System.out.println("c :: "+nEspacios+" i:: "+i);
        }
        return texto;
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
