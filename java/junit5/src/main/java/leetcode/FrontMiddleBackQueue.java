package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YUQIU
 */
public class FrontMiddleBackQueue {
	List<Integer> frontMiddleBackQueue = new ArrayList<>();

	public void pushFront(int val) {
		frontMiddleBackQueue.add(0, val);
	}

	public void pushMiddle(int val) {
		int middle = frontMiddleBackQueue.size() / 2;
		frontMiddleBackQueue.add(middle, val);
	}

	public void pushBack(int val) {
		frontMiddleBackQueue.add(val);
	}

	public int popFront() {
		if (frontMiddleBackQueue.isEmpty()) return -1;
		return frontMiddleBackQueue.remove(0);
	}

	public int popMiddle() {
		if (frontMiddleBackQueue.isEmpty()) return -1;
		int middle = frontMiddleBackQueue.size() % 2 == 1 ? frontMiddleBackQueue.size() / 2 : frontMiddleBackQueue.size() / 2 - 1;
		return frontMiddleBackQueue.remove(middle);
	}

	public int popBack() {
		if (frontMiddleBackQueue.isEmpty()) return -1;
		return frontMiddleBackQueue.remove(frontMiddleBackQueue.size() - 1);
	}
}
