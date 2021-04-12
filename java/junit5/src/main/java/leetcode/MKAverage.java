package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YUQIU
 * n: 10^5
 * m: 10^5
 * k: 10^5 / 2
 */
class MKAverage { // space: O(n), time: O(n) but for sorting alone: O(n * mlogm)

	int m;
	int k;
	List<Integer> intList;


	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		this.intList = new ArrayList<>();
	}

	public void addElement(int num) { // how to keep sorting ?
		this.intList.add(num);
	}

	public int calculateMKAverage() {
		int n = intList.size();
		if (n < m) return -1;

		// int min = value;
		// int max = value;

		List<Integer> lastElems = new ArrayList<>(); // as priority queue ? then still mlogm
		for (int i = n - 1; i >= n - m; i--) {
			lastElems.add(intList.get(i));
		}

//		int value = intList.pop();
//		int i = 1;
//		lastElems.add(value);
//
//		// pull the last m numbers, remove first and last k elems
//		while (i != m) {
//			value = intList.pop();
//			lastElems.add(value);
//			i++;
//		}

		Collections.sort(lastElems); // bottle neck
//		System.out.println(lastElems);
		return average(lastElems, k, lastElems.size() - k - 1); // m=6, k=1 -> average([1, 3, 3, 4, 5, 12], 1, 4), #nums = 4-1+1
	}

	int average(List<Integer> l, int from, int to) {
		long sum = 0L;
		for (int i = from; i <= to; i++) sum += (long) l.get(i);

		return Math.round(sum / (to - from + 1));
	}
}
