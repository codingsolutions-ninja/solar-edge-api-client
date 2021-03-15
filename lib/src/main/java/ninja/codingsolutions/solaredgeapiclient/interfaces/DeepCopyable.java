package ninja.codingsolutions.solaredgeapiclient.interfaces;

/**
 * Interface that defines a contract for classes to provide a method to consumers
 * that creates deep copies
 */
public interface DeepCopyable {
    /**
     * Create and return a deep copy of the current object
     * @return {Object} deep copy of current object
     */
    Object deepCopy();
}
