import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E>
        implements LinkedList<E>, Iterable<E> {
    private Node<E> head;

    SinglyLinkedList() {
        head = new SinglyLinkedNode<>();
    }

    private static class SinglyLinkedNode<E>
            implements Node<E> {
        private E data;
        private Node<E> next;

        SinglyLinkedNode() {
            this(null);
        }

        SinglyLinkedNode(E data) {
            this(data, null);
        }

        SinglyLinkedNode(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public Node<E> getNext() {
            return next;
        }

        @Override
        public void setPrev(Node<E> prev) {
            throw new UnsupportedOperationException("Not valid for " +
                    "SinglyLinkedList");
        }

        @Override
        public Node<E> getPrev() {
            throw new UnsupportedOperationException("Not valid for " +
                    "SinglyLinkedList");
        }

        @Override
        public void setData(E data) {
            this.data = data;
        }

        @Override
        public E getData() {
            return data;
        }

        @Override
        public String toString() {
            return "SinglyLinkedNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private class Itr implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous;

        Itr() {
            current = new SinglyLinkedNode<>(null, head.getNext());
            previous = new SinglyLinkedNode<>(null, head);
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public E next() {
            // Don't use "=" assignment. We want to continue to have the
            // iterator operating above the LinkedList. If we use assignment
            // then they just hold references to items of the LinkedList --
            // we want them the be nodes "floating above" the lined list
            // which is why we must use the getter and setter methods.
            previous.setNext(previous.getNext());
            current.setNext(current.getNext());
            return previous.getData();
        }

        public void advance() {
            previous.setNext(previous.getNext());
            current.setNext(current.getNext());
        }

        public E removeCurrent() {
            previous.setNext(null);
            return current.getData();
        }

        public E removeAndReturnCurrent() {
            previous.setNext(null);
            return current.getData();
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
    public E remove() {
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
     * @return true if list is empty, false if otherwise
     */
    private boolean isEmpty() {
        return ((head.getNext() == null) && (tail.getNext() == null));
    }

    /**
     * Checks if the list is a singleton.
     * @return true if list is empty, false if otherwise
     */
    private boolean isSingleton() {
        // Transitivity allows us to avoid checking (tail == null) as well
        return ((head.getNext() == tail.getNext()) && (head.getNext() != null));
    }



    @Override
    public void add(E data) {
        if (isEmpty()) {
            addAtHead(data);
        } else if (isSingleton()) {
            addAtHead(data);
        } else {
            // Must find the end of the list
            Iterator<E> itr = new Itr();
            while (itr.hasNext()) {
                itr.next();
            }
        }
    }

    private void addAtHead(E data) {
        Node<E> n = new SinglyLinkedNode<>(data, null);
        head.setNext(n);
        tail = n;
    }

    private E removeAtHead() {
        var ret = head.getData();
        head = head.getNext();
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SinglyLinedList:\n");
        int i = 0;
        for (Iterator<E> itr = iterator(); itr.hasNext(); i++) {
            E e = itr.next();
            sb.append("[").append(i).append("] = ").append(e).append("\n");
        }
        return sb.toString();
    }
}
