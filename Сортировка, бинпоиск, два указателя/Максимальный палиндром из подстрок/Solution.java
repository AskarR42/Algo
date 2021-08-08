class Solution {
    public String longestPalindrome(String s) {
        String maxPalindromicString = "";
        for (int i = 0; i < s.length(); i++) {
            String maxEvenPalindromicString = maxEvenPalindromicString(s, i);
            if (maxPalindromicString.length() < maxEvenPalindromicString.length()) {
                maxPalindromicString = maxEvenPalindromicString;
            }
            String maxOddPalindromicString = maxOddPalindromicString(s, i);
            if (maxPalindromicString.length() < maxOddPalindromicString.length()) {
                maxPalindromicString = maxOddPalindromicString;
            }
        }

        return maxPalindromicString;
    }

    private String maxEvenPalindromicString(String s, int k) {
        if (k == s.length() - 1) {
            return String.valueOf(s.charAt(k));
        }

        int i = k;
        int j = k + 1;
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }

    private String maxOddPalindromicString(String s, int k) {
        if (k == 0 || k == s.length() - 1) {
            return String.valueOf(s.charAt(k));
        }

        int i = k - 1;
        int j = k + 1;

        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }
}
