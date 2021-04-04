package leetcode;

/**
 * @author YUQIU
 */
public class SquareIsWhite { // https://leetcode.com/problems/determine-color-of-a-chessboard-square/
	boolean squareIsWhite(String coordinates) {
		int diffC = coordinates.charAt(0) - 'a';
		int diffNum = coordinates.charAt(1) - '0';

		return (diffC + diffNum) % 2 == 0;
	}
}

