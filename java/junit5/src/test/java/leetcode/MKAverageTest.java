package leetcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class MKAverageTest {
	MKAverage mkAverage;

//	@Test
//	void calculateMKAverage() {
//		mkAverage = new MKAverage(3, 1);
//		mkAverage.addElement(3);        // current elements are [3]
//		mkAverage.addElement(1);        // current elements are [3,1]
//		int first = mkAverage.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
//		mkAverage.addElement(10);       // current elements are [3,1,10]
//		int second = mkAverage.calculateMKAverage(); // The last 3 elements are [3,1,10].
//		// After removing smallest and largest 1 element the container will be [3].
//		// The average of [3] equals 3/1 = 3, return 3
//		mkAverage.addElement(5);        // current elements are [3,1,10,5]
//		mkAverage.addElement(5);        // current elements are [3,1,10,5,5]
//		mkAverage.addElement(5);        // current elements are [3,1,10,5,5,5]
//		int last = mkAverage.calculateMKAverage(); // The last 3 elements are [5,5,5].
//		// After removing smallest and largest 1 element the container will be [5].
//		// The average of [5] equals 5/1 = 5, return 5
//		assertEquals(-1, first);
//		assertEquals(3, second);
//		assertEquals(5, last);
//	}

	@Test void
	addInTheMiddleOfSlidingWindow() { // [1, 10], add 3 -> [1, 3, 10]
		mkAverage = new MKAverage(3, 1);
		mkAverage.nums = new ArrayList<>(Arrays.asList(1, 10));
		mkAverage.sortedSlidingWindowIndexes = new ArrayList<>(Arrays.asList(0, 1));

		mkAverage.addElement(3);

		assertEquals(mkAverage.nums, new ArrayList<>(Arrays.asList(1, 10, 3)));
		assertEquals(mkAverage.sortedSlidingWindowIndexes,
			new ArrayList<>(Arrays.asList(0, 2, 1))
		);
	}
}
