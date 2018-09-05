package problems;

/**
 * problem 6: ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String solution(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len;) {
            for (int j = 0; j < numRows && i < len; j++)
                sb[j].append(chars[i++]);
            for (int j = numRows - 2; j > 0 && i < len; j--)
                sb[j].append(chars[i++]);
        }

        for (int i = 1; i < numRows; i++)
            sb[0].append(sb[i]);

        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        System.out.println(test.solution(s, 3));
    }
}
