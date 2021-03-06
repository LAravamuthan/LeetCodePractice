package asu.edu.arav.impgoogle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import asu.edu.aravl.utility.Interval;

public class MergeInterval {

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		List<Interval> merged = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			int l = merged.size() - 1;
			if (merged.isEmpty() || merged.get(l).end < interval.start) {
				merged.add(interval);
			} else {
				merged.get(l).end = Math.max(merged.get(l).end, interval.end);
			}
		}
		return merged;
	}

}
