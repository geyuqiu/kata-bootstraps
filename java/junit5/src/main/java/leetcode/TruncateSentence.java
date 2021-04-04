package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author YUQIU
 */
public class TruncateSentence {
	public String truncateSentence(String s, int k) {
		String[] split = s.split(" ");
		return Arrays.stream(split).limit(k).collect(Collectors.joining(" "));
	}
}
