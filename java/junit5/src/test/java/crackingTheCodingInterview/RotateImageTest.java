package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class RotateImageTest {

	@Test
	void rotateImage() {
		RotateImage rotateImage = new RotateImage();
		int[][] expected = rotateImage.rotateImage(
			new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			}
		);

		assertArrayEquals(new int[][]{
			{7, 4, 1},
			{8, 5, 2},
			{9, 6, 3}
		}, expected);
	}
}
