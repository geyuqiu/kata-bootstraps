package leetcode;

/**
 * @author YUQIU
 */
public class ChalkReplacer {
	int chalkReplacer(int[] chalk, int k) {
		int i=0;
		long sum = 0;
		int N = chalk.length;
		for (int j = 0; j < N; j++) {
			sum += chalk[j];
		}

		k = (int) (k % sum);

		while (k>0) {
			if (k < chalk[i]) return i;
			k -= chalk[i];
			if (i != N -1) i++;
			else i=0;
		}
		return i;
	}
}
