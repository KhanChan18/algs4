package Algorithm.chapter01.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public Queue<Integer> queue = new LinkedList<>();

    public void genQueue(int N) {
        for (int i = 0; i < N; i++) {
            queue.offer(i);
        }
    }

    public void getOrder(int M) {
        int counter = 1;
        while(!queue.isEmpty()) {
            if (counter == M) {
                System.out.print(queue.poll()+" ");
            } else {
                queue.offer(queue.poll());
            }
            counter = (counter % 2 == 0)?1:counter+1;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Josephus dead1 = new Josephus();
        dead1.genQueue(7);
        dead1.getOrder(2);
    }
}
