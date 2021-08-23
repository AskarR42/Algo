class Solution {

    private int n;
    private boolean[] col;
    private boolean diag1[];
    private boolean diag2[];
    private int counter;

    public int totalNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        counter = 0;

        solve(0);
        return counter;
    }

    private void solve(int y) {
        if (y == n) {
            counter++;
            return;
        }
        for (int x = 0; x < n; x++) {
            if (col[x] || diag1[x + y] || diag2[n - 1 + y - x]) {
                continue;
            }
            col[x] = diag1[x + y] = diag2[n - 1 + y - x] = true;
            solve(y + 1);
            col[x] = diag1[x + y] = diag2[n - 1 + y - x] = false;
        }
    }
}
