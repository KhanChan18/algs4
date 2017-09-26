package Algorithm.chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    //Quick-Union components
    public boolean quickconnected(int p, int q) {
        return quickfind(p) == quickfind(q);
    }

    public int quickfind(int p) { return id[p];}

    public void quickunion(int p, int q) {
        int pID = quickfind(p);
        int qID = quickfind(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    //Root-Union components
    public boolean rootconnected(int p, int q) {
        return rootfind(p) == rootfind(q);
    }

    public int rootfind(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void rootunion(int p, int q) {
        int pRoot = rootfind(p);
        int qRoot = rootfind(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.rootconnected(p, q)) continue;
            uf.quickunion(p, q);
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count()+" components");
    }
}
