package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class MKAverageTest {

	@Test
	void calculateMKAverage() {
		MKAverage mkAverage = new MKAverage(3, 1);
		mkAverage.addElement(3);        // current elements are [3]
		mkAverage.addElement(1);        // current elements are [3,1]
		int first = mkAverage.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
		mkAverage.addElement(10);       // current elements are [3,1,10]
		int second = mkAverage.calculateMKAverage(); // The last 3 elements are [3,1,10].
		// After removing smallest and largest 1 element the container will be [3].
		// The average of [3] equals 3/1 = 3, return 3
		mkAverage.addElement(5);        // current elements are [3,1,10,5]
		mkAverage.addElement(5);        // current elements are [3,1,10,5,5]
		mkAverage.addElement(5);        // current elements are [3,1,10,5,5,5]
		int last = mkAverage.calculateMKAverage(); // The last 3 elements are [5,5,5].
		// After removing smallest and largest 1 element the container will be [5].
		// The average of [5] equals 5/1 = 5, return 5
		assertEquals(-1, first);
		assertEquals(3, second);
		assertEquals(5, last);
	}
}
