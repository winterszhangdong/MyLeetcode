package problems;

/**
 * problem 11: Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int tmpHeightL = -1;
        int tmpHeightR = -1;
        int maxarea = 0;
        while (l < r) {
            if(height[l] <= tmpHeightL || height[r] <= tmpHeightR) {
                if (tmpHeightL == -1)
                    r--;
                else
                    l++;
            }
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                tmpHeightL = -1;
                tmpHeightR = height[r];
                r--;
            } else {
                tmpHeightL = height[l];
                tmpHeightR = -1;
                l++;
            }
        }

        return maxarea;
    }
}
