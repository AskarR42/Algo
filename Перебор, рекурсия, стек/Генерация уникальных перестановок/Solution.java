import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private Set<List<Integer>> permutations;
    private List<Integer> permutation;
    private boolean[] chosen;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        permutations = new HashSet<>();
        permutation = new ArrayList<>();
        chosen = new boolean[nums.length];
        this.nums = nums;

        solve();
        List<List<Integer>> answer = new ArrayList<>();
        answer.addAll(permutations);
        return answer;
    }

    private void solve() {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (chosen[i]) continue;
                chosen[i] = true;
                permutation.add(nums[i]);
                solve();
                chosen[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
