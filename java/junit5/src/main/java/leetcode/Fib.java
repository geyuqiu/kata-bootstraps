package leetcode;

/**
 * @author YUQIU
 */
public class Fib { // https://leetcode.com/problems/fibonacci-number/
	int fib(int n) {
		return fib(n, new int[n + 1]);
	}

	int fib(int i, int[] memo) {
		if (i == 0 || i == 1) return i;

		if (memo[i] == 0) {
			memo[i] = fib(i - 1, memo) + fib(i - 2, memo);
		}
		return memo[i];
	}
}
