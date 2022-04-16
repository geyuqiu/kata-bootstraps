package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindClosestNumberTest {
  FindClosestNumber findClosestNumber = new FindClosestNumber();

  @Test
  void findClosestNumber() {
    int value = findClosestNumber.findClosestNumber(new int[]{-100, -100});

    assertEquals(value, -100);
  }
}
