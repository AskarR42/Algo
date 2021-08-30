import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Map<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            counter.put(candidate, counter.getOrDefault(candidate, 0) + 1);
        }

        List<int[]> counterList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
            counterList.add(new int[]{e.getKey(), e.getValue()});
        }

        backtrack(comb, target, 0, counterList, result);

        return result;
    }

    private void backtrack(LinkedList<Integer> comb, int remain, int curr, List<int[]> counter, List<List<Integer>> result) {
        if (remain <= 0) {
            if (remain == 0) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        for (int nextCurr = curr; nextCurr < counter.size(); nextCurr++) {
            int[] entry = counter.get(nextCurr);
            int candidate = entry[0];
            int freq = entry[1];

            if (freq == 0) {
                continue;
            }

            comb.addLast(candidate);
            counter.set(nextCurr, new int[]{candidate, freq - 1});

            backtrack(comb, remain - candidate, nextCurr, counter, result);

            comb.removeLast();
            counter.set(nextCurr, new int[]{candidate, freq});
        }
    }
}
