package Algorithm.chapter01;

import java.util.Iterator;

public class MyBag<T> implements Iterable<T> {
    private Node first;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            T item = curr.item;
            curr = curr.next;
            return item;
        }
    }
    public int size() { return N; }
    public boolean isEmpty() { return first == null; }
    public void add(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public static void main(String[] args) {
        char[] c = {'(',')','[',']','{','}'};
        for (char ch: c){
            System.out.println(Integer.valueOf(ch));
        }
    }

}
