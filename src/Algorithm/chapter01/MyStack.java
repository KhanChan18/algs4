package Algorithm.chapter01;

        import edu.princeton.cs.algs4.StdIn;
        import edu.princeton.cs.algs4.StdOut;

        import java.util.Iterator;

public class MyStack<Item> implements Iterable<Item>{
    public class Node {
        Item item;
        Node next;

    }
    private Node first;
    private int N;
    public boolean isEmpty() { return first == null; }
    public int size() { return N; }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
        Node oldfirst = first;
        first = first.next;
        N--;
        return oldfirst.item;
    }
    public Item peek(){
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
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

    public MyStack<String> copy(MyStack<String> mys) {
        Iterator<String> iter = mys.iterator();
        MyStack<String> cpStack = new MyStack<>();
        for (String e = iter.next(); iter.hasNext(); e = iter.next()) {
            cpStack.push(e);
        }
        return cpStack;
    }

    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop()+" ");
        }
        StdOut.println("("+s.size()+" left on stack");
    }
}
