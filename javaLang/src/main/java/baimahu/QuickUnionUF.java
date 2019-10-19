package baimahu;

public class QuickUnionUF {
    private int[] id;
    private QuickUnionUF(int n){
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    private int root(int i){
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    private boolean connected(int n, int m) {
        return root(n) == root(m);
    }

    private void union(int n, int m) {
        int nroot = root(n);
        int mroot = root(m);
        id[nroot] = mroot;
    }

    private void printId() {
        for (int i:id) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.printId();
        System.out.println(quickUnionUF.connected(2, 3));
        quickUnionUF.union(2, 3);
        quickUnionUF.union(2, 9);
        quickUnionUF.printId();
        System.out.println(quickUnionUF.connected(3, 9));

    }
}
