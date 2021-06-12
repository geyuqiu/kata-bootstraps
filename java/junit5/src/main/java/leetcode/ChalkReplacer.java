package leetcode;

/**
 * @author YUQIU
 */
public class ChalkReplacer {
	int chalkReplacer(int[] chalk, int k) { // TLE
		int i=0;
		while (k>0) {
			if (k < chalk[i]) return i;
			k -= chalk[i];
			if (i != chalk.length-1) i++;
			else i=0;
		}
		return i;
	}
}
