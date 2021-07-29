import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = dic.getOrDefault(s.charAt(i), 0);
            dic.put(s.charAt(i), count + 1);
        }

        for (Character c : dic.keySet()) {
            if (dic.get(c) % 2 == 1) {
                k--;
            }
        }

        return k >= 0;
    }
}
