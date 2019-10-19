package baimahu;


import java.util.Arrays;

public class LBS {
    public int findLBS(int[] seq) {
        int[] arr = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            arr[i] = 1;
        }

        int[] arr2 = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            arr2[i] = 1;
        }

        for (int i = 1; i < seq.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && arr[i] < arr[j] + 1) {
                    arr[i] += 1;
                }
            }
        }
        for (int i = seq.length - 2; i >= 0; i--) {
            for (int j = seq.length - 1; j > i; j--) {
                if (seq[i] > seq[j] && arr2[i] < arr2[j] + 1) {
                    arr2[i] += 1;
                }
            }
        }
        int[] arr3 = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            arr3[i] = arr[i] + arr2[i];
        }

        int LBS = Arrays.stream(arr3).max().getAsInt() - 1;

        return LBS;
    }
}
