package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HalveArrayTest {

  @Test
  void halveArray() {
    assertThat(new HalveArray().halveArray(
//      new int[]{17,20,37,28,57,9,97,96,49,47,30,12,15,70,15,13,16,100,53,89,64,44,67,94,97,56,83,6,8,66,18,71,26,80,82,85,32,45,50,48,90,7,26,17,58,96,90,3,68,30,63,91,86,98,61,61,7,92,70,8,19,51,18,87,70,88}
//      new int[]{5,19,8,1}
      new int[]{1}
    ))
      .isEqualTo(1);
  }
}
