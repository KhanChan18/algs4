package Algorithm.chapter01.exercise;

public class LoopListQueue {
    public static class Node {
        Node next;
        int val;
        Node(int v) { val = v; next = null; }
    }
    private int N;
    private Node last;

    public boolean isEmpty() {return last == null;}
    public int size() {return N;}
    public boolean isLoop() {
        if (this.isEmpty()) return false;
        else {
            Node p1 = last.next;
            Node p2 = last.next;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                if (p1 == p2)
                    return true;
            }
        }
        return false;
    }

    public void enqueue(int val) {
        if (this.isEmpty()) {
            last = new Node(val);
            last.next = last;
        } else {
            Node oldlast = last;
            last = new Node(val);
            last.next = oldlast.next;
            oldlast.next = last;
        }
        N++;
    }

    public int dequeue() {
        int res = last.next.val;
        last.next = last.next.next;
        N--;
        return res;
    }

    public void requeue() {
        last = last.next;
    }

    public static void printLoopList(LoopListQueue list) {
        Node curr = list.last;
        System.out.print("(ENDPOINT)");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println("(ENDPOINT)");
    }

    public static void main(String[] args) {
        LoopListQueue loopQueue = new LoopListQueue();
        System.out.println(loopQueue.isLoop());
        loopQueue.enqueue(1);
        System.out.println(loopQueue.isLoop());
        loopQueue.enqueue(2);
        System.out.println(loopQueue.isLoop());
        loopQueue.enqueue(3);
        System.out.println(loopQueue.isLoop());
        printLoopList(loopQueue);
        int[] arr = {4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1};
        for (int i: arr) {
            loopQueue.enqueue(i);
        }
        printLoopList(loopQueue);
        loopQueue.requeue();
        printLoopList(loopQueue);
    }
}
