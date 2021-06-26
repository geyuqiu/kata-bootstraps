package leetcode;

/**
 * @author YUQIU
 */
public class CanBeIncreasing {
	boolean canBeIncreasing(int[] nums) {
		int[] temp = new int[nums.length];

		if (strictlyIncreasing(nums)) return true;
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			temp[i] = -1;
			if (strictlyIncreasing(temp)) {
				return true;
			}
			temp[i] = nums[i];
		}
		return false;
	}

	private boolean strictlyIncreasing(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == -1) continue;
			if (nums[i - 1] == -1 && i - 2>= 0 && nums[i] <= nums[i - 2]) return false;
			if (nums[i] <= nums[i-1]) return false;
		}
		return true;
	}
}
