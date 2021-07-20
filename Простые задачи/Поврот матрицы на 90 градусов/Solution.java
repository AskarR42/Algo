class Solution {
    public static void rotate(int[][] matrix) {
        for (int boarder = 0; boarder < (matrix.length + 1) / 2; boarder++) {
            for (int j = boarder; j < matrix.length - 1 - boarder; j++) {
                int t1;
                int t2;

                t1 = matrix[j][matrix.length - 1 - boarder];
                matrix[j][matrix.length - 1 - boarder] = matrix[boarder][j];

                t2 = matrix[matrix.length - 1 - boarder][matrix.length - 1 - j];
                matrix[matrix.length - 1 - boarder][matrix.length - 1 - j] = t1;

                t1 = matrix[matrix.length - 1 - j][boarder];
                matrix[matrix.length - 1 - j][boarder] = t2;

                matrix[boarder][j] = t1;
            }
        }
    }
}
