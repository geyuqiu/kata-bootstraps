package leetcode;

/**
 * @author YUQIU
 */
public class RotateTheBox {
	char[][] rotateTheBox(char[][] a) {
		int xLen = a.length;
		int yLen = a[0].length;
		char[][] result = new char[yLen][xLen];

		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen; j++) {
				// transponse
				result[i][j] = a[j][i];
			}
		}

		for (int i = 0; i < yLen; i++) {
			for (int j = 0; j < xLen / 2; j++) {
				char temp = a[j][i];
				result[i][j] = result[i][xLen - j - 1];
				result[i][xLen - j - 1] = temp;
			}
		}

		print2DimArray(result);

		return result;
	}

	void print2DimArray(char[][] a) {
		System.out.println(a.length + " " + a[0].length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
