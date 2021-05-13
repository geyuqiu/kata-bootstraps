package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 */
public class Interview {
	int solution(String[] T, String[] R) {
		int N = T.length;
		int numberOfTasks;
		HashMap<Integer, Character> hm = new HashMap<>();

		for (int i = 0; i < T.length; i++) {
			char value = '\0';
			String key = "";
			boolean taskNumberDiscovered = false;
			for (int j = T[i].length() - 1; j > 0 ; j--) {
				if (Character.isDigit(T[i].charAt(j))) {
					key += T[i].charAt(j) + key;
					taskNumberDiscovered = true;
				} else {
					if (taskNumberDiscovered) {
						hm.put(Integer.parseInt(key), value);
						break;
					}
					value = T[i].charAt(j);
				}
			}
		}
		numberOfTasks = hm.size();

		System.out.println(hm);

		return 0;
	}
}
