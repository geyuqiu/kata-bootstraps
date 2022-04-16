package crackingTheCodingInterview;

public class WaysToBuyPensPencils {
  long waysToBuyPensPencils(int total, int cost1, int cost2) {
    int dividedByTimes = total / cost1;
    long max = 0;

    if (cost1 > total && cost2 > total) return 1;

    int[] a = new int[dividedByTimes+1];

    for (int i = 0; i < dividedByTimes+1; i++) {
      a[i] = i;
      int bAllowed = total - i*cost1;
      int divided = bAllowed / cost2;
      max += divided + 1;
    }

    return max;
  }
}
