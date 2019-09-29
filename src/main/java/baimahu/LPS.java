package baimahu;

public class LPS {
    public static int findLPS(String a) {
        int [][] arr = new int[a.length()][a.length()];
        for (int i = 0; i < a.length(); i++) {
            arr[i][i] = 1;
        }
        for (int i = 1; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {
                if (a.charAt(j) == a.charAt(j - i)) {
                    arr[j - i][j] = arr[j - i + 1][j - 1] + 2;
                } else {
                    arr[j - i][j] = arr[j - i][j - 1] > arr[j - i + 1][j]?arr[j - i][j - 1]:arr[j - i + 1][j];
                }

            }
        }
        return arr[0][a.length() - 1];
    }

    public static void main(String[] args) {

        String str = "BABCBAB";
        String str2 = "BABC";
        System.out.println(findLPS(str));
        System.out.println(findLPS(str2));
    }
}
