public interface LinkedList<E> {
    /**
     * Must be overriden. Throws UnsupportedOperationException if not overriden.
     * @throws UnsupportedOperationException if not overriden.
     */
    default E remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Must be overriden. Throws UnsupportedOperationException if not overriden.
     * @throws UnsupportedOperationException if not overriden.
     */
    default void add() {
        throw new UnsupportedOperationException();
    }



}
