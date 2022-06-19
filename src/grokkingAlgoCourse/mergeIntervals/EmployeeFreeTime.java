package grokkingAlgoCourse.mergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import leetcode.Interval;

public class EmployeeFreeTime {

  public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> allSchedules = new ArrayList<>();
    for (List<Interval> intervals : schedule) {
      allSchedules.addAll(intervals);
    }

    allSchedules.sort(Comparator.comparing(sch -> sch.start));

    LinkedList<Interval> merged = new LinkedList<>();
    merged.add(allSchedules.get(0));

    for (int i = 1; i < allSchedules.size(); i++) {
      if (merged.getLast().end >= allSchedules.get(i).start) {
        merged.getLast().end = Math.max(merged.getLast().end, allSchedules.get(i).end);
      } else {
        merged.add(allSchedules.get(i));
      }
    }

    List<Interval> result = new ArrayList<>();
    Interval prev = merged.removeFirst();

    while (!merged.isEmpty()) {
      Interval curr = merged.removeFirst();
      if (prev.end - curr.start != 0) {
        result.add(new Interval(prev.end, curr.start));
      }
      prev = curr;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findEmployeeFreeTime(List.of(
            List.of(new Interval(1, 3), new Interval(9, 12)),
            List.of(new Interval(2, 4), new Interval(6, 8))
        )
    ));
  }
}
