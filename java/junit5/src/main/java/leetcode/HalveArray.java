package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HalveArray {
  int halveArray(int[] nums) {
    double sum = 0;
    Queue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < nums.length; i++) {
      priorityQueue.add(Double.valueOf(nums[i]));
      sum += nums[i];
    }

    double temp = sum;
    double difference;
    int times = 0;

    while(temp > sum/2) {
      difference = priorityQueue.poll() / 2;
      times++;
      temp -= difference;
      priorityQueue.add(difference);
    }

    return times;
  }
}
