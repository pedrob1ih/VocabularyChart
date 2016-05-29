package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;

public class SacarVocabulario {

    public static void main(String[] args) throws IOException {
        
        String imput[]= args;
//        String imput[]= new String[]{"-v","Niccolò di Bernardo dei Machiavelli (Italian: [nikkoˈlɔ mmakjaˈvɛlli]; 3 May 1469 – 21 June 1527) was an Italian Renaissance historian, politician, diplomat, philosopher, humanist, and writer. He has often been called the founder of modern political science.[1] He was for many years a senior official in the Florentine Republic, with responsibilities in diplomatic and military affairs. He also wrote comedies, carnival songs, and poetry. His personal correspondence is renowned in the Italian language. He was secretary to the Second Chancery of the Republic of Florence from 1498 to 1512, when the Medici were out of power. He wrote his most renowned work The Prince (Il Principe) in 1513. Machiavellianism  is a widely used negative term to characterize unscrupulous politicians of the sort Machiavelli described most famously in The Prince. Machiavelli described immoral behavior, such as dishonesty and killing innocents, as being normal and effective in politics. He even seemed to endorse it in some situations. The book itself gained notoriety when some readers claimed that the author was teaching evil, and providing  evil recommendations to tyrants to help them maintain their power. [2] The term  Machiavellian  is often associated with political deceit, deviousness, and realpolitik. On the other hand, many commentators, such as Baruch Spinoza, Jean-Jacques Rousseau and Denis Diderot, have argued that Machiavelli was actually a republican, even when writing The Prince, and his writings were an inspiration \n                   to Enlightenment proponents of modern democratic political philosophy","textoPrueva.txt"};
        if(imput.length>0){
            String opcion =imput[0];
            if(imput[0].equals("--help")){
                System.out.println("to create the vocavulary chart in the terminal\n" +
        "		first parameter \"<text/>\"\n" +
        "	\n" +
        "	-s saves the vocavulary chart into a file in the actual path\n" +
        "		first \"<text/>\"\n" +      
        "               second \"<name of the file/>\"\n"+
        "	\n" +
        "	-p saves the vocavulary chart into the especified paht\n" +
        "		first \"<text/>\"\n" +
        "		second \"paht\"\n" +
        "               third \"<name of the file/>\"\n"+
        "	\n" +
        "	-v vervose, shows the vocavulary chart into the terminal\n" +
        "	\n" +
        "	--xml create chart in a xml format(NotImplemented yet)");
            }
            else if(opcion.charAt(0)=='-'){
                switch(opcion.charAt(1)){
                    case 's':
                        if (imput.length==3) {
                            MakeVocabulary.saveFile(MakeVocabulary.makeVocabulary(imput[1]), System.getProperty("user.dir")+"/"+imput[2]);
                            System.out.println("File "+imput[2]+" saved!");
                        }
                        else    
                            System.out.println("you must indicate the name of the file!");
                        break;
                    case 'p':
                        if (imput.length==4) {
                            MakeVocabulary.saveFile(MakeVocabulary.makeVocabulary(imput[1]), imput[2]+imput[3]);
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
	else{
            System.out.println("to create the vocavulary chart in the terminal\n" +
        "               first parameter \"<text/>\"\n" +
        "       \n" +
        "       -s saves the vocavulary chart into a file in the actual path\n" +
        "               first \"<text/>\"\n" +      
        "               second \"<name of the file/>\"\n"+
        "       \n" +
        "       -p saves the vocavulary chart into the especified paht\n" +
        "               first \"<text/>\"\n" +
        "               second \"paht\"\n" +
        "               third \"<name of the file/>\"\n"+
        "       \n" +
        "       -v vervose, shows the vocavulary chart into the terminal\n" +
        "       \n" +
        "       --xml create chart in a xml format(NotImplemented yet)");
	}
    }
    public static void printVocavulary(ArrayList<String> l){
        for (String l1 : l) {
            System.out.println(l1+" = ");
        }
    }
    
}
