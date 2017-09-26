package Algorithm.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item>{
    public class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;
    public int size() {return N;}
    public boolean isEmpty() {return first == null;}
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (this.isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (this.isEmpty())
            last = null;
        N--;
        return item;
    }

    public Item pop() { return this.dequeue();}

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst.next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue()+" ");
        }
        StdOut.println("<"+q.size()+"left on queue>");
    }
}
