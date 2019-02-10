public interface Node<E> {
    void setNext(Node<E> next);

    Node<E> getNext();

    void setPrev(Node<E> prev);

    Node<E> getPrev();

    void setData(E data);

    E getData();
}
