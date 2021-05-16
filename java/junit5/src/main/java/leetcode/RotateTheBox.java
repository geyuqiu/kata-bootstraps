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
//		print2DimArray(result);

		gravity(xLen, yLen, result);
//		System.out.println("Gravity");

//		print2DimArray(result);

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
		for (int j = 0; j < xLen; j++) {
			for (int i = yLen - 1; i > 0; i--) {
				if (result[i][j] == '.') {
					int swapI = getBoxThatFallsDown(result, xLen, i-1, j);
					if (swapI >= 0) {
						swap(result, j, i, swapI);
					}
				}
			}
		}
	}

	private int getBoxThatFallsDown(char[][] result, int xLen, int swapI, int j) {
		for (int i = swapI; i >= 0; i--) {
			if (result[i][j] == '*') return -1; // cannot fall through obstacle
			if (result[i][j] == '#') {
				return i;
			}
		}
		return -1;
	}

	private void swap(char[][] result, int j, int i, int swapI) {
		char temp = result[i][j];
		result[i][j] = result[swapI][j];
		result[swapI][j] = temp;
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
			System.out.println(a[i]);
		}
	}
}
