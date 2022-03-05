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
  List<List<Integer>> getAncestors(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i=0; i<n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      int ancestor = edge[0];
      HashSet<Integer> ancestors = (HashSet<Integer>) graph.get(ancestor);
      graph.get(edge[1]).add(ancestor);
      if (!ancestors.isEmpty()) {
        for (int node: ancestors) {
          graph.get(edge[1]).add(node);
        }
      }
    }

    List<List<Integer>> result = new ArrayList<>();

    for (Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()) {
      result.add(entry.getValue().stream().collect(Collectors.toList()));
    }

    return result;
  }
}
