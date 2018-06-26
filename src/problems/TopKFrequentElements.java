package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * problem 347: Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> solution(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int n : nums) {
            if (frequencyMap.containsKey(n))
                frequencyMap.put(n, frequencyMap.get(n) + 1);
            else
                frequencyMap.put(n, 1);
        }
        Integer[] keys = frequencyMap.keySet().toArray(new Integer[frequencyMap.size()]);
        int[] keyArray = new int[frequencyMap.size()];
        int[] freArray = new int[frequencyMap.size()];
        int index = 0;
        for (int key : keys) {
            keyArray[index] = keys[index];
            freArray[index++] = frequencyMap.get(key);
        }
        heapSort(freArray, keyArray);
        for (int i = 0; i < k; i++)
            resultList.add(keyArray[i]);

        return resultList;
    }

    public void heapSort(int[] keys, int[] vals) {
        buildMinHeap(vals, keys);
        for (int i = vals.length - 1; i > 0; i--) {
            swap(vals, 0, i);
            swap(keys, 0, i);
            minHeapify(vals, keys, 0, i);
        }
    }

    public void minHeapify(int[] vals, int[] keys, int parent, int heapSize) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int iMin = parent;

        if (left < heapSize && vals[left] < vals[parent])
            iMin = left;
        if (right < heapSize && vals[right] < vals[iMin])
            iMin = right;
        if (iMin != parent) {
            swap(vals, parent, iMin);
            swap(keys, parent, iMin);
            minHeapify(vals, keys, iMin, heapSize);
        }
    }

    public void buildMinHeap(int[] vals, int[] keys) {
        for (int i = vals.length / 2 - 1; i >= 0; i--) {
            minHeapify(vals, keys, i , vals.length);
        }
    }

    public void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[j] ^ array[i];
        array[i] = array[j] ^ array[i];
    }
}
