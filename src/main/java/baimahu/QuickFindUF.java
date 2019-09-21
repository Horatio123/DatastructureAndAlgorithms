package baimahu;

class QuickFindUF{
    private int[] id;

    private QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    private void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    private void printIds() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        System.out.println(quickFindUF.connected(1, 2));
        quickFindUF.printIds();

        quickFindUF.union(2, 4);
        quickFindUF.union(4, 6);
        System.out.println(quickFindUF.connected(2, 6));
        quickFindUF.printIds();

    }

}
