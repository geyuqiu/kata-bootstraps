package crackingTheCodingInterview;

import java.util.HashSet;

/**
 *
 */
public class Interview { // time: O(), space: O()
	boolean isHappy(int num) {
		HashSet<Long> hs = new HashSet<>();
		long product;
		long n = num;

		while (true) {
			product = 0;
			long temp = n;
			long rest = n;

			while (rest != 0 || temp != 0) {
				rest = (long) temp % 10;
				temp = (long) temp / 10;
				product += (long) rest * rest;
			}
			boolean added = hs.add(product);
			if (!added) break;

			n = product;
		}
		if (product == 1) return true;
		return false;
	}
}
