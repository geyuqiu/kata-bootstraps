package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Interview {
	int solution(String[] T, String[] R) {
		int N = T.length;
		int numberOfTasks;
		int numberOfSuccessfulTask = 0;
		HashMap<Integer, Character> hm = new HashMap<>(); // R: right, F: false

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
						int keyI = Integer.parseInt(key);
						if (value == '\0') {
							if (R[i].equals("OK")) {
								hm.put(keyI, 'T');
							} else {
								hm.put(keyI, 'F');
							}
						} else { // group
							if (R[i].equals("OK")) {
								if (hm.get(keyI) == null || hm.get(keyI) != 'F') hm.put(keyI, 'T');
							} else {
								hm.put(keyI, 'F');
							}
						}
						break;
					}
					value = T[i].charAt(j);
				}
			}
		}
		numberOfTasks = hm.size();

		for (Map.Entry<Integer, Character> entry: hm.entrySet()) {
			if ( entry.getValue() == 'T') numberOfSuccessfulTask++;
		}

//		System.out.println(hm);

		return numberOfSuccessfulTask * 100 / numberOfTasks;
	}
}
