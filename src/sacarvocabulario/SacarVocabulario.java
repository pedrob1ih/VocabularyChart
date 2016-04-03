package sacarvocabulario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SacarVocabulario {

    
    public static void main(String[] args) {
        try {
            ArrayList<String> ignore=new ArrayList();
            ignore.add("¿");
            ignore.add("?");
            ignore.add("=");
            ignore.add(",");
            ignore.add(";");
            ignore.add(".");
            ignore.add(":");
            ignore.add("!");
            ArrayList l=MakeVocabulary.makeVocabulary("1. El panel A de la figura adjunta muestra un esquema de una región del genoma de ratón en cuya\n" +
"secuencia se han detectado, por métodos informáticos, cuatro posibles exones (exón1 a exón4). Se han\n" +
"utilizado cuatro sondas de DNA (S1 a S4) para analizar mediante la técnica “Northern” muestras de RNA\n" +
"tomadas de dos órganos distintos del ratón (H= hígado y R= riñón). Los resultados aparecen en el panel\n" +
"B de la figura.\n" +
"Indica en 1A una explicación, lo más completa posible, de estos resultados, incluyendo el número más\n" +
"probable de genes que están representados en esta región genómica. Indica en 1B un experimento\n" +
"adicional para comprobar tu(s) hipótesis.\n" +
"2. Determinada enfermedad genética humana, dominante y ligada al cromosoma X, se produce cuando\n" +
"están presentes más de 40 repeticiones de la secuencia (CGG) en un determinado gen. A continuación\n" +
"se indica la secuencia que flanquea a esa repetición en dicho gen:\n" +
"5' CAGTATGCA ------ (CGG)n ------- ATGCGTAAT 3'\n" +
"3' GTCATACGT ------ (GCC)n ------- TACGCATTA 5'\n" +
"Indica en 2A cuáles de los siguientes cebadores utilizarías para amplificar dicha secuencia mediante PCR\n" +
"(indica solamente los números).\n" +
"Cebadores:\n" +
"#1) 5'-TAATGCGTA-3'\n" +
"#2) 5'-ATTACGCAT-3'\n" +
"#3) 3'-GTCATACGT-5'\n" +
"#4) 5'-CAGTATGCA-3'\n" +
"#5) 5'-GTCATACGT-3'\n" +
"#6) 3'-TAATGCGTA-5'\n" +
"En la siguiente página se indica el árbol incompleto de una familia en la que se presentan casos de dicha\n" +
"enfermedad, junto con una representación esquemática de los resultados obtenidos en un gel en el que\n" +
"se han separado los fragmentos obtenidos en una PCR, en un experimento realizado para detectar el\n" +
"número de repeticiones de la secuencia CGG presente en cada uno de los miembros de la familia. Con\n" +
"todos estos datos, completa el árbol en 2B, incluyendo los símbolos (círculos/cuadrados)\n" +
"correspondientes a cada individuo, indicando (mediante sombreado del correspondiente símbolo) si\n" +
"está afectado o no por la enfermedad.\n" +
"exón1 exón2 exón3 exón4\n" +
"S1 S2 S3 S4\n" +
"A)\n" +
"B)\n" +
"H R H R H H R\n" +
"S1 S2 S3 S4\n" +
"H R H R H R H R\n" +
"S1 S2 S3 S4\n" +
"Genética Molecular Humana - 3º Grado de Bioquímica – Curso 2015-2016\n" +
"Series de Problemas\n" +
"Considera ahora una familia diferente, la de Juan, que tiene un hermano con Fibrosis Quística (FQ), una\n" +
"enfermedad autosómica recesiva. Juan quiere tener un hijo con su pareja, Lola. Lola tiene un tío que\n" +
"también tiene FQ. ¿Cuál es la probabilidad de que el hijo de Juan y Lola tenga FQ? Indícala en 2C.\n" +
"Imagina ahora que tienen el hijo y éste tiene FQ. Lola está embarazada de nuevo (de Juan). Cuál es la\n" +
"probabilidad de que ese hijo tenga FQ? Indícala en 2D.\n" +
"3. El siguiente árbol genealógico corresponde a una pareja (P y M) con una hija (Ha) que presenta\n" +
"trisomía del cromosoma 21. Más abajo se muestra el resultado de un análisis de dos loci diferentes (13 y\n" +
"14), localizados en el cromosoma 21, para cada uno de los miembros de la familia. Las letras (A-C y E-H)\n" +
"indican alelos distintos para esos loci.\n" +
"Indica en 3A si la no-disyunción meiótica ha ocurrido en el PADRE o en la MADRE, y explica porqué en un\n" +
"máximo de 25 palabras. Indica en 3B si ha ocurrido en la Meiosis I ó en la Meiosis II, y explica tu\n" +
"respuesta en un máximo de 25 palabras.\n" +
"A\n" +
"E\n" +
"F\n" +
"G\n" +
"H\n" +
"Locus 13\n" +
"Locus 14\n" +
"B\n" +
"C\n" +
" P Ha M\n" +
"I 1\n" +
"II 2\n" +
"I1 I2 II1 II2 II3 II4 II5 II6 II7 II8\n" +
"42 repeticiones\n" +
"23 repeticiones\n" +
"20 repeticiones\n" +
"Genética Molecular Humana - 3º Grado de Bioquímica – Curso 2015-2016\n" +
"Series de Problemas\n" +
"4. Caenorhabditis elegans es un organismo utilizado como modelo para el estudio de muchos procesos\n" +
"fisiológicos, entre ellos, el envejecimiento. Con objeto de identificar genes implicados en el proceso de\n" +
"envejecimiento, se ha generado una genoteca de dsRNA (RNA de doble cadena) correspondiente a los\n" +
"aproximadamente 19.000 genes identificados en este organismo y se ha utilizado para llevar a cabo un\n" +
"análisis global de la función génica mediante RNAi en C. elegans. Para ello, se ha analizado el fenotipo de\n" +
"individuos que han sido alimentados con estirpes de E. coli portadoras de plásmidos distintos de esta\n" +
"genoteca. Se han identificado varios individuos que viven más tiempo que la estirpe silvestre (individuos\n" +
"1 a 6) y se ha analizado en dichos individuos la acumulación de RNAm y de proteína del gen AP2, del que\n" +
"se sabe que las mutaciones de falta de función provocan un alargamiento del periodo de vida de C.\n" +
"elegans. Los resultados se muestran en la figura adjunta. Indica en 4A una explicación lo más completa\n" +
"posible de los resultados obtenidos, especificando si la mayor longevidad de alguno de los individuos\n" +
"analizados se debe al silenciamiento del gen AP2. Teniendo en cuenta los resultados obtenidos, ¿es\n" +
"correcto pensar que existen otros genes que controlen el proceso de envejecimiento? Contesta\n" +
"razonadamente en 4B. En caso positivo, indica en 4C qué pasos seguirías para identificar esos otros\n" +
"genes a partir de los resultados obtenidos en este experimento" ,ignore);
            for (Object o : l) {
                System.out.println(((String)o));
            }
            MakeVocabulary.saveFile(l, "C:\\Users\\yo\\Desktop\\texto.txt");
        } catch (IOException ex) {
            Logger.getLogger(SacarVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        }
//        String texto="uno dos tres cuatro dos  dos dos dos dos cinco dos";
//        System.out.println(deleteWord("dos",texto));
    }
    
}
