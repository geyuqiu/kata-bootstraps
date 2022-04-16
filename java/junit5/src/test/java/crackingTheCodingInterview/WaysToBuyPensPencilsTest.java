package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToBuyPensPencilsTest {
  WaysToBuyPensPencils waysToBuyPensPencils = new WaysToBuyPensPencils();

  @Test
  void waysToBuyPensPencils() {
    long result = waysToBuyPensPencils.waysToBuyPensPencils(10,2,5);
    assertEquals(10, result);
  }
}
