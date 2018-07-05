package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 17: Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *  1    2    3
 *      abc  def
 *  4    5    6
 * ghi  jkl  mno
 *  7    8    9
 * pqrs tuv  wxyz
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        char[] curCom = new char[digits.length()];
        getAllCom(digits, 0, curCom, result);
        return result;
    }

    private void getAllCom(String digits, int i, char[] curCom, ArrayList<String> result) {
        if (digits.length() == 0)
            return;

        char c = digits.charAt(i);
        if (c < '2' || c > '9')
            return;

        int size = (c != '9' && c != '7') ? 3 : 4;
        for (int j = 0; j < size; j++) {
            if (c > '7')
                curCom[i] = (char) ('a' + (c - '2') * 3 + j + 1);
            else
                curCom[i] = (char) ('a' + (c - '2') * 3 + j);
            if (i == digits.length() - 1)
                result.add(new String(curCom));
            else
                getAllCom(digits, i+1, curCom, result);
        }
    }
}
