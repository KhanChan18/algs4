package Algorithm.chapter01.exercise;

import java.util.HashMap;

public class MoveToFront {
    public HashMap<String, Integer> duplicate = new HashMap<>();
    public Node first;
    public Node leftGuard;
    public Node rightGuard;
    public int N;
    public class Node {
        String val;
        Node next;
        Node prev;
        Node(String s) {
            val = s;
            next = null;
            prev = null;
        }
    }

    public boolean isEmpty() {return first == null;}
    public int size() {return N;}

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("LeftGuard<->RightGuard");
        } else {
            System.out.print("LeftGuard<->");
            Node curr = first;
            while (curr.val != null) {
                System.out.print(curr.val+"<->");
                curr = curr.next;
            }
            System.out.println("RightGuard");
        }
    }

    public void delete(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = null;
        curr.prev = null;
    }

    public void deleteAll(String s) {
        Node curr = first;
        while (curr.val != null) {
            if (curr.val == s) {
                curr = curr.next;
                this.delete(curr.prev);
            }
        }
    }

    public void add(String s) {
       if (!duplicate.containsKey(s)) {
           if (this.isEmpty()) {
               leftGuard = new Node(null);
               rightGuard = new Node(null);
               first = new Node(s);
               leftGuard.next = first;
               first.next = rightGuard;
               rightGuard.prev = first;
               first.prev = leftGuard;
           } else {
               Node oldfirst = first;
               first = new Node(s);
               first.prev = leftGuard;
               leftGuard.next = first;
               first.next = oldfirst;
               oldfirst.prev = first;
               duplicate.put(s, 1);
           }
       } else {
            this.deleteAll(s);
            Node oldfirst = first;
            first = new Node(s);
            first.next = oldfirst;
            first.prev = leftGuard;
            oldfirst.prev = first;
            leftGuard.next = first;
       }
    }

    public static void main(String[] args) {
        MoveToFront mtf = new MoveToFront();
        mtf.add("This");
        mtf.add("is");
        mtf.add("my");
        mtf.add("This");
        mtf.add("Life");
        mtf.printList();
        mtf.deleteAll("This");
        mtf.printList();
    }

}
