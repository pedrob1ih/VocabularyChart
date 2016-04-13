package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;

public class SacarVocabulario {

    
    public static void main(String[] args) throws IOException {
        String imput[]= args;
        
        if(imput.length>0){
            String opcion =imput[0];
            if(imput[0].equals("--help")){
                System.out.println("to create the vocavulary chart in the terminal\n" +
        "		first parameter \"<text/>\"\n" +
        "	\n" +
        "	-s saves the vocavulary chart into a file in the actual path\n" +
        "		first \"<text/>\"\n" +
        "	\n" +
        "	-p saves the vocavulary chart into the especified paht\n" +
        "		first \"<text/>\"\n" +
        "		second \"paht\"\n" +
        "	\n" +
        "	-v vervose, shows the vocavulary chart into the terminal\n" +
        "	\n" +
        "	--xml create chart in a xml format(NotImplemented)");
            }
            else if(opcion.charAt(0)=='-' && imput.length==2){
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
                        printVocavulary(l);
                        break;
                }
            }
            else if(opcion.charAt(0)=='-' && opcion.length()==3){
                switch(opcion.charAt(1)){
                    case 's':
                        switch(opcion.charAt(2)){
                            case 'v':
                                if (imput.length>2) {
                                    ArrayList<String> l= MakeVocabulary.makeVocabulary(imput[1]);
                                    printVocavulary(l);
                                    MakeVocabulary.saveFile(l, System.getProperty("user.dir")+"/"+imput[2]);
                                    System.out.println("File "+imput[2]+" saved!");
                                }
                                else
                                    System.out.println("you must indicate the name of the file!");
                                break;
                            default:
                                System.out.println("Option not recognized");
                                break;
                        }
                        break;
                    case 'p':
                        switch(opcion.charAt(2)){
                            case 'v':
                                if (imput.length>3) {
                                    ArrayList<String> l= MakeVocabulary.makeVocabulary(imput[1]);
                                    printVocavulary(l);
                                    MakeVocabulary.saveFile(l, imput[2]+"/"+imput[3]);
                                    System.out.println("File saved in "+imput[2]);
                                }
                                else
                                    System.out.println("you must indicate the name of the file!");
                                break;
                            default:
                                System.out.println("Option not recognized");
                                break;
                        }
                        break;
                    case 'v':
                        ArrayList<String> l=MakeVocabulary.makeVocabulary(imput[1]);
                        switch(opcion.charAt(2)){
                            case 's':
                                if (imput.length>2) {
                                    MakeVocabulary.saveFile(l, System.getProperty("user.dir")+"/"+imput[2]);
                                    System.out.println("File "+imput[2]+" saved!");
                                }
                                else
                                    System.out.println("you must indicate the name of the file!");
                                break;
                            case 'p':
                                if (imput.length>3) {
                                    MakeVocabulary.saveFile(l, imput[2]+"/"+imput[3]);
                                    System.out.println("File saved in "+imput[2]);
                                }
                                else
                                    System.out.println("you must to indicate the paht and the name of the file!");

                                break;
                            default:
                                System.out.println("Not recognized option");
                                break;
                        }
                        printVocavulary(l);
                        break;
                }
            }
            else{
                ArrayList<String> l=MakeVocabulary.makeVocabulary(imput[0]);
                printVocavulary(l);
            }
        }
    }
    public static void printVocavulary(ArrayList<String> l){
        for (String l1 : l) {
            System.out.println(l1+" = ");
        }
    }
    
}
