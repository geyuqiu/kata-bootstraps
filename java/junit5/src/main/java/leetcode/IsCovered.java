package leetcode;

/**
 * @author YUQIU
 */
public class IsCovered {
	boolean isCovered(int[][] ranges, int left, int right) {
		for (int i = left; i <= right; i++) {
			boolean covered = false;
			for (int j = 0; j < ranges.length; j++) {
				for (int k = ranges[j][0]; k <= ranges[j][1]; k++) {
					if (k == i) covered = true;
				}
			}
			if (!covered) return false;
		}
		return true;
	}
}
