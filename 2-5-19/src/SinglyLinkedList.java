import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E extends  Comparable<E>>
        implements List<E> {
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            advance();

            return (previous.getNext()).getData();
        }

        void advance() {
            // Don't use "=" assignment. We want to continue to have the
            // iterator operating above the List. If we use assignment
            // then they just hold references to items of the List --
            // we want them the be nodes "floating above" the lined list
            // which is why we must use the getter and setter methods.
            // Fix the Law of Demeter violation
            // - Fixed by using additional parenthesis. We treat n.getNext() as an object,
            //   instead of a method on an object returning an object.
            previous.setNext(current.getNext());
            current.setNext((current.getNext()).getNext());
        }

        private void unlinkNode() {
            // Move current to the node after the removed node
            current.setNext((current.getNext()).getNext());

            // Set the node before the node to be removed to point past the node to be removed
            // (which is current). This removes the only reference to the node to be removed and
            // clears it for GC.
            (previous.getNext()).setNext(current.getNext());
        }

        @Override
        public void remove() {
            if (isEmpty()) {
                throw new NoSuchElementException("List is empty");
            }

            unlinkNode();
        }
    }

    /**
     * Checks if the list is empty.
     * @return true if list is empty, false if otherwise
     */
    private boolean isEmpty() {
        return (head.getNext() == null);
    }

    /**
     * Checks if the list is a singleton.
     * @return true if list is empty, false if otherwise
     */
    private boolean isSingleton() {
        return (!isEmpty() && ((head.getNext()).getNext() == null));
    }

    @Override
    public void add(E data) {
        addAtHead(data);
    }

    private void addAtHead(E data) {
        Node<E> n = new SinglyLinkedNode<>(data, head.getNext());
        head.setNext(n);
    }

    /**
     * Removes the element at the head.
     * @return the removed element
     * @throws NoSuchElementException if the element was not found
     */
    @Override
    public E remove() {
        return removeAndReturnAtHead();
    }

    private void removeAtHead() {
        new Itr().remove();
    }

    private E removeAndReturnAtHead() {
        Iterator<E> itr = new Itr();
        var ret = (head.getNext()).getData();
        itr.remove();
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SinglyLinedList:\n");

        int i = 0;
        for (Iterator<E> itr = new Itr(); itr.hasNext(); i++) {
            E e = itr.next();
            sb.append("[").append(i).append("] = ").append(e).append("\n");
        }

        return sb.toString();
    }
}
