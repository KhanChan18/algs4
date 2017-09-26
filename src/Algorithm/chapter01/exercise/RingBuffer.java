package Algorithm.chapter01.exercise;

public class RingBuffer<Item> {
    public int MAX_LEN = 5;
    public Item[] buffer =  (Item[]) new Object[MAX_LEN];
    public int N;
    public int counter = 0;

    public boolean isFull() {return N == MAX_LEN;}
    public boolean isEmpty() {return N == 0;}

    public void enqueue(Item item) {
        if (this.isFull()) {
            System.out.println("The buffer is full now.");
            return;
        } else {
            buffer[N] = item;
            N++;
        }
    }

    public void dequeue() {
        if (this.isEmpty()) {
            System.out.println("The buffer is empty now");
            return;
        } else {
            buffer[counter] = null;
            counter++;
        }
    }


}
