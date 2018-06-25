package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by winters on 2018/6/25.
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
            keyArray[index++] = keys[index];
            freArray[index] = frequencyMap.get(key);
        }
    }

    public void sort(int[] keys, int[] vals) {

    }

    public buildMaxHeap(int[] keys, int[] vals) {

    }

    public swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[j] ^ array[i];
        array[i] = array[j] ^ array[i];
    }
}
