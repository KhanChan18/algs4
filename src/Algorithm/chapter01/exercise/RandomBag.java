package Algorithm.chapter01.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    public class Node {
        Node next;
        Item item;
    }

    public int N;
    public Node first;
    public int counter = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() { return N; }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>{
        Node curr = first;
        Object[] randomList = new Object[N];

        RandomBagIterator() {
            for (int i = 0; i < N; i++) {
                randomList[i] = curr.item;
                curr = curr.next;
            }
            StdRandom.shuffle(randomList);
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = (Item)randomList[counter];
            counter++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<String> randomBag = new RandomBag<>();
        randomBag.add("T");
        randomBag.add("h");
        randomBag.add("i");
        randomBag.add("s");
        Iterator randIterator = randomBag.iterator();
        for (int i = 0; i < 4; i++) {
            System.out.println(randIterator.next());
        }
    }
}
