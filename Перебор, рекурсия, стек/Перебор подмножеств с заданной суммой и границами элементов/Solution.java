import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> subsets;
    private List<Integer> subset;

    public List<List<Integer>> combinationSum3(int k, int n) {
        subsets = new ArrayList<>();
        subset = new ArrayList<>();

        solve(1, k, n);
        return subsets;
    }

    private void solve(int currElem, int k, int n) {
        if (subset.size() == k) {
            if (sum(subset) == n) {
                subsets.add(new ArrayList<>(subset));
            }
        } else if (currElem == 10) {
            return;
        } else {
            subset.add(currElem);
            solve(currElem + 1, k, n);
            subset.remove(subset.size() - 1);
            solve(currElem + 1, k, n);
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int elem : list) {
            sum += elem;
        }

        return sum;
    }
}
