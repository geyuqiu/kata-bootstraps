package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author YUQIU
 */
public class AreSentencesSimilar { // https://leetcode.com/problems/sentence-similarity-iii/
	boolean areSentencesSimilar(String sentence1, String sentence2) {
		if (sentence1.equals(sentence2) || sentence1.isEmpty() || sentence2.isEmpty()) return true;
		String[] sentence1Split = sentence1.split(" ");
		String[] sentence2Split = sentence2.split(" ");

		LinkedList<String> queue1 = new LinkedList<>();
		queue1.addAll(Arrays.asList(sentence1Split));

		LinkedList<String> queue2 = new LinkedList<>();
		queue2.addAll(Arrays.asList(sentence2Split));

		while (notEmpty(queue1, queue2) && queue1.getFirst().equals(queue2.getFirst())) {
			queue1.removeFirst();
			queue2.removeFirst();
		}
		while (notEmpty(queue1, queue2) && queue1.getLast().equals(queue2.getLast())) {
			queue1.removeLast();
			queue2.removeLast();
		}

		if (queue1.isEmpty() || queue2.isEmpty()) return true;
		return false;
	}

	private boolean notEmpty(LinkedList<String> queue1, LinkedList<String> queue2) {
		return !queue1.isEmpty() && !queue2.isEmpty();
	}
}
