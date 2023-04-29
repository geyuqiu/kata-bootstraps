package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindThePrefixCommonArray {
  int[] findThePrefixCommonArray(int[] A, int[] B) {

    int[] commons = new int[A.length];
    List<Integer> a = Arrays.stream(A)
      .mapToObj(Integer::valueOf)
      .collect(Collectors.toList());
    List<Integer> b = Arrays.stream(B)
      .mapToObj(Integer::valueOf)
      .collect(Collectors.toList());

    int temp = 0;
    for (int i = 0; i < A.length; i++) {
      if (b.indexOf(A[i]) <= i && a.indexOf(B[i]) <= i && A[i]==B[i]) {
        temp++;
        commons[i] = temp;
        continue;
      }
      if (b.indexOf(A[i]) <= i) temp++;
      if (a.indexOf(B[i]) <= i) temp++;
      commons[i] = temp;
    }

    return commons;
  }
}
