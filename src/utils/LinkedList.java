package utils;

import java.util.Iterator;

/*
Realizuokite visus interfeiso metodus susietojo sarašo pagrindu.
Nesinaudokite java klase LinkedList<E>, visa logika meginkite parasyti patys.
Jeigu reikia, galima kurti papildomus metodus ir kintamuosius.
*/
public class LinkedList<T> implements List<T> {

    class Node<T> {
        T Data;
        Node<T> Next;

        public Node(T data, Node<T> next) {
            Data = data;
            Next = next;
        }
    }

    private Node<T> begin;
    private Node<T> end;
    private Node<T> current;


    @Override
    public void add(T item) {
        begin = new Node<>(item, begin);
    }

    @Override
    public T get(int index) {
        if (index == 0 && this.begin != null) return null;

    }

    @Override
    public boolean remove(T item) {
        if (begin == null)
            return false;
        Node previousNode = null;
        for (Node i = begin; i != null; i = i.Next) {
            if (i.Data.equals(item)) {
                if (previousNode == null) {
                    begin = begin.Next;
                    return true;
                } else if (i.Next == null) {
                    previousNode.Next = null;
                    return true;
                } else {
                    previousNode.Next = i.Next;
                    return true;
                }
            } else
                previousNode = i;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()){
                    T data = current.Data;
                    current = current.Next;
                    return data;
                }
                return null;
            }
        };
    }
}
