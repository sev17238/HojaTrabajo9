
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal donde se realizan las acciones y operaciones del trabajo.
 * @author David Soto 17551
 * @author Diego Sevilla 17238
 */
public class HT9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int decision = 0; 
        
        Factory fac = new Factory();
        
        SplayTree<String,String> SPTree = null;
        RedBlackBST<String,String> RBTree = null;
        
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        
        System.out.println("¿Que Implementacion desea usar? (Escriba solo el numero) \n\t1. SplayTree \n\t2. Red/Black-Tree");
        String entry = teclado.nextLine();
        
        Object tree;
        switch(entry){            
                    case "1":                         
                        SPTree = (SplayTree)fac.getImp("SplayTree"); 
                        break;
                    case "2":                         
                        RBTree = (RedBlackBST)fac.getImp("RedBlackTree");                    
                        break;                     
                } 
        
            System.out.println("Ingrese el nombre del archivo.txt que quiere leer para su diccionario (Ej. freedict-eng-spa.txt): ");
            String file = teclado.nextLine();
            
            BufferedReader br = new BufferedReader(new FileReader(file));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = "";  
                String line2 = "";                                                
                String ingles = "";
                String espanol = "";                
                //Ciclo principal en donde se lee cada linea del .txt donde estan las asociaciones de ingles y espanol
                while ((line=br.readLine())!=null) { //Se obtiene el primer significado en espanol unicamente.
                    sb.append(line);
                    sb.append(System.lineSeparator()); 
                    line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                       //por substring      
                    for(int i=1;i<line.length();i++){
                        String iter = line.substring((i-1), i); //iterador que toma el valor de cada letra de la linea
                        if(iter.equals("\t")){
                            ingles = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de " "  
                            line2 = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de " "                            
                            for(int e=1;e<line2.length();e++){
                                String iter2 = line2.substring((e-1), e);
                                if(iter2.equals(";")||iter2.equals(",")){
                                    espanol = line2.substring(0, e-1).toUpperCase(); //se obtiene la subcadena antes de , o ;  
                                    break;
                                }else{
                                    espanol = line2; //sino se encuentra una , o un ; 
                                }                                
                            }
              /*IMPRESION*/ System.out.println(ingles +", "+ espanol); //PRUEBA para ver que los datos se esten leyendo bien  
                            if(entry.equals("1")){
                                SPTree.put(ingles, espanol);
                            }else{
                                RBTree.put(ingles,espanol);
                            }  
                        }                        
                    }
                                      
                                      
                }
                System.out.println("Que desea hacer? \n1. Traducir archivo de texto\n2. Salir ");
                decision = teclado.nextInt();               
                while(decision != 2){
                    if(decision == 1){
                        //String traduccion = "";
                        String oracion = "";
                        System.out.println("Ingrese el nombre del archivo a traducir(Ej. texto.txt): ");
                        String texto = teclado2.nextLine();
                        File archivo = new File (texto);

                        FileReader fr = new FileReader (archivo);
                        BufferedReader br1 = new BufferedReader(fr);
                        String linea = "";
                        Scanner scanner = new Scanner(fr);
                        String palabra = "";
        
                        while (scanner.hasNextLine()) {
                            linea += scanner.nextLine();
                            palabra = linea.replaceAll("\n", " ");
                        }
                        fr.close();
                        br1.close();
        
                        String palabras[] = palabra.split(" ");
                        /*for(int i = 0; i < palabras.length;i++){
                            palabra = palabras[i];
                            palabra = palabra.toUpperCase();
                            String prueba = "";
                            if(entry.equals("1")){
                                prueba = SPTree.get(palabra);
                            }else{
                                prueba = RBTree.get(palabra);
                            }                             
                            if(prueba == null){
                                prueba = "*" + palabra + "*";
                            }
                            traduccion = traduccion + " " + prueba + " ";
                        } */   
                        //System.out.println(traduccion);
                        System.out.println(Traduccion(palabras,palabra,SPTree,RBTree,entry));
                    }else{
                        System.out.println("No ha ingresado una opcion valida");
                    }    
                System.out.println("Que desea hacer? \n1. Traducir archivo de texto \n2. Salir ");
                decision = teclado.nextInt();
                }
                
            }
            finally{
                br.close();
            }          
    }
    /**
     * Metodo para chequear el tiempo que toma una traduccion de un texto con alguna de las dos implementaciones.
     * @param palabras cadena de caracteres
     * @param palabra un string 
     * @param SPTree el objeto de SplayTree en cuestion
     * @param RBTree el objeto de RedBlaskBST en cuestion
     * @param entry la entrada para elegir entre una implementacion y la otra
     * @return 
     */
    private static String Traduccion(String palabras[],String palabra,SplayTree SPTree,RedBlackBST RBTree, String entry){
        String traduccion = "";
        for(int i = 0; i < palabras.length;i++){
            palabra = palabras[i];
            palabra = palabra.toUpperCase();
            String prueba = "";
            if(entry.equals("1")){
                prueba = (String)SPTree.get(palabra);
            }else{
                prueba = (String)RBTree.get(palabra);
            }                             
            if(prueba == null){
                prueba = "*" + palabra + "*";
            }
                traduccion = traduccion + " " + prueba + " ";
        }
        return traduccion;
    }
    
    
}
