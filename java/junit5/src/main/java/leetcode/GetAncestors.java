package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GetAncestors {
  // return ancestors (of ancestors) sorted in a DAG
  Map<Integer, Set<Integer>> graph = new HashMap<>();
  Map<Integer, Set<Integer>> allAncestors = new HashMap<>();
  List<List<Integer>> getAncestors(int n, int[][] edges) {
    for (int i=0; i<n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int i=0; i<n; i++) {
      allAncestors.put(i, new HashSet<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      graph.get(edge[1]).add(edge[0]);
    }
    System.out.println(graph);

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      dfs(i, i);
    }

    for (Map.Entry<Integer, Set<Integer>> entry: allAncestors.entrySet()) {
      result.add(entry.getValue().stream().sorted().collect(Collectors.toList()));
    }

    return result;
  }

  private void dfs(int root, int node) {
    for (int neighbor: graph.get(node)) {
      allAncestors.get(root).add(neighbor);
      dfs(root, neighbor);
    }
  }
}
