class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        int[] ip = new int[4];
        solve(answer, ip, s, 0, 0);
        return answer;
    }

    private void solve(List<String> answer, int[] ip, String s, int segment, int idx) {
        if (segment == 4 && idx == s.length()) {
            answer.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
            return;
        } else if (segment == 4 || idx == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            int val = Integer.parseInt(s.substring(idx, idx + len));
            if (val > 255 || len > 1 && s.charAt(idx) == '0') {
                break;
            }

            ip[segment] = val;
            solve(answer, ip, s, segment + 1, idx + len);
        }
    }
}
