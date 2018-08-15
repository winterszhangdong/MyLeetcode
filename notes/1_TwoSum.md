## 问题描述：

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```



## 分析

这道题第一反应可能会想到回溯法，不过已经明确了一定是**两个数**相加，并且有且只有**一个解**，那就有有更简单的办法了，用字典。

遍历数组，用`target` 减去数组中每一个数，得到的差在字典中检索，如果能找到，则字典中的检索结果和当前的数就是解。

如果字典中找不到，就把得到的差放入字典，键是当前的数，值为当前数在数组中的索引。

算法的时间复杂度和空间复杂度都是`O(n)`。

下面是代码：

``` java
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                result[0] = map.get(tmp);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
```
