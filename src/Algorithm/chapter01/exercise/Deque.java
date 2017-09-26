package Algorithm.chapter01.exercise;

public class Deque<Item> {
    public class Node {
        Node prev;
        Node next;
        Item item;
        Node() {
            item = null;
            prev = null;
            next = null;
        }
    }

    Node leftGuard;
    Node rightGuard;
    Node first;
    Node last;
    int N;

    Deque() {
        leftGuard = new Node();
        rightGuard = new Node();
        leftGuard.next = rightGuard;
        rightGuard.prev = leftGuard;
        N = 0;
    }

    public boolean isEmpty() { return N == 0;}

    public int size() { return N;}

    public void pushLeft(Item item) {
        if (this.isEmpty()) {
            first = new Node();
            first.item = item;
            first.prev = leftGuard;
            first.next = rightGuard;
            rightGuard.prev = first;
            leftGuard.next = first;
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.prev = leftGuard;
            first.next = oldfirst;
            leftGuard.next = first;
            oldfirst.prev = first;
        }
        N++;
    }

    public void pushRight(Item item) {
        if (this.isEmpty()) {
            last = new Node();
            last.item = item;
            last.prev = leftGuard;
            last.next = rightGuard;
            rightGuard.prev = last;
            leftGuard.next = last;
            first = last;
        } else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.prev = oldlast;
            last.next = rightGuard;
            rightGuard.prev = last;
            oldlast.next = last;
        }
        N++;
    }

    public Item popLeft() {
        if (this.isEmpty()) {
            return null;
        } else {
            Item item = first.item;
            leftGuard.next = first.next;
            first.next.prev = leftGuard;
            first = first.next;
            N--;
            return item;
        }
    }

    public Item popRight() {
        if (this.isEmpty()) {
            return null;
        } else {
            Item item = last.item;
            rightGuard.prev = last.next;
            last.prev.next = rightGuard;
            N--;
            return item;
        }
    }
    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println("LeftGuard<->RightGuard");
        } else {
            System.out.print("LeftGuard<->");
            Node curr = first;
            while (curr.item != null) {
                System.out.print(curr.item+"<->");
                curr = curr.next;
            }
            System.out.println("RightGuard");
        }
    }

    public static void main(String[] args) {
        Deque deque1 = new Deque();
        deque1.pushLeft("T");
        System.out.println(deque1.size());
        deque1.printDeque();
        deque1.pushRight("h");
        deque1.pushRight("i");
        deque1.pushRight("s");
        deque1.printDeque();
        deque1.pushLeft("s");
        deque1.pushLeft("i");
        deque1.printDeque();
        deque1.popLeft();
        deque1.popLeft();
        deque1.printDeque();
        deque1.popRight();
        deque1.popRight();
        deque1.popRight();
        deque1.popRight();
        deque1.printDeque();
        System.out.println(deque1.isEmpty());
    }
}
