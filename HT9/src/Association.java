
import java.util.Map;

/**
 * CLase Association que representa el par asociado de cada nodo en los arboles binarios de busqueda que simulan a un 
 * diccionario en este trabajo.
 * @author David Soto 17555
 * @author Diego Sevilla 17238
 * @param <K> un generico que representa la llave (ingles)
 * @param <V> un generico que representa el valor (espanol)
 */
public class Association<K extends Comparable<K>,V extends Comparable<V>> implements Map.Entry<K,V>
{
    /**
     * The immutable key.  An arbitrary object.
     */
    protected K theKey; // the key of the key-value pair
    /**
     * The mutable value.  An arbitrary object.
     */
    protected V theValue; // the value of the key-value pair

    /*
      for example:
      Association<String,Integer> personAttribute =
         new Assocation<String,Integer>("Age",34);
     */
    /**
     * Constructs a pair from a key and value.
     * @param key A non-null object.
     * @param value A (possibly null) object.
     */
    public Association(K key, V value)
    {        
        theKey = key;
        theValue = value;
    }

    /**
     * Constructs a pair from a key; value is null.
     * @param key A non-null key value.
     */
    public Association(K key)
    {
        this(key,null);
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     * @param other Another association.
     * @return true iff the keys are equal.
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     * @return A hash code for association.
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     * @return The value field of the association.
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Fetch key from association.  Should not return null.
     * @return Key of the key-value pair.
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     * @param value The new value.
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * Standard string representation of an association.
     * @return String representing key-value pair.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
    /*
...
*/
}
