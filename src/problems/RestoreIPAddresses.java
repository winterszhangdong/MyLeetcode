package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 93: Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> resultList = new ArrayList<String>();
        ArrayList<Integer> curList = new ArrayList<Integer>();
        if (s.length() > 12 || s.length() < 4)
            return resultList;

        char[] ss = s.toCharArray();
        restore(ss, 0, curList, resultList);
        return resultList;
    }

    private void restore(char[] ss, int index, ArrayList<Integer> curList, ArrayList<String> resultList) {
        if (curList.size() == 4) {
            if (index >= ss.length)
                resultList.add(join(curList));
            else
                return;
        }

        if (index < ss.length && ss[index] == '0') {
            curList.add(0);
            restore(ss, index+1, curList, resultList);
            curList.remove(curList.size()-1);
            return;
        }

        int sum = 0;
        for (int i = 0; i < 3 && index+i < ss.length; i++) {
            sum = 10 * sum + (ss[index+i] - '0');
            if (sum <= 255 && curList.size() < 4) {
                curList.add(sum);
                restore(ss, index+i+1, curList, resultList);
                curList.remove(curList.size()-1);
            } else
                break;
        }
    }

    private String join(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(".");
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }
}
