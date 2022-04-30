package crackingTheCodingInterview;

public class ATM {
  // always request the highest note available, even if there is a solution

  int[] balance = new int[5];
  int[] notes = new int[]{500, 200, 100, 50, 20};
  long sum = 0;

  public ATM() { }

  public void deposit(int[] banknotesCount) {
    for (int i = 0; i < 5; i++) {
      balance[i] += banknotesCount[i];
    }
  }

  public int[] withdraw(int amount) {
    int[] output = tryWithDraw(amount);
    if (output != null) {
      return output;
    }

    return new int[]{-1};
  }

  private int[] tryWithDraw(int amount) {
    int[] result = new int[5];
    for (int i = 0; i < 5; i++) {
      if (amount - notes[i] >= 0 && balance[5-i-1] > 0) {
        result[5-i-1] = amount / notes[i];
        amount -= notes[i] * result[5-i-1];
      }
      if (amount < 0) {
        break;
      }
      if (amount == 0 && checkBalance(result)) {
        for (int j = 0; j < 5; j++) {
          balance[j] -= result[j];
        }
        return result;
      }
    }
    return null;
  }

  private boolean checkBalance(int[] result) {
    for (int j = 0; j < 5; j++) {
      if (balance[j] < result[j]) return false;
    }

    return true;
  }
}
