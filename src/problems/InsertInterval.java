package problems;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 57: Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public List<Interval> solution(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> resultList = new ArrayList<Interval>();
        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).start) {
            resultList.add(intervals.get(i));
            i++;
        }

        if (i != 0 && newInterval.start <= intervals.get(i-1).end) {
            if (newInterval.end > intervals.get(i-1).end) {
                intervals.get(i-1).end = newInterval.end;
                newInterval = intervals.get(i-1);
            }
        } else {
            resultList.add(newInterval);
        }

        while (i < intervals.size()) {
            if (newInterval.end >= intervals.get(i).start) {
                if (newInterval.end < intervals.get(i).end)
                    newInterval.end = intervals.get(i).end;
            } else {
                resultList.add(intervals.get(i));
            }
            i++;
        }

        return resultList;
    }
}
