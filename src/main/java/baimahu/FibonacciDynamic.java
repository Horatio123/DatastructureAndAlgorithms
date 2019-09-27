package baimahu;

public class FibonacciDynamic {
    private int[] lookup = new int[100];

    private void printLookuup() {
        for (int i: lookup){
            System.out.print(i);
        }
    }

    private int fib(int n) {
        if (lookup[n] == 0) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fib(n -1) + fib(n -2);
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {

        FibonacciDynamic fibonacciDynamic = new FibonacciDynamic();
        fibonacciDynamic.printLookuup();
        System.out.println();
        int f1 = fibonacciDynamic.fib(3);
        int f2 = fibonacciDynamic.fib(3);
        System.out.println(f1);
        System.out.println(f2);
    }
}
