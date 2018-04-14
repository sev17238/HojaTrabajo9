
import java.util.PriorityQueue;

/**
 * Clase que muestra la utilizacion del patron de diseño factory.
 * @author David Soto 17551
 * @author Diego Sevilla 17238
 */
class Factory {
    /**
     * Constructor vacio.
     */
    public Factory(){}
    Object Imp;
    /**
     * Metodo que retorna la implementacion a utilizar
     * @param impMap el string que dice que implementacionse utilizara
     * @return el Map correspondiente
     */
    public Object getImp(String imp) {
    // seleccion de la implementacion a utilizar:
        if(imp.equals("SplayTree"))
        {   
            Imp = new SplayTree<>();
        }else{
            Imp = new RedBlackBST<>();
        } 
        return Imp;
   }

}
