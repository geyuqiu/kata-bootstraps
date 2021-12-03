package leetcode;

public class Coordinates {
  double[][] calcDistances(int[][] coordinates) {
    double[][] maxDistanceCoord = new double[1][2];
    double[][] minDistanceCoord = new double[1][2];
    double min = Double.MAX_VALUE;
    double max = -1;

    for (int i = 0; i < coordinates.length - 1; i++) {
      for (int j = i+1; j < coordinates.length; j++) {
        int x2 = coordinates[j][0];
        int x1 = coordinates[i][0];
        int y2 = coordinates[j][1];
        int y1 = coordinates[i][1];
        double distance = Math.hypot(x2 - x1, y2 - y1);

        if (distance > max) {
          max = distance;
          maxDistanceCoord = new double[][]{{x1, y1}, {x2, y2}};
        } else if (distance < min) {
          min = distance;
          minDistanceCoord = new double[][]{{x1, y1}, {x2, y2}};
        }
      }
    }

    return minDistanceCoord;
  }
}
