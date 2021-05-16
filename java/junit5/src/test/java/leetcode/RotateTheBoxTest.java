package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author YUQIU
 */
class RotateTheBoxTest {

	@Test
	void rotateTheBox() {
		RotateTheBox rotateTheBox = new RotateTheBox();
		char[][] expected = rotateTheBox.rotateTheBox(
			new char[][]{
				{'#', '#', '*', '.', '*', '.'},
				{'#', '#', '#', '*', '.', '.'},
				{'#', '#', '#', '.', '#', '.'}
			}
		);

		assertArrayEquals(new char[][]{
			{'.', '#', '#'},
			{'.', '#', '#'},
			{'#', '#', '*'},
			{'#', '*', '.'},
			{'#', '.', '*'},
			{'#', '.', '.'}
		}, expected);
	}
}
