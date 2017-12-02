package nl.hva.dmci.ict.se.datastructures.LinkedList;

/**
 * Double Ended Queue zoals beschreven op pagina 167 van het boek van Sedgewick en Wayne. <br>
 * <br>
 * <b>Tip:</b> implementeer eerste de methodes die beschreven zijn in het boek van Sedgewick en
 * Wayne en daarna pas de extra methodes <code>changeLeft</code> en <code>changeRight</code>.
 */
public interface OwnLinkedList<T> {
    
    /**
     * Check if list is empty
     */
    boolean isEmpty();

    /**
     * get the size of the list
     */
    int size();

    /**
     * Add element at position 0
     */

    /**
     * Add an element at the end
     */
    void add(T item);
    
    /**
     * Add an element at the end
     */
    void add(int index, T item);
    
    /**
     * Add an element at the end
     */
    T get(int i);
}
