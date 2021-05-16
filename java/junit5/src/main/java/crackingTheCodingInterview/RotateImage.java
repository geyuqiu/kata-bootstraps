package crackingTheCodingInterview;

/**
 * @author YUQIU
 */
public class RotateImage {
	int[][] rotateImage(int[][] a) {
		int len = a.length;
		int[][] result = new int[len][len];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				// transponse
				result[i][j] = a[j][i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < len / 2; j++) {
				int temp = a[j][i];
				result[i][j] = result[i][len - j - 1];
				result[i][len - j - 1] = temp;
			}
		}
		return result;
	}
}
