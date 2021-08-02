class Solution {

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int countOfNeighbors = 0;

                for (int p = -1; p <= 1; p++) {
                    for (int q = -1; q <= 1; q++) {
                        if (p == 0 && q == 0) {
                            continue;
                        }
                        if (i + p >= 0 && i + p < n && j + q >= 0 && j + q < m) {
                            if (board[i + p][j + q] > 0) {
                                countOfNeighbors++;
                            }
                        }
                    }
                }

                if (countOfNeighbors == 0 && board[i][j] == 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = board[i][j] == 1 ? countOfNeighbors : -countOfNeighbors;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] <= 0) {
                    if (board[i][j] == -3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else {
                    if (board[i][j] == 2 || board[i][j] == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
}
