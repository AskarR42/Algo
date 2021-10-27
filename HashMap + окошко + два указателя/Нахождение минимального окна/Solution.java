import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n < m) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < m; i++) {
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
        }

        int minWindowSize = Integer.MAX_VALUE;
        int minBeginning = -1;
        int minEnding = n;
        int beginning = 0;
        int ending = m;
        while (canBeShifted(s, tMap, window, beginning, ending)) {
            while (!window.isEmpty() && (!tMap.containsKey(s.charAt(beginning)) || window.get(s.charAt(beginning)) > tMap.get(s.charAt(beginning)))) {
                window.put(s.charAt(beginning), window.get(s.charAt(beginning)) - 1);
                window.remove(s.charAt(beginning), 0);
                beginning++;
            }
            if (isValid(tMap, window)) {
                if (ending - beginning < minWindowSize) {
                    minBeginning = beginning;
                    minEnding = ending;
                    minWindowSize = minEnding - minBeginning;
                }
            }
            if (ending < s.length()) {
                window.put(s.charAt(ending), window.getOrDefault(s.charAt(ending), 0) + 1);
            }
            ending++;
        }

        if (isValid(tMap, window)) {
            if (ending - beginning < minWindowSize) {
                minBeginning = beginning;
                minEnding = ending;
                minWindowSize = minEnding - minBeginning;
            }
        }

        if (minWindowSize != Integer.MAX_VALUE) {
            return s.substring(minBeginning, minEnding);
        } else {
            return "";
        }
    }

    private boolean isValid(Map<Character, Integer> tMap, Map<Character, Integer> window) {
        for (var e : tMap.entrySet()) {
            if (!window.containsKey(e.getKey()) || e.getValue() > window.get(e.getKey())) {
                return false;
            }
        }
        return true;
    }

    private boolean canBeShifted(String s, Map<Character, Integer> tMap, Map<Character, Integer> window, int beginningIncluding, int endingExcluding) {
        if (endingExcluding < s.length()) {
            return true;
        }
        if (window.isEmpty()) {
            return false;
        }
        if (!tMap.containsKey(s.charAt(beginningIncluding))) {
            return true;
        }
        return window.get(s.charAt(beginningIncluding)) > tMap.get(s.charAt(beginningIncluding));
    }
}
