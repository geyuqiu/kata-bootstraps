package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

  Coordinates coordinates;
  @BeforeEach
  void setUp() {
    coordinates = new Coordinates();
  }

//  @Test
//  void calcDistances() {
//    int[][] coord = new int[][] {{1,4},{4,4},{3,2},{5,1}};
//    assertEquals(, coordinates.calcDistances(coord));
//  }

  @Test
  void getMax() {
    int[][] coord = new int[][] {{1,4},{4,4},{3,2},{5,1}};
    double[][] actual = coordinates.calcDistances(coord);
    assertArrayEquals(new int[][] {{1,4},{5,1}}, actual);
  }

  @Test
  void getMin() {
    int[][] coord = new int[][] {{1,4},{4,4},{3,2},{5,1}};
    double[][] actual = coordinates.calcDistances(coord);
    assertArrayEquals(new int[][] {{1,4},{5,1}}, actual);
  }
}
