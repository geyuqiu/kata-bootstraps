package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetAncestors {
  List<List<Integer>> dag = new ArrayList();
  List<List<Integer>> ancestors = new ArrayList();
  boolean[] visited;

  List<List<Integer>> getAncestors(int n, int[][] edges) {
    for (int i=0; i<n; i++) {
      dag.add(new ArrayList<>());
      ancestors.add(new ArrayList<>());
    }
    for (int[] edge: edges) {
      dag.get(edge[0]).add(edge[1]);
    }

    System.out.println(dag);

    for (int i = 0; i < n; i++) {
      visited = new boolean[n];
      dfs(i, i);
    }

    return ancestors;
  }

  private void dfs(int root, int current) {
    visited[current] = true;
    for (int neighbor: dag.get(current)) {
      if (!visited[neighbor]) {
        ancestors.get(neighbor).add(root);
        dfs(root, neighbor);
      }
    }
  }
}
