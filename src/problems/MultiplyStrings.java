package problems;

/**
 * problem 43: Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public String solution(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = num1.charAt(i) - '0';
        for (int i = 0; i < nums2.length; i++)
            nums2[i] = num2.charAt(i) - '0';

        char[] result = new char[nums1.length + nums2.length];
        for (int i = 0; i < result.length; i++)
            result[i] = '0';

        for (int i = nums2.length - 1; i >= 0; i--) {
            int carry = 0;
            int index = 1;
            for (int j = nums1.length - 1; j >= 0; j--) {
                index = result.length - (nums2.length - i) - (nums1.length - j - 1);
                int curSum = nums2[i] * nums1[j] + carry + (result[index] - '0');
                result[index] = (char) ((curSum % 10) + '0');
                carry = curSum / 10;
            }

            while (carry != 0) {
                index--;
                int curSum = (carry + (result[index] - '0'));
                result[index] = (char) ((curSum % 10) + '0');
                carry = curSum / 10;
            }
        }

        if (result[0] == '0')
            return String.valueOf(result, 1, result.length-1);
        else
            return String.valueOf(result);
    }
}
