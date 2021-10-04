public class Solution {
    public static String lcs(String x, String y) {
        String[][] LCS = new String[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            LCS[i][0] = "";
        }
        for (int i = 0; i <= y.length(); i++) {
            LCS[0][i] = "";
        }

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + x.charAt(i - 1);
                } else {
                    LCS[i][j] = LCS[i][j - 1].length() > LCS[i - 1][j].length() ? LCS[i][j - 1] : LCS[i - 1][j];
                }
            }
        }

        return LCS[x.length()][y.length()];
    }
}
