package problems;

import java.util.Stack;

/**
 * problem 42: Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trapped = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                trapped += leftMax - height[left];
                left++;
            } else {
                trapped += rightMax - height[right];
                right--;
            }
        }

        return trapped;
    }

    // anthor solution used stack
    private int solution2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int trapped = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int preIndex = stack.pop();
                if (stack.isEmpty())
                    break;

                int curHeight = Math.min(height[i]-height[preIndex], height[stack.peek()]-height[preIndex]);
            }
            stack.push(i);
        }

        return trapped;
    }
}
