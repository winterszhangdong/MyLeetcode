package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 68: Text Justification
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is,
 * pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int start = 0;
        int count = 0;
        int curWidth = 0;
        for (int i = 0; i < words.length; i++) {
            if (curWidth + words[i].length() > maxWidth) {
                // count of spaces between words
                int slot = (maxWidth - (curWidth - count));
                // count of gaps between words
                int gap = count == 1 ? 1 : count - 1;
                // evenly spaces for each gap
                int spaceCount = slot / gap;
                // count of gaps that must have evenly spaces
                int evenlyCount = slot % gap == 0 ? 0 : slot - spaceCount * gap;
                StringBuilder sb = new StringBuilder();
                while (count > 0) {
                    sb.append(words[start]);
                    for (int j = 0; j < spaceCount; j++)
                        sb.append(" ");
                    if (count > 2 && evenlyCount > 0)
                        sb.append(" ");
                    evenlyCount--;
                    count--;
                    start++;
                }
                res.add(sb.substring(0, maxWidth));
                start = i;
                count = 1;
                curWidth = words[i].length() + 1;
            } else {
                count++;
                curWidth += words[i].length() + 1;
            }
        }

        // build the last group of text
        StringBuilder sb = new StringBuilder();
        int rest = maxWidth - (curWidth - 1);
        while (count > 0) {
            sb.append(words[start]);
            if (count == 1) {
                for (int j = 0; j < rest; j++)
                    sb.append(" ");
            } else
                sb.append(" ");
            start++;
            count--;
        }
        res.add(sb.substring(0, maxWidth));
        return res;
    }
}
