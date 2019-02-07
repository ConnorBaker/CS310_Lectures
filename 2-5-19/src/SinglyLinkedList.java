import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E>
        implements LinkedList<E>, Iterable<E> {
    private Node<E> head;
    private Node<E> tail;

    SinglyLinkedList() {
        head = null;
        tail = null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        Node() {
            data = null;
            next = null;
        }
//
//        void setNext(Node<E> next) {
//            this.next = next;
//        }
//
//        Node getNext() {
//            return next;
//        }
//
//        void setData(E data) {
//            this.data = data;
//        }
//
//        E getData() {
//            return data;
//        }
    }

    private class Itr implements Iterator<E> {
        private Node<E> current = head;
        private Node<E> previous = null;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            final E ret = current.data;
            previous = current;
            current = current.next;
            return ret;
        }

        public void advance() {
            previous = current;
            current = current.next;
        }

        public E removeCurrent() {
            previous.next = null;
            return current.data;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     *
     * @return the removed element
     * @throws NoSuchElementException if the element was not found
     */
    @Override
    public E remove() throws NoSuchElementException {
        // Empty list
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // List contains a single element
        if (isSingleton()) {
            return removeAtHead();
        }

        // Must find the end of the list
        // TODO: Consider using a third node to track the one before tail
        Itr itr = new Itr();
        while (itr.hasNext()) {
            itr.advance();
        }

        return itr.removeCurrent();
    }

    /**
     * Checks if the list is empty.
     * @returns true if list is empty, false if otherwise
     */
    private boolean isEmpty() {
        return ((head == null) && (tail == null));
    }

    /**
     * Checks if the list is a singleton.
     * @returns true if list is empty, false if otherwise
     */
    private boolean isSingleton() {
        // Transitivity allows us to avoid checking (tail == null) as well
        return ((head == tail) && (head != null));
    }



    @Override
    public void add() {
        // Empty list
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // List contains a single element
        if (isSingleton()) {

        }

        // Must find the end of the list
        Itr itr = new Itr();
        while (itr.hasNext()) {
            itr.advance();
        }
    }

    private void addAtHead() {

    }

    private E removeAtHead() {

    }
}
