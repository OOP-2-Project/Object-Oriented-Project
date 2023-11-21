package comp3607project;

/** 
 * An interface used to traverse a list
 */
public interface InterfaceIterator {

    /**
     * An iterator method which checks if there is another entry in the iterator.
     * @return Returns a boolean value. True if there exits another entry in thr iterator. False otherwise.
     */
    public abstract boolean hasNext();
    
    /**
     * Iterates through the collection.
     * @return Returns the collection.
     */
    public abstract Object next();
}
