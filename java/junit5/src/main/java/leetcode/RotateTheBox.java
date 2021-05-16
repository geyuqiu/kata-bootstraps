package leetcode;

/**
 * @author YUQIU
 */
public class RotateTheBox {
	char[][] rotateTheBox(char[][] a) {
		int xLen = a.length;
		int yLen = a[0].length;
		char[][] result = new char[yLen][xLen];

		transpose(a, xLen, yLen, result);

		reorder(a, xLen, yLen, result);
		gravity(xLen, yLen, result);

		print2DimArray(result);

		return result;
	}

	private void transpose(char[][] a, int xLen, int yLen, char[][] result) {
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				result[i][j] = a[j][i];
			}
		}
	}

	private void gravity(int xLen, int yLen, char[][] result) {
		for (int i = yLen - 1; i > 0; i--) {
			for (int j = 0; j < xLen; j++) {
				if (result[i][j] == '.' && result[i-1][j] == '#') {
					result[i][j] = '#';
					result[i-1][j] = '.';
				}
			}
		}
	}

	private void reorder(char[][] a, int xLen, int yLen, char[][] result) {
		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen / 2; j++) {
				char temp = a[j][i];
				result[i][j] = result[i][xLen - j - 1];
				result[i][xLen - j - 1] = temp;
			}
		}
	}

	void print2DimArray(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
