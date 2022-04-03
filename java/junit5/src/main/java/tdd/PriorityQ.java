package tdd;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQ {
  int getMax(int A[]) {
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < A.length; i++) {
      pq.add(A[i]);
    }

    return pq.poll();
  }
}
