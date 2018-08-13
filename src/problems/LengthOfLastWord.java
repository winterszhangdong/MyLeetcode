package problems;

/**
 * problem 58: Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public int solution(String s) {
        String[] strs = s.split("\\s+");
        return strs.length == 0 ? 0 : strs[strs.length-1].length();
    }
}
