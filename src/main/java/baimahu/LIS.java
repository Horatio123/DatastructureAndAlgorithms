package baimahu;

public class LIS {
    public int [] findLIS(int[] seq) {
        int[] nums = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            nums[i] = 1;
        }
        for (int i = 1; i < seq.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && nums[i] < nums[j] + 1) {
                    nums[i] = nums[j] + 1;
                }
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] input = {3, 1, 4, 2, 7, 9, 8, 13};
        LIS lis = new LIS();
        int[] output = lis.findLIS(input);
        for (int i: output) {
            System.out.println(i);
        }
    }
}
