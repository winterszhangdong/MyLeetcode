package problems;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import utils.Interval;

/**
 * problem 56: Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty())
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int size = 0;
        for (Interval cur : intervals) {
            Interval tail = intervals.get(size);
            if (cur.start <= tail.end) {
                if (cur.end > tail.end)
                    tail.end = cur.end;
            } else {
                size++;
                intervals.get(size).start = cur.start;
                intervals.get(size).end = cur.end;
            }
        }

        return intervals.subList(0, size+1);
    }
}
