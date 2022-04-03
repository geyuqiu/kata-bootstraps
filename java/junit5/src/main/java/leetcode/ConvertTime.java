package leetcode;

public class ConvertTime {
  int convertTime(String current, String correct) {
    String[] currentSplit = current.split(":");
    int minutesCurrent = 60 * Integer.valueOf(currentSplit[0]) + Integer.valueOf(currentSplit[1]);

    String[] correctSplit = correct.split(":");
    int minutesCorrect = 60 * Integer.valueOf(correctSplit[0]) + Integer.valueOf(correctSplit[1]);

    int[] ops = new int[]{60, 15, 5, 1};
    int difference = minutesCorrect -  minutesCurrent;
    int minNumOfOps = 0;

    while(difference > 0) {
      for (int i = 0; i < ops.length; i++) {
        if (difference - ops[i] >= 0 ) {
          difference -= ops[i];
          break;
        }
      }

      minNumOfOps++;
    }

    return minNumOfOps;
  }
}
