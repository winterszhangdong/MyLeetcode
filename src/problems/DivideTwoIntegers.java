package problems;

/**
 * problem 29: Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int solution(int dividend, int divisor) {
        // when dividend is MIN_VALUE, abs(dividend) will overflow
        if (dividend == divisor)
            return 1;
        if (dividend == 0 || divisor == Integer.MIN_VALUE)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // brallient!
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        int res = 0;
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE) {
            dividend += divisor;
            res++;
        }
        dividend = Math.abs(dividend);
        // use addition to approach dividend
        while (dividend >= divisor) {
            long tmp = divisor;
            long multiple = 1;
            // use exponent to approach quickly
            while (dividend >= (tmp << 1)) {
                tmp <<= 1;
                multiple <<= 1;
            }
            dividend -= tmp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }

    // ??????????????????????????????????????????
//    public int divide(int A, int B) {
//        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
//        int a = Math.abs(A), b = Math.abs(B), res = 0;
//        for (int x = 31; x >= 0; x--)
//            if ((a >>> x) - b >= 0) {
//                res += 1 << x;
//                a -= b << x;
//            }
//        return (A > 0) == (B > 0) ? res : -res;
//    }
}
