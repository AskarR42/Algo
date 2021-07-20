import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
            if (!isValidRow(board, i)) {
                return false;
            }
            if (!isValidSquare(board, i % 3 * 3 + 1, i / 3 * 3 + 1)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidSquare(board, 3 * i + 1, 3 * j + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int i) {
        Set<Character> numbers = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (numbers.contains(board[i][j])) {
                return false;
            } else if (Character.isDigit(board[i][j])) {
                numbers.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int j) {
        Set<Character> numbers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (numbers.contains(board[i][j])) {
                return false;
            } else if(Character.isDigit(board[i][j])) {
                numbers.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSquare(char[][] board, int p, int q) {
        Set<Character> numbers = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (numbers.contains(board[p + i][q + j])) {
                    return false;
                } else if (Character.isDigit(board[p + i][q + j])) {
                    numbers.add(board[p + i][q + j]);
                }
            }
        }
        return true;
    }
}
