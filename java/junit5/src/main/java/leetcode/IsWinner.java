package leetcode;

public class IsWinner {
  int isWinner(int[] player1, int[] player2) {
    int score1 = 0;
    int score2 = 0;

    for (int i = 0; i < player1.length; i++) {
      score1 += couldDoubleBecauseOfStrike(i, player1);
      score2 += couldDoubleBecauseOfStrike(i, player2);
    }

    if (score1 == score2) return 0;
    else if (score1 < score2) return 2;
    else return 1;
  }

  private int couldDoubleBecauseOfStrike(int i, int[] player1) {
    if (i-1 >= 0 && player1[i-1] == 10
    || i-2 >= 0 && player1[i-2] == 10) return player1[i] * 2;
    return player1[i];
  }
}
