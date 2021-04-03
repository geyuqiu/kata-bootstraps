package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author YUQIU
 */
class FrontMiddleBackQueueTest {

	@Test void
	all_operations() {
		FrontMiddleBackQueue q = new FrontMiddleBackQueue();
		q.pushFront(1);
		assertEquals(List.of(1), q.frontMiddleBackQueue);
		q.pushBack(2);    // [1, 2]
		assertEquals(List.of(1,2), q.frontMiddleBackQueue);
		q.pushMiddle(3);  // [1, 3, 2]
		assertEquals(List.of(1, 3, 2), q.frontMiddleBackQueue);
		q.pushMiddle(4);  // [1, 4, 3, 2]
		assertEquals(List.of(1, 4, 3, 2), q.frontMiddleBackQueue);

		int front = q.popFront();     // return 1 -> [4, 3, 2]
		assertEquals(1, front);
		assertEquals(List.of(4, 3, 2), q.frontMiddleBackQueue);

		int middle = q.popMiddle();    // return 3 -> [4, 2]
		assertEquals(3, middle);
		assertEquals(List.of(4, 2), q.frontMiddleBackQueue);

		middle = q.popMiddle();    // return 4 -> [2]
		assertEquals(4, middle);
		assertEquals(List.of(2), q.frontMiddleBackQueue);

		int back = q.popBack();      // return 2 -> []
		assertEquals(2, back);
		assertEquals(List.of(), q.frontMiddleBackQueue);

		front = q.popFront();     // return -1 -> [] (The queue is empty)
		assertEquals(-1, front);
		assertEquals(List.of(), q.frontMiddleBackQueue);
	}
}
