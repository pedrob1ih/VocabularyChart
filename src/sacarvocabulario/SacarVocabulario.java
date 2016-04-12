package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;

public class SacarVocabulario {

    
    public static void main(String[] args) throws IOException {
        String imput[]= args;
        if(imput.length>0){
            String opcion =imput[0];
            if(opcion.charAt(0)=='-' && imput.length>1){
                switch(opcion.charAt(1)){
                case 's':
                    if (imput.length>2) {
                        MakeVocabulary.saveFile(MakeVocabulary.makeVocabulary(imput[1]), System.getProperty("user.dir")+"/"+imput[2]);
                        System.out.println("File "+imput[2]+" saved!");
                    }
                    else
                        System.out.println("you must indicate the name of the file!");
                    break;
                case 'p':
                    if (imput.length>3) {
                        MakeVocabulary.saveFile(MakeVocabulary.makeVocabulary(imput[1]), imput[2]+"/"+imput[3]);
                        System.out.println("File saved in "+imput[2]);
                    }
                    else
                        System.out.println("you must to indicate the paht and the name of the file!");
                    
                    break;
                case 'v':
                    ArrayList<String> l=MakeVocabulary.makeVocabulary(imput[1]);
                    for (String l1 : l) {
                        System.out.println(l1+" = ");
                    }
                    break;
                }
            }
            else{
                ArrayList<String> l=MakeVocabulary.makeVocabulary(imput[0]);
                for (String l1 : l) {
                    System.out.println(l1+" = ");
                }
            }
        }
    }
    
}
