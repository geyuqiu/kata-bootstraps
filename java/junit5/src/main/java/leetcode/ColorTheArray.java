package leetcode;

public class ColorTheArray {
    int[] colorTheArray(int n, int[][] queries) {
        int L = queries.length;
        int[] result = new int[L];
        int[] colors = new int[n];

        int sameColor = 0;
        for (int i = 0; i < L; i++) {
            int index = queries[i][0];
            int color = queries[i][1];

            if (index-1 >= 0 && colors[index-1] > 0) {
                if (colors[index-1] == colors[index] && colors[index-1] != color) {
                    sameColor--;
                } else if (colors[index-1] != colors[index] && colors[index-1] == color) {
                    sameColor++;
                }
            }
            if (index+1 < n && colors[index+1] > 0) {
                if (colors[index+1] == colors[index] && colors[index+1] != color) {
                    sameColor--;
                } else if (colors[index+1] != colors[index] && colors[index+1] == color) {
                    sameColor++;
                }
            }
            result[i] = sameColor;
            colors[index] = color;
        }

        return result;
    }
}
