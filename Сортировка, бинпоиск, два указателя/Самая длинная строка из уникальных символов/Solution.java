import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> symbols = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        int length = 0;
        while (j < s.length()) {
            if (symbols.contains(s.charAt(j))) {
                max = Math.max(max, length);
                symbols.remove(s.charAt(i));
                i++;
                length--;
            } else {
                symbols.add(s.charAt(j));
                length++;
                j++;
            }
        }
        return Math.max(max, length);
    }
}
