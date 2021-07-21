class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        for (int boarder = 0; boarder < (n + 1) / 2; boarder++) {
            for (int j = boarder; j < n - boarder; j++) {
                matrix[boarder][j] = counter++;
            }
            for (int i = boarder + 1; i < n - boarder; i++) {
                matrix[i][n - 1 - boarder] = counter++;
            }
            for (int j = n - 2 - boarder; j >= boarder; j--) {
                matrix[n - 1 - boarder][j] = counter++;
            }
            for (int i = n - 2 - boarder; i >= boarder + 1; i--) {
                matrix[i][boarder] = counter++;
            }
        }
        return matrix;
    }
}
