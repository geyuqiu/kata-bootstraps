package leetcode;

import java.util.*;

/**
 * @author YUQIU
 * n: 10^5
 * m: 10^5
 * k: 10^5 / 2
 * similar to this: https://leetcode.com/problems/sliding-window-maximum/
 */
class MKAverage { // space: O(n), time: O(n) but for sorting alone: O(n * mlogm), n: # of calculateMKAverage operations

	int m;
	int k;
	List<Integer> intList;
	Queue<Integer> queue;

	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		this.intList = new ArrayList<>();
		this.queue = new PriorityQueue<>(m);
	}

	public void addElement(int num) { // how to keep sorting ?
		this.intList.add(num);
	}

	public int calculateMKAverage() {
		int n = intList.size();
		if (n < m) return -1;

		for (int i = n - 1; i >= n - m; i--) {  // as priority queue but still have bottleneck for insertion: O(n*mlogm), so same thing
			queue.add(this.intList.get(i));
		}

//		System.out.println(intList);
//		System.out.println(queue);
		return averageInQueue(queue, k, queue.size() - k - 1); // m=6, k=1 -> average([1, 3, 3, 4, 5, 12], 1, 4), #nums = 4-1+1
	}

	int averageInQueue(Queue<Integer> indexQueue, int from, int to) { // O(k)
		long sum = 0L;
		int i = 0;
		while (!indexQueue.isEmpty()) {
			int num = indexQueue.poll();
			if (i >= from && i <= to) {
				sum += num;
			}
			i++;
		}
//		 System.out.println(sum);

		return Math.round(sum / (to - from + 1));
	}

	int averageInList(List<Integer> l, int from, int to) {
		long sum = 0L;
		for (int i = from; i <= to; i++) sum += (long) l.get(i);

		return Math.round(sum / (to - from + 1));
	}
}
