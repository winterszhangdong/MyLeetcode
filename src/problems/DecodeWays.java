package problems;

/**
 * problem 91: Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public int solution(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            int pre = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';
            int decode = pre * 10 + cur;
            if (cur == 0) {
                if (pre != 0 && pre <= 2)
                    dp[i+1] = dp[i-1];
                else
                    return 0;
            } else {
                if (pre != 0 && decode <= 26)
                    dp[i+1] = dp[i] + dp[i-1];
                else
                    dp[i+1] = dp[i];
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        String s = "10101";
        System.out.println(test.solution(s));
    }
}
