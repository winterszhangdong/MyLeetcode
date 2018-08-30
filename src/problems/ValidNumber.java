package problems;

/**
 * problem 65: Valid Number
 *
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated.
 * If you still see your function signature accepts a const char * argument,
 * please click the reload button to reset your code definition.
 */
public class ValidNumber {
    public boolean solution(String s) {
        s = s.trim();

        boolean pointFlg = false;
        boolean eFlg = false;
        boolean numFlg = false;
        boolean numAfterEFlg = true;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                numFlg = true;
                numAfterEFlg = true;
            }
            else if (cur == '.') {
                if (eFlg || pointFlg)
                    return false;
                pointFlg = true;
            }
            else if (cur == 'e') {
                if (eFlg || !numFlg)
                    return false;
                numAfterEFlg = false;
                eFlg = true;
            }
            else if (cur == '-' || cur == '+') {
                if (i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }
            else
                return false;
        }

        return numFlg && numAfterEFlg;
    }
}
