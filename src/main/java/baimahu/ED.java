package baimahu;

public class ED {
    public static int findEditDistance(String a, String b) {
        int[][] arr = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            arr[i][0] = i;
        }
        for (int j = 0; j < b.length() + 1; j++) {
            arr[0][j] = j;
        }
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    int num = arr[i - 1][j] < arr[i][j - 1]?arr[i - 1][j]:arr[i][j - 1];
                    arr[i][j] = num < arr[i - 1][j - 1]?num:arr[i - 1][j - 1] + 1;
                }
            }
        }
        return arr[a.length()][b.length()];
    }
    public static void main(String[] args) {
        String str1 = "CART";
        String str2 = "MARCH";
        System.out.println(findEditDistance(str1, str2));
    }
}
