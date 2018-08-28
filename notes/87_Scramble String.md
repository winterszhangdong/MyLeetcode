## 问题描述：

Given a string *s1*, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of *s1* = `"great"`:

```
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
```

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.

```
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
```

We say that `"rgeat"` is a scrambled string of `"great"`.

Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.

```
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
```

We say that `"rgtae"` is a scrambled string of `"great"`.

Given two strings *s1* and *s2* of the same length, determine if *s2* is a scrambled string of *s1*.

**Example 1:**

```
Input: s1 = "great", s2 = "rgeat"
Output: true
```

**Example 2:**

```
Input: s1 = "abcde", s2 = "caebd"
Output: false
```

## 分析

题目是真的长...

其实就是把一个字符串拆分，拆分得到的子串再拆分，如此递归，形成一个二叉树，每个**非叶结点**都是一个可以拆分的子串。将树中**任意个非叶子**结点的左右子树交换，可以重新拼成一个字符串。

题目是验证给定字符串s2，是否能由字符串s1以上述操作转换而来。

看到原字符串可以拆分成子串，然后子串也能进行同样操作的时候，就应该想到可以用递归或者动态规划来解决。

相比动态规划，这里用递归写起来更好理解一些。

## 代码

```java
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int[] letters = new int[128];
        int len = s1.length();
        // 首先统计字符串s1，s2中各字符出现的次数，
        // 如果每个字符出现的次数不同，说明s1，s2肯定不能相互转换。
        for (int i = 0; i < len; i++)
            letters[s1.charAt(i)]++;

        for (int i = 0; i < len; i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0)
                return false;
        }
		
        // 因为是交换子串的左右子树，可以将s1 s2以相同方式分割比较，
        // 然后在以一头一尾的方式分割比较。
        for (int i = 1; i < len; i++) {
            // s1前i个字符能转换为s2前i个字符，并且s1剩余字符也能转换为s2剩余字符。
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            // s1前i个字符能转换为s2后i个字符，并且s1剩余字符能转换为s2前len-i个字符。
            if (isScramble(s1.substring(0, i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0, len-i)))
                return true;
        }

        return false;
    }
}
```

