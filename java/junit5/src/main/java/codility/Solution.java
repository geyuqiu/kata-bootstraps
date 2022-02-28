package codility;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // only rings that center at (0,0)
  // performance does not matter
  // border not included
  public int solution(int inner, int outer, int[] points_x, int[] points_y) {
    // calculate radius pythagoras (absolute values)
    // check: inner < radius < outer
    int N = points_x.length;
    int result = 0;

    for (int i = 0; i < N; i++) {
      double radius = Math.sqrt((points_x[i]*points_x[i])+(points_y[i]*points_y[i]));
      if (radius > inner && radius < outer) {
        result++;
      }
    }

    return result;
  }
}
