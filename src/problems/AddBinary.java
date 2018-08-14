package problems;

/**
 * problem 67: Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i < 0 ? 0 : a.charAt(i) - '0';
            int n2 = j < 0 ? 0 : b.charAt(j) - '0';
            int n = n1 + n2 + carry;
            carry = n / 2;
            sb.append(n % 2);
            i--;
            j--;
        }

        if (carry == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
}
