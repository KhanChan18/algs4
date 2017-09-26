package Algorithm.chapter01.exercise;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int N;
    public static class Node {
        int val;
        Node next;
        Node(int v) {
            val = v;
            next = null;
        }
    }

    public boolean isEmpty() { return first == null;}
    public int size() { return N;}
    public void add(int v) {
        if (this.isEmpty()) {
            first = new Node(v);
            last = first;
        } else {
            Node oldlast = last;
            last = new Node(v);
            oldlast.next = last;
        }
        N++;
    }

    public void leftDelete() {
        first = first.next;
        N--;
    }

    public void rightDelete() {
        Node curr = first;
        for (int i =0; i < this.size(); i++) {
            if (i == this.size() - 2)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
    }

    public void kDelete(int k) {
        Node curr = first;
        int counter = 0;

        if (k < 0 || k >= N) {
            System.out.println("kth element doesn't exist");
            return;
        } else {
            if (k == 0) {
                leftDelete();
                return;
            } else {
                while (counter != k - 1) {
                    curr = curr.next;
                    counter +=1;
                }
                curr.next = curr.next.next;
            }
        }
    }

    public boolean find(int key) {
        Node curr = first;
        while (curr != null) {
            if (curr.val == key)
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void removeAfter(Node node) {
        node.next = null;
    }

    public void insertAfter(Node prev, Node insert) {
        insert.next = prev.next;
        prev.next = insert;
    }

    public static void remove(MyLinkedList list, int value) {
        Node curr = list.first;
        int cnt = 0;
        while (curr != null) {
            if (curr.val == value)
                list.kDelete(cnt);
            cnt++;
            curr = curr.next;
        }
    }

    public static int max(Node firstnode) {
        int temp = 0;
        Node curr = firstnode;
        if (firstnode == null)
            return 0;
        else {
            while (curr != null) {
                if (curr.val > temp)
                    temp = curr.val;
                curr = curr.next;
            }
        }
        return temp;
    }

    public static int max_rec(Node firstnode) {
        int temp = 0;
        int cmp = 0;
        if (firstnode == null) return 0;
        if (firstnode == null) return firstnode.val;
        else {
            temp = firstnode.val;
            cmp = max_rec(firstnode.next);
            return (temp>cmp)?temp:cmp;
        }
    }

    public static void printLinkedList(MyLinkedList linkedlist) {
        Node curr = linkedlist.first;
        for (int i = 0; i < linkedlist.size(); i++) {
            if (curr.next != null) {
                System.out.print(curr.val + "->");
                curr = curr.next;
            } else {
                System.out.println(curr.val + "->NIL");
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList mlist = new MyLinkedList();
        int[] arr = {1,2,3,4,5,6,7,6,5,4,3,2,1};
        for (int i: arr) {
            mlist.add(i);
        }
        printLinkedList(mlist);
        mlist.leftDelete();
        printLinkedList(mlist);
        mlist.rightDelete();
        printLinkedList(mlist);
        mlist.kDelete(1);
        printLinkedList(mlist);
        System.out.println(mlist.find(8));
        //mlist.removeAfter(mlist.first.next.next.next.next);
        //printLinkedList(mlist);
        Node inserted = new Node(98);
        mlist.insertAfter(mlist.first, inserted);
        printLinkedList(mlist);
        remove(mlist,5);
        printLinkedList(mlist);
        mlist.first.next.val = 3;
        System.out.println(max_rec(mlist.first));
    }
}
