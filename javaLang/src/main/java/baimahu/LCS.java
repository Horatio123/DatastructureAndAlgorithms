package baimahu;
// a string vertical, b string parralle
public class LCS {
    public int findLCS(String a, String b) {
        int[][] nums = new int[a.length() + 1][b.length() + 1];
//        for (int i = 0; i <= b.length(); i++) {
//            nums[0][i] = 0;
//        }
//        for (int j = 0; j <= a.length(); j++) {
//            nums[j][0] = 0;
//        }
// if i == 0 || j == 0 ==> nums[i][j] = 0
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    nums[i][j] = nums[i -1][j -1] + 1;
                } else {
                    nums[i][j] = nums[i - 1][j] > nums[i][j - 1]?nums[i - 1][j]:nums[i][j - 1];
                }
            }
        }
        return nums[a.length()][b.length()];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String str1 = "GXTXAYB";
        String str2 = "AGGTAB";
        //String str1 = "GX";
        //String str2 = "X";
        System.out.println(lcs.findLCS(str1, str2));
    }
}
